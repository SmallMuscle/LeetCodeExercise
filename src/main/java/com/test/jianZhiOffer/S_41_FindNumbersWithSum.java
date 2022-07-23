package com.test.jianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S_41_FindNumbersWithSum {

    public int[][] findNumbersWithSum(int[] arr, int sum) {
        if (null == arr || 2 > arr.length) return null;
        int start = 0;
        int end = arr.length - 1;
        List<int[]> result = new LinkedList<>();
        while (start < end) {
            if (sum < arr[end]) --end;
            else {
                if (sum < arr[start] + arr[end]) --end;
                else if (sum > arr[start] + arr[end]) ++start;
                else result.add(new int[] {arr[start++], arr[end--]});
            }
        }
        return convert(result);
    }

    private int[][] convert(List<int[]> list) {
        if (null == list) return null;
        if (0 == list.size()) return new int[][] {};
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
