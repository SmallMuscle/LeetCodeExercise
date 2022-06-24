package com.test.jianZhiOffer;

public class S_31_ContinuousSubArrayMaxSum {

    public int continousSubArrayMaxSum(int[] arr) {
        int result = 0;
        if (null != arr && 0 < arr.length) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum < arr[i]) sum = arr[i];
                if (sum > result) result = sum;
            }
        }
        return result;
    }

}
