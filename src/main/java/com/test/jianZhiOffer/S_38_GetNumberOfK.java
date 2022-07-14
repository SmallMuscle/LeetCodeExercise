package com.test.jianZhiOffer;

public class S_38_GetNumberOfK {

    public int getNumberOfk(int[] arr, int k) {
        int result = 0;
        if (null != arr && 0 < arr.length) {
            int firstIndex = getFirstInArray(arr, k);
            if (0 <= firstIndex) {
                int lastIndex = getLastInArray(arr, k);
                result = lastIndex - firstIndex + 1;
            }
        }
        return result;
    }

    private int getFirstInArray(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] > k) end = mid - 1;
            else if (arr[mid] < k) start = mid + 1;
            else {
                if (mid > start && arr[mid - 1] == k) end = mid - 1;
                else {
                    start = mid;
                    break ;
                }
            }
        }
        return k == arr[start] ? start : -1;
    }

    private int getLastInArray(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] < k) start = mid + 1;
            else if (arr[mid] > k) end = mid - 1;
            else {
                if (mid < end && arr[mid + 1] == k) start = mid + 1;
                else {
                    start = mid;
                    break ;
                }
            }
        }
        return k == arr[start] ? start : -1;
    }

}
