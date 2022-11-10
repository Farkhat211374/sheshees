package com.example.demo1.PlaneSub.Klass;

import com.example.demo1.ConcreteObjects.Plane;
import com.example.demo1.PlaneSub.PlaneDecorator;

public class Luxury extends PlaneDecorator {
    public Luxury(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed();
    }
    public double getBaggage() {
        return plane.getBaggage()*8;
    }

    public String getDescription(){
        return plane.getDescription()+" Luxury class";
    }
}
