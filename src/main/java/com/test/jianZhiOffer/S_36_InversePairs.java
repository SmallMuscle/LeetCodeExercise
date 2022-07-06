package com.test.jianZhiOffer;

public class S_36_InversePairs {

    public int inversePairs(int[] nums) {
        int result = 0;
        if (null != nums && 1 < nums.length) {
            int[] copy = new int[nums.length];
            for (int i = 0; i < nums.length; i++) copy[i] = nums[i];
            result = inversePairsCore(nums, copy, 0, nums.length - 1);
        }
        return result;
    }

    public int inversePairsCore(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }
        int len = (end - start) >> 1;
        int right = inversePairsCore(copy, nums, start, start + len);
        int left = inversePairsCore(copy, nums, start + len + 1, end);
        int rIndex = start + len;
        int lIndex = end;
        int copyIndex = end;
        int currentResult = 0;
        while (rIndex >= start && lIndex >= start + len + 1) {
            if (nums[rIndex] > nums[lIndex]) {
                currentResult += lIndex - start - len;
                copy[copyIndex--] = nums[rIndex--];
            } else {
                copy[copyIndex--] = nums[lIndex--];
            }
        }
        for (; rIndex >= start; --rIndex) copy[copyIndex--] = nums[rIndex];
        for (; lIndex >= start + len + 1; --lIndex) copy[copyIndex--] = nums[lIndex];
        return left + right + currentResult;
    }

}
