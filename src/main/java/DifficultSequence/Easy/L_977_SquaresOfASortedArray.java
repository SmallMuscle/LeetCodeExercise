package DifficultSequence.Easy;

import java.util.Arrays;

public class L_977_SquaresOfASortedArray {

    /*
        2019.03.24

        Given an array of integers A sorted in non-decreasing order,
        return an array of the squares of each number, also in sorted
        non-decreasing order.

        Example 1:
            Input: [-4,-1,0,3,10]
            Output: [0,1,9,16,100]
        Example 2:
            Input: [-7,-3,2,3,11]
            Output: [4,9,9,49,121]

        Note:
            1 <= A.length <= 10000
            -10000 <= A[i] <= 10000
            A is sorted in non-decreasing order.

    */

    public static void main(String[] args) {
        L_977_SquaresOfASortedArray l = new L_977_SquaresOfASortedArray();
        int[] A = {-4,-1,0,3,10};
        int[] B = {-7,-3,2,3,11};
        int[] result1 = l.sortedSquares(A);
        int[] result2 = l.sortedSquares(B);
        int[] C = {-3,-1,0};
        int[] result3 = l.sortedSquares(C);
        for (int a : result1) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int a : result2) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int a : result3) {
            System.out.print(a + " ");
        }
    }

    public int[] sortedSquares(int[] A) {
        return sortedSquares3(A);
    }

    // 插入排序，看上去很简洁，对于大数组效率不高呀。。
    public int[] sortedSquares3(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            int square = A[i] * A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > square) {
                A[j + 1] = A[j];
                --j;
            }
            A[++j] = square;
        }
        return A;
    }

    // 类似归并
    public int[] sortedSquares2(int[] A) {
        if (null != A && A.length > 0) {
            int[] tmp = new int[A.length];
            int num = -1;
            for (int i = 0; i < A.length; ++i) {
                if (A[i] < 0) {
                    tmp[++num] = A[i] * A[i];
                } else {
                    A[i] = A[i] * A[i];
                }
            }
            int index = 0;
            int s;
            for (s = num + 1; s < A.length && num >= 0;) {
                if (A[s] < tmp[num]) {
                    A[index++] = A[s];
                    ++s;
                } else {
                    A[index++] = tmp[num];
                    --num;
                }
            }
            while (num >= 0) {
                A[index++] = tmp[num--];
            }
        }
        return A;
    }

    // 平方、排序
    public int[] sortedSquares1(int[] A) {
        if (null != A && A.length > 0) {
            for (int i = 0; i < A.length; A[i] = A[i] * A[i++]);
            Arrays.sort(A);
        }
        return A;
    }
}
