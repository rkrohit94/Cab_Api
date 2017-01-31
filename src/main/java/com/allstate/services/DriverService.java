package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    private IDriverRepository driverRepository;

    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(Driver driver){
        return this.driverRepository.save(driver);
    }


    public Driver findById(int id){
        return this.driverRepository.findOne(id);
    }

    public Driver findByName(String name){
        return this.driverRepository.findByName(name);
    }

    public void deleteById(int id){
        this.driverRepository.delete(id);
    }

    public Driver addViolation(Driver driver){
        driver.setViolations(driver.getViolations() + 1 );
        return this.driverRepository.save(driver);
    }

}
