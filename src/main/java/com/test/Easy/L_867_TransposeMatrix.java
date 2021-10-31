package com.test.Easy;

import com.test.utils.PrintUtil;

public class L_867_TransposeMatrix {

    /*
        2019.04.07

        Given a matrix A, return the transpose of A.

        The transpose of a matrix is the matrix flipped over
        it's main diagonal, switching the row and column
        indices of the matrix.

        Example 1:
            Input: [[1,2,3],[4,5,6],[7,8,9]]
            [1,2,3],
            [4,5,6],
            [7,8,9]
            Output: [[1,4,7],[2,5,8],[3,6,9]]
            [1,4,7],
            [2,5,8],
            [3,6,9]
        Example 2:
            Input: [[1,2,3],[4,5,6]]
            [1,2,3],
            [4,5,6]
            Output: [[1,4],[2,5],[3,6]]
            [1,4],
            [2,5],
            [3,6]
     */

    public static void main(String[] args) {
        L_867_TransposeMatrix l = new L_867_TransposeMatrix();
        int[][] A1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        PrintUtil.printArray(A1);
        PrintUtil.printArray(l.transpose(A1));
        int[][] A2 = {{1,2,3}, {4,5,6}};
        PrintUtil.printArray(A2);
        PrintUtil.printArray(l.transpose(A2));
    }

    public int[][] transpose(int[][] A) {
        return transpose1(A);
    }

    public int[][] transpose1(int[][] A) {
        if (null != A) {
            int[][] result = new int[A[0].length][A.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    result[j][i] = A[i][j];
                }
            }
            return result;
        }
        return A;
    }
}
