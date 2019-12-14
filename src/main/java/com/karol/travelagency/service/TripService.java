package com.karol.travelagency.service;


import com.karol.travelagency.dto.SearchTrip;
import com.karol.travelagency.dto.TripDto;
import com.karol.travelagency.model.Country;
import com.karol.travelagency.model.Trip;
import com.karol.travelagency.repositories.CountryRepository;
import com.karol.travelagency.repositories.TripRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service

public class TripService {

    private final TripRepository tripRepository;
    private final CountryRepository countryRepository;

    @PersistenceContext
    EntityManager entityManager;

    public TripService(TripRepository tripRepository, CountryRepository countryRepository, CityService cityService, AirportService airportService, HotelService hotelService) {
        this.tripRepository = tripRepository;
        this.countryRepository = countryRepository;
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

    public List<Trip> getAllTripsByCityId(Long cityId) {
        return tripRepository.findAllByArrivalCity_Country_Id(cityId);
    }
    public List<Trip> getAllTripsToGivenCountry(Long countryId) {
        return tripRepository.findAllByArrivalCity_Country_Id(countryId);
    }

    public List<Trip> getAllTripsByGivenHotelId(Long hotelId) {
        return tripRepository.findAllByHotelId(hotelId);
    }

    public List<Trip> getAllTripsToGivenCountry(Long countryId, Pageable pageable) {
        return getAllTripsToGivenCountry(countryId, pageable);
    }

    public Trip getTripById(Long id) {
        return tripRepository.getOne(id);
    }

    public List<Trip> getAllCommingTrips(LocalDate localDate) {
        localDate = LocalDate.now().minusDays(7);
        return tripRepository.findAllByStartDateGreaterThan(localDate);
    }
    public List<Trip> getPromotedTrips() {
        boolean isPromoted = true;
        return tripRepository.findByIsPromotedLike(true);
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
            trip = getTripById(tripDto.getId());
        }
        trip.setId(tripDto.getId());
        trip.setDepartureCity(cityService.findCityById(tripDto.getDepartureCity()));
        trip.setDepartureAirport(airportService.findAirportById(tripDto.getDepartureAirport()));
        trip.setArrivalCity(cityService.findCityById(tripDto.getArrivalCity()));
        trip.setArrivalAirport(airportService.findById(tripDto.getArrivalAirport()));
        trip.setHotel(hotelService.findById(tripDto.getHotel()));
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
        tripDto.setDepartureCity(trip.getDepartureCity().getId());
        tripDto.setDepartureAirport(trip.getDepartureAirport().getId());
        tripDto.setArrivalCity(trip.getArrivalCity().getId());
        tripDto.setArrivalAirport(trip.getArrivalAirport().getId());
        tripDto.setHotel(trip.getHotel().getId());
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

    public List<Trip> findATrip(SearchTrip trip) {
        String query = "select t from Trip t";

        List<String> fragments = new ArrayList<>();

        if (trip.getDepartureCity() != null && !trip.getDepartureCity().isBlank()) {
            fragments.add("  t.departureCity.name = 'Warszawa' ");
            //return tripRepository.findAllByDepartureCity_NameContaining(trip.getDepartureCity());
        }
        if (trip.getArrivalCity() != null && !trip.getArrivalCity().isBlank()) {
            fragments.add("  t.arrivalCity.name = 'Ateny' ");
        }

        if (!fragments.isEmpty()) {
            query += " where " + String.join(" and ", fragments);
        }

        System.out.println(query);
        return entityManager.createQuery(query).getResultList();
    }

//        if (parameter.equals("departureCity")&&parameter!=null) {
//            return tripRepository.findAllByDepartureCity_NameContaining(value);
//        } else if (parameter.equals("departureAirport")&&parameter!=null) {
//            return tripRepository.findAllByDepartureAirport_NameContaining(value);
//        } else if (parameter.equals("arrivalCity")&&parameter!=null) {
//            return tripRepository.findAllByArrivalCity_NameContaining(value);
//        } else if (parameter.equals("arrivalAirport")&&parameter!=null) {
//            return tripRepository.findAllByArrivalAirport_NameContaining(value);
//        } else if (parameter.equals("hotel")&&parameter!=null) {
//            return tripRepository.findAllByHotel_NameContaining(value);
//        } else if (parameter.equals("startDate")&&parameter!=null) {
//            return tripRepository.findAllByStartDateContaining(LocalDate.parse(value,  DateTimeFormatter.ofPattern("yyyy-MM-d")));
//        } else if (parameter.equals("endDate")&&parameter!=null) {
//            return tripRepository.findAllByEndDateContaining(LocalDate.parse(value,  DateTimeFormatter.ofPattern("yyyy-MM-d")));
//        } else if (parameter.equals("daysQuantity")&&parameter!=null) {
//            return tripRepository.findAllByDaysQuantityEquals(Integer.valueOf(value));
//        } else if (parameter.equals("type")&&parameter!=null) {
//            return tripRepository.findAllByTypeEquals(value);
//        } else if (parameter.equals("adultPrice")&&parameter!=null) {
//            return tripRepository.findAllByAdultPriceIsLessThanEqual(Double.valueOf(value));
//        } else if (parameter.equals("childPrice")&&parameter!=null) {
//            return tripRepository.findAllByChildPriceIsLessThanEqual(Double.valueOf(value));
//        } else if (parameter.equals("isPromoted")&&parameter!=null) {
//            return tripRepository.findAllByIsPromotedContaining(value);
//        } else if (parameter.equals("adultsQuantity")&&parameter!=null) {
//            return tripRepository.findAllByAdultsQuantityGreaterThanEqual(Integer.valueOf(value));
//        } else if (parameter.equals("childrenQuantity")&&parameter!=null) {
//            return tripRepository.findAllByChildrenQuantityGreaterThanEqual(Integer.valueOf(value));
//        } else
//            return null;


    public List<Trip> getTripsOrderedByStartDateAsc() {
        List<Trip> trips = tripRepository.findAll();
        trips.sort(Comparator.comparing(Trip::getStartDate));
        return trips;
    }

    public List<Trip> findAllByArrivalCity_Country_Continent_Id(Long continentId) {
        return tripRepository.findAllByArrivalCity_Country_Continent_Id(continentId);
    }


    public List<Trip> findAllByArrivalCity_Country(Long countryId) {
        return tripRepository.findAllByArrivalCity_Country_Id(countryId);
    }
}
