package com.test.jianZhiOffer;

import com.test.utils.ArrayUtil;
import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_41_FindNumbersWithSumTest {

    private S_41_FindNumbersWithSum solution = new S_41_FindNumbersWithSum();

    @Test
    public void findNumbersWithSumTest() {
        int[] arr = null;
        execTest(arr, 0, null);
        arr = new int[] {};
        execTest(arr, 0, null);
        arr = new int[] {1};
        execTest(arr, 0, null);
        arr = new int[] {1, 2};
        execTest(arr, 3, new int[][] {{1, 2}});
        arr = new int[] {1, 2};
        execTest(arr, 2, null);
        arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        execTest(arr, 8, new int[][] {{1, 7}, {2, 6}, {3, 5}});
        execTest(arr, 7, new int[][] {{1, 6}, {2, 5}, {3, 4}});
        execTest(arr, 6, new int[][] {{1, 5}, {2, 4}});
        execTest(arr, 5, new int[][] {{1, 4}, {2, 3}});
        execTest(arr, 4, new int[][] {{1, 3}});
        execTest(arr, 3, new int[][] {{1, 2}});
        execTest(arr, 2, null);
    }

    public void execTest(int[] arr, int sum, int[][] expect) {
        log.info("-------------------------------------------------");
        try {
            int[][] result = CostTimeUtil.costMillisecond(() -> solution.findNumbersWithSum(arr, sum));
            log.info("The sum of {} in {} is {} \nExpect: {}", result, arr, sum, expect);
            log.info("Result is {}correct.", ArrayUtil.equals(result, expect) ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
