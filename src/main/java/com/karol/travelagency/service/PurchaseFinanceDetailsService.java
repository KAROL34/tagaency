package com.karol.travelagency.service;


import com.karol.travelagency.model.PurchaseFinanceDetails;
import com.karol.travelagency.model.TripPurchase;
import com.karol.travelagency.repositories.PurchaseFinanceDetailsRepository;
import org.springframework.stereotype.Service;

@Service

public class PurchaseFinanceDetailsService {

    private final PurchaseFinanceDetailsRepository financeDetailsRepository;

    public PurchaseFinanceDetailsService(PurchaseFinanceDetailsRepository financeDetailsRepository) {
        this.financeDetailsRepository = financeDetailsRepository;
    }

    public PurchaseFinanceDetails save(TripPurchase tripPurchase) {
        PurchaseFinanceDetails purchaseFinanceDetails = new PurchaseFinanceDetails();

        purchaseFinanceDetails.setAdultsCost(calculateAdultsCost(tripPurchase));
        purchaseFinanceDetails.setChildrenCost(calculateChildrenCost(tripPurchase));
        purchaseFinanceDetails.setTotalCost(calculateTotalCost(tripPurchase));
        purchaseFinanceDetails.setTripPurchase(tripPurchase);
        tripPurchase.setFinanceDetails(purchaseFinanceDetails);
        return financeDetailsRepository.save(purchaseFinanceDetails);
    }


    private Double calculateAdultsCost(TripPurchase tripPurchase) {

        Integer adultsQuantity = tripPurchase.getAdultsQuantity();
        double adultPrice = tripPurchase.getTrip().getAdultPrice();
        return adultsQuantity * adultPrice;

    }

    private Double calculateChildrenCost(TripPurchase tripPurchase) {
            Integer childrenQuantity = tripPurchase.getChildrenQuantity();
            double childPrice = tripPurchase.getTrip().getChildPrice();
            return childrenQuantity * childPrice;
    }

    private Double calculateTotalCost(TripPurchase tripPurchase) {
            return calculateAdultsCost(tripPurchase) + calculateChildrenCost(tripPurchase);
     }


}
