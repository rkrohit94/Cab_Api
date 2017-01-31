package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityService {
    private ICityRepository cityRepository;

    @Autowired
    public void setCityRepository(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City createCity(City city){
        return this.cityRepository.save(city);
    }

    public City findById(int id){
        return this.cityRepository.findOne(id);
    }

    public City findByName(String name){
        return this.cityRepository.findByName(name);
    }

    public void deleteById(int id){
        this.cityRepository.delete(id);
    }

}
