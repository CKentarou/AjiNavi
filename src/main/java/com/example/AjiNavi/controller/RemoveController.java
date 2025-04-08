package com.example.AjiNavi.controller;

import com.example.AjiNavi.entity.Review;
import com.example.AjiNavi.form.ReviewEditForm;
import com.example.AjiNavi.form.ReviewRemoveForm;
import com.example.AjiNavi.service.ReviewEditServiceImpl;
import com.example.AjiNavi.service.ReviewRemoveServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class RemoveController {

    private final ReviewRemoveServiceImpl service;

    @PostMapping("/remove-form")
    public String confirmRemoveReview(ReviewRemoveForm form, RedirectAttributes redirectAttributes) {

        Review r = form.toReview();

        service.removeReview(r);

        System.out.println("レビューの削除" + r);
        redirectAttributes.addFlashAttribute("msg", "(レビュー削除)");

        return "redirect:/complete";
    }

}
