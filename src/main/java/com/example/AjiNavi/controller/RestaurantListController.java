package com.example.AjiNavi.controller;

import com.example.AjiNavi.entity.Restaurant;
import com.example.AjiNavi.form.RestaurantSearchForm;
import com.example.AjiNavi.service.RestaurantListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantListController {
    //ここで使用しているRestaurantListServiceはインターフェース型である。業務処理の実装クラスがなくても定義自体はできる。
    private final RestaurantListService service;

    @GetMapping("/top")
    private String restaurantList(@ModelAttribute RestaurantSearchForm form) {
        return "restaurant-list";
    }

    @PostMapping("/restaurant-search")
    private String restaurantSearch(@ModelAttribute RestaurantSearchForm form, Model model) {

        //formには入力された値が入っている。ゲッターを使って引数に渡す。
        List<Restaurant> list = service.findByNameWildcard(form.getRestaurantName());
        model.addAttribute("restaurantList", list);

        return "restaurant-list";
    }
}
