package com.allstate.repositories;


import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITripRepository extends CrudRepository<Trip,Integer>{

    String sqlShortestTipQuery = "SELECT MIN(kms_driven) from trips where passenger_id = :id";
    @Query(value = sqlShortestTipQuery, nativeQuery = true)
    public int findShortestTripDetails(@Param("id") int id);

    String sqlLongestTripQuery = "SELECT MAX(kms_driven) from trips where passenger_id = :id";
    @Query(value = sqlLongestTripQuery, nativeQuery = true)
    public int findLongestTripDetails(@Param("id") int id);

    String sqlTotalMoneyByCityQuery = "SELECT SUM(total_trip_cost) from trips where city_id = :id";
    @Query(value = sqlTotalMoneyByCityQuery, nativeQuery = true)
    public int findTotalMoneyByCity(@Param("id") int id);

    String sqlTotalMoneyByDriverQuery = "SELECT SUM(total_trip_cost) from trips where driver_id = :id";
    @Query(value = sqlTotalMoneyByDriverQuery, nativeQuery = true)
    public int findTotalMoneyByDriver(@Param("id") int id);

    String sqlTotalMoneyByYear = "SELECT sum(total_trip_cost) from trips where trip_start_time > DATE_SUB(NOW(),INTERVAL 1 YEAR) && passenger_id = :id";
    @Query(value = sqlTotalMoneyByYear, nativeQuery = true)
    public int findTotalMoneyByYear(@Param("id") int id);

    String sqlTotalMoneyByMonth = "SELECT sum(total_trip_cost) from trips where trip_start_time > DATE_SUB(NOW(),INTERVAL 1 MONTH) && passenger_id = :id";
    @Query(value = sqlTotalMoneyByMonth, nativeQuery = true)
    public int findTotalMoneyByMonth(@Param("id") int id);

    String sqlTotalMoneyByDay = "SELECT sum(total_trip_cost) from trips where trip_start_time > DATE_SUB(NOW(),INTERVAL 1 Day) && passenger_id = :id";
    @Query(value = sqlTotalMoneyByDay, nativeQuery = true)
    public int findTotalMoneyByDay(@Param("id") int id);

}
