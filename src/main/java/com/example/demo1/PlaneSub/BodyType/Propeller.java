package com.example.demo1.PlaneSub.BodyType;

import com.example.demo1.ConcreteObjects.Plane;
import com.example.demo1.PlaneSub.PlaneDecorator;

public class Propeller extends PlaneDecorator {
    public Propeller(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed()-90;
    }
    public double getBaggage() {
        return plane.getBaggage()+200;
    }
    public String getDescription(){
        return plane.getDescription()+" with body type Propeller";
    }
}