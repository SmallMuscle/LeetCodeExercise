package NumSequence;

import utils.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class L_1030_MatrixCellsInDistanceOrder {

    /*
        We are given a matrix with R rows and C columns has cells with
        integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

        Additionally, we are given a cell in that matrix with coordinates (r0, c0).

        Return the coordinates of all cells in the matrix, sorted by their
        distance from (r0, c0) from smallest distance to largest distance.
        Here, the distance between two cells (r1, c1) and (r2, c2) is the
        Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the
        answer in any order that satisfies this condition.)

        Example 1:
            Input: R = 1, C = 2, r0 = 0, c0 = 0
            Output: [[0,0],
                     [0,1]]
            Explanation: The distances from (r0, c0) to other cells are: [0,1]
        Example 2:
            Input: R = 2, C = 2, r0 = 0, c0 = 1
            Output: [[0,1],
                     [0,0],
                     [1,1],
                     [1,0]]
            Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
                The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
        Example 3:
            Input: R = 2, C = 3, r0 = 1, c0 = 2
            Output: [[1,2],
                     [0,2],
                     [1,1],
                     [0,1],
                     [1,0],
                     [0,0]]
            Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
                There are other answers that would also be accepted as correct, such as
                [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].

        Note:
            1 <= R <= 100
            1 <= C <= 100
            0 <= r0 < R
            0 <= c0 < C

     */

    public static void main(String[] args) {
        L_1030_MatrixCellsInDistanceOrder l = new L_1030_MatrixCellsInDistanceOrder();
        int R = 1;
        int C = 2;
        int r0 = 0;
        int c0 = 0;
        PrintUtil.printArray(l.allCellsDistOrder(R, C, r0, c0));
        R = 2;
        C = 2;
        r0 = 0;
        c0 = 1;
        PrintUtil.printArray(l.allCellsDistOrder(R, C, r0, c0));
        R = 2;
        C = 3;
        r0 = 1;
        c0 = 2;
        PrintUtil.printArray(l.allCellsDistOrder(R, C, r0, c0));
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        return allCellsDistOrder1(R, C, r0, c0);
    }

    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int num = R * C;
        int[][] result = new int[num][2];
        result[0][0] = r0;
        result[0][1] = c0;
        int index = 1;
        int len = 1;
        while (index < num) {
            if (r0 - len >= 0) {
                result[index][0] = r0 - len;
                result[index++][1] = c0;
            }
            if (r0 + len < R) {
                result[index][0] = r0 + len;
                result[index++][1] = c0;
            }
            if (c0 - len >= 0) {
                result[index][0] = r0;
                result[index++][1] = c0 - len;
            }
            if (c0 + len < C) {
                result[index][0] = r0;
                result[index++][1] = c0 + len;
            }
            for (int i = 1; i < len; i++) {
                // top left
                if (r0 - len >= 0 && c0 - i >= 0) {
                    result[index][0] = r0 - len;
                    result[index++][1] = c0 - i;
                }
                // top right
                if (r0 - len >= 0 && c0 + i < C) {
                    result[index][0] = r0 - len;
                    result[index++][1] = c0 + i;
                }
                // bottom left
                if (r0 + i < R && c0 - len >= 0) {
                    result[index][0] = r0 + i;
                    result[index++][1] = c0 - len;
                }
                // bottom right
                if (r0 + i < R && c0 + len < C) {
                    result[index][0] = r0 + i;
                    result[index++][1] = c0 + len;
                }

            }
            ++len;
        }
        return result;
    }
}
