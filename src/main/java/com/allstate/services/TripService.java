package com.allstate.services;

import com.allstate.entities.*;
import com.allstate.enums.CarType;
import com.allstate.repositories.IDriverRepository;
import com.allstate.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private ITripRepository tripRepository;
    private DriverService driverService;
    private PassengerService passengerService;
    private CarService carService;
    private CityService cityService;

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Autowired
    public void setTripRepository(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public Trip createTrip(Trip trip){
        Driver driver = this.driverService.findById(trip.getDriver().getId());
        Passenger passenger=this.passengerService.findById(trip.getPassenger().getId());
        Car car =this.carService.findById(trip.getCar().getId());
        City city=this.cityService.findById(trip.getCity().getId());
        int tripCost = city.getDayRate()*trip.getKmsDriven();

        if(car.getType()== CarType.LUX) {
            tripCost = (5 / 100) * tripCost;
        }

         int totalTripCost=tripCost + (trip.getTip() * tripCost)/100;

          trip.setTripCost(tripCost);
          trip.setTotalTripCost(totalTripCost);
            if (driver.getViolations() < 3 && passenger.getCreditBalance() > totalTripCost) {
                passenger.setCreditBalance(passenger.getCreditBalance() - totalTripCost);
                return this.tripRepository.save(trip);
            }
            else
                return null;
    }
    public Trip findById(int id){
        return  this.tripRepository.findOne(id);
    }

    public int findShortestTripDetails(int passenger_id){
        return this.tripRepository.findShortestTripDetails(passenger_id);
    }

    public int findLongestTripDetails(int passenger_id){
        return this.tripRepository.findLongestTripDetails(passenger_id);
    }


    public int findTotalMoneyByCity(int city_id){
        return this.tripRepository.findTotalMoneyByCity(city_id);
    }

    public int findTotalMoneyByDriver(int driver_id){
        return this.tripRepository.findTotalMoneyByDriver(driver_id);
    }

    public int findTotalMoneyByYear(int passenger_id){
        return this.tripRepository.findTotalMoneyByYear(passenger_id);
    }

    public int findTotalMoneyByMonth(int passenger_id){
        return this.tripRepository.findTotalMoneyByMonth(passenger_id);
    }
    public int findTotalMoneyByDay(int passenger_id){
        return this.tripRepository.findTotalMoneyByDay(passenger_id);
    }
}
