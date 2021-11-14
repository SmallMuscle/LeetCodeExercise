package com.test.Medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class L153_FindMinimumInRotatedSortedArray {

    /**
     * question: 给定一个升序且无重复的int数组，多次滚动数组元素，找出最小值
     * O(log n) time
     *
     * eg:
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     *
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     *
     * Input: nums = [11,13,15,17]
     * Output: 11
     *
     * constraints:
     * 1 <= 数组长度 <= 5000
     * -5000 <= 数组元素 <= 5000
     *
     * analysis:
     * 题目限制 O(log n)，二分 。。
     * 存在如下几种情况
     * 1234567
     * 6712345
     * 3456712
     *
     */

    public int findMin(int[] nums) {
        if (1 == nums.length) {
            return nums[0];
        } else {
            int start = 0;
            int end = nums.length - 1;
            int mid = 0;
            while (start < end) {
                if (1 < end - start) {
                    mid = (start + end) >> 1;
                    if (nums[start] > nums[end]) {
                        if (nums[mid] > nums[start]) {
                            start = mid + 1;
                        } else {
                            end = mid;
                        }
                    } else {
                        return nums[start];
                    }
                } else {
                    return Math.min(nums[start], nums[end]);
                }
            }
            return nums[start];
        }
    }

    @Test
    public void test() {
        int[] nums = new int[] {3,4,5,1,2};
        log.info("result: {}", findMin(nums));
        nums = new int[] {4,5,6,7,0,1,2};
        log.info("result: {}", findMin(nums));
        nums = new int[] {11,13,15,17};
        log.info("result: {}", findMin(nums));
    }

}
