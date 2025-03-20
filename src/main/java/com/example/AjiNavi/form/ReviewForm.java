package com.example.AjiNavi.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.sql.Date;

@Data
public class ReviewForm {
    @NotNull(message="入力して下さい")
    @Min(value=1, message="1以上の数字を入力して下さい")
    private Integer restaurantId;

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
}
