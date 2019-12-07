package com.karol.travelagency.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity

public class TripPurchase {
    public TripPurchase(){}
    public TripPurchase(Trip trip, ClientsData client, Integer adultsQuantity, Integer childrenQuantity, PurchaseFinanceDetails financeDetails) {
        this.trip = trip;
        this.client = client;
        this.adultsQuantity = adultsQuantity;
        this.childrenQuantity = childrenQuantity;
        this.financeDetails = financeDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public ClientsData getClient() {
        return client;
    }

    public void setClient(ClientsData client) {
        this.client = client;
    }

    public Integer getAdultsQuantity() {
        return adultsQuantity;
    }

    public void setAdultsQuantity(Integer adultsQuantity) {
        this.adultsQuantity = adultsQuantity;
    }

    public Integer getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(Integer childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public PurchaseFinanceDetails getFinanceDetails() {
        return financeDetails;
    }

    public void setFinanceDetails(PurchaseFinanceDetails financeDetails) {
        this.financeDetails = financeDetails;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private Trip trip;
    @OneToOne
    private ClientsData client;
    private Integer adultsQuantity;
    private Integer childrenQuantity;
    @OneToOne
    private PurchaseFinanceDetails financeDetails;

}
