package com.test.Easy;

import java.util.Arrays;

public class L_561_ArrayPartitionI {

    /*
        2019.04.08

        Given an array of 2n integers, your task is to group these
        integers into n pairs of integer, say (a1, b1), (a2, b2), ...,
        (an, bn) which makes sum of min(ai, bi) for all i from 1 to n
        as large as possible.

        Example 1:
            Input: [1,4,3,2]
            Output: 4
            Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
        Note:
            n is a positive integer, which is in the range of [1, 10000].
            All the integers in the array will be in the range of [-10000, 10000].
     */

    public static void main(String[] args) {
        L_561_ArrayPartitionI l = new L_561_ArrayPartitionI();
        int[] ints = {1,4,3,2};
        System.out.println(l.arrayPairSum(ints));
    }

    public int arrayPairSum(int[] nums) {
        return arrayPairSum2(nums);
    }


    // inspired by Discuss
    public int arrayPairSum2(int[] nums) {
        if (null != nums && 0 < nums.length) {
            int result = 0;
            boolean flag = true;
            int[] dirs = new int[20001];
            for (int i = 0; i < nums.length; ++dirs[nums[i++] + 10000]);
            for (int i = 0; i < dirs.length;) {
                if (dirs[i] > 0) {
                    if (flag) result += i - 10000;
                    flag = !flag;
                    --dirs[i];
                }
                if (0 == dirs[i]) ++i;
            }
            return result;
        }
        return 0;
    }


    public int arrayPairSum1(int[] nums) {
        if (null != nums && 0 < nums.length) {
            Arrays.sort(nums);
            int result = 0;
            for (int i = 0; i < nums.length; result +=nums[i], i += 2);
            return result;
        }
        return 0;
    }
}
