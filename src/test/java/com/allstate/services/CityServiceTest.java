package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class CityServiceTest {

    @Autowired
    private CityService cityService;
    private City city;

    @Before
    public void setUp() throws Exception {
        city=new City();
        city.setName("Mumbai");
        city.setState("Maharashtra");
        city.setDayRate(40);
        city.setNightRate(70);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCity() throws Exception {
        City result=this.cityService.createCity(city);
        assertNotNull(result);
        assertEquals(3,result.getId());
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void shouldNotCreateCityWithBadName() throws Exception {
        City city1=new City();
        city1.setName(null);
        city1.setState("AP");
        city1.setDayRate(25);
        city1.setNightRate(45);
        City result=this.cityService.createCity(city1);
        assertNull(result);
    }

    @Test
    public void shouldFindCityById() throws Exception {
        City result = this.cityService.findById(1);
        assertNotNull(result);
        assertEquals("bangalore", result.getName());
    }

    @Test
    public void shouldNotFindCityByIDWhichDoesNotExist() throws Exception {
        City result = this.cityService.findById(5);
        assertNull(result);
    }

    @Test
    public void shouldFindCityByName() throws Exception {
        City result = this.cityService.findByName("bangalore");
        assertNotNull(result);
        assertEquals(1,result.getId());
    }

    @Test
    public void shouldNotFindCityWhichDoesNotExist() throws Exception {
        City result = this.cityService.findByName("mysore");
        assertNull(result);
    }

    @Test
    public void shouldDeleteCityById() throws Exception {
        this.cityService.deleteById(1);
        City result= this.cityService.findById(1);
        assertNull(result);
    }

    @Test
    @Transactional
    public void shouldReturnListOfDriverInCity() throws Exception {
        City city1 =this.cityService.findById(1);
        System.out.println(city1.getName());
        List<Driver> driverList = city1.getDrivers();
        assertEquals(2,driverList.size());
    }
}