package com.test.Easy;

import com.test.utils.PrintUtil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class L_349_IntersectionOfTwoArrays {

    /*
    Given two arrays, write a function to compute their intersection(交集).

    Example 1:
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2]
    Example 2:
        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [9,4]

    Note:
        Each element in the result must be unique.
        The result can be in any order.

     */

    public static void main(String[] args) {
        L_349_IntersectionOfTwoArrays l = new L_349_IntersectionOfTwoArrays();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        PrintUtil.printArray(l.intersection(nums1, nums2));
        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        PrintUtil.printArray(l.intersection(nums3, nums4));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        return intersection1(nums1, nums2);
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> index = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        if (nums1.length > nums2.length) {
            for (int i = 0; i < nums2.length; i++) {
                index.add(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                if (index.contains(nums1[i])) {
                    result.add(nums1[i]);
                }
            }
        } else {
            for (int i = 0; i < nums1.length; i++) {
                index.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (index.contains(nums2[i])) {
                    result.add(nums2[i]);
                }
            }
        }
        index.retainAll(result);
        int[] rst = new int[result.size()];
        Iterator<Integer> it = result.iterator();
        for (int i = 0; it.hasNext(); i++) {
            rst[i] = it.next();
        }
        return rst;
    }
}
