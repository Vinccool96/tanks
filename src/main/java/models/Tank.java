package models;

public class Tank {
    private double orientation = 0.0;
    private double leftSpeed = 0;
    private double rightSpeed = 0;
    private double posX = 0.0;
    private double posY = 0.0;
    private double width = 25.0;
    private double length = 50.0;

    public Tank() {
    }

    public Tank(double orientation, double posX, double posY, double width, double length) {
        this.orientation = orientation;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.length = length;
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
        setLeftSpeed(leftSpeed - (leftSpeed % 1.0));
    }

    public double getRightSpeed() {
        return rightSpeed;
    }

    private void setRightSpeed(double rightSpeed) {
        this.rightSpeed = rightSpeed;
    }

    public void setRightSpeed(float rightAxisXDelta) {
        double rightSpeed = (((double) rightAxisXDelta) * 10.0);
        setRightSpeed(rightSpeed - (rightSpeed % 1.0));
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

    public double getLength() {
        return length;
    }
}
