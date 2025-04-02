package com.example.AjiNavi.repository;

import com.example.AjiNavi.entity.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> selectByNameWildcard(String restaurantName);
}
