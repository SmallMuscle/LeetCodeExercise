package DifficultSequence.Easy;

public class L_766_ToeplitzMatrix {

    /*

        A matrix is Toeplitz if every diagonal(对角线) from top-left to
        bottom-right has the same element.

        Now given an M x N matrix, return True if and only if
        the matrix is Toeplitz.

        Example 1:
        Input:
        matrix = [
          [1,2,3,4],
          [5,1,2,3],
          [9,5,1,2]
        ]
        Output: True
        Explanation:
        In the above grid, the diagonals are:
        "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
        In each diagonal all elements are the same, so the answer is True.
        Example 2:
        Input:
        matrix = [
          [1,2],
          [2,2]
        ]
        Output: False
        Explanation:
        The diagonal "[1, 2]" has different elements.

        Note:
        matrix will be a 2D array of integers.
        matrix will have a number of rows and columns in range [1, 20].
        matrix[i][j] will be integers in range [0, 99].

        Follow up:
        What if the matrix is stored on disk, and the memory is limited
        such that you can only load at most one row of the matrix into
        the memory at once?
        What if the matrix is so large that you can only load up a partial
        row into the memory at once?

     */

    public static void main(String[] args) {
        L_766_ToeplitzMatrix l = new L_766_ToeplitzMatrix();
        int[][] matrix1 = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        System.out.println(l.isToeplitzMatrix(matrix1));
        int[][] matrix2 = {{1,2}, {2,2}};
        System.out.println(l.isToeplitzMatrix(matrix2));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        return isToeplitzMatrix1(matrix);
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        if (matrix.length > 1) {
            for (int y = matrix.length - 2; y > 0; --y) {
                if (isNotToeplitz2(matrix, 0, y)) {
                    return false;
                }
            }
            for (int x = 0; x < matrix[0].length - 1; ++x) {
                if (isNotToeplitz2(matrix, x, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isNotToeplitz2(int[][] martix, int x, int y) {
        int tmp = martix[y][x];
        if (++x >= martix[0].length || ++y >= martix.length) return false;
        if (tmp != martix[y][x]) {
            return true;
        }
        return isNotToeplitz2(martix, x, y);
    }

    boolean isNotToeplitz1(int[][] martix, int x, int y) {
        int tmp = martix[y][x];
        for (++x, ++y; x < martix[0].length && y < martix.length; ++x, ++y) {
            if (tmp != martix[y][x]) return true;
        }
        return false;
    }

}
