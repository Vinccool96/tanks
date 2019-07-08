package models;

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
        this.orientation = orientation < 0 ? (-orientation) % 360.0 : orientation % 360.0;
        this.magnitude = magnitude < 0 ? -magnitude : magnitude;
        this.x = magnitude * Math.cos(Math.toRadians(orientation));
        this.y = magnitude * Math.sin(Math.toRadians(orientation));
    }

    public void setVectorXY(double x, double y) {
        this.x = x;
        this.y = y;
        this.orientation = x == 0 ? 90 : x < 0 ? Math.toDegrees(Math.atan(y / x)) + 180 :
                (y < 0 ? Math.toDegrees(Math.atan(y / x)) + 360 : Math.toDegrees(Math.atan(y / x)));
        this.magnitude = Math.pow(x * x + y * y, 0.5);
    }

    public double getOrientation() {
        return orientation;
    }

    public void setOrientation(double orientation) {
        this.orientation = orientation;
        this.x = this.magnitude * Math.cos(Math.toRadians(orientation));
        this.y = this.magnitude * Math.sin(Math.toRadians(orientation));
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
        this.x = this.magnitude * Math.cos(Math.toRadians(orientation));
        this.y = this.magnitude * Math.sin(Math.toRadians(orientation));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        this.orientation = x == 0 ? 90 : x < 0 ? Math.toDegrees(Math.atan(this.y / x)) + 180 :
                (this.y < 0 ? Math.toDegrees(Math.atan(this.y / x)) + 360 : Math.toDegrees(Math.atan(this.y / x)));
        this.magnitude = Math.pow(x * x + this.y * this.y, 0.5);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        this.orientation = this.x == 0 ? 90 : this.x < 0 ? Math.toDegrees(Math.atan(y / this.x)) + 180 :
                (y < 0 ? Math.toDegrees(Math.atan(y / this.x)) + 360 : Math.toDegrees(Math.atan(y / this.x)));
        this.magnitude = Math.pow(this.x * this.x + y * y, 0.5);
    }
}
