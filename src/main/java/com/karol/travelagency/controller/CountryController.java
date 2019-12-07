package com.karol.travelagency.controller;


import com.karol.travelagency.model.Country;
import com.karol.travelagency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/admin/add-country/{continentId}")
    public String addCountry(@PathVariable("continentId") Long id,
                                         Model model) {
        model.addAttribute("continentId", id);
        model.addAttribute("newCountry", new Country());
        return "country/add-country";
    }

    @PostMapping("/admin/add-country/{continentId}")
    public String addCountryPost(@PathVariable("continentId") Long id,
            @ModelAttribute("newCountry") Country country) {
        countryService.addNewCountry(id, country);
        return "redirect:/country/list/{continentId}";
    }

    @GetMapping("/country/list/{continentId}")
    public String getAllCountriesOfGivenContinent(@PathVariable("continentId") Long id,
                                                  Model model){
        List<Country> foundCountries = countryService.getAllCountrierOfGivenContinent(id);
        model.addAttribute("countries_of_continent", foundCountries);
        return "country/list";
    }

    @GetMapping("/country/all-countries")
    public String getAllCountries(Model model) {
        model.addAttribute("allCountries", countryService.getAllCountries());
        return "country/all-countries";
    }
}

