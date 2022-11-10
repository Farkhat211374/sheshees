package com.example.demo1.CarSub.BodyType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Sport extends CarDecorator {
    public Sport(Car car) {
        super(car);
        car.setBodyType(4);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+90;
    }
    public double getKpl() {
        return car.getKpl()+0.1;
    }
    public String getDescription(){
        return car.getDescription()+" with body type Sport";
    }
}
