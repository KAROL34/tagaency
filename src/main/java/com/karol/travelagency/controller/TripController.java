package com.karol.travelagency.controller;


import com.karol.travelagency.dto.PageForm;
import com.karol.travelagency.dto.SearchTrip;
import com.karol.travelagency.dto.TripDto;
import com.karol.travelagency.model.Trip;
import com.karol.travelagency.model.TripPurchase;
import com.karol.travelagency.service.AirportService;
import com.karol.travelagency.service.CityService;
import com.karol.travelagency.service.ContinentService;
import com.karol.travelagency.service.CountryService;
import com.karol.travelagency.service.HotelService;
import com.karol.travelagency.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.directory.SearchResult;
import java.time.LocalDate;
import java.util.List;


@Controller
public class TripController {

    private TripService tripService;
    private CityService cityService;
    private AirportService airportService;
    private HotelService hotelService;
    private ContinentService continentService;
    private CountryService countryService;
    @Autowired
    public TripController(TripService tripService,
                          CityService cityService,
                          AirportService airportService,
                          HotelService hotelService, ContinentService continentService, CountryService countryService) {
        this.tripService = tripService;
        this.cityService = cityService;
        this.airportService = airportService;
        this.hotelService = hotelService;
        this.continentService = continentService;
        this.countryService = countryService;
    }

    @GetMapping("/admin/addtrip")
    public String addNewTrip(Model model) {
        model.addAttribute("newTrip", new TripDto());
        model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("airports", airportService.getAllAirports());
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "admin/addtrip";
    }

    @PostMapping("/admin/addtrip")
    public String addNewTripPost(@ModelAttribute("newTrip") TripDto tripDto) {
        tripService.createTripFromDto(tripDto);
        return "redirect:/trips";
    }

    @GetMapping("/admin/edittrip/{tripId}")
    public String editTrip(@PathVariable("tripId") Long id, Model model) {
        Trip trip = tripService.getTripById(id);

        model.addAttribute("trip", trip);
//            TripDto editedTrip = tripService.createTripDtoFromTrip(trip);
        //    model.addAttribute("editedTrip", tripService.createTripDtoFromTrip(trip));
            model.addAttribute("cities", cityService.getAllCities());
        model.addAttribute("airports", airportService.getAllAirports());
            model.addAttribute("hotels", hotelService.getAllHotels());
            return "admin/edittrip";

    }

    @PostMapping("/admin/edittrip/{tripId}")
    public String editTripPost(@PathVariable("tripId") Long id, @ModelAttribute("trip") TripDto tripDto) {
        tripDto.setId(id);
        Trip trip = tripService.createTripFromDto(tripDto);
        tripService.addNewTrip(trip);
        return "redirect:/trips";
    }

    @GetMapping("/trip/{tripId}")
    public String showDetailsOfGivenTrip(@PathVariable("tripId") Long tripId,
                                         Model model) {
        model.addAttribute("trip", tripService.getTripById(tripId));

        model.addAttribute("tripsbycountryid", tripService.getAllTripsToGivenCountry(tripId));
        model.addAttribute("newPurchase", new TripPurchase());
        return "trip";
    }

    @GetMapping("/search")
    public String searchATrip(SearchTrip searchedTrip, Model model) {
        model.addAttribute("searchedTrip", searchedTrip);
        model.addAttribute("foundTrips", tripService.findATrip(searchedTrip));
        return "trips";
    }

//    @PostMapping("/search")
//    public String searchATrip(@ModelAttribute("searchedTrip") SearchTrip searchTrip,
//                              Model model) {
//
//        String param = searchTrip.getParam();
//        String value = searchTrip.getValue();
//        model.addAttribute("foundTrips", tripService.findATrip(param, value));
//
//        return "trips";
//    }

    @GetMapping("/trips")
    public String getAllTrips(Model model) {

        model.addAttribute("tripes", tripService.getAllTrips());
        return "tripsc";
    }

    @GetMapping("/lastminute")
    public String getAllCommingTrips(Model model) {

        model.addAttribute("tripes", tripService.getAllCommingTrips(LocalDate.now().minusDays(7)));
        return "indexlastminute";
    }

    @GetMapping("/promo")
    public String getAllPromo(Model model) {

        model.addAttribute("tripes", tripService.getPromotedTrips());
        return "indexlastminute";
    }

    @GetMapping("/trips/continent/{continentId}")
    public String getAllTripsByContinent(@PathVariable("continentId") Long continentId, Model model) {
        model.addAttribute("continents", continentService.getAllContinentsSortedByName());
        model.addAttribute("countries", countryService.getAllCountriesSortedByName());
        model.addAttribute("tripes", tripService.getAllTrips());
        model.addAttribute("tripsbycontinents", tripService.findAllByArrivalCity_Country_Continent_Id(continentId));
        return "tripsc";
    }

    @GetMapping("/trips/continent/{continentId}/country/{countryId}")
    public String getAllTripsByCountryAfterContinent(@PathVariable("continentId") Long continentId, @PathVariable("countryId") Long countryId, Model model) {
        model.addAttribute("continents", continentService.getAllContinentsSortedByName());
        model.addAttribute("countries", countryService.getAllCountriesSortedByName());
        model.addAttribute("tripes", tripService.getAllTrips());
        model.addAttribute("tripsbycontinents", tripService.findAllByArrivalCity_Country_Continent_Id(continentId));
        model.addAttribute("tripsbycountryafterconinent", tripService.findAllByArrivalCity_Country(countryId));
        return "tripsc";
    }

    @PostMapping("/trip/list")
    public String getAllTripsPost(@ModelAttribute("pageForm") PageForm pageForm, Model model) {

        Pageable pageable = PageRequest.of(pageForm.getPage(),
                pageForm.getSize(),
                pageForm.getSortOrder(),
                pageForm.getSortField()
        );
        List<Trip> trips = tripService.getAllTrips(pageable).getContent();
        model.addAttribute("tripsList", trips);

        return "trip/list";
    }

    @GetMapping("/trip/list/{countryId}")
    public String getAllTripsToGivenCountry(@PathVariable("countryId") Long countryId,
                                            @ModelAttribute("pageForm") PageForm pageForm,
                                            Model model) {
        model.addAttribute("pageForm", new PageForm());
        model.addAttribute("tripsList", tripService.getAllTripsToGivenCountry(countryId));
        return "trip/list";
    }

    @PostMapping("/trip/list/{countryId}")
    public String getAllTripsToGivenCountryPost(@PathVariable("countryId") Long countryId,
                                                @ModelAttribute("pageForm") PageForm pageForm,
                                                Model model) {
        Pageable pageable = PageRequest.of(pageForm.getPage(),
                pageForm.getSize(),
                pageForm.getSortOrder(),
                pageForm.getSortField());
        List<Trip> tripList = tripService.getAllTripsToGivenCountry(countryId, pageable);
        model.addAttribute("tripsList", tripList);

        return "trip/list";
    }


}
