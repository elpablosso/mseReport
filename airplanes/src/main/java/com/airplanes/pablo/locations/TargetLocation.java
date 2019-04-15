package com.airplanes.pablo.locations;
import com.airplanes.pablo.locations.interfaces.Location;
import com.airplanes.pablo.locations.interfaces.TripPlanner;

public class TargetLocation implements TripPlanner {

    private Location currentLocation;
    private Location target;
    private double distance;
    private double deltaX;
    private double deltaY;

    private final double stepValue = 10;

    private int numberOfSteps;
    private double stepX;
    private double stepY;
    private double lastStepX;
    private double lastStepY;

    public TargetLocation(Location currentLocation, Location target) {
        this.currentLocation = currentLocation;
        this.target = target;

        distance = currentLocation.distanceTo(target);
        deltaX = currentLocation.deltaX(target);
        deltaY = currentLocation.deltaY(target);

        numberOfSteps = calculateNumberOfSteps();
        stepX = calculateStepX();
        stepY = calculateStepY();
        lastStepX = calculateLastStepX();
        lastStepY = calculateLastStepY();
    }

    public int calculateNumberOfSteps() {
        return (int) (currentLocation.distanceTo(target)%stepValue==0 ?
                distance/stepValue : distance/stepValue+1);
    }

    public double calculateStepX() {
        return deltaX/numberOfSteps;
    }

    public double calculateStepY() {
        return deltaY/numberOfSteps;
    }

    public double calculateLastStepX() {
        return deltaX-stepX*numberOfSteps;
    }

    public double calculateLastStepY() {
        return deltaY-stepY*numberOfSteps;
    }
}
