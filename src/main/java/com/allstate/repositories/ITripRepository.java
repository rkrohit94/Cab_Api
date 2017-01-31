package com.allstate.repositories;


import com.allstate.entities.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripRepository extends CrudRepository<Trip,Integer>{
}
