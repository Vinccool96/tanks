package game.movement;

import game.MoveTank;
import models.PhysicsVector;
import models.RelativeCoordinates;
import models.Tank;

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
