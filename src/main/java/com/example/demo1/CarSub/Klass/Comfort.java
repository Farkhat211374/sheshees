package com.example.demo1.CarSub.Klass;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class Comfort extends CarDecorator {
    public Comfort(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+10;
    }
    public double getKpl() {
        return car.getKpl();
    }
    public double getFuelPrice() {
        return car.getFuelPrice()+10;
    }
    public String getDescription(){
        return car.getDescription()+" Comfort class";
    }
}
