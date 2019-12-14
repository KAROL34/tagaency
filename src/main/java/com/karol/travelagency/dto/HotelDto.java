package com.karol.travelagency.dto;

import java.util.Objects;

public class HotelDto {
    public HotelDto() {
    }

    private Long id;
    private String name;
    private String standard;
    private String description;
    private Long cityId;

    public HotelDto(Long id, String name, String standard, String description, Long cityId) {
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.description = description;
        this.cityId = cityId;
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

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                ", description='" + description + '\'' +
                ", cityId=" + cityId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDto hotelDto = (HotelDto) o;
        return id.equals(hotelDto.id) &&
                name.equals(hotelDto.name) &&
                standard.equals(hotelDto.standard) &&
                description.equals(hotelDto.description) &&
                cityId.equals(hotelDto.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, standard, description, cityId);
    }
}
