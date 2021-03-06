package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="passengers")
public class Passenger {

    private int id;
    private int version;
    private String name;
    private int age;
    private Gender gender;
    private int creditBalance;
    private Date created;
    private Date modified;
    private List<Trip> tripList;
    private City city;
    private List<Driver> driverList;
    private List<Review> reviewList;

    public Passenger() {
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

    @NotNull
    public int getCreditBalance() {
        return creditBalance;
    }
    public void setCreditBalance(int creditBalance) {
        this.creditBalance = creditBalance;
    }

    @OneToMany(mappedBy = "passenger")
    @JsonIgnore
    public List<Trip> getTripList() {
        return tripList;
    }
    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @ManyToOne
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    @ManyToMany
    @JoinTable(name = "trips",
            joinColumns = @JoinColumn(name = "passenger_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"))
    @JsonIgnore
    public List<Driver> getDriverList() {
        return driverList;
    }
    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    @OneToMany(mappedBy = "passenger")
    @JsonIgnore
    public List<Review> getReviewList() {
        return reviewList;
    }
    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
