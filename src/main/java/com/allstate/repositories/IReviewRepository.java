package com.allstate.repositories;

import com.allstate.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends CrudRepository<Review,Integer>{
    public Review findReviewByReviewer(String reviewer);
}
