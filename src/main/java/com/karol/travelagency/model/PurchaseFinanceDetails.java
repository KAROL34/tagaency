package com.karol.travelagency.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PurchaseFinanceDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Double adultsCost;
    private Double childrenCost;
    private Double totalCost;
    @OneToOne
    private TripPurchase tripPurchase;
    public PurchaseFinanceDetails(){}
    public PurchaseFinanceDetails(Double adultsCost, Double childrenCost, Double totalCost, TripPurchase tripPurchase) {
        this.adultsCost = adultsCost;
        this.childrenCost = childrenCost;
        this.totalCost = totalCost;
        this.tripPurchase = tripPurchase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAdultsCost() {
        return adultsCost;
    }

    public void setAdultsCost(Double adultsCost) {
        this.adultsCost = adultsCost;
    }

    public Double getChildrenCost() {
        return childrenCost;
    }

    public void setChildrenCost(Double childrenCost) {
        this.childrenCost = childrenCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public TripPurchase getTripPurchase() {
        return tripPurchase;
    }

    public void setTripPurchase(TripPurchase tripPurchase) {
        this.tripPurchase = tripPurchase;
    }


}
