package com.test.Hard;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class L_827_MakingALargeIsland {

    /**
     * question: 给定一个 n * n 二位数组，包含 0、1，最多将一个 0 改为 1
     * 返回最大的 1 相连的数量
     *
     * eg:
     * Example 1:
     * Input: grid = [[1,0],[0,1]]
     * Output: 3
     *
     * Example 2:
     * Input: grid = [[1,1],[1,0]]
     * Output: 4
     *
     * Example 3:
     * Input: grid = [[1,1],[1,1]]
     * Output: 4
     *
     * Constraints:
     * 1 <= n <= 500
     *
     * analysys:
     * 遍历出各个相连的 1，
     * 判断边界 +1 可以连接的区域
     * 计算最大值
     *
     *
     * 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 1 1 1 1 1 0 0 0 0
     * 0 0 0 0 0 0 0 0 1 1 1 0 0 0 0 0
     * 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 0
     * 0 0 0 1 1 1 1 1 1 1 1 1 1 0 0 0
     * 0 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0
     * 0 0 0 0 0 0 1 1 1 1 1 1 1 1 0 0
     * 0 0 0 0 0 1 1 1 1 1 1 1 1 0 0 0
     * 0 0 0 0 1 1 0 0 0 1 1 1 0 0 0 0
     * 0 0 0 0 1 1 1 0 0 0 1 0 0 0 0 0
     *
     */
    public int largestIsland(int[][] grid) {
        return 0;
    }

    private List<Island> findIsland(int[][] grid) {
        List<Island> islands = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

            }
        }
        return islands;
    }

    class Island {
        Map<Integer, Integer> border;
        int num;
    }
}
