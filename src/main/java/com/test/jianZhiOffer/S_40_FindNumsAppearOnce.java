package com.test.jianZhiOffer;

public class S_40_FindNumsAppearOnce {

    public int[] findNumsAppearOnce(int[] arr) {
        if (null == arr || 2 > arr.length) return null;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) flag ^= arr[i];
        int mask = getFirst1(flag);
        int[] tmp = new int[arr.length];
        int containIndex = 0;
        int nonContainIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (mask == (mask & arr[i])) tmp[containIndex++] = arr[i];
            else tmp[nonContainIndex--] = arr[i];
        }
        int[] result = new int[2];
        result[0] = findNumAppearOnce(tmp, 0, containIndex);
        result[1] = findNumAppearOnce(tmp, nonContainIndex + 1, arr.length);
        return result;
    }

    private int getFirst1(int flag) {
        int result = 1;
        while (result != (result & flag)) result <<= 1;
        return result;
    }

    private int findNumAppearOnce(int[] arr, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) result ^= arr[i];
        return result;
    }

}
