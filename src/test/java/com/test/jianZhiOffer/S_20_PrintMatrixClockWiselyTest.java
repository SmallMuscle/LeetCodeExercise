package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_20_PrintMatrixClockWiselyTest {

    private S_20_PrintMatrixClockWisely solution = new S_20_PrintMatrixClockWisely();

    @Test
    public void printMatrixClockWiselyTest() {
        int[][] matrix = null;
        execTest(matrix);
        matrix = new int[][] {};
        execTest(matrix);
        matrix = new int[][] {{}};
        execTest(matrix);
        matrix = new int[][] {{}, {}};
        execTest(matrix);
        matrix = new int[][] {{1}, {2}, {3}, {4}, {5}};
        execTest(matrix);
        matrix = new int[][] {{1, 2, 3, 4, 5}};
        execTest(matrix);
        matrix = new int[][] {{1, 6, 11, 16, 21}, {2, 7, 12, 17, 22}, {3, 8, 13, 18, 23}, {4, 9, 14, 19, 24}, {5, 10, 15, 20, 25}};
        execTest(matrix);
        matrix = new int[][] {{1, 6, 11, 16}, {2, 12, 17, 22}, {3, 8, 18, 23}, {4, 14, 19, 24}, {5, 10, 15, 20}};
        execTest(matrix);
        matrix = new int[][] {{1, 6, 11, 16}, {2, 12, 17, 22}, {3, 8, 18, 23}, {4, 14, 19, 24}};
        execTest(matrix);
        matrix = new int[][] {{1, 6, 11, 16, 2, 12, 17, 22}, {3, 8, 18, 23, 4, 14, 19, 24}};
        execTest(matrix);
    }

    public void execTest(int[][] matrix) {
        log.info("-------------------------------------------------");
        try {
            log.info("origin matrix: ");
            PrintUtil.printArray(matrix);
            CostTimeUtil.costMillisecond(() -> solution.printMatrixClockWisely(matrix));
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
