package com.karol.travelagency.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity

public class ClientsData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne
    private TripPurchase tripPurchase;

    public ClientsData(String firstName, String lastName, String email, TripPurchase tripPurchase) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tripPurchase = tripPurchase;
    }

    public ClientsData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TripPurchase getTripPurchase() {
        return tripPurchase;
    }

    public void setTripPurchase(TripPurchase tripPurchase) {
        this.tripPurchase = tripPurchase;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
