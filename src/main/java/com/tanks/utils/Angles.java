package com.tanks.utils;

public class Angles {

    public static double angle(double angle) {
        double result = angle;
        if (result < 0) {
            result = angle(result + 360);
        } else if (result >= 360) {
            result = angle(result - 360);
        }
        return result;
    }

    public static double fromXY(double x, double y) {
        double result = 0;
        if (!(x == 0 && y == 0)) {
            if (x == 0) {
                result = y > 0 ? 90 : 270;
            } else if (y == 0) {
                result = x > 0 ? 0 : 180;
            } else {
                if (x < 0) {
                    result = Math.toDegrees(Math.atan(y / x)) + 180;
                } else {
                    if (y < 0) {
                        result = Math.toDegrees(Math.atan(y / x)) + 360;
                    } else {
                        result = Math.toDegrees(Math.atan(y / x));
                    }
                }
            }
        }
        return result;
    }

    public static double angularDelta(double previous, double current) {
        double delta = current - previous;
        if (delta > 180.0) {
            delta -= 360.0;
        } else if (delta < -180.0) {
            delta += 360.0;
        }
        return delta;
    }
}
