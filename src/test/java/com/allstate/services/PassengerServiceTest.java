package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
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
public class PassengerServiceTest {

    @Autowired
    private PassengerService passengerService;

    private Passenger passenger;


    @Before
    public void setUp() throws Exception {
        passenger = new Passenger();
        passenger.setName("jacob");
        passenger.setAge(34);
        passenger.setGender(Gender.MALE);
        passenger.setCreditBalance(1000);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateDriver() throws Exception {
      Passenger result=this.passengerService.createPassenger(passenger);
      assertNotNull(result);
      assertEquals(3,result.getId());

    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void shouldNotCreateDriverWithNullDetails() throws Exception {
        Passenger passenger1=new Passenger();
        Passenger result=this.passengerService.createPassenger(passenger1);
        assertNull(result);
    }

    @Test
    public void findById() throws Exception {
        Passenger result=this.passengerService.findById(1);
        assertEquals(1,result.getId());
        assertEquals("abc",result.getName());
    }


    @Test
    public void shouldNotFindPassengerByBadId() throws Exception {
        Passenger result=this.passengerService.findById(5);
        assertNull(result);
    }

    @Test
    public void shouldFindPassengerByName() throws Exception {
        Passenger result=this.passengerService.findByName("abc");
        assertEquals(1,result.getId());
    }

    @Test
    public void shouldNotFindPassengerByBadName() throws Exception {
        Passenger result=this.passengerService.findByName("aaa");
        assertNull(result);
    }

    @Test
    public void shouldDeletePassengerById() throws Exception {
        this.passengerService.deleteById(1);
        Passenger result= this.passengerService.findById(1);
        assertNull(result);
    }

}