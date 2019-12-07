package com.karol.travelagency.service;


import com.karol.travelagency.dto.TripDto;
import com.karol.travelagency.model.Trip;
import com.karol.travelagency.repositories.TripRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service

public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository, CityService cityService, AirportService airportService, HotelService hotelService) {
        this.tripRepository = tripRepository;
        this.cityService = cityService;
        this.airportService = airportService;
        this.hotelService = hotelService;
    }

    private final CityService cityService;
    private final AirportService airportService;
    private final HotelService hotelService;


    public Trip addNewTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Page<Trip> getAllTrips(Pageable pageable) {
        return tripRepository.findAll(pageable);
    }

    public List<Trip> getAllTripsToGivenCountry(Long countryId) {
        return tripRepository.findAllByArrivalCity_Country_Id(countryId);
    }

    public List<Trip> getAllTripsToGivenCountry(Long countryId, Pageable pageable) {
        return getAllTripsToGivenCountry(countryId, pageable);
    }

    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }

    public List<Trip> getPromotedTrips() {
        String isPromoted = "Tak";
        return tripRepository.findByIsPromotedLike("Tak");
    }

    public List<Trip> getTripsOrderedByStartDateDesc() {
        List<Trip> trips = tripRepository.findAll();
        trips.sort(Comparator.comparing(Trip::getStartDate).reversed());
        return trips;
    }


    public List<Trip> getAllTripsOfGivenContinent(Long continentId) {
        return tripRepository.findAllByArrivalCity_Country_Continent_Id(continentId);
    }

    public Trip createTripFromDto(TripDto tripDto) {
        Trip trip;
        if (tripDto.getId() == null) {
            trip = new Trip();
        } else {
            trip = getTripById(tripDto.getId()).get();
        }
        trip.setDepartureCity(cityService.findCityByName(tripDto.getDepartureCity()));
        trip.setDepartureAirport(airportService.findByName(tripDto.getDepartureAirport()));
        trip.setArrivalCity(cityService.findCityByName(tripDto.getArrivalCity()));
        trip.setArrivalAirport(airportService.findByName(tripDto.getArrivalAirport()));
        trip.setHotel(hotelService.findByName(tripDto.getHotel()));
        trip.setStartDate(LocalDate.parse(tripDto.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-d")));
        trip.setEndDate(LocalDate.parse(tripDto.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-d")));
        trip.setDaysQuantity(tripDto.getDaysQuantity());
        trip.setType(tripDto.getType());
        trip.setAdultPrice(tripDto.getAdultPrice());
        trip.setChildPrice(tripDto.getChildPrice());
        trip.setAdultsQuantity(tripDto.getAdultsQuantity());
        trip.setChildrenQuantity(tripDto.getChildrenQuantity());
        trip.setIsPromoted(tripDto.getIsPromoted());

        return tripRepository.save(trip);
    }

    public TripDto createTripDtoFromTrip(Trip trip) {
        TripDto tripDto = new TripDto();
        tripDto.setId(trip.getId());
        tripDto.setDepartureCity(trip.getDepartureCity().getName());
        tripDto.setDepartureAirport(trip.getDepartureAirport().getName());
        tripDto.setArrivalCity(trip.getArrivalCity().getName());
        tripDto.setArrivalAirport(trip.getArrivalAirport().getName());
        tripDto.setHotel(trip.getHotel().getName());
        tripDto.setStartDate(trip.getStartDate().toString());
        tripDto.setEndDate(trip.getEndDate().toString());
        tripDto.setDaysQuantity(trip.getDaysQuantity());
        tripDto.setType(trip.getType());
        tripDto.setAdultPrice(trip.getAdultPrice());
        tripDto.setChildPrice(trip.getChildPrice());
        tripDto.setIsPromoted(trip.getIsPromoted());
        tripDto.setAdultsQuantity(trip.getAdultsQuantity());
        tripDto.setChildrenQuantity(trip.getChildrenQuantity());
        return tripDto;
    }

    public List<Trip> findATrip(String parameter, String value) {
        if (parameter.equals("departureCity")) {
            return tripRepository.findAllByDepartureCity_NameContaining(value);
        } else if (parameter.equals("departureAirport")) {
            return tripRepository.findAllByDepartureAirport_NameContaining(value);
        } else if (parameter.equals("arrivalCity")) {
            return tripRepository.findAllByArrivalCity_NameContaining(value);
        } else if (parameter.equals("arrivalAirport")) {
            return tripRepository.findAllByArrivalAirport_NameContaining(value);
        } else if (parameter.equals("hotel")) {
            return tripRepository.findAllByHotel_NameContaining(value);
        } else if (parameter.equals("startDate")) {
            return tripRepository.findAllByStartDateContaining(LocalDate.parse(value,  DateTimeFormatter.ofPattern("yyyy-MM-d")));
        } else if (parameter.equals("endDate")) {
            return tripRepository.findAllByEndDateContaining(LocalDate.parse(value,  DateTimeFormatter.ofPattern("yyyy-MM-d")));
        } else if (parameter.equals("daysQuantity")) {
            return tripRepository.findAllByDaysQuantityEquals(Integer.valueOf(value));
        } else if (parameter.equals("type")) {
            return tripRepository.findAllByTypeEquals(value);
        } else if (parameter.equals("adultPrice")) {
            return tripRepository.findAllByAdultPriceIsLessThanEqual(Double.valueOf(value));
        } else if (parameter.equals("childPrice")) {
            return tripRepository.findAllByChildPriceIsLessThanEqual(Double.valueOf(value));
        } else if (parameter.equals("isPromoted")) {
            return tripRepository.findAllByIsPromotedContaining(value);
        } else if (parameter.equals("adultsQuantity")) {
            return tripRepository.findAllByAdultsQuantityGreaterThanEqual(Integer.valueOf(value));
        } else if (parameter.equals("childrenQuantity")) {
            return tripRepository.findAllByChildrenQuantityGreaterThanEqual(Integer.valueOf(value));
        } else
            return null;
    }

    public List<Trip> getTripsOrderedByStartDateAsc() {
        List<Trip> trips = tripRepository.findAll();
        trips.sort(Comparator.comparing(Trip::getStartDate));
        return trips;
    }
}
