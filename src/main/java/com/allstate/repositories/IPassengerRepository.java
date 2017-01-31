package com.allstate.repositories;

import com.allstate.entities.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPassengerRepository extends CrudRepository<Passenger,Integer>{
    Passenger findByName(String name);
}
