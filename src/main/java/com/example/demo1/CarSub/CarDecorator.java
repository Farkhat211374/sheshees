package com.example.demo1.CarSub;

import com.example.demo1.ConcreteObjects.Car;

public class CarDecorator extends Car {
    public Car car;

    public CarDecorator(Car car){
        this.car=car;
    }

    public CarDecorator() {

    }
    public int getBodyType() {
        return car.getBodyType();
    }

    public int getFuelType() {
        return car.getFuelType();
    }

    public Car getCar() {
        return car;
    }
}
