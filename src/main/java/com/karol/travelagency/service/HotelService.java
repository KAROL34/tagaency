package com.karol.travelagency.service;


import com.karol.travelagency.model.City;
import com.karol.travelagency.model.Hotel;
import com.karol.travelagency.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private HotelRepository hotelRepository;
    private CityService cityService;

    @Autowired
    public HotelService(HotelRepository hotelRepository, CityService cityService) {
        this.hotelRepository = hotelRepository;
        this.cityService = cityService;
    }

    public Hotel addNewHotel(Long cityId, Hotel hotel){
        Optional<City> foundCity = cityService.findCityById(cityId);
        foundCity.ifPresent(hotel::setCity);
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    public Hotel getHotelById(Long hoteId){
        return hotelRepository.getOne(hoteId);
    }
    public List<Hotel> findHotelsByCityId(Long cityId) {
        return hotelRepository.findAllByCity_Id(cityId);
    }

    public Hotel findByName(String name){
        return hotelRepository.findByNameContaining(name);
    }


}
