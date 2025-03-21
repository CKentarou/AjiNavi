package com.example.AjiNavi.repository;

import com.example.AjiNavi.entity.Review;
import org.springframework.stereotype.Repository;

@Repository
public class RegistRepositoryImpl implements RegistRepository{
    @Override
    public void add(Review review) {
        System.out.println(review);
    }
}
