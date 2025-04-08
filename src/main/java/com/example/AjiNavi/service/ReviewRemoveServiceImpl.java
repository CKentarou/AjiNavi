package com.example.AjiNavi.service;

import com.example.AjiNavi.entity.Review;
import com.example.AjiNavi.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewRemoveServiceImpl implements ReviewRemoveService{

    private final ReviewRepository repository;

    @Override
    public void removeReview(Review review) {
        repository.delete(review);
    }
}
