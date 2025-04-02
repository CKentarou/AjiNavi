package com.example.AjiNavi.service;

import com.example.AjiNavi.entity.Restaurant;

import java.util.List;

public interface RestaurantListService {
    List<Restaurant> findByNameWildcard(String restaurantName);
}
