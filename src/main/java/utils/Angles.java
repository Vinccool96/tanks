package utils;

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
}
