package models;

public class Tank {
    private double orientation = 0.0;
    private double leftSpeed = 0;
    private double rightSpeed = 0;
    private double posX = 0.0;
    private double posY = 0.0;
    private double width = 3.37;

    public Tank() {
    }

    public Tank(double orientation, double posX, double posY) {
        this.orientation = orientation;
        this.posX = posX;
        this.posY = posY;
    }

    public double getOrientation() {
        return orientation;
    }

    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    public double getLeftSpeed() {
        return leftSpeed;
    }

    private void setLeftSpeed(double leftSpeed) {
        this.leftSpeed = leftSpeed;
    }

    public void setLeftSpeed(float leftAxisXDelta) {
        double leftSpeed = (((double) leftAxisXDelta) * 10.0);
        setLeftSpeed(leftSpeed);
    }

    public double getRightSpeed() {
        return rightSpeed;
    }

    private void setRightSpeed(double rightSpeed) {
        this.rightSpeed = rightSpeed;
    }

    public void setRightSpeed(float rightAxisXDelta) {
        double rightSpeed = (((double) rightAxisXDelta) * 10.0);
        setRightSpeed(rightSpeed);
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
