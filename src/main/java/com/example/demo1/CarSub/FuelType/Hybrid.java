package com.example.demo1.CarSub.FuelType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Hybrid extends CarDecorator {
    public Hybrid(Car car) {
        super(car);
        car.setFuelType(4);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+8;
    }
    public double getKpl() {
        return car.getKpl()*0.67;
    }
    public double getFuelPrice() {
        return car.getFuelPrice()-20;
    }
    public String getDescription(){
        return car.getDescription()+" with fuel type Hybrid";
    }
}
