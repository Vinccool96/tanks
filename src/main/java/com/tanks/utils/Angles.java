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

    public static double fromXY(double x, double y){
        double result = 0;
        if (!(x==0&&y==0)){

        }
        return result;
    }
}
