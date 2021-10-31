package com.test.Easy;

public class L_908_SmallestRangeI {

    /*
        2019.04.17

        Given an array A of integers, for each integer A[i]
        we may choose any x with -K <= x <= K, and add x to A[i].

        After this process, we have some array B.

        Return the smallest possible difference between the maximum value of B and the minimum value of B.

        Example 1:
            Input: A = [1], K = 0
            Output: 0
            Explanation: B = [1]
        Example 2:
            Input: A = [0,10], K = 2
            Output: 6
            Explanation: B = [2,8]
        Example 3:
            Input: A = [1,3,6], K = 3
            Output: 0
            Explanation: B = [3,3,3] or B = [4,4,4]

        Note:
            1 <= A.length <= 10000
            0 <= A[i] <= 10000
            0 <= K <= 10000

     */

    public static void main(String[] args) {
        L_908_SmallestRangeI l = new L_908_SmallestRangeI();
        int[] A1 = {1};
        int K1 = 0;
        System.out.println(l.smallestRangeI(A1, K1));
        int[] A2 = {0,10};
        int K2 = 2;
        System.out.println(l.smallestRangeI(A2, K2));
        int[] A3 = {1,3,6};
        int K3 = 3;
        System.out.println(l.smallestRangeI(A3, K3));
    }

    public int smallestRangeI(int[] A, int K) {
        return smallestRangeI1(A, K);
    }

    public int smallestRangeI1(int[] A, int K) {
        if (null != A) {
            if (1 == A.length) return 0;
            int min = A[0];
            int max = A[0];
            for (int i = 1; i < A.length; ++i) {
                if (min > A[i]) min = A[i];
                else if (max < A[i]) max = A[i];
            }
            min += K;
            max -= K;
            if (max > min)
                return max - min;
            else return 0;
        }
        return 0;
    }

}
