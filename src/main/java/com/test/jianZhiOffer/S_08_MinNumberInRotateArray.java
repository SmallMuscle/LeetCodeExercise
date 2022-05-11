package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_08_MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] arrs) {
        if (null == arrs || 0 == arrs.length) {
            //throw new RuntimeException("Invalid input.");
            log.error("Invalid input.");
            return -1;
        }
        int start = 0, end = arrs.length - 1;
        while (start < end) {
            if (arrs[start] < arrs[end]) return arrs[start];
            else if (arrs[start] > arrs[end]) {
                int mid = (start + end) >> 1;
                if (arrs[mid] >= arrs[start]) start = mid + 1;
                else  end = mid;
            } else ++start;
        }
        return arrs[start];
    }

    public int minNumberInRotateArrayByRecursive(int[] arrs) {
        if (null == arrs || 0 == arrs.length) {
            //throw new RuntimeException("Invalid input.");
            log.error("Invalid input.");
            return -1;
        }
        return minNumberInRotateArrayByRecursiveCore(arrs, 0, arrs.length - 1);
    }

    public int minNumberInRotateArrayByRecursiveCore(int[] arrs, int start, int end) {
        if (start < end) {
            if (arrs[start] < arrs[end]) return arrs[start];
            else if (arrs[start] > arrs[end]){
                int mid = (start + end) >> 1;
                if (arrs[mid] >= arrs[start]) return minNumberInRotateArrayByRecursiveCore(arrs, mid + 1, end);
                else return minNumberInRotateArrayByRecursiveCore(arrs, start, mid);
            } else return minNumberInRotateArrayByRecursiveCore(arrs, start + 1, end);
        }
        return arrs[start];
    }


}
