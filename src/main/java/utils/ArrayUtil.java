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
}
