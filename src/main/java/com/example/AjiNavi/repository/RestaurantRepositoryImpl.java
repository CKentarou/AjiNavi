package com.example.AjiNavi.repository;

import com.example.AjiNavi.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository{

    private final JdbcTemplate jdbcTemplete;

    @Override
    public List<Restaurant> selectByNameWildcard(String restaurantName) {
        String sql =
                "SELECT mr.restaurant_id, mr.restaurant_name, mr.catch_phrase, COALESCE(AVG(tr.rating), 0.0) AS average_rating " +
                        "FROM m_restaurant mr " +
                        "LEFT OUTER JOIN t_review tr ON mr.restaurant_id = tr.restaurant_id " +
                        "WHERE mr.restaurant_name LIKE ? " +
                        "GROUP BY mr.restaurant_id, mr.restaurant_name, mr.catch_phrase " +
                        "ORDER BY mr.restaurant_id ";


        String p = "%" + restaurantName + "%";//プレースホルダーの値
        List<Map<String, Object>> list = jdbcTemplete.queryForList(sql, p);

        List<Restaurant> result = new ArrayList<Restaurant>();
        for (Map<String, Object> one : list) {
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantId((int)one.get("restaurant_id"));
            restaurant.setRestaurantName((String)one.get("restaurant_name"));
            restaurant.setCatchPhrase((String)one.get("catch_phrase"));
            double d = ((BigDecimal)one.get("average_rating")).doubleValue();
            restaurant.setAverageRating(d);
            result.add(restaurant);
        }
        return result;
    }
}
