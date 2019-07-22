package com.tanks.events.movement;

import com.tanks.events.MoveTank;
import com.tanks.models.physics.PhysicsVector;
import com.tanks.models.physics.RelativeCoordinates;
import com.tanks.models.game.Tank;

public class TranslateTank {

    public static void translate(Tank tank, RelativeCoordinates relativeCoordinates) {
        double speed = tank.getLeftSpeed();
        double distanceTraveled = Math.abs(speed * MoveTank.TIME_OF_STEP);
        double orientation = speed < 0 ? -tank.getOrientation() : tank.getOrientation();
        PhysicsVector vector = new PhysicsVector();
        vector.setVectorMagnitude(orientation, distanceTraveled);
        relativeCoordinates.setCalcX(vector.getX());
        relativeCoordinates.setCalcY(vector.getY());
    }
}
