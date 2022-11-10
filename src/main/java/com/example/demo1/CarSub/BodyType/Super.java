package com.example.demo1.CarSub.BodyType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Super extends CarDecorator {
    public Super(Car car) {
        super(car);
        car.setBodyType(5);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+210;
    }
    public double getKpl() {
        return car.getKpl()+0.3;
    }
    public String getDescription(){
        return car.getDescription()+" with body type Super";
    }
}
