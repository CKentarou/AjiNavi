package com.example.AjiNavi.form;

import lombok.Data;
import java.sql.Date;

@Data
public class ReviewForm {
    private Integer restaurantId;
    private String userId;
    private Date visitDate;
    private Integer rating;
    private String comment;
}
