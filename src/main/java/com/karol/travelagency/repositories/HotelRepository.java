package com.karol.travelagency.repositories;


import com.karol.travelagency.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByCity_Id(Long id);
    Hotel findByNameContaining(String name);
}
