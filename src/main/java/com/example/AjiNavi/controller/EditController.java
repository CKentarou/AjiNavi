package com.example.AjiNavi.controller;

import com.example.AjiNavi.entity.Review;
import com.example.AjiNavi.form.ReviewEditForm;
import com.example.AjiNavi.form.ReviewForm;
import com.example.AjiNavi.service.RegistService;
import com.example.AjiNavi.service.ReviewEditServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class EditController {

    private final ReviewEditServiceImpl service;

    @PostMapping("show-edit-form")
    public String showEditForm(@ModelAttribute ReviewEditForm form) {
        return "edit-review";
    }


    @PostMapping("/confirm-edit-review")
    public String confirmEditReview(@Validated ReviewEditForm form, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "edit-review";
        }

        Review r = form.toReview();

        service.editReview(r);

        System.out.println("レビューの更新" + r);
        redirectAttributes.addFlashAttribute("msg", "(レビュー更新)");

        return "redirect:/complete";
    }

}
