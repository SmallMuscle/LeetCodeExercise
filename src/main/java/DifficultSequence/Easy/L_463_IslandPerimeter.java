package DifficultSequence.Easy;

public class L_463_IslandPerimeter {

    /*

        You are given a map in form of a two-dimensional integer grid
        where 1 represents land and 0 represents water.

        Grid cells are connected horizontally/vertically (not diagonally).
        The grid is completely surrounded by water, and there is exactly
        one island (i.e., one or more connected land cells).

        The island doesn't have "lakes" (water inside that isn't connected
        to the water around the island). One cell is a square with side
        length 1. The grid is rectangular, width and height don't exceed 100.
        Determine the perimeter of the island.

        Example:
        Input:
            [[0,1,0,0],
             [1,1,1,0],
             [0,1,0,0],
             [1,1,0,0]]
        Output: 16
        Explanation: The perimeter is the 16 yellow stripes in the image below:
            images/Example_L_463_IslandPerimeter.png

     */

    public static void main(String[] args) {
        L_463_IslandPerimeter l = new L_463_IslandPerimeter();
        int[][] grid1 = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(l.islandPerimeter(grid1));
        int[][] grid2 = {{1,0,1}, {1,1,1}};
        System.out.println(l.islandPerimeter(grid2));
    }

    public int islandPerimeter(int[][] grid) {
        return islandPerimeter2(grid);
    }

    public int islandPerimeter2(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] relate = new int[row][column];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (1 == grid[i][j]) {
                    return countIslandPerimeter2(grid, relate, i, j);
                }
            }
        }
        return result;
    }

    // inspired by Discuss
    // The distinguish is that the grid is modified in Discuss but this not
    private int countIslandPerimeter2(int[][] grid,int[][] relate, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) return 1;
        if (1 == relate[i][j]) return 0;
        if (0 == grid[i][j]) return 1;
        else relate[i][j] = 1;
        int num = 0;
        // top
        num += countIslandPerimeter2(grid, relate, i - 1, j);
        // bottom
        num += countIslandPerimeter2(grid, relate, i + 1, j);
        // left
        num += countIslandPerimeter2(grid, relate, i, j - 1);
        // right
        num += countIslandPerimeter2(grid, relate, i, j + 1);
        return num;
    }

    private int countIslandPerimeter1(int[][] grid,int[][] relate, int i, int j) {
        if (1 == relate[i][j]) return 0;
        int num = 0;
        if (0 == i || 0 == grid[i - 1][j]) ++num;
        if (grid.length - 1 == i || 0 == grid[i + 1][j]) ++num;
        if (0 == j || 0 == grid[i][j - 1]) ++num;
        if (grid[0].length - 1 == j || 0 == grid[i][j + 1]) ++num;
        relate[i][j] = 1;
        // top
        if (0 != i && 1 == grid[i - 1][j]) num += countIslandPerimeter1(grid, relate, i - 1, j);
        // bottom
        if (grid.length - 1 != i && 1 == grid[i + 1][j]) num += countIslandPerimeter1(grid, relate, i + 1, j);
        // left
        if (0 != j && 1 == grid[i][j - 1]) num += countIslandPerimeter1(grid, relate, i, j - 1);
        // right
        if (grid[0].length - 1 != j && 1 == grid[i][j + 1]) num += countIslandPerimeter1(grid, relate, i, j + 1);
        return num;
    }

    public int islandPerimeter1(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (1 == grid[i][j]) {
                    // top
                    int tmp = i - 1;
                    if (0 > tmp || 0 == grid[tmp][j])  ++result;
                    // bottom
                    tmp = i + 1;
                    if (row == tmp || 0 == grid[tmp][j]) ++result;
                    // left
                    tmp = j - 1;
                    if (0 > tmp || 0 == grid[i][tmp]) ++result;
                    // right
                    tmp = j + 1;
                    if (column == tmp || 0 == grid[i][tmp]) ++result;
                }
            }
        }
        return result;
    }

}
