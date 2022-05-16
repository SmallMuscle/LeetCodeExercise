package com.test.Hard.L_42_TrappingRainWater;

public class Solution {

    /**
     * question: Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining.
     *
     * eg:
     * Image: resources/static/images/Example_L_42_RainWaterTrap.png
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     * In this case, 6 units of rain water (blue section) are being trapped.
     *
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     *
     * Constraints:
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     * analysis:
     * n 小于 3 无法 trap，返回 0
     *
     *               1
     *       1       1
     *   1   1   1   1       1
     *   1   1   1   1   1   1   1
     * -----------------------------------------
     * 找坑，两边最高的，取最小，减去中间地的之和即为一个坑的
     * 左边比右边大，则从右边向左遍历，计算 traped water
     * 反之亦然
     * 直到两边 index 交叉
     */
    public int trap(int[] height) {
        int result = 0;
        if (null != height && 3 <= height.length) {
            int li = 0;
            int ri = height.length - 1;
            int lm = height[li];
            int rm = height[ri];
            while (li < ri) {
                if (lm < rm) {
                    if (lm > height[++li]) {
                        result += lm - height[li];
                    } else {
                        lm = height[li];
                    }
                } else {
                    if (rm > height[--ri]) {
                        result += rm - height[ri];
                    } else {
                        rm = height[ri];
                    }
                }
            }
        }
        return result;
    }

}
