package game;

import game.movement.RotateTank;
import game.movement.TranslateTank;
import models.Tank;

public class MoveTank {

    public static final double TIME_OF_STEP = 0.1;

    public static void move(Tank tank, float leftAxisXDelta, float rightAxisXDelta) {
        setSpeed(tank, leftAxisXDelta, rightAxisXDelta);
        movement(tank);
    }

    private static void setSpeed(Tank tank, float leftAxisXDelta, float rightAxisXDelta) {
        tank.setLeftSpeed(leftAxisXDelta);
        tank.setRightSpeed(rightAxisXDelta);
    }

    private static void movement(Tank tank) {
        if (isTranslating(tank)) {
            TranslateTank.translate(tank);
        } else {
            RotateTank.rotate(tank);
        }
    }

    private static boolean isTranslating(Tank tank) {
        return tank.getLeftSpeed() == tank.getRightSpeed();
    }
}
