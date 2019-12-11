package com.karol.travelagency.service;


import com.karol.travelagency.dto.TripPurchaseDto;
import com.karol.travelagency.model.ClientsData;
import com.karol.travelagency.model.Trip;
import com.karol.travelagency.model.TripPurchase;
import com.karol.travelagency.repositories.TripPurchaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TripPurchaseService {

    private final TripPurchaseRepository tripPurchaseRepository;
    private final TripService tripService;
    private final ClientsDataService clientsDataService;

    public TripPurchaseService(TripPurchaseRepository tripPurchaseRepository, TripService tripService, ClientsDataService clientsDataService) {
        this.tripPurchaseRepository = tripPurchaseRepository;
        this.tripService = tripService;
        this.clientsDataService = clientsDataService;
    }

    public List<TripPurchase> getAllTripPurchases() {
        return tripPurchaseRepository.findAll();
    }

    public Page<TripPurchase> getAllTripPurchases(Pageable pageable) {
        return tripPurchaseRepository.findAll(pageable);
    }

    public TripPurchase createPurchaseFromDto(Long tripId, TripPurchaseDto tripPurchaseDto) {
        Optional<Trip> foundTrip = Optional.ofNullable(tripService.getTripById(tripId));
        TripPurchase tripPurchase = new TripPurchase();
        ClientsData clientsData = new ClientsData();
        clientsData.setFirstName(tripPurchaseDto.getClientFirstName());
        clientsData.setLastName(tripPurchaseDto.getClientLastName());

        clientsData = clientsDataService.addNewClient(clientsData);

        tripPurchase.setClient(clientsData);
        tripPurchase.setAdultsQuantity(Integer.valueOf(tripPurchaseDto.getAdultsQuantity()));
        tripPurchase.setChildrenQuantity(Integer.valueOf(tripPurchaseDto.getChildrenQuantity()));

        foundTrip.ifPresent(tripPurchase::setTrip);

        if (foundTrip.isPresent()) {
            foundTrip.get()
                    .setAdultsQuantity(foundTrip.get().getAdultsQuantity() - Integer.valueOf(tripPurchaseDto.getAdultsQuantity()));
            foundTrip.get()
                    .setChildrenQuantity(foundTrip.get().getChildrenQuantity() - Integer.valueOf(tripPurchaseDto.getChildrenQuantity()));
        }

        return tripPurchaseRepository.save(tripPurchase);
    }

    public Optional<TripPurchase> getTripPurchaseById(Long id) {
        return tripPurchaseRepository.findById(id);
    }

    public Double calculateTripPurchaseFinances(Long tripPurchaseId) {
        Optional<TripPurchase> foundTrip = getTripPurchaseById(tripPurchaseId);
        if (foundTrip.isPresent()) {
            Integer childrenQuantity = foundTrip.get().getChildrenQuantity();
            double childPrice = foundTrip.get().getTrip().getChildPrice();

            Integer adultsQuantity = foundTrip.get().getAdultsQuantity();
            double adultPrice = foundTrip.get().getTrip().getAdultPrice();

            Double amount = (childrenQuantity * childPrice) + (adultsQuantity * adultPrice);
            return amount;
        }
        return null;
    }
}
