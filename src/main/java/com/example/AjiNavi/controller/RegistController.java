package com.example.AjiNavi.controller;

import com.example.AjiNavi.form.ReviewForm;
import com.example.AjiNavi.service.RegistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistController {

    private final RegistService service;

    @GetMapping("show-review-form")
    public String showReviewForm(@ModelAttribute ReviewForm form) {
        return "regist-review";
    }

    @PostMapping("/confirm-regist-review")
    public String confirmRegistReview(@Validated @ModelAttribute ReviewForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "regist-review";
        }

        String msg = service.regist();
        model.addAttribute("msg", msg);

        return "complete-regist-review";
    }

}
