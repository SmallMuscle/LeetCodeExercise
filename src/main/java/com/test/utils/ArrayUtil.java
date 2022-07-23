package com.test.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayUtil {

    private static final Comparator<int[]> twoDimArrayCompartor = new Comparator<int[]>() {
        @Override
        public int compare(int[] a1, int[] a2) {
            if (a1 == a2) return 0;
            if (null == a1) return -1;
            if (null == a2) return 1;
            Arrays.sort(a1);
            Arrays.sort(a2);
            int minLen = Math.min(a1.length, a2.length);
            for (int i = 0; i < minLen; i++) {
                if (a1[i] > a2[i]) return 1;
                else if (a1[i] < a2[i]) return -1;
            }
            return a1.length - a2.length;
        }
    };

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

    public static int[] copy(int[] sour) {
        if (null == sour) return null;
        int[] dest = new int[sour.length];
        System.arraycopy(sour, 0, dest,0, sour.length);
        return dest;
    }

    public static int[][] copy(int[][] sour) {
        if (null == sour) return null;
        int[][] dest = new int[sour.length][];
        for (int i = 0; i < sour.length; i++) dest[i] = copy(sour[i]);
        return dest;
    }

    public static void swap(int[] arrs, int first, int second) {
        int tmp = arrs[first];
        arrs[first] = arrs[second];
        arrs[second] = tmp;
    }

    public static boolean equals(int[] arr1, int[] arr2) {
        if (arr1 == arr2) return true;
        boolean resultIsBlank = null == arr1 || 0 == arr1.length;
        boolean expectIsBlank = null == arr2 || 0 == arr2.length;
        if (resultIsBlank) return expectIsBlank;
        if (expectIsBlank || arr1.length != arr2.length) return false;
        int[] a1 = copy(arr1);
        int[] a2 = copy(arr2);
        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static boolean equals(int[][] arrs1, int[][] arrs2) {
        if (arrs1 == arrs2) return true;
        boolean resultIsBlank = isBlank(arrs1);
        boolean expectIsBlank = isBlank(arrs2);
        if (resultIsBlank) return expectIsBlank;
        if (expectIsBlank) return false;
        if (arrs1.length != arrs2.length) return false;
        int[][] a1 = copy(arrs1);
        int[][] a2 = copy(arrs2);
        Arrays.sort(a1, twoDimArrayCompartor);
        Arrays.sort(a2, twoDimArrayCompartor);
        for (int i = 0; i < a1.length; i++) {
            if (! equals(a1[i], a2[i])) return false;
        }
        return true;
    }

    public static boolean isBlank(int[][] arrs) {
        if (null == arrs || 0 == arrs.length) return true;
        int i = 0;
        for (; i < arrs.length && 0 == arrs[i].length; ++i);
        return i == arrs.length;
    }

}
