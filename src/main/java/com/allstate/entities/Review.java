package com.allstate.entities;

import com.allstate.enums.ReviewType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="reviews")
public class Review {

    private int id;
    private int version;
    private int score;
    private String description;
    private Date created;
    private Date modified;
    private ReviewType reviewedBy;
    private Driver driver;
    private Passenger passenger;
    public Review() {
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
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @NotNull
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DRIVER','PASSENGER')")
    public ReviewType getReviewedBy() {
        return reviewedBy;
    }
    public void setReviewedBy(ReviewType reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    @ManyToOne
    @JoinColumn(name = "driver_id")
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
