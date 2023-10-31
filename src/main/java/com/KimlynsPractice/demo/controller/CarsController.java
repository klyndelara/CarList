package com.KimlynsPractice.demo.controller;

import com.KimlynsPractice.demo.dao.CarsDao;
import com.KimlynsPractice.demo.model.Cars;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
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

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Cars getCar(@PathVariable int id) {
        Cars cars = carsDao.getCarById(id);

        if (cars == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Car Not Found");
        }else {
            return cars;
        }
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Cars create(@RequestBody Cars car) {

        int carId = carsDao.insert(car);
        return carsDao.getCarById(carId);
    }
    //            try {
//            carId = carsDao.insert(car);
//        } catch(ResponseStatusException e){
//            e.getReason();
//        }
//            return carsDao.getCarById(carId);
//
//
//    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCar(@PathVariable int id) {
        carsDao.delete(id);
    }



}
