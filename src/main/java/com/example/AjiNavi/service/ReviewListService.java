package com.example.AjiNavi.service;

import com.example.AjiNavi.entity.Review;

import java.util.List;

public interface ReviewListService {
    List<Review> findByRestaurantId(int restaurantId);
}
