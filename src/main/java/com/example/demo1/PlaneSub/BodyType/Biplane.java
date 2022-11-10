package com.example.demo1.PlaneSub.BodyType;

import com.example.demo1.ConcreteObjects.Plane;
import com.example.demo1.PlaneSub.PlaneDecorator;

public class Biplane extends PlaneDecorator {
    public Biplane(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed()-40;
    }
    public double getBaggage() {
        return plane.getBaggage()+190;
    }
    public String getDescription(){
        return plane.getDescription()+" with body type Biplane";
    }
}

