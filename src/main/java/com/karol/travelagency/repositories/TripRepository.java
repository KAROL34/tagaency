package com.karol.travelagency.repositories;


import com.karol.travelagency.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByArrivalCity_Country_Id(Long countryId);

    List<Trip> findAllByStartDateGreaterThan(LocalDate localDate);
    List<Trip> findByIsPromotedLike(boolean isPromoted);
    List<Trip> findAllByArrivalCity_Country_Continent_Id(Long continentId);

    List<Trip> findAllByDepartureCity_NameContaining(String value);
    List<Trip> findAllByDepartureAirport_NameContaining(String value);
    List<Trip> findAllByArrivalCity_NameContaining(String value);
    List<Trip> findAllByArrivalAirport_NameContaining(String value);
    List<Trip> findAllByHotel_NameContaining(String value);

    List<Trip> findAllByHotelId(Long hotelId);
    List<Trip> findAllByStartDateContaining(LocalDate localDate);
    List<Trip> findAllByEndDateContaining(LocalDate localDate);
    List<Trip> findAllByDaysQuantityEquals(Integer daysQuantity);
    List<Trip> findAllByTypeEquals(String type);
    List<Trip> findAllByAdultPriceIsLessThanEqual(Double adultPrice);
    List<Trip> findAllByChildPriceIsLessThanEqual(Double childPrice);
    List<Trip> findAllByIsPromotedContaining(String value);
    List<Trip> findAllByAdultsQuantityGreaterThanEqual(Integer adultsQuantity);
    List<Trip> findAllByChildrenQuantityGreaterThanEqual(Integer childrenQuantity);

    Trip findByDepartureCity_NameContaining(String departureCityName);
    Trip findByDepartureAirport_NameContaining(String departureAirportName);
    Trip findByArrivalCity_NameContaining(String arrivalCityName);
    Trip findByArrivalAirport_NameContaining(String arrivalAirportName);
    Trip findByHotel_NameContaining(String hotelName);

}
