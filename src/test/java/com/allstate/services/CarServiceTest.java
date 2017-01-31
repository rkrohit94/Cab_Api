package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.City;
import com.allstate.enums.CarType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class CarServiceTest {

    @Autowired
    private CarService carService;

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
        car.setMake("BMW");
        car.setModel("S series");
        car.setYear(2008);
        car.setType(CarType.BASIC);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCar() throws Exception {
        Car result=this.carService.createCar(car);
        assertNotNull(result);
        assertEquals(4,result.getId());
    }

    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void shouldNotCreateCarWithNullValues() throws Exception {
        Car car1=new Car();
        Car result=this.carService.createCar(car1);
        assertNull(result);
    }


    @Test
    public void shouldFindCarsById() throws Exception {
        Car result = this.carService.findById(1);
        assertNotNull(result);
        assertEquals("hyundai", result.getMake());
    }

    @Test
    public void shouldNotFindCarByIDWhichDoesNotExist() throws Exception {
        Car result = this.carService.findById(5);
        assertNull(result);
    }

    @Test
    public void shouldFindCarByName() throws Exception {
       List<Car> result = this.carService.findByMake("hyundai");
        assertNotNull(result);
        assertEquals(2,result.size());
    }

    @Test
    public void shouldNotFindCityWhichDoesNotExist() throws Exception {
        List<Car> result = this.carService.findByMake("make");
        assertEquals(0,result.size());
    }

    @Test
    public void shouldDeleteCarById() throws Exception {
        this.carService.deleteById(1);
        Car result= this.carService.findById(1);
        assertNull(result);
    }
}