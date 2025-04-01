package com.example.AjiNavi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int restaurantId;
    private String restaurantName;
    private String catchPhrase;
    private double averageRating;

    public String formatAberageRating() {
        String result;
        if (averageRating == 0) {
            result = "評価なし";
        } else {
            result = String.format("%.1f", averageRating);
        }

        return  result;
    }
}
