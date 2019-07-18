package com.tanks.models;

public class RelativeCoordinates {

    private double calcX;
    private double calcY;
    private double fxX;
    private double fxY;

    public RelativeCoordinates() {
        this.calcX = 0.0;
        this.calcY = 0.0;
        this.fxX = 0.0;
        this.fxY = 0.0;
    }

    public void setCalcX(double calcX) {
        this.calcX = calcX;
        this.setFX();
    }

    public void setCalcY(double calcY) {
        this.calcY = calcY;
        this.setFX();
    }

    private void setFX() {
        this.fxX = this.calcX;
        this.fxY = -this.calcY;
    }

    public double getFxX() {
        return fxX;
    }

    public double getFxY() {
        return fxY;
    }

    public void reset() {
        this.calcX = 0.0;
        this.calcY = 0.0;
        this.setFX();
    }
}
