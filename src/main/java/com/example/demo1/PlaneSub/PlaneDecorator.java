package com.example.demo1.PlaneSub;

import com.example.demo1.ConcreteObjects.Plane;

public class PlaneDecorator extends Plane {
    public Plane plane;
    public PlaneDecorator(Plane plane){
        this.plane=plane;
    }

    public PlaneDecorator() {

    }

    public Plane getPlane() {
        return plane;
    }
}
