package com.example.demo1.CarSub.FuelType;

import com.example.demo1.CarSub.CarDecorator;
import com.example.demo1.ConcreteObjects.Car;

public class NaturalGas extends CarDecorator {

    public NaturalGas(Car car) {
        super(car);
        car.setFuelType(5);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()-8;
    }
    public double getKpl() {
        return car.getKpl()*0.9;
    }
    public double getFuelPrice() {
        return car.getFuelPrice()-15;
    }
    public String getDescription(){
        return car.getDescription()+" with fuel type NaturalGas";
    }
}
