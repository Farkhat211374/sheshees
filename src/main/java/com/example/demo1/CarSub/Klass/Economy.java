package com.example.demo1.CarSub.Klass;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Economy extends CarDecorator {
    public Economy(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed();
    }
    public double getKpl() {
        return car.getKpl()*0.9;
    }
    public double getFuelPrice() {
        return car.getFuelPrice();
    }
    public String getDescription(){
        return car.getDescription()+" Economy class";
    }
}
