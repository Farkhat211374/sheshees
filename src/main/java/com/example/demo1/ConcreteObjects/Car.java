package com.example.demo1.ConcreteObjects;

public class Car{
    double fuelPrice = 50.0;
    double speed = 90.0;
    double kpl = 0.1; //на каждый метр, (100km - 10)
    double driver = 0;
    double road = 0;
    String description="Car";
    String decorator="1111";
    int bodyType=1,fuelType=1;

    public int getBodyType() {
        return bodyType;
    }

    public int getFuelType() {
        return fuelType;
    }

    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }

    public void setFuelType(int fuelType) {
        this.fuelType = fuelType;
    }

    public double getDriver() {
        return driver;
    }

    public double getRoad() {
        return road;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public double getSpeed() {
        return speed;
    }

    public double getKpl() {
        return kpl;
    }

    public String getDescription() {
        return description;
    }

    public String getDecorator() {
        return decorator;
    }
}
