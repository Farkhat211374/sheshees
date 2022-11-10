package com.example.demo1.CarSub.FuelType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Electric extends CarDecorator {

    public Electric(Car car) {
        super(car);
        car.setFuelType(3);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+10;
    }
    public double getKpl() {
        return car.getKpl()*0.9;
    }
    public double getFuelPrice() {
        return car.getFuelPrice()/2;
    }
    public String getDescription(){
        return car.getDescription()+" with fuel type Electric";
    }
}
