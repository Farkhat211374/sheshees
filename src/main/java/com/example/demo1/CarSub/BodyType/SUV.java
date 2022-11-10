package com.example.demo1.CarSub.BodyType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class SUV extends CarDecorator {
    public SUV(Car car) {
        super(car);
        car.setBodyType(3);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()-5;
    }
    public double getKpl() {
        return car.getKpl()+0.07;
    }
    public String getDescription(){

        return car.getDescription()+" with body type SUV";
    }
}
