package com.karol.travelagency.repositories;

import com.karol.travelagency.model.Airport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findAllByCity_Id(Long cityId);
    Airport findByNameContaining(String name);
}
