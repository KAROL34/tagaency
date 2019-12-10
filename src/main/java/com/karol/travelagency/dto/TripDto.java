package com.karol.travelagency.dto;




public class TripDto {
    public TripDto() {
    }
    private Long id;
    private Long departureCity;
    private Long departureAirport;
    private Long arrivalCity;
    private Long arrivalAirport;
    private Long hotel;
    private String startDate;
    private String endDate;
    private Integer daysQuantity;
    private String type;    //BB, HB, FB, AI
    private double adultPrice;
    private double childPrice;
    private boolean isPromoted;
    private Integer adultsQuantity;
    private Integer childrenQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(Long departureCity) {
        this.departureCity = departureCity;
    }

    public Long getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Long departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Long getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(Long arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Long getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Long arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Long getHotel() {
        return hotel;
    }

    public void setHotel(Long hotel) {
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

    public boolean getIsPromoted() {
        return isPromoted;
    }

    public void setIsPromoted(boolean promoted) {
        isPromoted = promoted;
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

    public TripDto(Long id, Long departureCity, Long departureAirport, Long arrivalCity, Long arrivalAirport, Long hotel, String startDate, String endDate, Integer daysQuantity, String type, double adultPrice, double childPrice, boolean isPromoted, Integer adultsQuantity, Integer childrenQuantity) {
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
}
