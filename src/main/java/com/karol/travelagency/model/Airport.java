package com.karol.travelagency.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;


@Entity

public class Airport {
    public Airport(){

    }
    public Airport(String name, City city, List<Trip> departureTripList, List<Trip> arrivalTripList) {
        this.name = name;
        this.city = city;
        this.departureTripList = departureTripList;
        this.arrivalTripList = arrivalTripList;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Trip> getDepartureTripList() {
        return departureTripList;
    }

    public void setDepartureTripList(List<Trip> departureTripList) {
        this.departureTripList = departureTripList;
    }

    public List<Trip> getArrivalTripList() {
        return arrivalTripList;
    }

    public void setArrivalTripList(List<Trip> arrivalTripList) {
        this.arrivalTripList = arrivalTripList;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(id, airport.id) &&
                Objects.equals(name, airport.name) &&
                Objects.equals(city, airport.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, departureTripList, arrivalTripList);
    }

    private String name;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "departureAirport")
    private List<Trip> departureTripList;
    @OneToMany(mappedBy = "arrivalAirport")
    private List<Trip> arrivalTripList;
}
