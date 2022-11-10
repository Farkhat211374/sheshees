package com.example.demo1.CarSub.BodyType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Minivan extends CarDecorator {
    public Minivan(Car car) {
        super(car);
        car.setBodyType(6);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+10;
    }
    public double getKpl() {
        return car.getKpl()+0.06;
    }
    public String getDescription(){
        return car.getDescription()+" with body type Minivan";
    }
}
