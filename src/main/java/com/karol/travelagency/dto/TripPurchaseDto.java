package com.karol.travelagency.dto;


import org.springframework.stereotype.Component;

@Component

public class TripPurchaseDto {
    private String purchaseId;
    private String clientFirstName;
    private String clientLastName;
    private String adultsQuantity;
    private String childrenQuantity;
    private String adultsAvailable;
    private String childrenAvailable;

    public TripPurchaseDto(){}
    public TripPurchaseDto(String purchaseId, String clientFirstName, String clientLastName, String adultsQuantity, String childrenQuantity, String adultsAvailable, String childrenAvailable) {
        this.purchaseId = purchaseId;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.adultsQuantity = adultsQuantity;
        this.childrenQuantity = childrenQuantity;
        this.adultsAvailable = adultsAvailable;
        this.childrenAvailable = childrenAvailable;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getAdultsQuantity() {
        return adultsQuantity;
    }

    public void setAdultsQuantity(String adultsQuantity) {
        this.adultsQuantity = adultsQuantity;
    }

    public String getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(String childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public String getAdultsAvailable() {
        return adultsAvailable;
    }

    public void setAdultsAvailable(String adultsAvailable) {
        this.adultsAvailable = adultsAvailable;
    }

    public String getChildrenAvailable() {
        return childrenAvailable;
    }

    public void setChildrenAvailable(String childrenAvailable) {
        this.childrenAvailable = childrenAvailable;
    }




}
