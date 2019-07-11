package game.movement;

import game.MoveTank;
import models.PhysicsVector;
import models.Tank;

public class RotateTank {

    public static void rotate(Tank tank) {
        double width = tank.getWidth();
        double leftSpeed = tank.getLeftSpeed();
        double rightSpeed = tank.getRightSpeed();
        double radius = getRadius(width, leftSpeed, rightSpeed);
        double angularVelocity = getAngularVelocity(radius, leftSpeed, rightSpeed);
        PhysicsVector vector = getRadiusVector(radius, tank.getOrientation());
        double rotationPointX = tank.getPosX() + vector.getX();
        double rotationPointY = tank.getPosY() + vector.getY();
        PhysicsVector nextVector = getNextVector(vector, angularVelocity);
        tank.setPosX(rotationPointX + nextVector.getX());
        tank.setPosY(rotationPointY + nextVector.getY());
        tank.setOrientation(nextVector.getOrientation());
    }

    private static double getRadius(double width, double leftSpeed, double rightSpeed) {
        double radius;
        if (leftSpeed > rightSpeed) {
            radius = (width / 2) * ((leftSpeed + rightSpeed) / (leftSpeed - rightSpeed));
        } else {
            radius = -(width / 2) * ((rightSpeed + leftSpeed) / (rightSpeed - leftSpeed));
        }
        return radius;
    }

    private static double getAngularVelocity(double radius, double leftSpeed, double rightSpeed) {
        double angularVelocityAsRad = (rightSpeed + leftSpeed) / (2 * radius);
        double angularVelocity = Math.toDegrees(angularVelocityAsRad);
        return leftSpeed > rightSpeed ? -angularVelocity : angularVelocity;
    }

    private static PhysicsVector getRadiusVector(double radius, double orientation) {
        PhysicsVector vector = new PhysicsVector();
        double nextOrientation = radius < 0 ? orientation + 90 : orientation - 90;
        if (radius < 0) {
            radius = -radius;
        }
        vector.setVectorMagnitude(nextOrientation, radius);
        return vector;
    }

    private static PhysicsVector getNextVector(PhysicsVector vector, double angularVelocity) {
        PhysicsVector nextVector = new PhysicsVector();
        double nextOrientation = vector.getOrientation() + (angularVelocity * MoveTank.TIME_OF_STEP);
        nextVector.setVectorMagnitude(nextOrientation, vector.getMagnitude());
        return nextVector;
    }

    private static double nextOrientation(double radius, double orientation){
        return radius < 0 ? orientation - 90 : orientation + 90;
    }
}
