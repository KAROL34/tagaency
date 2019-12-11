package com.karol.travelagency.controller;

import com.karol.travelagency.dto.PageForm;
import com.karol.travelagency.dto.TripPurchaseDto;
import com.karol.travelagency.model.Trip;
import com.karol.travelagency.model.TripPurchase;
import com.karol.travelagency.service.PurchaseFinanceDetailsService;
import com.karol.travelagency.service.TripPurchaseService;
import com.karol.travelagency.service.TripService;
import com.karol.travelagency.validator.TripPurchaseValidator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class TripPurchaseController {

    private final TripPurchaseService tripPurchaseService;

    public TripPurchaseController(TripPurchaseService tripPurchaseService, TripService tripService, TripPurchaseValidator tripPurchaseValidator, PurchaseFinanceDetailsService financeDetailsService) {
        this.tripPurchaseService = tripPurchaseService;
        this.tripService = tripService;
        this.tripPurchaseValidator = tripPurchaseValidator;
        this.financeDetailsService = financeDetailsService;
    }

    private final TripService tripService;
    private final TripPurchaseValidator tripPurchaseValidator;
    private final PurchaseFinanceDetailsService financeDetailsService;

    @GetMapping("/buy-a-trip/{tripId}")
    public String buyATrip(@PathVariable("tripId") Long tripId,
                           Model model) {
        Trip trip = tripService.getTripById(tripId);
        TripPurchaseDto dto = new TripPurchaseDto();

        model.addAttribute("trip", trip);
        model.addAttribute("newTripPurchase", dto);
        dto.setAdultsAvailable(String.valueOf(trip.getAdultsQuantity()));
        dto.setChildrenAvailable(String.valueOf(trip.getChildrenQuantity()));
        dto.setAdultsQuantity("2");
        dto.setChildrenQuantity("0");
        return "trip-purchase/buy";
    }

    @PostMapping("/buy-a-trip/{tripId}")
    public String buyATripPost(@PathVariable("tripId") Long tripId,
                               @ModelAttribute("newTripPurchase") TripPurchaseDto tripPurchaseDto,
                               Model model, BindingResult bindingResult) {
        Trip trip = tripService.getTripById(tripId);
        tripPurchaseValidator.validate(tripPurchaseDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult);
            return "trip-purchase/buy";
        }

        TripPurchase purchase = tripPurchaseService.createPurchaseFromDto(tripId, tripPurchaseDto);
        model.addAttribute("purchaseId", purchase.getId());
        return "redirect:/purchase/purchase-summary/" + purchase.getId();
    }

    @GetMapping("/purchase/purchase-summary/{purchaseId}")
    public String showYourPurchase(@PathVariable("purchaseId") Long purchaseId,
                                   Model model) {
        model.addAttribute("newTripPurchase", tripPurchaseService.getTripPurchaseById(purchaseId).get());
        model.addAttribute("amountOfMoney", tripPurchaseService.calculateTripPurchaseFinances(purchaseId));
        model.addAttribute("financeDetails", financeDetailsService.save(tripPurchaseService.getTripPurchaseById(purchaseId).get()));
        return "trip-purchase/purchase-summary";
    }

    @PostMapping("/purchase/purchase-summary")
    public String showYourPurchasePost() {

        return "trip-purchase/purchase-summary";
    }

    @GetMapping("/admin/purchase-list")
    public String getAllPurchases(Model model) {
        model.addAttribute("pageForm", new PageForm());
        model.addAttribute("purchaseList", tripPurchaseService.getAllTripPurchases());
        return "trip-purchase/list";
    }

    @PostMapping("/admin/purchase-list")
    public String getAllPurchasesPost(@ModelAttribute("pageForm") PageForm pageForm, Model model) {
        Pageable pageable = PageRequest.of(pageForm.getPage(),
                pageForm.getSize(),
                pageForm.getSortOrder(),
                pageForm.getSortField());
        Page<TripPurchase> allTripPurchases = tripPurchaseService.getAllTripPurchases(pageable);
        model.addAttribute("purchaseList", allTripPurchases);
        return "/admin/purchase-list";
    }
}
