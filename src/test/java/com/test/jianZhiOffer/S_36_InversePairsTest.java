package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_36_InversePairsTest {

    private S_36_InversePairs solution = new S_36_InversePairs();

    @Test
    public void inversePairsTest() {
        int[] nums = null;
        execTest(nums, null);
        nums = new int[] {};
        execTest(nums, null);
        nums = new int[] {4, 5, 6, 7};
        execTest(nums, null);
        nums = new int[] {7, 6, 5, 4};
        execTest(nums, new int[][] {{7, 6}, {7, 5}, {7, 4}, {6, 5}, {6, 4}, {5, 4}});
        nums = new int[] {7, 5, 6, 4};
        execTest(nums, new int[][] {{7, 5}, {7, 6}, {7, 4}, {5, 4}, {6, 4}});
        nums = new int[] {7, 6, 7, 5, 4};
        execTest(nums, new int[][] {{7, 6}, {7, 5}, {7, 4}, {6, 5}, {6, 4}, {7, 5}, {7, 4}, {5, 4}});
        nums = new int[] {5};
        execTest(nums, null);
        nums = new int[] {7, 6};
        execTest(nums, new int[][] {{7, 6}});
        nums = new int[] {6, 7};
        execTest(nums, null);
        nums = new int[] {6, 6};
        execTest(nums, null);
    }

    public void execTest(int[] nums, int[][] expect) {
        log.info("-------------------------------------------------");
        try {
            int[][] result = CostTimeUtil.costMillisecond(() -> solution.inversePairs(nums));
            log.info("Inverse pairs in {} ", nums);
            log.info("Expect: {}", expect);
            log.info("Result: {} is {}correct.", result, checkResult(result, expect) ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

    private boolean checkResult(int[][] result, int[][] expect) {
        if  (null == result || 0 == result.length) {
            return null == expect || 0 == expect.length;
        } else {
            if (null == expect || 0 == expect.length
                    || result.length != expect.length) return false;
            int[] index = new int[expect.length];
            for (int i = 0; i < expect.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    if (1 != index[j]) {
                        int minE = Math.min(expect[i][0], expect[i][1]);
                        int maxE = Math.min(expect[i][0], expect[i][1]);
                        int minR = Math.min(result[j][0], result[j][1]);
                        int maxR = Math.min(result[j][0], result[j][1]);
                        if (minE == minR && maxE == maxR) {
                            index[j] = 1;
                            break;
                        }
                    }
                }
            }
            for (int one : index) {
                if (1 != one) return false;
            }
            return true;
        }
    }

}
