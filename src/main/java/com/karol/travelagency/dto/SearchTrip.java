package com.karol.travelagency.dto;


import java.util.Objects;

public class SearchTrip {
    private String arrivalCity;
    private String arrivalAirport;
    private String hotel;
    private String startDate;
    private String endDate;
    private String type;
    private Double adultPrice;
    private Double childPrice;
    private Integer adultsQuantity;
    private Integer childrenQuantity;
    private Boolean isPromoted;
    private String departureCity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchTrip that = (SearchTrip) o;
        return Objects.equals(arrivalCity, that.arrivalCity) &&
                Objects.equals(arrivalAirport, that.arrivalAirport) &&
                Objects.equals(hotel, that.hotel) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(type, that.type) &&
                Objects.equals(adultPrice, that.adultPrice) &&
                Objects.equals(childPrice, that.childPrice) &&
                Objects.equals(adultsQuantity, that.adultsQuantity) &&
                Objects.equals(childrenQuantity, that.childrenQuantity) &&
                Objects.equals(isPromoted, that.isPromoted) &&
                Objects.equals(departureCity, that.departureCity) &&
                Objects.equals(param, that.param) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrivalCity, arrivalAirport, hotel, startDate, endDate, type, adultPrice, childPrice, adultsQuantity, childrenQuantity, isPromoted, departureCity, param, value);
    }

    @Override
    public String toString() {
        return "SearchTrip{" +
                "arrivalCity='" + arrivalCity + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", hotel='" + hotel + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", type='" + type + '\'' +
                ", adultPrice=" + adultPrice +
                ", childPrice=" + childPrice +
                ", adultsQuantity=" + adultsQuantity +
                ", childrenQuantity=" + childrenQuantity +
                ", isPromoted=" + isPromoted +
                ", departureCity='" + departureCity + '\'' +
                ", param='" + param + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(Double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public Double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(Double childPrice) {
        this.childPrice = childPrice;
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

    public Boolean getPromoted() {
        return isPromoted;
    }

    public void setPromoted(Boolean promoted) {
        isPromoted = promoted;
    }

    public SearchTrip(String param, String value) {
        this.param = param;
        this.value = value;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public SearchTrip() {

    }

    public String getParam() {
        return param;
    }



    public void setParam(String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String param;
    private String value;
}
