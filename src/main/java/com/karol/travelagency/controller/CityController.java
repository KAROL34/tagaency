package com.karol.travelagency.controller;

import com.karol.travelagency.dto.CityDto;
import com.karol.travelagency.model.City;
import com.karol.travelagency.service.CityService;

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
public class CityController {

    private CityService cityService;
    private CountryService countryService;

    @Autowired
    public CityController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @GetMapping("/admin/addcity")
    public String addCity(Model model) {
        model.addAttribute("newCity", new CityDto());
        model.addAttribute("countries", countryService.getAllCountries());
        return "admin/addcity";
    }

    @PostMapping("/admin/addcity")
    public String addNewCity(@ModelAttribute("newCity") CityDto cityDto) {

        cityService.addNewCity(cityDto);

        return "redirect:/all-hotels";
    }


    @GetMapping("/city/list/{countryId}")
    public String getAllCitiesOfGivenCountry(@PathVariable("countryId") Long countryId,
                                             Model model) {
        List<City> cityList = cityService.getAllCitiesOfGivenCountry(countryId);
        model.addAttribute("cityList", cityList);
        return "city/list";
    }

    @GetMapping("city/all-cities")
    public String getAllCities(Model model) {
        model.addAttribute("allCities", cityService.getAllCities());
        return "city/all-cities";
    }
}
