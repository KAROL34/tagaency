package com.karol.travelagency.service;


import com.karol.travelagency.model.Airport;
import com.karol.travelagency.model.City;
import com.karol.travelagency.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private AirportRepository airportRepository;
    private CityService cityService;

    @Autowired
    public AirportService(AirportRepository airportRepository,
                          CityService cityService) {
        this.airportRepository = airportRepository;
        this.cityService = cityService;
    }

    public void addNewAirport(Long cityId, Airport airport) {
        Optional<City> foundCity = (Optional<City>) Optional.ofNullable(cityService.findCityById(cityId));
        foundCity.ifPresent(airport::setCity);
        airportRepository.save(airport);
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public List<Airport> getAllAirportsOfGivenCity(Long cityId) {
        return airportRepository.findAllByCity_Id(cityId);
    }

    public Airport findByName(String name) {
        return airportRepository.findByNameContaining(name);
    }

    public Airport findAirportById(Long departureAirportID) {
        return airportRepository.getOne(departureAirportID);
    }

    public Airport findById(Long departureAirportID) {
        return airportRepository.getOne(departureAirportID);

    }
}
