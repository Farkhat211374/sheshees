package com.example.demo1.ConcreteObjects;

public class Plane {
    double baggage = 10.0;
    double speed = 340.0;
    double pilot = 0;
    String description="Plane";
    String decorator="1111";

    public double getPilot() {
        return pilot;
    }

    public double getBaggage() {
        return baggage;
    }

    public double getSpeed() {
        return speed;
    }

    public String getDescription() {
        return description;
    }

    public String getDecorator() {
        return decorator;
    }
}
