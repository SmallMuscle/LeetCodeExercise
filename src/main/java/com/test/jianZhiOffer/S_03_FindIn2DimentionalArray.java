package com.test.jianZhiOffer;

public class S_03_FindIn2DimentionalArray {

    /**
     * Question: 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * Eg:
     *      1   2   8   9
     *      2   4   9   12
     *      4   7   10  13
     *      6   8   11  15
     *
     * Example1:
     * Input:  3
     * Output: false
     *
     * Example2:
     * Input:  4
     * Output: true
     */

    public boolean isInArray(int[][] arrs, int target) {
        if (null == arrs) return false;
        int rIndex = arrs.length - 1;
        int cIndex = 0;
        while (rIndex >= 0 && cIndex < arrs[0].length) {
            if (target > arrs[rIndex][cIndex]) ++cIndex;
            else if (target < arrs[rIndex][cIndex]) --rIndex;
            else return true;
        }
        return false;
    }
}
