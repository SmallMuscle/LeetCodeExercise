package com.test.Easy;

import com.test.utils.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L_496_NextGreaterElementI {

    /*
        You are given two arrays (without duplicates) nums1 and nums2 where
        nums1’s elements are subset of nums2. Find all the next greater
        numbers for nums1's elements in the corresponding places of nums2.

        The Next Greater Number of a number x in nums1 is the first greater
        number to its right in nums2. If it does not exist, output -1 for
        this number.

        Example 1:
            Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
            Output: [-1,3,-1]
            Explanation:
                For number 4 in the first array, you cannot find the next
                greater number for it in the second array, so output -1.
                For number 1 in the first array, the next greater number
                for it in the second array is 3.
                For number 2 in the first array, there is no next greater
                number for it in the second array, so output -1.
        Example 2:
            Input: nums1 = [2,4], nums2 = [1,2,3,4].
            Output: [3,-1]
            Explanation:
                For number 2 in the first array, the next greater number
                for it in the second array is 3.
                For number 4 in the first array, there is no next greater
                number for it in the second array, so output -1.
        Note:
            All elements in nums1 and nums2 are unique.
            The length of both nums1 and nums2 would not exceed 1000.

     */

    public static void main(String[] args) {
        L_496_NextGreaterElementI l = new L_496_NextGreaterElementI();
        int[] nums11 = {4,1,2};
        int[] nums12 = {1,3,4,2};
        PrintUtil.printArray(l.nextGreaterElement(nums11, nums12));
        int[] nums21 = {2,4};
        int[] nums22 = {1,2,3,4};
        PrintUtil.printArray(l.nextGreaterElement(nums21, nums22));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nextGreaterElement3(nums1, nums2);
    }

    // inspired by Discuss
    // record next greater number
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() < n)
                map.put(stack.pop(), n);
            stack.push(n);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> index = new HashMap<>();
        int[] result = new int[nums1.length];
        // record index
        for (int i = 0; i < nums2.length; i++) {
            index.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = true;
            for (int j = index.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    flag = false;
                    result[i] = nums2[j];
                    break;
                }
            }
            if (flag) result[i] = -1;
        }
        return result;
    }


    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] index = new int[10000];
        int[] result = new int[nums1.length];
        // record index
        for (int i = 0; i < nums2.length; i++) {
            index[nums2[i]] = i;
        }
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = true;
            for (int j = index[nums1[i]] + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    flag = false;
                    result[i] = nums2[j];
                    break;
                }
            }
            if (flag) result[i] = -1;
        }
        return result;
    }



}
