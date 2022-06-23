package com.test.utils;

public class ArrayUtil {


    public static int[] getArrayInstance(int len) {
        return len > 0 ? new int[len] : null;
    }

    public static int[] initArray(int[] arrays, int defaultNum) {
        if (null != arrays) {
            for (int i = 0; i < arrays.length; arrays[i++] = defaultNum);
        }
        return arrays;
    }

    public static void exchangeElement(int[] dest, int a, int b) {
        if (dest != null && a >= 0 && b <= dest.length) {
            if (a != b) {
                int tmp = dest[a];
                dest[a] = dest[b];
                dest[b] = tmp;
            }
        }
    }

    public static void copy(int[] sour, int[] dest) {
        System.arraycopy(sour, 0, dest,0, sour.length);
    }

    public static void swap(int[] arrs, int first, int second) {
        int tmp = arrs[first];
        arrs[first] = arrs[second];
        arrs[second] = tmp;
    }

}
