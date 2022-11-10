package com.example.demo1.PlaneSub.Klass;

import com.example.demo1.ConcreteObjects.Plane;
import com.example.demo1.PlaneSub.PlaneDecorator;

public class Economy extends PlaneDecorator {
    public Economy(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed();
    }
    public double getBaggage() {
        return plane.getBaggage()*2;
    }

    public String getDescription(){
        return plane.getDescription()+" Economy class";
    }
}