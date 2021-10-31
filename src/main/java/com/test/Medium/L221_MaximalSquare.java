package com.test.Medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class L221_MaximalSquare {

    /**
     * 传送门：https://leetcode.com/problems/maximal-square/
     *
     * question：给定一个二位数组，元素有 0、1
     * 返回最大的正方形区域的 1 的个数（正方形不包含斜着的。。）
     *
     * eg：
     * Input: matrix = [
     *      ["1","0","1","0","0"],
     *      ["1","0","1","1","1"],
     *      ["1","1","1","1","1"],
     *      ["1","0","0","1","0"]
     *  ]
     * Output: 4
     *
     * Input: matrix = [
     *      ["0","1"],
     *      ["1","0"]
     *  ]
     * Output: 1
     *
     * Input: matrix = [["0"]]
     * Output: 0
     *
     * analysis：
     * 思想和 1277 类似
     *
     * solution：
     * 遍历左、上边界，存在 1 则记录 max 为 1，跳出循环
     * 遍历二位数组剩余部分，按照 1277 规则，记录最大的值
     * 遍历结束后，返回 max * max
     */
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                max = 1;
                break;
            }
        }
        if (max != 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == '1') {
                    max = 1;
                    break;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1],
                            Math.min(matrix[i - 1][j], matrix[i][j - 1])) - '0';
                    int num = matrix[i][j] - '0';
                    if (num > max) max = num;
                }
            }
        }
        return max * max;
    }
    /*
    // 暴力
    public int maximalSquare(char[][] matrix) {
        int rowMax = matrix.length;
        int colMax = matrix[0].length;
        int min = rowMax > colMax ? colMax : rowMax;

        int rowEnd, colEnd;
        for (int i = min; i >= 1; i--) {
            rowEnd = rowMax - i;
            colEnd = colMax - i;
            for (int j = 0; j <= rowEnd; j++) {
                for (int k = 0; k <= colEnd; k++) {
                    if (isSquare(matrix, j, k, i)) {
                        return i * i;
                    }
                }
            }
        }
        return 0;
    }*/

    private boolean isSquare(char[][] martrix,
                             int rowStart,
                             int colStart,
                             int len) {
        int rowEnd = rowStart + len;
        int colEnd = colStart + len;
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (martrix[i][j] == '0') return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] chs = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        log.info("###{}###", maximalSquare(chs));
    }

    @Test
    public void charPlus() {
        char ch = '0';
        log.info("###{}###", ch);
        ch += 1;
        log.info("###{}###", ch);
    }

}
