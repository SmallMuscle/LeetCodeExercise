package com.test.utils;

public class NumericalUtil {

    private static final double doubleAccuracy = 0.0000001;

    public static boolean equals(double d1, double d2) {

        return ((d1 - d2) > - doubleAccuracy) && ((d1 - d2) < doubleAccuracy);
    }
}
