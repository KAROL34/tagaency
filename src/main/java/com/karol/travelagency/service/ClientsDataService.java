package com.karol.travelagency.service;

import com.karol.travelagency.model.ClientsData;
import com.karol.travelagency.repositories.ClientsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsDataService {

    private ClientsDataRepository clientsDataRepository;

    @Autowired
    public ClientsDataService(ClientsDataRepository clientsDataRepository) {
        this.clientsDataRepository = clientsDataRepository;
    }

    public ClientsData addNewClient(ClientsData clientsData) {
        return clientsDataRepository.save(clientsData);
    }

    public Optional<ClientsData> getById(Long id) {
        return clientsDataRepository.findById(id);
    }

    public List<ClientsData> getllClientsOfGivenPurchase(Long tripPurchaseId) {
        return clientsDataRepository.findAllByTripPurchaseId(tripPurchaseId);
    }


}
