package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.Cars;

import java.util.List;

public interface CarsDao {

    List<Cars> getCars();

    Cars getById(int carId);
}
