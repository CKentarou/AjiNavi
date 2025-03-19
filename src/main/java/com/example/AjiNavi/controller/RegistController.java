package com.example.AjiNavi.controller;

import com.example.AjiNavi.form.ReviewForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistController {

    @GetMapping("show-review-form")
    public String showReviewForm(@ModelAttribute ReviewForm form) {
        return "regist-review";
    }

    @PostMapping("/confirm-regist-review")
    public String confirmRegistReview(@ModelAttribute ReviewForm form,Model model) {
        model.addAttribute("msg", "登録されました");
        System.out.println(form);
        return "complete-regist-review";
    }
}
