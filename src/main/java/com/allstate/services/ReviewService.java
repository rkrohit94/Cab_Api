package com.allstate.services;


import com.allstate.entities.Review;
import com.allstate.repositories.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private IReviewRepository reviewRepository;

    @Autowired
    public void setReviewRepository(IReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review){
       return this.reviewRepository.save(review);
    }

    public Review findReviewByReviewer(String reviewer){
        return this.reviewRepository.findReviewByReviewer(reviewer);
    }
}
