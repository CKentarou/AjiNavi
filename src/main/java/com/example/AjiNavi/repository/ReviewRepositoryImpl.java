package com.example.AjiNavi.repository;

import com.example.AjiNavi.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Review> selectByRestaurantId(int restaurantId) {
        String sql = "SELECT review_id, restaurant_id, user_id, visit_date, rating, comment From t_review Where restaurant_id = ? ORDER BY visit_date DESC, review_id ASC";

        List<Map<String, Object>> list = jdbcTemplete.queryForList(sql, restaurantId);
        List<Review> result = new ArrayList<Review>();
        for (Map<String, Object> one : list) {
            Review review = new Review();
            review.setReviewId((Integer) one.get("review_id"));
            review.setRestaurantId((Integer) one.get("restaurant_id"));
            review.setUserId((String) one.get("user_id"));
            review.setVisitDate((Date)one.get("visit_date"));
            review.setRating((Integer) one.get("rating"));
            review.setComment((String) one.get("comment"));
            result.add(review);
        }
        return result;
    }

    @Override
    public void update(Review review) {
        String sql = "UPDATE t_review SET user_id = ?, visit_date = ?, rating = ?, comment = ? WHERE review_id = ?";

        jdbcTemplete.update(sql, review.getUserId(), review.getVisitDate(), review.getRating(), review.getComment(), review.getReviewId());
    }

    @Override
    public void delete(Review review) {
        String sql = "DELETE FROM t_review WHERE review_id = ?";
        jdbcTemplete.update(sql, review.getReviewId());
    }
}
