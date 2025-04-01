package com.example.AjiNavi.controller;

import com.example.AjiNavi.entity.Restaurant;
import com.example.AjiNavi.form.RestaurantSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantListController {
    @GetMapping("/top")
    private String restaurantList(@ModelAttribute RestaurantSearchForm form) {
        return "restaurant-list";
    }

    @PostMapping("/restaurant-search")
    private String restaurantSearch(@ModelAttribute RestaurantSearchForm form, Model model) {
        List<Restaurant> list = new ArrayList<Restaurant>();
        list.add(new Restaurant(1, "店舗１", "キャッチフレーズ", 3.5));
        list.add(new Restaurant(2, "店舗2", "キャッチフレーズ", 0.0));
        list.add(new Restaurant(3, "店舗3", "キャッチフレーズ", 4.2));

        model.addAttribute("restaurantList", list);

        return "restaurant-list";
    }
}
