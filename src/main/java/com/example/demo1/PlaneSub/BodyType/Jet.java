package com.example.demo1.PlaneSub.BodyType;

import com.example.demo1.ConcreteObjects.Plane;
import com.example.demo1.PlaneSub.PlaneDecorator;

public class Jet extends PlaneDecorator {
    public Jet(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed()+560;
    }
    public double getBaggage() {
        return plane.getBaggage()+22;
    }
    public String getDescription(){
        return plane.getDescription()+" with body type Jet";
    }
}

