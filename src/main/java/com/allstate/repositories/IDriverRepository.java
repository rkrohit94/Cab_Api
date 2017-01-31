package com.allstate.repositories;

import com.allstate.entities.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDriverRepository extends CrudRepository<Driver,Integer>{
    Driver findByName(String name);
}
