package com.example.demo1.CarSub.BodyType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Sedan extends CarDecorator {
    public Sedan(Car car) {
        super(car);
        car.setBodyType(1);
    }

    public String getDescription(){
        return car.getDescription()+" with body type Sedan";
    }
}
