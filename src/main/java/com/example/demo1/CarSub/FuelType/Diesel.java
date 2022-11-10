package com.example.demo1.CarSub.FuelType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Diesel extends CarDecorator {
    public Diesel(Car car) {
        super(car);
        car.setFuelType(2);

    }
    @Override
    public double getSpeed() {
        return car.getSpeed();
    }
    public double getKpl() {
        return car.getKpl()*0.8;
    }
    public double getFuelPrice() {
        return car.getFuelPrice()*2;
    }
    public String getDescription(){
        return car.getDescription()+" with fuel type Diesel";
    }
    public int getBodyType() {
        return car.getBodyType();
    }

    public int getFuelType() {
        return car.getFuelType();
    }
}
