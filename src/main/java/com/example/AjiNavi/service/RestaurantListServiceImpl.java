package com.example.AjiNavi.service;

import com.example.AjiNavi.entity.Restaurant;
import com.example.AjiNavi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //ステレオタイプアノテーション（このアノテーションがついてるやつがコンポーネントスキャンの対象になる）
@RequiredArgsConstructor
public class RestaurantListServiceImpl implements RestaurantListService{

    private final RestaurantRepository repository;

    @Override
    public List<Restaurant> findByNameWildcard(String restaurantName) {
        List<Restaurant> list = repository.selectByNameWildcard(restaurantName);

        return list;
    }
}
