package com.test.jianZhiOffer;

import java.util.function.Function;

public class S_14_ChangeSequenceByRule {

    public static final Function<Integer, Boolean> oddEven = (num) -> 1 == (num & 1);

    public static final Function<Integer, Boolean> negitive = (num) -> 0 > num;

    public static final Function<Integer, Boolean> div3 = (num) -> 0 == (num % 3);

    public void reorderArrayByRule(int [] arr, Function<Integer, Boolean> rule) {
        if (null == arr || 2 > arr.length || null == rule) return ;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (rule.apply(arr[start])) ++start;
            else if (! rule.apply(arr[end])) --end;
            else {
                arr[start] ^= arr[end];
                arr[end] ^= arr[start];
                arr[start++] ^= arr[end--];
            }
        }
    }

}
