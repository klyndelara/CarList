package com.KimlynsPractice.demo.controller;

import com.KimlynsPractice.demo.dao.CarsDao;
import com.KimlynsPractice.demo.model.Cars;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

//@RestController annotation gives Spring context for this class.
// Prevents us from needing to write annotations on every method that tell Spring they are controller related.
//@RequestMapping at the class level like this allows us to define a base path for all controller methods in this class.
//@CrossOrigin allows for Cross-Origin Resource Sharing -- disabled by default for security. Should be used carefully in live production due to vulnerabilities.
@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarsController {

//    We use CarsDao (the interface) because we've annotated the @Component tag on the JdbcCarsDao.
//    By implementing carsDao, JdbcCarsDao qualifies 'as a' CarsDao as well.
//    The @Component tag on our JdbcCarsDao allows Spring to use it as a CarsDao where called for/needed, like in our constructor below.
    private CarsDao carsDao;

    public CarsController (CarsDao carsDao){
        this.carsDao = carsDao;

    }
//    Controller method that listens at the "/cars" path for GET requests.
//    Provides a List of all Cars from the database as a response, by using our JdbcCarsDao.
//    On the client side, this will be seen in JSON form.
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Cars> getCars() { return carsDao.getCars(); }

//    Controller method that listens at the "/cars/{id}" path for GET requests.
//    Provides a specific Cars object that matches the provided id.
//    The id is collected by Spring as an int id because of the @PathVariable annotation and our {id} field in the path.
//    Both the @PathVariable and variable defined in {} in the path need to match, but, can be named anything.
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Cars getCar(@PathVariable int id) {
        Cars cars = carsDao.getCarById(id);

        if (cars == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Car Not Found");
        }else {
            return cars;
        }
    }

//    Controller method to create an entry in the cars table within the database.
//    Listens at the "/cars" path for POST requests. Requires a Cars object in the body of the request.
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

//    Controller method that deletes an entry in the cars table within the database.
//    Listens at the "/cars/{id}" path for DELETE requests.
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCar(@PathVariable int id) {
        carsDao.delete(id);
    }



}
