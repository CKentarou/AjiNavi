package com.example.AjiNavi.service;

import com.example.AjiNavi.entity.Review;
import com.example.AjiNavi.repository.ReviewRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewListServiceImpl implements ReviewListService{

    private final ReviewRepositoryImpl repository;

    @Override
    public List<Review> findByRestaurantId(int restaurantId) {
        List<Review> list = repository.selectByRestaurantId(restaurantId);

        return list;
    }
}
