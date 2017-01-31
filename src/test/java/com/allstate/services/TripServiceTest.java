package com.allstate.services;

import com.allstate.entities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class TripServiceTest {

    @Autowired
    private TripService tripService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private CarService carService;
    @Autowired
    private CityService cityService;

    private Trip trip;
    @Before
    public void setUp() throws Exception {
        City city = this.cityService.findById(1);
        Passenger passenger = this.passengerService.findById(1);
        Car car =this.carService.findById(1);
        Driver driver =this.driverService.findById(1);
        trip = new Trip(car,city,driver,passenger);
        trip.setKmsDriven(10);
        trip.setTip(10);
        trip.setTripCost(100);
        trip.setTotalTripCost(110);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTrip() throws Exception {
        Trip result = this.tripService.createTrip(trip);
        assertEquals(3,result.getId());
    }

//    @Test(expected = javax.validation.ConstraintViolationException.class)
//    public void shouldNotCreateTripWithWrongDetails() throws Exception {
//        Trip trip1=new Trip();
//        Trip result = this.tripService.createTrip(trip1);
//        assertNull(result);
//    }

}