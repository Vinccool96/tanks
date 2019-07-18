package com.tanks.game.movement;

import com.tanks.game.MoveTank;
import com.tanks.models.PhysicsVector;
import com.tanks.models.RelativeCoordinates;
import com.tanks.models.Tank;

public class RotateTank {

    public static void rotate(Tank tank, RelativeCoordinates relativeCoordinates) {
        double width = tank.getWidth();
        double leftSpeed = tank.getLeftSpeed();
        double rightSpeed = tank.getRightSpeed();
        double radius = getRadius(width, leftSpeed, rightSpeed);
        double angularVelocity = getAngularVelocity(radius, leftSpeed, rightSpeed, width);
        PhysicsVector radiusVector = getRadiusVector(radius, tank.getOrientation(), leftSpeed, rightSpeed);
        double rotationPointX = radiusVector.getX();
        double rotationPointY = radiusVector.getY();
        PhysicsVector nextVector = getNextVector(radiusVector, angularVelocity);
        relativeCoordinates.setCalcX(rotationPointX + nextVector.getX());
        relativeCoordinates.setCalcY(rotationPointY + nextVector.getY());
        tank.setOrientation(nextOrientation(radius, nextVector.getOrientation()));
    }

    private static double getRadius(double width, double leftSpeed, double rightSpeed) {
        double radius;
        if (leftSpeed == -rightSpeed) {
            radius = 0;
        } else if (leftSpeed > rightSpeed) {
            radius = (width / 2) * ((leftSpeed + rightSpeed) / (leftSpeed - rightSpeed));
        } else {
            radius = -(width / 2) * ((rightSpeed + leftSpeed) / (rightSpeed - leftSpeed));
        }
        return radius;
    }

    private static double getAngularVelocity(double radius, double leftSpeed, double rightSpeed, double width) {
        double angularVelocityAsRad = radius != 0 ? (rightSpeed + leftSpeed) / (2 * radius) : (2 * leftSpeed) / width;
        double angularVelocity = Math.toDegrees(angularVelocityAsRad);
        return leftSpeed > rightSpeed ? -angularVelocity : angularVelocity;
    }

    private static PhysicsVector getRadiusVector(double radius, double orientation, double leftSpeed,
            double rightSpeed) {
        PhysicsVector radiusVector = new PhysicsVector();
        double nextOrientation = radius < 0 ? orientation + 90 : orientation - 90;
        if (leftSpeed < rightSpeed) {
            radius = -radius;
        }
        radiusVector.setVectorMagnitude(nextOrientation, radius);
        return radiusVector;
    }

    private static PhysicsVector getNextVector(PhysicsVector radiusVector, double angularVelocity) {
        radiusVector.turn180Degrees();
        PhysicsVector nextVector = new PhysicsVector();
        double nextOrientation = radiusVector.getOrientation() + (angularVelocity * MoveTank.TIME_OF_STEP);
        nextVector.setVectorMagnitude(nextOrientation, radiusVector.getMagnitude());
        return nextVector;
    }

    private static double nextOrientation(double radius, double orientation) {
        return radius < 0 ? orientation + 90 : orientation - 90;
    }
}
