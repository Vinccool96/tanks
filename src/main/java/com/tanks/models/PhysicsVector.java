package com.tanks.models;

import com.tanks.utils.Angles;

public class PhysicsVector {
    private double orientation;
    private double magnitude;
    private double x;
    private double y;

    public PhysicsVector() {
        this.orientation = 0;
        this.magnitude = 0;
        this.x = 0;
        this.y = 0;
    }

    public void setVectorMagnitude(double orientation, double magnitude) {
        this.orientation = Angles.angle(orientation);
        this.magnitude = magnitude < 0 ? -magnitude : magnitude;
        setXY();
    }

    public void setVectorXY(double x, double y) {
        this.x = x;
        this.y = y;
        setOM();
    }

    public double getOrientation() {
        return orientation;
    }

    public void setOrientation(double orientation) {
        this.orientation = Angles.angle(orientation);
        setXY();
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude < 0 ? -magnitude : magnitude;
        setXY();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        setOM();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        setOM();
    }

    public void turn180Degrees() {
        double newOrientation = this.orientation + 180;
        setVectorMagnitude(newOrientation, this.magnitude);
    }

    private void setXY() {
        double xTemp = this.magnitude * Math.cos(Math.toRadians(this.orientation));
        this.x = xTemp - (xTemp % 1E-11);

        double yTemp = this.magnitude * Math.sin(Math.toRadians(this.orientation));
        this.y = yTemp - (yTemp % 1E-11);
    }

    private void setOM(){
        this.orientation = Angles.fromXY(this.x, this.y);
        this.magnitude = Math.pow(this.x * this.x + this.y * this.y, 0.5);
    }
}
