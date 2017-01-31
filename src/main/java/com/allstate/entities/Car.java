package com.allstate.entities;


import com.allstate.enums.CarType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    private int id;
    private int version;
    private String make;
    private String model;
    private int year;
    private CarType type;
    private Date created;
    private Date modified;
    private List<Trip> tripList;

    public Car() {
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
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @NotNull
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('BASIC','LUX')")
    public CarType getType() {
        return type;
    }
    public void setType(CarType type) {
        this.type = type;
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

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    public List<Trip> getTripList() {
        return tripList;
    }
    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }
}
