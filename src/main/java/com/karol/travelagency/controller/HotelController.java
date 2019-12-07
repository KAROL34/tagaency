package com.karol.travelagency.controller;

import com.karol.travelagency.model.Hotel;
import com.karol.travelagency.service.CityService;
import com.karol.travelagency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HotelController {

    private HotelService hotelService;
    private CityService cityService;

    @Autowired
    public HotelController(HotelService hotelService, CityService cityService) {
        this.hotelService = hotelService;
        this.cityService = cityService;
    }

    @GetMapping("/all-hotels")
    public String showAll(Model model) {
        model.addAttribute("hoteles", hotelService.getAllHotels());
        return "hotels";
    }

    @GetMapping("/admin/add-hotel/{cityId}")
    public String addHotel(@PathVariable("cityId") Long cityId,
                           Model model) {
        model.addAttribute("newHotel", new Hotel());
        return "hotel/add-hotel";
    }

    @PostMapping("/admin/add-hotel/{cityId}")
    public String addHotelPost(@PathVariable("cityId") Long id,
                              @ModelAttribute("newHotel") Hotel hotel) {
        hotelService.addNewHotel(id, hotel);
        return "redirect:/hotel/list/{cityId}";
    }

    @GetMapping("/hotel/list/{cityId}")
    public String getHotelsOfGivenCity(@PathVariable("cityId") Long cityId,
                                       Model model) {
        model.addAttribute("hotelsList", hotelService.findHotelsByCityId(cityId));
        return "hotel/list";
    }
    @GetMapping("/hotel/{hotelid}")
    public String getHotelById(@PathVariable("hotelid") Long hotelid,
                                       Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(hotelid));
        return "hotel";
    }
}
