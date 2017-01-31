package com.allstate.repositories;

import com.allstate.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends CrudRepository<Car, Integer> {
    List<Car> findByMake(String make);
}
