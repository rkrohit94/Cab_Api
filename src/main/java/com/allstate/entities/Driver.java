package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.tools.javac.code.Attribute;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="drivers")
public class Driver {

    private int id;
    private int version;
    private String name;
    private int age;
    private Gender gender;
    private int violations;
    private Date created;
    private Date modified;
    private List<City> city;
    private List<Car> carsList;
    private List<Trip> tripList;
    private List<Passenger> passengerList;
    private List<Review> reviewList;

    public Driver() {
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('MALE','FEMALE')")
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @NotNull
    public int getViolations() {
        return violations;
    }
    public void setViolations(int violations) {
        this.violations = violations;
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

    @ManyToMany
    @JoinTable(name = "trips",
            joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
    @JsonIgnore
    public List<City> getCity() {
        return city;
    }
    public void setCity(List<City> city) {
        this.city = city;
    }

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    public List<Trip> getTripList() {
        return tripList;
    }
    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    public List<Car> getCarsList() {
        return carsList;
    }
    public void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }

    @ManyToMany(mappedBy = "driverList")
    @JsonIgnore
    public List<Passenger> getPassengerList() {
        return passengerList;
    }
    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    public List<Review> getReviewList() {
        return reviewList;
    }
    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
