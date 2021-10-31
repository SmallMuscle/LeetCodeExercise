package com.test.other;

import com.test.utils.PrintUtil;
import com.test.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class EditDistance {

    /**
     * 已知 word1、word2，有插入、删除、替换三种操作
     * 计算 word1 转换成 word2 所使用的最少操作次数
     *
     * eg:
     * Input: word1 = "horse", word2 = "ros"
     * Output: 3
     * Explain:
     *      horse -> rorse
     *      rorse -> rose
     *      rose  -> ros
     *
     * Input: word1 = "intention", word2 = "execution"
     * Output: 5
     * Explain:
     *      intention -> inention
     *      inention  -> enention
     *      enention  -> exention
     *      exention  -> exection
     *      exection  -> execution
     *
     * analysis:
     *      0   e   x   e   c   u   t   i   o   n
     *  0   0   1   2   3   4   5   6   7   8   9
     *  i   1   1   2   3   4   5   6   6   7   8
     *  n   2   2   2   3   4   5   6   7   7   7
     *  t   3   3   3   3   4   5   5   6   7   8
     *  e   4   3   4   3   4   5   6   6   7   8
     *  n   5   4   4   4   4   5   6   7   7   7
     *  t   6   5   5   5   5   5   5   6   7   8
     *  i   7   6   6   6   6   6   6   5   6   7
     *  o   8   7   7   7   7   7   7   6   5   6
     *  n   9   8   8   8   8   8   8   7   6   5
     *
     *                          ┏ max(i, j)                                     min(i, j) == 0
     *  f word1, word2 (i, j) = |
     *                          |     ┏ f word1, word2 (i, j - 1) + 1                           ┓
     *                          ┗ min ╋ f word1, word2 (i - 1, ) + 1                            ┣ min(i, j) != 0
     *                                ┗ f word1, word2 (i - 1, j - 1) + (word1(i) != word2(j))  ┛
     *                                                                       ? 1
     *                                                                       : 0
     */

    public int editDistance(String str1, String str2) {
        if (StringUtil.isEmpty(str1) && StringUtil.isEmpty(str2)) {
            return 0;
        } else if (StringUtil.isEmpty(str1)) {
            return str2.length();
        } else if (StringUtil.isEmpty(str2)) {
            return str1.length();
        }
        int len1 = str1.length() + 1;
        int len2 = str2.length() + 1;
        int[][] distince = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int min, max;
                if (i > j) {
                    min = j;
                    max = i;
                } else {
                    min = i;
                    max = j;
                }
                if (0 == min) {
                    distince[i][j] = max;
                } else {
                    int realIndex1 = i - 1;
                    int realIndex2 = j - 1;
                    int d1 = distince[i][realIndex2] + 1;
                    int d2 = distince[realIndex1][j] + 1;
                    int d3 = distince[realIndex1][realIndex2]
                            + (str1.charAt(realIndex1) != str2.charAt(realIndex2)
                                ? 1 : 0);
                    distince[i][j] = Math.min(d3, Math.min(d1, d2));
                }
            }
        }
        //PrintUtil.printArray(distince);
        return distince[str1.length()][str2.length()];
    }

    @Test
    public void testCase() {
        String str1 = "llll";
        String str2 = "lol";
        /**
         *      0   l   o   l
         *  0   0   1   2   3
         *  l   1   0   1   2
         *  l   2   1   1   1
         *  l   3   2   2   1
         *  l   4   3   3   2
         */
        int result = editDistance(str1, str2);
        log.info("result: {}", result);

        str1 = "horse";
        str2 = "ros";
        result = editDistance(str1, str2);
        log.info("result: {}", result);

        str1 = "intention";
        str2 = "execution";
        result = editDistance(str1, str2);
        log.info("result: {}", result);
    }

}
