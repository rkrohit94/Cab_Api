package com.allstate.entities;

import com.allstate.enums.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="trips")
public class Trip {

    private int id;
    private int version;
    private Car car;
    private City city;
    private Driver driver;
    private Passenger passenger;
    private int kmsDriven;
    private Date tripStartTime;
    private Date tripEndTime;
    private int tripCost;
    private int tip;
    private int totalTripCost;
    private Date created;
    private Date modified;


    public Trip(Car car, City city, Driver driver, Passenger passenger) {
        this.car = car;
        this.city = city;
        this.driver = driver;
        this.passenger = passenger;
    }


    public Trip() {
    }


    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name="car_id")
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    @JoinColumn(name="city_id")
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToOne
    @JoinColumn(name="passenger_id")
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @NotNull
    public int getKmsDriven() {
        return kmsDriven;
    }
    public void setKmsDriven(int kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    @CreationTimestamp
    public Date getTripStartTime() {
        return tripStartTime;
    }
    public void setTripStartTime(Date tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    @UpdateTimestamp
    public Date getTripEndTime() {
        return tripEndTime;
    }
    public void setTripEndTime(Date tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    @NotNull
    public int getTripCost() {
        return tripCost;
    }
    public void setTripCost(int tripCost) {
        this.tripCost = tripCost;
    }

    @NotNull
    public int getTip() {
        return tip;
    }
    public void setTip(int tip) {
        this.tip = tip;
    }

    @NotNull
    public int getTotalTripCost() {
        return totalTripCost;
    }
    public void setTotalTripCost(int totalTripCost) {
        this.totalTripCost = totalTripCost;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
}
