package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cities")
public class City {

    private int id;
    private int version;
    private String name;
    private String state;
    private int dayRate;
    private int nightRate;
    private Date created;
    private Date modified;
    private List<Driver> drivers;
    private List<Trip> tripList;
    private List<Passenger> passengerList;

    public City() {
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


    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @NotNull
    public int getDayRate() {
        return dayRate;
    }
    public void setDayRate(int dayRate) {
        this.dayRate = dayRate;
    }

    @NotNull
    public int getNightRate() {
        return nightRate;
    }
    public void setNightRate(int nightRate) {
        this.nightRate = nightRate;
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

    @ManyToMany(mappedBy = "city")
    @JsonIgnore
    public List<Driver> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    public List<Trip> getTripList() {
        return tripList;
    }
    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    public List<Passenger> getPassengerList() {
        return passengerList;
    }
    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
