package com.example.AjiNavi.controller;

import com.example.AjiNavi.form.ReviewForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String confirmRegistReview(@Validated @ModelAttribute ReviewForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "regist-review";
        }

        model.addAttribute("msg", "登録されました");
        return "complete-regist-review";
    }

}
