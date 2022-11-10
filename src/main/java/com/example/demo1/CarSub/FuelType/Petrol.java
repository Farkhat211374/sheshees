package com.example.demo1.CarSub.FuelType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Petrol extends CarDecorator {
    public Petrol(Car car) {
        super(car);
        car.setFuelType(1);
    }
    @Override
    public String getDescription(){
        return car.getDescription()+" with fuel type petrol";
    }
}
