package com.tanks.models.game;

import com.tanks.models.game.tank.parts.Turret;
import com.tanks.utils.Angles;

public class Tank {

    private double orientation = 0.0;
    private double leftSpeed = 0;
    private double rightSpeed = 0;
    private double width = 25.0;
    private double length = 50.0;
    private Turret turret = new Turret();

    public Tank() {
    }

    public Tank(double orientation, double width, double length) {
        this.orientation = Angles.angle(orientation);
        this.width = width;
        this.length = length;
    }

    public double getOrientation() {
        return orientation;
    }

    public void setOrientation(double orientation) {
        this.orientation = Angles.angle(orientation);
    }

    public double getLeftSpeed() {
        return leftSpeed;
    }

    private void setLeftSpeed(double leftSpeed) {
        this.leftSpeed = leftSpeed;
    }

    public void setLeftSpeed(float leftAxisY) {
        double leftSpeed = (((double) leftAxisY) * 10.0);
        double l = leftSpeed - (leftSpeed % 1.0);
        setLeftSpeed(l);
    }

    public double getRightSpeed() {
        return rightSpeed;
    }

    private void setRightSpeed(double rightSpeed) {
        this.rightSpeed = rightSpeed;
    }

    public void setRightSpeed(float rightAxisY) {
        double rightSpeed = (((double) rightAxisY) * 10.0);
        double r = rightSpeed - (rightSpeed % 1.0);
        setRightSpeed(r);
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public Turret getTurret() {
        return turret;
    }
}
