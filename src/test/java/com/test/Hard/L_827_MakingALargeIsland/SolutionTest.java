package com.test.Hard.L_827_MakingALargeIsland;

import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

@Slf4j
public class SolutionTest {


    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] grid = new int[][] {{0, 0},
                                    {0, 0}};
        PrintUtil.printArray(grid);
        final int [][] g = grid;
        int max = (int) CostTimeUtil.costMillisecond(() -> solution.largestIsland(g));
        log.info("max island: {}", max);
        grid = new int[][] {{0, 1},
                            {1, 0}};
        PrintUtil.printArray(grid);
        max = solution.largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{1, 1},
                            {1, 0}};
        PrintUtil.printArray(grid);
        max = solution.largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{1, 1},
                            {1, 1}};
        PrintUtil.printArray(grid);
        max = solution.largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{0,0,0,0,0,0,0},
                            {0,1,1,1,1,0,0},
                            {0,1,0,0,1,0,0},
                            {1,0,1,0,1,0,0},
                            {0,1,0,0,1,0,0},
                            {0,1,0,0,1,0,0},
                            {0,1,1,1,1,0,0}};
        PrintUtil.printArray(grid);
        max = solution.largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{1,0,1,0,1},
                            {0,1,1,0,1},
                            {1,1,1,0,0},
                            {1,0,1,1,1},
                            {0,0,1,1,0}};
        PrintUtil.printArray(grid);
        max = solution.largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{1,0,0,0,1,0,1,0,1},
                            {0,1,0,0,1,0,0,0,0},
                            {1,0,1,0,1,1,0,0,0},
                            {1,1,1,1,1,0,0,0,0},
                            {1,1,0,1,0,1,1,1,0},
                            {0,0,0,1,0,1,0,1,1},
                            {1,1,1,1,0,0,1,1,0},
                            {0,1,1,1,0,1,0,0,1},
                            {1,1,1,0,1,0,1,0,1}};
        PrintUtil.printArray(grid);
        max = solution.largestIsland(grid);
        log.info("max island: {}", max);
    }
}
