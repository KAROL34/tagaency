package com.karol.travelagency.controller;


import com.karol.travelagency.service.ClientsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClientsDataController {

    private ClientsDataService clientsDataService;

    @Autowired
    public ClientsDataController(ClientsDataService clientsDataService) {
        this.clientsDataService = clientsDataService;
    }

//    @GetMapping("/client/add/{tripId}")
//    public String addNewClient(@PathVariable("tripId") Long id,
//                               Model model) {
//        model.addAttribute("newClient", new ClientsData());
//        return "/client/add";
//    }
//
//    @PostMapping("/client/add/{tripId}")
//    public String addNewClientPost(@PathVariable("tripId") Long id,
//            @ModelAttribute("newClient") ClientsData clientsData) {
//        clientsDataService.addNewClient(id, clientsData);
//        return "redirect:/trip/your-purchase";
//    }
}
