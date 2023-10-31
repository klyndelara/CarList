package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.Cars;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCarsDao implements CarsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCarsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Cars> getCars() {
        List<Cars> cars = new ArrayList<>();
        String carsSql = "Select * From cars;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(carsSql);
            while (results.next()) {
                Cars car = mapRowToCars(results);
                cars.add(car);
            }

        }catch (CannotGetJdbcConnectionException e) {
            System.out.println(e.getMessage());
        }
            return cars;
    }

    @Override
<<<<<<< HEAD
    public Cars getById(int carId){
=======
    public Cars getCarById(int carId){
>>>>>>> d4447df (Initial commit)
        String sql = "Select * From cars where car_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, carId);
        if (results.next()) {
            return mapRowToCars(results);
        } else {
            return null;
        }
    }
    private Cars mapRowToCars (SqlRowSet rowSet){
        Cars cars = new Cars();
        cars.setCarId(rowSet.getInt("car_id"));
        cars.setMake(rowSet.getString("make"));
        cars.setModel(rowSet.getString("model"));
        return cars;
    }

}