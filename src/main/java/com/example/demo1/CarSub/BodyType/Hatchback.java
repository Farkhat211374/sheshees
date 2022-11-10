package com.example.demo1.CarSub.BodyType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Hatchback extends CarDecorator {
    public Hatchback(Car car) {
        super(car);
        car.setBodyType(2);
    }

    @Override
    public double getSpeed() {
        return car.getSpeed()+10;
    }
    public double getKpl() {
        return car.getKpl()-0.03;
    }
    public String getDescription(){
        return car.getDescription()+" with body type Hatchback";
    }
}
