package DifficultSequence.Easy;

public class L_883_ProjectionAreaOf3DShapes {

    /*
        2019.04.14

        On a N * N grid, we place some 1 * 1 * 1 cubes that
        are axis-aligned with the x, y, and z axes.

        Each value v = grid[i][j] represents a tower of v
        cubes placed on top of grid cell (i, j).

        Now we view the projection of these cubes onto the
        xy, yz, and zx planes.

        A projection is like a shadow, that maps our 3
        dimensional figure to a 2 dimensional plane.

        Here, we are viewing the "shadow" when looking at
        the cubes from the top, the front, and the side.

        Return the total area of all three projections.

        Example 1:
            Input: [[2]]
            Output: 5
        Example 2:
            Input: [[1,2],[3,4]]
            Output: 17
            Explanation:
                Here are the three projections ("shadows")
                of the shape made with each axis-aligned plane.

        Example 3:
            Input: [[1,0],[0,2]]
            Output: 8
        Example 4:
            Input: [[1,1,1],[1,0,1],[1,1,1]]
            Output: 14
        Example 5:
            Input: [[2,2,2],[2,1,2],[2,2,2]]
            Output: 21

        Note:
            1 <= grid.length = grid[0].length <= 50
            0 <= grid[i][j] <= 50

[[0,3,4,3],
 [4,5,0,5],
 [0,4,2,4],
 [4,0,0,2]]

3 3 3 2     11
4 5 4 4     17
4 5 4 5     18
     */

    public static void main(String[] args) {
        L_883_ProjectionAreaOf3DShapes l = new L_883_ProjectionAreaOf3DShapes();
        int[][] grid1 = {{2}};
        System.out.println(l.projectionArea(grid1));
        int[][] grid2 = {{1, 2}, {3, 4}};
        System.out.println(l.projectionArea(grid2));
        int[][] grid3 = {{1, 0}, {0, 2}};
        System.out.println(l.projectionArea(grid3));
        int[][] grid4 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(l.projectionArea(grid4));
        int[][] grid5 = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(l.projectionArea(grid5));
        int[][] grid6 = {{0,3,4,3},{4,5,0,5},{0,4,2,4},{4,0,0,2}};
        System.out.println(l.projectionArea(grid6));

    }


    public int projectionArea(int[][] grid) {
        return projectionArea2(grid);
    }

    static int[] tmps = new int[50];

    public int projectionArea2(int[][] grid) {
        if (null != grid && 0 < grid.length) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                int max = 0;
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] > 0) {
                        // record top num
                        // add top num
                        ++result;
                        // record front num
                        if (grid[i][j] > max) {
                            max = grid[i][j];
                        }
                    }
                    // record side num
                    if (grid[i][j] > tmps[j]) {
                        tmps[j] = grid[i][j];
                    }
                }
                // add front num
                result += max;
            }
            // add side num
            for (int i = 0; i < grid[0].length; i++) {
                result += tmps[i];
                tmps[i] = 0;
            }
            return result;
        }
        return 0;
    }

    public int projectionArea1(int[][] grid) {
        if (null != grid && 0 < grid.length) {
            int result = 0;
            int[] tmp = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                int max = 0;
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] > 0) {
                        // record top num
                        // add top num
                        ++result;
                        // record front num
                        if (grid[i][j] > max) {
                            max = grid[i][j];
                        }
                    }
                    // record side num
                    if (grid[i][j] > tmp[j]) {
                        tmp[j] = grid[i][j];
                    }
                }
                // add front num
                result += max;
            }
            // add side num
            for (int s : tmp) {
                result += s;
            }
            return result;
        }
        return 0;
    }
}
