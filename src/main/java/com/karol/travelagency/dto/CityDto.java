package com.karol.travelagency.dto;

import java.util.Objects;

public class CityDto {
    private Long id;
    private String name;

    private Long countryId;

    public CityDto(Long id, String name, Long countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public CityDto() {

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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return id.equals(cityDto.id) &&
                name.equals(cityDto.name) &&
                countryId.equals(cityDto.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryId);
    }
}
