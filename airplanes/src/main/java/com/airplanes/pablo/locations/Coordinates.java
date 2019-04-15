package com.airplanes.pablo.locations;

import com.airplanes.pablo.locations.interfaces.Location;

public class Coordinates implements Location {

    private double x;
    private double y;


    public double deltaX(Location location) {
        return Math.abs(x-location.getX());
    }

    public double deltaY(Location location) {
        return Math.abs(y-location.getY());
    }

    public double distanceTo(Location location) {
        return Math.sqrt( Math.pow(deltaX(location),2) + Math.pow(deltaY(location),2) );
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
