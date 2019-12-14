package com.karol.travelagency.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


@Entity


public class City {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Airport> airportList;
    @OneToMany(mappedBy = "city")
    private List<Hotel> hotelList;
    @OneToMany(mappedBy = "departureCity")
    private List<Trip> departureTripList;
    @OneToMany(mappedBy = "arrivalCity")
    private List<Trip> arrivalTripList;

    public City() {
        this.name = name;
        this.country = country;
        this.airportList = airportList;
        this.hotelList = hotelList;
        this.departureTripList = departureTripList;
        this.arrivalTripList = arrivalTripList;
    }
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

    public Country getCountry() {
        return country;
    }




    public List<Airport> getAirportList() {
        return airportList;
    }

    public void setAirportList(List<Airport> airportList) {
        this.airportList = airportList;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
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

    public void setCountry(Country country) {this.country=country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +


                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(country, city.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }
}
