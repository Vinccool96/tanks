package com.tanks.game;

import com.tanks.game.movement.RotateTank;
import com.tanks.game.movement.TranslateTank;
import com.tanks.models.RelativeCoordinates;
import com.tanks.models.Tank;

public class MoveTank {

    public static final double TIME_OF_STEP = 0.1;

    public static void move(Tank tank, float leftAxisY, float rightAxisY,
            RelativeCoordinates relativeCoordinates) {
        setSpeed(tank, leftAxisY, rightAxisY);
        movement(tank, relativeCoordinates);
    }

    private static void setSpeed(Tank tank, float leftAxisY, float rightAxisY) {
        tank.setLeftSpeed(leftAxisY);
        tank.setRightSpeed(rightAxisY);
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
