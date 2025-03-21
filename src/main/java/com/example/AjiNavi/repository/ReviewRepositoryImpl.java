package com.example.AjiNavi.repository;

import com.example.AjiNavi.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

    private final JdbcTemplate jdbcTemplete;

    @Override
    public void add(Review review) {
        String sql = "INSERT INTO t_review (restaurant_id, user_id, visit_date, rating, comment) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplete.update(
                sql,
                review.getRestaurantId(),
                review.getUserId(),
                review.getVisitDate(),
                review.getRating(),
                review.getComment()
        );
    }
}
