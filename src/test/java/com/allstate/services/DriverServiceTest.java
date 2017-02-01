package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class DriverServiceTest {

    @Autowired
    private DriverService driverService;

    private Driver driver;

    @Before
    public void setUp() throws Exception {
        driver =new Driver();
        driver.setName("bob");
        driver.setGender(Gender.MALE);
        driver.setAge(30);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateDriver() throws Exception {
      Driver result=this.driverService.createDriver(driver);
      assertNotNull(result);
      assertEquals(4,result.getId());
    }


    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void shouldNotCreateDriverWithBadName() throws Exception {
        Driver driver1=new Driver();
        Driver result=this.driverService.createDriver(driver1);
        assertNull(result);
    }

    @Test
    public void shouldFindDriverById() throws Exception {
        Driver result=this.driverService.findById(1);
        assertEquals(1,result.getId());
        assertEquals("abc",result.getName());
    }


    @Test
    public void shouldNotFindDriverByBadId() throws Exception {
        Driver result=this.driverService.findById(5);
        assertNull(result);
    }

    @Test
    public void shouldFindDriverByName() throws Exception {
        Driver result=this.driverService.findByName("abc");
        assertEquals(1,result.getId());
    }

    @Test

    public void shouldNotFindDriverByBadName() throws Exception {
        Driver result=this.driverService.findByName("aaa");
        assertNull(result);
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldDeleteDriverById() throws Exception {
        this.driverService.deleteById(1);
        Driver result= this.driverService.findById(1);
        assertNull(result);
    }

    @Test
    public void shouldAddDriverViolation() throws Exception {
        Driver driver1 = this.driverService.findById(1);
        Driver result = this.driverService.addViolation(driver1);
        assertEquals(1,result.getViolations());
        assertEquals(1,result.getVersion());
    }

    @Test
    @Transactional
    public void shouldFindListOfCitiesDrivenByDriver() throws Exception {

        Driver driver1 =this.driverService.findById(1);
        List<City> cityList = driver1.getCity();
        assertEquals(1,cityList.size());
    }

    @Test
    @Transactional
    public void shouldFindListOfCarsOfDriver() throws Exception{
        Driver driver1 =this.driverService.findById(1);
        List<Car> carsList = driver1.getCarsList();
        assertEquals(2,carsList.size());
    }

    @Test
    @Transactional
    public void shouldFindListOfTripsByDriver() throws Exception {
        Driver driver1 =this.driverService.findById(1);
        List<Trip> tripList = driver1.getTripList();
        assertEquals(2,tripList.size());

    }
}