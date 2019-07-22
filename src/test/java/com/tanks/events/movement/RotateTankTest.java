package com.tanks.events.movement;

import com.tanks.models.game.Tank;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RotateTankTest {

    Tank tank;

    @Before
    public void setUp() throws Exception {
        tank = new Tank();
    }

    @Test
    public void rotateLeftMaxRightZero() {
        tank.setLeftSpeed(1.0f);
        assertTrue(tank.getLeftSpeed() == 1.0);
        assertTrue(tank.getRightSpeed() == 0.0);
    }
}