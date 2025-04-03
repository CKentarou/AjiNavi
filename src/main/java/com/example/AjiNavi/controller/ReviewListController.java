package com.example.AjiNavi.controller;

import com.example.AjiNavi.entity.Review;
import com.example.AjiNavi.form.ReviewSerchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReviewListController {

    @PostMapping("/serch-review")
    private String serchReview(@ModelAttribute ReviewSerchForm form, Model model) {

        List<Review> list = new ArrayList<Review>();

        //仮のレビューデータを作成
        Review review = new Review();
        review.setReviewId(1);
        review.setRestaurantId(1);
        review.setUserId("user1");
        review.setVisitDate(Date.valueOf("2027-07-01"));
        review.setRating(3);
        review.setComment("comment1");
        list.add(review);
        review = new Review();
        review.setReviewId(2);
        review.setRestaurantId(2);
        review.setUserId("user2");
        review.setVisitDate(Date.valueOf("2027-07-02"));
        review.setRating(4);
        review.setComment("comment2");
        list.add(review);

        if (list.size() > 0) {
            model.addAttribute("reviewList", list);
        }

        return "review-list";
    }
}
