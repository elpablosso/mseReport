package com.airplanes.pablo.locations.interfaces;
public interface Location {

    double deltaX(Location location);
    double deltaY(Location location);
    double distanceTo(Location location);

    void setX(double value);
    void setY(double value);
    double getX();
    double getY();

}
