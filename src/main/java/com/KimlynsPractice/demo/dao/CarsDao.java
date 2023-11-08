package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.Cars;

import java.util.List;


//Interface to define the intended functionality of the CarsDao.
//
// Classes that implement this interface carry the responsibility of defining HOW these methods return the values defined here.


public interface CarsDao {

    List<Cars> getCars();

    Cars getCarById(int carId);

    int insert(Cars car);

    void delete(int carId);
}