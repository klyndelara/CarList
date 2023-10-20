package com.KimlynsPractice.demo.controller;

import com.KimlynsPractice.demo.dao.CarsDao;
import com.KimlynsPractice.demo.model.Cars;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarsController {
    private CarsDao carsDao;

    public CarsController (CarsDao carsDao){
        this.carsDao = carsDao;

    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Cars> getCars() { return carsDao.getCars(); }

}
