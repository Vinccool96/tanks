package com.tanks.game;

import com.tanks.game.movement.RotateTank;
import com.tanks.game.movement.TranslateTank;
import com.tanks.models.RelativeCoordinates;
import com.tanks.models.Tank;

public class MoveTank {

    public static final double TIME_OF_STEP = 0.1;

    public static void move(Tank tank, float leftAxisXDelta, float rightAxisXDelta,
            RelativeCoordinates relativeCoordinates) {
        setSpeed(tank, leftAxisXDelta, rightAxisXDelta);
        movement(tank, relativeCoordinates);
    }

    private static void setSpeed(Tank tank, float leftAxisXDelta, float rightAxisXDelta) {
        tank.setLeftSpeed(leftAxisXDelta);
        tank.setRightSpeed(rightAxisXDelta);
    }

    private static void movement(Tank tank, RelativeCoordinates relativeCoordinates) {
        if (isTranslating(tank)) {
            TranslateTank.translate(tank, relativeCoordinates);
        } else {
            RotateTank.rotate(tank, relativeCoordinates);
        }
    }

    private static boolean isTranslating(Tank tank) {
        return tank.getLeftSpeed() == tank.getRightSpeed();
    }
}
