package com.karol.travelagency.dto;


public class SearchTrip {
    public SearchTrip(String param, String value) {
        this.param = param;
        this.value = value;
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
