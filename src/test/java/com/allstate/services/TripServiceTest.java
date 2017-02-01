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

import javax.transaction.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

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
        trip.setKmsDriven(40);
        trip.setTip(10);
        trip.setTripCost(100);
        trip.setTotalTripCost(110);
        trip.setTripStartTime(new SimpleDateFormat( "yyyyMMdd" ).parse( "20170201" ));
        trip.setTripEndTime(new SimpleDateFormat( "yyyyMMdd" ).parse( "20170201" ));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTrip() throws Exception {
        Trip result = this.tripService.createTrip(trip);
        System.out.println("DAte parsing***************"+result.getTripStartTime());
        assertEquals(3,result.getId());
    }

    @Test
    public void shouldFindTripById() throws Exception {
        Trip result = this.tripService.findById(1);
        assertNotNull(result);
        assertEquals(1,result.getId());
    }

    @Test
    @Transactional
    public void shouldFindCarByTrip() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Car car = trip1.getCar();
        assertNotNull(car);
        assertEquals(1,car.getId());
    }

    @Test
    @Transactional
    public void shouldFindDriverByTrip() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Driver driver=trip1.getDriver();
        assertNotNull(driver);
        assertEquals(1,driver.getId());
    }

    @Test
    @Transactional
    public void shouldFindPassengerByTrip() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Passenger passenger=trip1.getPassenger();
        assertNotNull(passenger);
        assertEquals(1,passenger.getId());
    }


    @Test
    public void shouldFindShortestTrip() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Trip result = this.tripService.createTrip(trip);
        Passenger passenger=trip1.getPassenger();
        int res=this.tripService.findShortestTripDetails(passenger.getId());
        assertNotNull(res);
        assertEquals(10,res);

    }


    @Test
    public void shouldFindLongestTrip() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Trip result = this.tripService.createTrip(trip);
        Passenger passenger=trip1.getPassenger();
        int res=this.tripService.findLongestTripDetails(passenger.getId());
        assertNotNull(res);
        assertEquals(40,res);

    }


    @Test
    public void shouldFindTotalMoneyByCity() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Trip result = this.tripService.createTrip(trip);
        City city=trip1.getCity();
        int res=this.tripService.findTotalMoneyByCity(city.getId());
        assertNotNull(res);
        assertEquals(220,res);

    }

    @Test
    public void shouldFindTotalMoneyByDriver() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Trip result = this.tripService.createTrip(trip);
        Driver driver=trip1.getDriver();
        int res=this.tripService.findTotalMoneyByDriver(driver.getId());
        assertNotNull(res);
        assertEquals(440,res);

    }


    @Test
    public void shouldFindTotalMoneyByYear() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Trip result = this.tripService.createTrip(trip);
        Passenger passenger=trip1.getPassenger();
        int res=this.tripService.findTotalMoneyByYear(passenger.getId());
        assertNotNull(res);
        assertEquals(110,res);
    }

    @Test
    public void shouldFindTotalMoneyByMonth() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Trip result = this.tripService.createTrip(trip);
        Passenger passenger=trip1.getPassenger();
        int res=this.tripService.findTotalMoneyByMonth(passenger.getId());
        assertNotNull(res);
        assertEquals(110,res);
    }

    @Test
    public void shouldFindTotalMoneyByDay() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Trip result = this.tripService.createTrip(trip);
        Passenger passenger=trip1.getPassenger();
        int res=this.tripService.findTotalMoneyByDay(passenger.getId());
        assertNotNull(res);
        assertEquals(110,res);
    }
}