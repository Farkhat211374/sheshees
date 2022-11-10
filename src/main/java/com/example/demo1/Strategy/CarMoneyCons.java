package com.example.demo1.Strategy;

import com.example.demo1.ConcreteObjects.Car;

public class CarMoneyCons implements MoneyStrategy {

    Car car = new Car();
    CarDisplacement carDisplacement = new CarDisplacement();

    public void setCar(Car car) {
        this.car = car;
        carDisplacement.setCar(car);
    }

    @Override
    public double money(double distance) {
        return car.getKpl()*distance*car.getFuelPrice()
                +carDisplacement.displacement(distance)*car.getRoad()
                +carDisplacement.displacement(distance)*car.getDriver();
    }
}
