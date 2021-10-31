package com.test.Easy;

import com.test.utils.PrintUtil;

public class L_922_SortArrayByParityII {

    /*
        2019.04.04

        Given an array A of non-negative integers, half of the
        integers in A are odd, and half of the integers are even.

        Sort the array so that whenever A[i] is odd, i is odd;
        and whenever A[i] is even, i is even.

        You may return any answer array that satisfies this condition.

        Example 1:
            Input: [4,2,5,7]
            Output: [4,5,2,7]
            Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

        Note:
            2 <= A.length <= 20000
            A.length % 2 == 0
            0 <= A[i] <= 1000

     */

    public static void main(String[] args) {
        L_922_SortArrayByParityII l = new L_922_SortArrayByParityII();
        int[] A = {4,2,5,7};
        PrintUtil.printArray(l.sortArrayByParityII(A));
    }

    public int[] sortArrayByParityII(int[] A) {
        return sortArrayByParityII1(A);
    }

    public int[] sortArrayByParityII1(int[] A) {
        int oddPos = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (0 != (1 & A[i])) {
                while (0 != (1 & A[oddPos])) oddPos += 2;
                int tmp = A[i];
                A[i] = A[oddPos];
                A[oddPos] = tmp;
            }
        }
        return A;
    }
}
