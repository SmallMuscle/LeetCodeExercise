package NumSequence;

public class L_892_SurfaceAreaOf3DShapes {

    /*
        On a N * N grid, we place some 1 * 1 * 1 cubes.

        Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

        Return the total surface area of the resulting shapes.

        Example 1:
            Input: [[2]]
            Output: 10
        Example 2:
            Input: [[1,2],[3,4]]
            Output: 34
        Example 3:
            Input: [[1,0],[0,2]]
            Output: 16
        Example 4:
            Input: [[1,1,1],[1,0,1],[1,1,1]]
            Output: 32
        Example 5:
            Input: [[2,2,2],[2,1,2],[2,2,2]]
            Output: 46

        Note:
            1 <= N <= 50
            0 <= grid[i][j] <= 50

     */

    public static void main(String[] args) {
        L_892_SurfaceAreaOf3DShapes l = new L_892_SurfaceAreaOf3DShapes();
        int[][] grid1 = {{2}};
        System.out.println(l.surfaceArea(grid1));
        int[][] grid2 = {{1,2}, {3,4}};
        System.out.println(l.surfaceArea(grid2));
        int[][] grid3 = {{1,0}, {0, 2}};
        System.out.println(l.surfaceArea(grid3));
        int[][] grid4 = {{1,1,1},{1,0,1}, {1,1,1}};
        System.out.println(l.surfaceArea(grid4));
        int[][] grid5 = {{2,2,2},{2,1,2}, {2,2,2}};
        System.out.println(l.surfaceArea(grid5));
    }

    public int surfaceArea(int[][] grid) {
        return surfaceArea3(grid);
    }

    // inspired by Discuss
    public int surfaceArea3(int[][] grid) {
        int allArea = 0;
        int overlap = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    allArea += (grid[i][j] << 2) + 2;
                }
                if (i != grid.length - 1) {
                    overlap += (grid[i][j] > grid[i + 1][j] ? grid[i + 1][j] : grid[i][j]) << 1;
                    overlap += (grid[j][i] > grid[j][i + 1] ? grid[j][i + 1] : grid[j][i]) << 1;
                }
                /*  Easy to understand.
                if (i != grid.length - 1)
                    overlap += (grid[i][j] > grid[i + 1][j] ? grid[i + 1][j] : grid[i][j]) << 1;
                if (j != grid.length - 1)
                    overlap += (grid[i][j] > grid[i][j + 1] ? grid[i][j + 1] : grid[i][j]) << 1;
                    */
            }
        }
        return allArea - overlap;
    }

    // inspired by Solution
    public int surfaceArea2(int[][] grid) {
        int result = 0;
        int n = grid.length;

        int[] ew = {1, 0, -1, 0};
        int[] sn = {0, 1, 0, -1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    result += 2;
                    for (int k = 0; k < 4; k++) {
                        if (i + ew[k] >= 0 && i + ew[k] < n && j + sn[k] >= 0 && j + sn[k] < n) {
                            if (grid[i][j] > grid[i + ew[k]][j + sn[k]]) result += grid[i][j] - grid[i + ew[k]][j + sn[k]];
                        } else {
                            result += grid[i][j];
                        }
                    }
                }
            }
        }
        return result;
    }

    public int surfaceArea1(int[][] grid) {
        int result = 0;
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    if (i == 0) {
                        if (j == 0) {
                            if (grid[i][j] != 0) result += (grid[i][j] << 1) + 2;
                            if (i + 1 < n) {
                                if (grid[i][j] > grid[i + 1][j]) result += grid[i][j] - grid[i + 1][j];
                            } else result += grid[i][j];
                            if (j + 1 < n) {
                                if (grid[i][j] > grid[i][j + 1]) result += grid[i][j] - grid[i][j + 1];
                            } else result += grid[i][j];
                        } else if (j == n - 1) {
                            result += (grid[i][j] << 1) + 2;
                            if (i + 1 < n && grid[i][j] > grid[i + 1][j]) result += grid[i][j] - grid[i + 1][j];
                            if (j - 1 >= 0 && grid[i][j] > grid[i][j - 1]) result += grid[i][j] - grid[i][j - 1];
                        } else {
                            result += grid[i][j] + 2;
                            if (i + 1 < n && grid[i][j] > grid[i + 1][j]) result += grid[i][j] - grid[i + 1][j];
                            if (j + 1 < n && grid[i][j] > grid[i][j + 1]) result += grid[i][j] - grid[i][j + 1];
                            if (j - 1 >= 0 && grid[i][j] > grid[i][j - 1]) result += grid[i][j] - grid[i][j - 1];
                        }
                    } else if (i == n - 1) {
                        if (j == 0) {
                            result += (grid[i][j] << 1) + 2;
                            if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j]) result += grid[i][j] - grid[i - 1][j];
                            if (j + 1 < n && grid[i][j] > grid[i][j + 1]) result += grid[i][j] - grid[i][j + 1];
                        } else if (j == n - 1) {
                            result += (grid[i][j] << 1) + 2;
                            if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j]) result += grid[i][j] - grid[i - 1][j];
                            if (j - 1 >= 0 && grid[i][j] > grid[i][j - 1]) result += grid[i][j] - grid[i][j - 1];
                        } else {
                            result += grid[i][j] + 2;
                            if (i - 1 < n && grid[i][j] > grid[i - 1][j]) result += grid[i][j] - grid[i - 1][j];
                            if (j + 1 < n && grid[i][j] > grid[i][j + 1]) result += grid[i][j] - grid[i][j + 1];
                            if (j - 1 >= 0 && grid[i][j] > grid[i][j - 1]) result += grid[i][j] - grid[i][j - 1];
                        }
                    } else {
                        if (j == 0) {
                            result += grid[i][j] + 2;
                            if (grid[i][j] > grid[i + 1][j]) result += grid[i][j] - grid[i + 1][j];
                            if (grid[i][j] > grid[i - 1][j]) result += grid[i][j] - grid[i - 1][j];
                            if (j + 1 < n && grid[i][j] > grid[i][j + 1]) result += grid[i][j] - grid[i][j + 1];
                        } else if (j == n - 1) {
                            result += grid[i][j] + 2;
                            if (grid[i][j] > grid[i + 1][j]) result += grid[i][j] - grid[i + 1][j];
                            if (grid[i][j] > grid[i - 1][j]) result += grid[i][j] - grid[i - 1][j];
                            if (j - 1 >= 0 && grid[i][j] > grid[i][j - 1]) result += grid[i][j] - grid[i][j - 1];
                        } else {
                            result += 2;
                            if (grid[i][j] > grid[i + 1][j]) result += grid[i][j] - grid[i + 1][j];
                            if (grid[i][j] > grid[i - 1][j]) result += grid[i][j] - grid[i - 1][j];
                            if (j - 1 >= 0 && grid[i][j] > grid[i][j - 1]) result += grid[i][j] - grid[i][j - 1];
                            if (j + 1 < n && grid[i][j] > grid[i][j + 1]) result += grid[i][j] - grid[i][j + 1];
                        }
                    }
                }
            }
        }
        return result;
    }


}
