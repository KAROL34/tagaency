package com.karol.travelagency.repositories;


import com.karol.travelagency.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

     List<Country> findAllByContinent_Id(Long id);


    List<Country> findAll();

}
