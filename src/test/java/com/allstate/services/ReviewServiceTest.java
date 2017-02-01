package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Review;
import com.allstate.enums.ReviewType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class ReviewServiceTest {
    @Autowired
    private ReviewService reviewService;


    private  Review review;
    @Before
    public void setUp() throws Exception {
        review=new Review();
        review.setScore(5);
        review.setDescription("Good");
        review.setReviewedBy(ReviewType.DRIVER);
        Passenger passenger = new Passenger();
        passenger.setId(1);
        Driver driver = new Driver();
        driver.setId(1);
        review.setPassenger(passenger);
        review.setDriver(driver);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void ShouldCreateReview() throws Exception {
      Review result=this.reviewService.createReview(review);
      assertNotNull(result);
      assertEquals(1,result.getId());
    }

//    @Test
//    public void findReviewByReviewer() throws Exception {
//        Review result=this.reviewService.findReviewByReviewer("DRIVER");
//        assertNotNull(result);
//        assertEquals(1,result.getId());
//    }

}