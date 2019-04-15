package com.airplanes.pablo.locations;

import com.airplanes.pablo.locations.interfaces.Location;
import com.airplanes.pablo.locations.interfaces.Movable;

public abstract class FlyingObject implements Movable {

    private Location location;
    private TargetLocation targetLocation;

    public void setTargetLocation(Location target) {
        targetLocation = new TargetLocation(location,target);
    }

    public void increaseX(double value) {
        location.setX(location.getX()+value);
    }

    public void increaseY(double value) {
        location.setY(location.getY()+value);
    }
}
