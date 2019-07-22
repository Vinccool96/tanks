package com.tanks.utils;

public class Modulo {

    public static double modulo(double a, double n) {
        return a - Math.floor(a / n) * n;
    }
}
