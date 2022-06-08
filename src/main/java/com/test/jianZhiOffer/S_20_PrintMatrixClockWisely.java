package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_20_PrintMatrixClockWisely {

    /**
     * print matrix
     * ==================
     * |================|
     * -----------------|
     * @param matrix
     */
    public void printMatrixClockWisely(int[][] matrix) {
        if (null == matrix || 1 > matrix.length || 1 > matrix[0].length) return ;
        int rs = 0, re = matrix.length - 1, cs = 0, ce = matrix[0].length - 1;
        StringBuilder buffer = new StringBuilder();
        while (rs <= re && cs <= ce) {
            for (int i = cs; i <= ce; ++i) {
                buffer.append(matrix[rs][i]).append(' ');
            }
            ++rs;
            for (int i = rs; i <= re; ++i) {
                buffer.append(matrix[i][ce]).append(' ');
            }
            --ce;
            if (rs <= re) {
                for (int i = ce; i >= cs; --i) {
                    buffer.append(matrix[re][i]).append(' ');
                }
            }
            --re;
            if (cs <= ce) {
                for (int i = re; i >= rs; --i) {
                    buffer.append(matrix[i][cs]).append(' ');
                }
            }
            ++cs;
        }
        log.info("Result: {}", buffer);
    }

}
