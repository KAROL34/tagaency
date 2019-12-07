package com.karol.travelagency.dto;




public class TripDto {

    private Long id;
    private String departureCity;
    public TripDto(){}
    public TripDto(Long id, String departureCity, String departureAirport, String arrivalCity, String arrivalAirport, String hotel, String startDate, String endDate, Integer daysQuantity, String type, double adultPrice, double childPrice, String isPromoted, Integer adultsQuantity, Integer childrenQuantity) {
        this.id = id;
        this.departureCity = departureCity;
        this.departureAirport = departureAirport;
        this.arrivalCity = arrivalCity;
        this.arrivalAirport = arrivalAirport;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.daysQuantity = daysQuantity;
        this.type = type;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.isPromoted = isPromoted;
        this.adultsQuantity = adultsQuantity;
        this.childrenQuantity = childrenQuantity;
    }

    private String departureAirport;
    private String arrivalCity;
    private String arrivalAirport;
    private String hotel;
    private String startDate;
    private String endDate;
    private Integer daysQuantity;
    private String type;    //BB, HB, FB, AI
    private double adultPrice;
    private double childPrice;
    private String isPromoted;
    private Integer adultsQuantity;
    private Integer childrenQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
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

    public Integer getDaysQuantity() {
        return daysQuantity;
    }

    public void setDaysQuantity(Integer daysQuantity) {
        this.daysQuantity = daysQuantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public String getIsPromoted() {
        return isPromoted;
    }

    public void setIsPromoted(String isPromoted) {
        this.isPromoted = isPromoted;
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
}
