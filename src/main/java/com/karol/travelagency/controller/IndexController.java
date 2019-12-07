package com.karol.travelagency.controller;

import com.karol.travelagency.service.ContinentService;
import com.karol.travelagency.service.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequiredArgsConstructor
public class IndexController {

    private TripService tripService;
    private ContinentService continentService;

    @Autowired
    public IndexController(TripService tripService,
                           ContinentService continentService) {
        this.tripService = tripService;
        this.continentService = continentService;
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("allTrips", tripService.getAllTrips());
        model.addAttribute("promotedTrips", tripService.getPromotedTrips());
        model.addAttribute("allContinents", continentService.getAllContinentsSortedByName());
   //     model.addAttribute("firstMinute", tripService.getTripsOrderedByStartDateDesc().subList(0, 3));
   //     model.addAttribute("lastMinute", tripService.getTripsOrderedByStartDateAsc().subList(0, 3));

        return "index";
    }
}
