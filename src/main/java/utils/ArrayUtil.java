package utils;

public class ArrayUtil {


    public static int[] getArray(int len) {
        return len > 0 ? new int[len] : null;
    }

    public static int[] initArray(int[] arrays) {
        if (null != arrays) {
            for (int i = 0; i < arrays.length; arrays[i++] = 0);
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
}
