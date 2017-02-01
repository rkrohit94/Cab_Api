package com.allstate.repositories;

import com.allstate.entities.Review;
import com.allstate.enums.ReviewType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends CrudRepository<Review,Integer>{
    public Review findReviewByReviewer(ReviewType reviewer);
}
