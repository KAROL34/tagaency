package com.karol.travelagency.service;

import com.karol.travelagency.dto.CityDto;
import com.karol.travelagency.model.City;

import com.karol.travelagency.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityService {

    private CityRepository cityRepository;
    private CountryService countryService;

    @Autowired
    public CityService(CityRepository cityRepository,
                       CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    public City addNewCity(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCountry(countryService.getCountryById(cityDto.getCountryId()));
        return cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<City> getAllCitiesOfGivenCountry(Long countryId) {
        return cityRepository.findAllByCountry_Id(countryId);
    }

    public City findCityById(Long id) {
        return cityRepository.getOne(id);
    }

    public City findCityByName(String name) {
        return cityRepository.findByNameContaining(name);
    }
}
