package com.tanks.models.game.tank.parts;

import com.tanks.utils.Angles;

public class Turret {

    private double horizontalOrientation = 0.0;
    private double verticalOrientation = 0.0;

    public Turret() {
    }

    public double getHorizontalOrientation() {
        return horizontalOrientation;
    }

    public void setHorizontalOrientation(double horizontalOrientation) {
        this.horizontalOrientation = Angles.angle(horizontalOrientation);
    }

    public double getVerticalOrientation() {
        return verticalOrientation;
    }

    public void setVerticalOrientation(double verticalOrientation) {
        this.verticalOrientation = Angles.verticalAngle(verticalOrientation);
    }
}
