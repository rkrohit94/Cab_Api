package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private IPassengerRepository passengerRepository;

    @Autowired
    public void setPassengerRepository(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger createPassenger(Passenger passenger){
        return this.passengerRepository.save(passenger);
    }


    public Passenger findById(int id){
        return this.passengerRepository.findOne(id);
    }

    public Passenger findByName(String name){
        return this.passengerRepository.findByName(name);
    }

    public void deleteById(int id){
        this.passengerRepository.delete(id);
    }
}
