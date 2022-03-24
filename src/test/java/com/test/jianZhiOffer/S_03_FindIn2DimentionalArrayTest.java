package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_03_FindIn2DimentionalArrayTest {

    private S_03_FindIn2DimentionalArray solution = new S_03_FindIn2DimentionalArray();

    @Test
    public void findTest() {
        int[][] arrs = null;
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {};
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {
                {0}
        };
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {
                {0, 1, 3}
        };
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {
                {0, 1, 3},
                {0, 1, 3}
        };
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {
                {0, 1, 3},
                {0, 1, 3},
                {0, 1, 3}
        };
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {
                {0, 1, 3},
                {1, 1, 4},
                {2, 3, 4}
        };
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {
                {0, 1, 3},
                {1, 1, 9},
                {2, 3, 10},
                {2, 3, 12},
                {2, 3, 12},
                {3, 8, 12},
                {5, 9, 15},
                {10, 12, 16}
        };
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {
                {0},
                {1},
                {2},
                {2},
                {3},
                {10},
                {12},
                {15}
        };
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
        arrs = new int[][] {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        execTest(arrs, -1);
        execTest(arrs, 0);
        execTest(arrs, 1);
        execTest(arrs, 2);
        execTest(arrs, 100);
    }

    private void execTest(int[][] arrs, int target) {
        PrintUtil.printArray(arrs);
        log.info("target {} is{}in arrays.", target,
                CostTimeUtil.costMillisecond(() -> solution.isInArray(arrs, target)) ? " " : " not ");
    }
}
