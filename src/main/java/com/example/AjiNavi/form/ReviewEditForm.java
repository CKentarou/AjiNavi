package com.example.AjiNavi.form;

import com.example.AjiNavi.entity.Review;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.sql.Date;

@Data
public class ReviewEditForm {
    @NotNull(message="入力して下さい")
    @Min(value=1, message="正の整数を入力してください")
    private Integer reviewId;

    @NotNull(message="入力して下さい")
    @Min(value=1, message="1以上の数字を入力して下さい")
    private Integer restaurantId;

    private String restaurantName;

    @Size(min=4, max=16, message="4文字から16文字で指定してください。")
    private String userId;

    @Past(message="今日以前の日付を入力してください。")
    private Date visitDate;

    @NotNull(message="入力してください。")
    @Min(value=1, message="1-5で指定してください。")
    @Max(value=5, message="1-5で指定してください。")
    private Integer rating;

    @Size(min=1, max=128, message="1文字から128文字で指定してください。")
    private String comment;

    public Review toReview() {
        Review r = new Review();
        r.setUserId(this.getUserId());
        r.setRestaurantId(this.getRestaurantId());
        r.setVisitDate(this.getVisitDate());
        r.setRating(this.getRating());
        r.setComment(this.getComment());
        r.setReviewId(this.getReviewId());

        return r;
    }
}
