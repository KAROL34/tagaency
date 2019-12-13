package com.karol.travelagency.service;


import com.karol.travelagency.model.Continent;
import com.karol.travelagency.model.Country;
import com.karol.travelagency.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;
    private ContinentService continentService;

    @Autowired
    public CountryService(CountryRepository countryRepository, ContinentService continentService) {
        this.countryRepository = countryRepository;
        this.continentService = continentService;
    }

    public void addNewCountry(Long continentId, Country country){
        Optional<Continent> foundContinent = continentService.getContinentById(continentId);
        foundContinent.ifPresent(country::setContinent);
        countryRepository.save(country);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<Country> getAllCountrierOfGivenContinent(Long id) {
        return countryRepository.findAllByContinent_Id(id);
    }

    public Country getCountryById(Long id) {
        return countryRepository.getOne(id);
    }

    public List<Country> getAllCountriesSortedByName() {
        List<Country> countries = countryRepository.findAll();
        countries.sort(Comparator.comparing(Country::getName));
        return countries;
    }



}
