package com.example.AjiNavi.service;

import com.example.AjiNavi.entity.Review;
import com.example.AjiNavi.repository.RegistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService{

    private final RegistRepository repository;

    @Override
    public void regist(Review review) {
        repository.add(review);
    }
}
