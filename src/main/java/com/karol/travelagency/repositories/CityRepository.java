package com.karol.travelagency.repositories;


import com.karol.travelagency.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByCountry_Id(Long id);
    City findByNameContaining(String name);
}
