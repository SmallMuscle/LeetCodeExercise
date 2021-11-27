package com.test.Hard.L_827_MakingALargeIsland;

import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        Map<Integer, Solution.Island> islands = new HashMap<>();
        final int n = grid.length;
        final int maxLimit = n * n;
        int[][] pointIsland = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = j - 1;
                int top = i - 1;
                if (1 == grid[i][j]) {
                    Solution.Island island = null;
                    int islandId = -1;
                    if (0 <= left && 1 == grid[i][left]) {
                        island = islands.get(islandId = pointIsland[i][left]);
                        pointIsland[i][j] = islandId;
                        island.num++;
                    }

                    if (0 <= top && 1 == grid[top][j]) {
                        int topIslandId = pointIsland[top][j];
                        Solution.Island topIsland = islands.get(topIslandId);
                        if (null == island) {
                            island = topIsland;
                            pointIsland[i][j] = islandId = topIslandId;
                            island.num++;
                        } else if (topIsland != island) {
                            island.num += topIsland.num;
                            islands.remove(topIslandId);
                            islands.put(topIslandId, island);
                        }
                    }
                    if (null == island) {
                        island = new Island();
                        islandId = islands.size();
                        islands.put(islandId, island);
                        pointIsland[i][j] = islandId;
                        island.num++;
                    }
                    int preLeft = left - 1;
                    if (0 <= preLeft && 1 != grid[i][left] && 1 == grid[i][preLeft]) {
                        int neiborId = pointIsland[i][preLeft];
                        Solution.Island leftIsland = islands.get(neiborId);
                        if (island != leftIsland) {
                            island.addNeiborhood(neiborId);
                            leftIsland.addNeiborhood(islandId);
                        }
                    }
                    int preTop = top - 1;
                    if (0 <= preTop && 1 != grid[top][j] && 1 == grid[preTop][j]) {
                        int neiborId = pointIsland[preTop][j];
                        Solution.Island topIsland = islands.get(neiborId);
                        if (island != topIsland) {
                            island.addNeiborhood(neiborId);
                            topIsland.addNeiborhood(islandId);
                        }
                    }

                    if (0 <= top && 0 <= left && 1 == grid[top][left]
                            && 0 == grid[top][j] && 0 == grid[i][left]) {
                        int neiborId = pointIsland[top][left];
                        Solution.Island neiborIsland = islands.get(neiborId);
                        island.addNeiborhood(neiborId);
                        neiborIsland.addNeiborhood(islandId);
                    }
                } else {
                    if (0 <= left && 0 <= top && 1 == grid[top][j] && 1 == grid[i][left]
                            && 0 == grid[top][left]) {
                        int topId = pointIsland[top][j];
                        int leftId  = pointIsland[i][left];
                        Solution.Island topIsland = islands.get(topId);
                        Solution.Island leftIsland = islands.get(leftId);
                        if (topIsland != leftIsland) {
                            topIsland.addNeiborhood(leftId);
                            leftIsland.addNeiborhood(topId);
                        }
                    }
                }
            }
        }
        Iterator<Map.Entry<Integer, Solution.Island>> islandIterator = islands.entrySet().iterator();
        int max = 0;
        Set<Solution.Island> filter = new HashSet<>();
        while (islandIterator.hasNext()) {
            Map.Entry<Integer, Solution.Island> islandEntry = islandIterator.next();
            int islandId = islandEntry.getKey();
            Solution.Island island = islandEntry.getValue();
            if (! filter.contains(island)) {
                filter.add(island);
                if (island.hasNeiborhood()) {
                    Iterator<Integer> neiborIdIterator = island.neiborhoods.iterator();
                    while (neiborIdIterator.hasNext()) {
                        int neiborId = neiborIdIterator.next();
                        Solution.Island neiborIsland = islands.get(neiborId);
                        neiborIdIterator.remove();
                        if (island != neiborIsland) {
                            neiborIsland.removeNeiborhood(islandId);
                            int maxTmp = island.num + neiborIsland.num + 1;
                            if (maxTmp > max) {
                                max = maxTmp;
                            }
                        }
                    }
                } else {
                    int maxTmp = island.num;
                    if (maxLimit == maxTmp) {
                        max = island.num;
                    } else if (++maxTmp > max) {
                        max = maxTmp;
                    }
                }
            }
        }
        return 0 == max ? 1 : max;
    }

    class Island {
        int num = 0;
        Set<Integer> neiborhoods;

        public boolean hasNeiborhood() {
            return null != neiborhoods && ! neiborhoods.isEmpty();
        }

        public void addNeiborhood(int neiborhoodId) {
            if (null == neiborhoods) {
                neiborhoods = new HashSet();
            }
            neiborhoods.add(neiborhoodId);
        }

        public void removeNeiborhood(int neiborHoodId) {
            if (null != neiborhoods) {
                neiborhoods.remove(neiborHoodId);
            }
        }
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
    }

    
}

