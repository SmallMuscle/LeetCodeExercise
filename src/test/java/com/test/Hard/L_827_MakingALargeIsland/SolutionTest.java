package com.test.Hard.L_827_MakingALargeIsland;

import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test() {
        final int[][] grid1 = new int[][]{
                {0, 0},
                {0, 0}};
        execTest(grid1);
        final int[][] grid2 = new int[][]{
                {0, 1},
                {1, 0}};
        execTest(grid2);
        final int[][] grid3 = new int[][]{
                {1, 1},
                {1, 0}};
        execTest(grid3);
        final int[][] grid4 = new int[][]{
                {1, 1},
                {1, 1}};
        execTest(grid4);
        final int[][] grid5 = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}};
        execTest(grid5);
        final int[][] grid6 = new int[][]{
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {1, 1, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 1, 1, 0}};
        execTest(grid6);
        final int[][] grid7 = new int[][] {
                {1,0,0,0,1,0,1,0,1},
                {0,1,0,0,1,0,0,0,0},
                {1,0,1,0,1,1,0,0,0},
                {1,1,1,1,1,0,0,0,0},
                {1,1,0,1,0,1,1,1,0},
                {0,0,0,1,0,1,0,1,1},
                {1,1,1,1,0,0,1,1,0},
                {0,1,1,1,0,1,0,0,1},
                {1,1,1,0,1,0,1,0,1}};
        execTest(grid7);
    }

    private void execTest(int [][] grid) {
        PrintUtil.printArray(grid);
        int max = CostTimeUtil.costMillisecond(() -> solution.largestIsland(grid));
        log.info("max island: {}", max);
    }
}
