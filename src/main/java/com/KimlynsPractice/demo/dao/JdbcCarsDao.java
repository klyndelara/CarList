package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.Cars;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//Implementation of the CarsDao interface.
//
//Because this class is 'implementing' CarsDao, it is responsible for supplying the logic for
//the methods defined by the interface.

//The @Component annotation is a way of tagging a class in a Spring project so that it can be injected elsewhere in your project.
//An example of this is when you inject Daos into your Controller constructors.

@Component
public class JdbcCarsDao implements CarsDao {

//    JdbcTemplate is a class provided by the Spring framework. It simplifies the use of Java DataBase Connectivity (JDBC).
//    import org.springframework.jdbc.core.JdbcTemplate;
//    JdbcTemplate is necessary for our JdbcCarsDao to function properly. We can refer to JdbcTemplate as a dependency.
//    By declaring JdbcTemplate and passing it into our constructor as you see below, we are performing what is called 'dependency injection.'
//    This allows us to ensure that vital dependencies are properly allocated and available for our JdbcCarsDao.

    private final JdbcTemplate jdbcTemplate;

    public JdbcCarsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
//    Method to retrieve a List of Cars objects by pulling data from our 'cars' table in the database.
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
//   Method to retrieve a Cars object (name should be singular, but I forgive you) that match a provided car_id.
    public Cars getCarById(int carId){
        String sql = "Select * From cars where car_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, carId);
        if (results.next()) {
            return mapRowToCars(results);
        } else {
            return null;
        }
    }
    @Override
//    Method to create/insert data into the Cars table. Requires a Cars object as a parameter.
    public int insert (Cars car) {
        String sql = "Insert into cars(model, make) values (?,?) returning car_id";
        int newCarId = jdbcTemplate.queryForObject(sql, int.class, car.getModel(), car.getMake());
        return newCarId;
    }



    @Override
//    Method to delete data from the Cars table. Requires a carId to identify the specific entry to delete.
//    memberscar is a dependent table, so we have to delete any references to the car_id before we can remove the cars entry.
    public void delete (int carId) {
        String sql = "Delete from memberscar where car_id = ?";
        jdbcTemplate.update(sql, carId);
        sql = "Delete from cars where car_id = ?";
        jdbcTemplate.update(sql, carId);
    }

//    Mapping method for translating SqlRowSet data into a Java object that models the table columns into equivalent object properties.
    private Cars mapRowToCars (SqlRowSet rowSet){
        Cars cars = new Cars();
        cars.setCarId(rowSet.getInt("car_id"));
        cars.setMake(rowSet.getString("make"));
        cars.setModel(rowSet.getString("model"));
        return cars;
    }

}