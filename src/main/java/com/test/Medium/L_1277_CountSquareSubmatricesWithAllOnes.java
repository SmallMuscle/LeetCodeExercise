package com.test.Medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class L_1277_CountSquareSubmatricesWithAllOnes {

   /**
    * 传送门：https://leetcode.com/problems/count-square-submatrices-with-all-ones/
    * question：给定二维数组，元素有 0、1
    * 假定 1 为边长为 1 的正方形，返回所有正方形的数量（不包含斜着的。。）
    *
    * eg：
    *   [0,1,1,1],
    *   [1,1,1,1],
    *   [0,1,1,1]
    * 返回: 15
    * 10 个边长为 1.
    * 4 个边长为 2.
    * 1 个边长为 3.
    * sum = 10 + 4 + 1 = 15.
    *
    *   [1,0,1],
    *   [1,1,0],
    *   [1,1,0]
    * 返回: 7
    * 6 个边长为 1.
    * 1 个边长为 2.
    * sum = 6 + 1 = 7
    *
    * analysis：
    * 第一反应暴力，需要遍历多次数组，效率不高。。。
    * 参考 Discuss，仅需遍历 1 次
    * 左、上边界统计 1 的数量
    * 1 1 1     1 1 1
    * 1 1 1 ->  1 2 2
    * 1 1 1     1 2 3
    * 每个 1 1 除了各个 1 还需加上 4 个合并起来的 1 个
    *     1 1
    * 把结果加在右下角 1 1 （碰巧题目是 1 才统计，若不是使用 0、1 表示，
    *                1 2   可另开辟个使用 0、1 表示的数组记录）
    * 若左边和下边相邻的的 4 个也是全 1，
    * 右下角的四个 1 -> 1 1 和之前的 3 个 1 1 -> 1 1 1 组合成一个大的 1 1 1
    *                 1 1              1 1    1 1 1               1 1 1
    *                                         1 1                 1 1 1
    * 之前的 3 个 1 1 已经变成 1 1 1
    *            1 1         1 2 2
    *                        1 2
    * 当出现 2 2 说明存在 1 1 1 ，不仅要加 右下角的 1 1 的合起来的
    *       2 1         1 1 1                   1 1
    *                   1 1 1
    * 还要加 1 1 1 合起来的，2 2 就成了 2 2，最终成为 1 1 1
    *       1 1 1          2 1       2 3          1 2 2
    *       1 1 1                                 1 2 3
    * 遍历 1 1 的同时将结果加在右下角的同时，用一个变量记录总的数量
    *     1 1
    * solution：
    * 遍历二位数组，若为左、上边界则将 1 直接累加至结果中，
    * 否则 当前值为 1 时判断左上 3 个数是否存在 0
    *       若不存在，当前值 + 左上 3 个数最小的一个
    *       （若最小为 0，说明不存在组合的情况
    *         若最小为 1，则说明存在 1 1
    *                              1 1
    *         若存在最小为 2，则说明存在 1 1 1
    *                                 1 2 2
    *                                 1 2 1
    *         若存在最小为 3，则说明存在 1 1 1 1
    *                                 1 2 2 2
    *                                 1 2 3 3
    *                                 1 2 3 1
    *       ）
    * 将当前值累加至结果中，直到二位数组遍历完毕
    * 返回结果值
    */
   public int countSquares(int[][] matrix) {
       int result = 0;
       for (int i = 0; i < matrix.length; i++) {
           result += matrix[i][0];
       }
       for (int i = 1; i < matrix[0].length; i++) {
           result += matrix[0][i];
       }
       for (int i = 1; i < matrix.length; i++) {
           for (int j = 1; j < matrix[0].length; j++) {
               if (matrix[i][j] == 1) {
                   matrix[i][j] += Math.min(matrix[i - 1][j - 1],
                           Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                   result += matrix[i][j];
               }
           }
       }
       return result;
   }
/*
   // method 1
   public int countSquares(int[][] matrix) {
       int result = 0;
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[0].length; j++) {
               if (i == 0 || j == 0) result += matrix[i][j];
               else {
                   if (matrix[i][j] == 1) {
                       matrix[i][j] += matrix[i - 1][j] > matrix[i][j - 1]
                           ? (matrix[i][j - 1] > matrix[i - 1][j - 1]
                               ? matrix[i - 1][j - 1]
                               : matrix[i][j - 1])
                           : (matrix[i - 1][j] > matrix[i - 1][j - 1]
                               ? matrix[i - 1][j - 1]
                               : matrix[i - 1][j]);
                       result += matrix[i][j];
                   }
               }
           }
       }
       return result;
   }*/
   /*
    // 暴力
    public int countSquares(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int min = rowNum > colNum ? colNum : rowNum;
        int result = 0,
                rowEnd, colEnd;
        for (int i = 1; i <= min; i++) {
            rowEnd = rowNum - i + 1;
            colEnd = colNum - i + 1;
            for (int j = 0; j < rowEnd; j++) {
                for (int k = 0; k < colEnd; k++) {



                    if (isSquare(matrix, j, k, i)) {
                        ++result;
                    }
                }
            }

        }
        return result;
    }*/

    private boolean isSquare(int[][] martrix,
                             int rowStart,
                             int colStart,
                             int len) {
        int rowEnd = rowStart + len;
        int colEnd = colStart + len;
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (martrix[i][j] == 0) return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] martrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        log.info("result: {}", countSquares(martrix));
        martrix = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        log.info("result: {}", countSquares(martrix));
        martrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 0}
        };
        log.info("result: {}", countSquares(martrix));
    }


}
