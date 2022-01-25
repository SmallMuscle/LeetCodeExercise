package com.test.Hard.L_827_MakingALargeIsland;

import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Solution {

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
     * 1 0 1 0 1 0 0 1 0 1 0 0 0 0 0 0
     * 0 1 0 1 0 0 0 1 1 1 1 1 0 0 0 0
     * 1 0 1 0 1 0 0 0 1 1 1 0 0 0 0 0
     * 0 1 0 1 0 0 1 1 1 1 1 1 1 1 1 0
     * 1 0 1 0 1 1 1 1 1 1 1 1 1 0 0 0
     * 0 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0
     * 0 0 0 0 0 0 1 1 1 1 1 1 1 1 0 0
     * 0 0 0 0 0 1 1 1 1 1 1 1 1 0 0 0
     * 0 0 0 0 1 1 0 0 0 1 1 1 0 0 0 0
     * 0 0 0 0 1 1 1 0 0 0 1 0 0 0 0 0
     */
    public int largestIsland(int[][] grid) {
        Map<Integer, Island> islands = new HashMap<>();
        Map<Island, Set<Integer>> island2Id = new HashMap<>();
        Map<Integer, Set<Integer>> linkes = new HashMap<>();
        final int n = grid.length;
        final int maxLimit = n * n;
        int[][] pointIndex = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = j - 1;
                int top = i - 1;
                Set<Integer> rightLink = null;
                Set<Integer> bottomLink = null;
                if (1 == grid[i][j]) {
                    Island island = null;
                    int islandId = -1;
                    if (0 <= left) {
                        if (1 == grid[i][left]) {
                            island = islands.get(islandId = pointIndex[i][left]);
                            pointIndex[i][j] = islandId;
                            island.num++;
                        } else {
                            rightLink = linkes.get(pointIndex[i][left]);
                        }
                    }

                    if (0 <= top) {
                        if (1 == grid[top][j]) {
                            int topIslandId = pointIndex[top][j];
                            Island topIsland = islands.get(topIslandId);
                            if (null == island) {
                                island = topIsland;
                                pointIndex[i][j] = islandId = topIslandId;
                                island.num++;
                            } else if (topIsland != island) {
                                island.num += topIsland.num;
                                islands.put(topIslandId, island);
                                Set<Integer> ids = island2Id.get(island);
                                ids.addAll(island2Id.get(topIsland));
                                for (Integer id : ids) {
                                    islands.put(id, island);
                                }
                                island2Id.remove(topIsland);
                            }
                        } else {
                            bottomLink = linkes.get(pointIndex[top][j]);
                        }
                    }
                    if (null == island) {
                        island = new Island();
                        islandId = islands.size();
                        islands.put(islandId, island);
                        pointIndex[i][j] = islandId;
                        Set<Integer> ids = new HashSet<>();
                        island2Id.put(island, ids);
                        ids.add(islandId);
                        island.num++;
                    }
                    if (null != rightLink) {
                        linkes.get(pointIndex[i][left]).add(islandId);
                    }
                    if (null != bottomLink) {
                        linkes.get(pointIndex[top][j]).add(islandId);
                    }
                } else {
                    int right = j + 1;
                    int bottom = i + 1;
                    int islandLinkCount = 0;
                    if (left >= 0) {
                        islandLinkCount += grid[i][left];
                    }
                    if (right < n) {
                        islandLinkCount += grid[i][right];
                    }
                    if (top >= 0) {
                        islandLinkCount += grid[top][j];
                    }
                    if (bottom < n) {
                        islandLinkCount += grid[bottom][j];
                    }
                    if (islandLinkCount > 1) {
                        int linkId = 1 + linkes.size();
                        pointIndex[i][j] = linkId;
                        Set<Integer> linkSet = new HashSet<>();
                        linkes.put(linkId, linkSet);
                        if (left >= 0 && 1 == grid[i][left]) {
                            linkSet.add(pointIndex[i][left]);
                        }
                        if (top >= 0 && 1 == grid[top][j]) {
                            linkSet.add(pointIndex[top][j]);
                        }
                    }
                }
            }
        }

        int max = 0;
        if (linkes.isEmpty()) {
            Iterator<Island> islandItr = islands.values().iterator();
            while (islandItr.hasNext()) {
                Island island = islandItr.next();
                if (island.num > max ) {
                    max=  island.num;
                }
            }
        } else {
            Iterator<Set<Integer>> linkesItr = linkes.values().iterator();
            Set<Island> filter = new HashSet<>();
            while (linkesItr.hasNext()) {
                int tmpMax = 0;
                Set<Integer> islandIdSet = linkesItr.next();
                for (Integer islandId : islandIdSet) {
                    Island island = islands.get(islandId);
                    if (!filter.contains(island)) {
                        filter.add(island);
                        tmpMax += island.num;
                    }
                }
                filter.clear();
                if (tmpMax > max) {
                    max = tmpMax;
                }
            }
        }
        return maxLimit == max ? max : max + 1;
    }

    class Island {
        int num;
    }

    @Test
    public void test() {
        int max;
        int[][] grid = new int[][] {{0, 0}, {0, 0}};
        PrintUtil.printArray(grid);
        max = largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{0, 1}, {1, 0}};
        PrintUtil.printArray(grid);
        max = largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{1, 1}, {1, 0}};
        PrintUtil.printArray(grid);
        max = largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{1, 1}, {1, 1}};
        PrintUtil.printArray(grid);
        max = largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}};
        PrintUtil.printArray(grid);
        max = largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{1,0,1,0,1},{0,1,1,0,1},{1,1,1,0,0},{1,0,1,1,1},{0,0,1,1,0}};
        PrintUtil.printArray(grid);
        max = largestIsland(grid);
        log.info("max island: {}", max);
        grid = new int[][] {{1,0,0,0,1,0,1,0,1},{0,1,0,0,1,0,0,0,0},{1,0,1,0,1,1,0,0,0},{1,1,1,1,1,0,0,0,0},{1,1,0,1,0,1,1,1,0},{0,0,0,1,0,1,0,1,1},{1,1,1,1,0,0,1,1,0},{0,1,1,1,0,1,0,0,1},{1,1,1,0,1,0,1,0,1}};
        PrintUtil.printArray(grid);
        max = largestIsland(grid);
        log.info("max island: {}", max);
    }

}

