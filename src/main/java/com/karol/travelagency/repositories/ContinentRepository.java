package com.karol.travelagency.repositories;


import com.karol.travelagency.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Long> {

}
