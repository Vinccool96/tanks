package game.movement;

import game.MoveTank;
import models.PhysicsVector;
import models.Tank;

public class TranslateTank {

    public static void translate(Tank tank) {
        double speed = tank.getLeftSpeed();
        double distanceTraveled = speed * MoveTank.TIME_OF_STEP;
        PhysicsVector vector = new PhysicsVector();
        double orientation = speed < 0 ? -tank.getOrientation() : tank.getOrientation();
        vector.setVectorMagnitude(orientation, distanceTraveled);
        tank.setPosX(tank.getPosX() + vector.getX());
        tank.setPosY(tank.getPosY() + vector.getY());
    }
}
