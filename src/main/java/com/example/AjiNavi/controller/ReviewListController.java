package com.example.AjiNavi.controller;

import com.example.AjiNavi.entity.Review;
import com.example.AjiNavi.form.ReviewSerchForm;
import com.example.AjiNavi.service.ReviewListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewListController {

    private final ReviewListService service;

    @PostMapping("/serch-review")
    private String serchReview(@ModelAttribute ReviewSerchForm form, Model model) {

        List<Review> list = service.findByRestaurantId(form.getRestaurantId());


        if (list.size() > 0) {
            model.addAttribute("reviewList", list);
        }

        return "review-list";
    }
}
