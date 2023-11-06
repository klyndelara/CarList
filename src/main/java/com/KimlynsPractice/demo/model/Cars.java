package com.KimlynsPractice.demo.model;

public class Cars {
    private int carId;
    private String model;
    private String make;

//    public Cars (int carId, String model, String make) {
//        this.carId = carId;
//        this.model = model;
//        this.make = make;
//    }





    public Cars(){}

    public int getCarId(){
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }


    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
