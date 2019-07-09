package game;

import game.movement.RotateTank;
import game.movement.TranslateTank;
import javafx.scene.shape.Rectangle;
import models.Tank;

public class MoveTank {

    public static void move(Tank tank, Rectangle rect, float leftAxisXDelta, float rightAxisXDelta) {
        setSpeed(tank, leftAxisXDelta, rightAxisXDelta);
    }

    private static void setSpeed(Tank tank, float leftAxisXDelta, float rightAxisXDelta) {
        tank.setLeftSpeed(leftAxisXDelta);
        tank.setRightSpeed(rightAxisXDelta);
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
