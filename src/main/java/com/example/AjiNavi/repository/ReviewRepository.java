package com.example.AjiNavi.repository;

import com.example.AjiNavi.entity.Review;

import java.util.List;

public interface ReviewRepository {
    void add(Review review);

    List<Review> selectByRestaurantId(int restaurantId);

    void update(Review review);

    void delete(Review review);
}
