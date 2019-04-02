package DifficultSequence.Easy;

import utils.PrintUtil;

public class L_832_FlippinganImage {

    /*
        2019.03.26

        Given a binary matrix A, we want to flip the image horizontally,
        then invert it, and return the resulting image.

        To flip an image horizontally means that each row of the image is
        reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

        To invert an image means that each 0 is replaced by 1, and each 1 is
        replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

        Example 1:
            Input: [[1,1,0],[1,0,1],[0,0,0]]
                    1,1,0
                    1,0,1
                    0,0,0
            Output: [[1,0,0],[0,1,0],[1,1,1]]
                    1,0,0
                    0,1,0
                    1,1,1
            Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
            Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
        Example 2:
            Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
                    1,1,0,0
                    1,0,0,1
                    0,1,1,1
                    1,0,1,0
            Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
                    1,1,0,0
                    0,1,1,0
                    0,0,0,1
                    1,0,1,0
            Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
            Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

        Notes:
            1 <= A.length = A[0].length <= 20
            0 <= A[i][j] <= 1
    */


    public static void main(String[] args) {
        int i = 0;
        System.out.println(~i & 1);
        L_832_FlippinganImage l = new L_832_FlippinganImage();
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        PrintUtil.printArray(l.flipAndInvertImage(A));
        int[][] B = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        PrintUtil.printArray(l.flipAndInvertImage(B));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        return flipAndInvertImage1(A);
    }

    // 从左右向中间扫描，
    // 相同取反，不相同不动
    public int[][] flipAndInvertImage1(int[][] A) {
        if (null != A) {
            for (int[] a : A) {
                int s = -1;
                int e = a.length;
                while (++s <= --e) {
                    if (s == e) {
                        a[s] = ~a[s] & 1;
                        break;
                    }
                    if (a[s] == a[e]) {
                        a[s] = ~a[s] & 1;
                        a[e] = ~a[e] & 1;
                    }
                }
            }
        }
        return A;
    }

}
