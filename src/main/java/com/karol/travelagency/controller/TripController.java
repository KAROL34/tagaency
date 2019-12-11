package com.karol.travelagency.controller;


import com.karol.travelagency.dto.PageForm;
import com.karol.travelagency.dto.SearchTrip;
import com.karol.travelagency.dto.TripDto;
import com.karol.travelagency.model.Trip;
import com.karol.travelagency.model.TripPurchase;
import com.karol.travelagency.repositories.TripRepository;
import com.karol.travelagency.service.AirportService;
import com.karol.travelagency.service.CityService;
import com.karol.travelagency.service.HotelService;
import com.karol.travelagency.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Controller
public class TripController {

    private TripService tripService;
    private CityService cityService;
    private AirportService airportService;
    private HotelService hotelService;
    private TripRepository tripRepository;

    @Autowired
    public TripController(TripService tripService,
                          CityService cityService,
                          AirportService airportService,
                          HotelService hotelService) {
        this.tripService = tripService;
        this.cityService = cityService;
        this.airportService = airportService;
        this.hotelService = hotelService;
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

    @PostMapping("/admin/edit-trip/{tripId}")
    public String editTripPost(@PathVariable("tripId") Long id, @ModelAttribute("trip") TripDto tripDto) {
        Trip trip = tripService.createTripFromDto(tripDto);
        trip.setId(id);
        tripService.addNewTrip(trip);
        return "redirect:/trips";
    }

    @GetMapping("/trip/details/{tripId}")
    public String showDetailsOfGivenTrip(@PathVariable("tripId") Long tripId,
                                         Model model) {
        model.addAttribute("trip", tripService.getTripById(tripId));
        model.addAttribute("newPurchase", new TripPurchase());
        return "trip/details";
    }

    @GetMapping("/search")
    public String searchATrip(Model model) {
        model.addAttribute("searchedTrip", new SearchTrip());
        return "trip/search";
    }

    @PostMapping("/search")
    public String searchATrip(@ModelAttribute("searchedTrip") SearchTrip searchTrip,
                              Model model) {

        String param = searchTrip.getParam();
        String value = searchTrip.getValue();
        model.addAttribute("foundTrips", tripService.findATrip(param, value));

        return "trip/search-result";
    }

    @GetMapping("/trips")
    public String getAllTrips(Model model) {

        model.addAttribute("tripes", tripService.getAllTrips());
        return "trips";
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
