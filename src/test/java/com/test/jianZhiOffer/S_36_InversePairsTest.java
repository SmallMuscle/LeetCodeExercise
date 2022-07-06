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
        execTest(nums, 0);
        nums = new int[] {};
        execTest(nums, 0);
        nums = new int[] {4, 5, 6, 7};
        execTest(nums, 0);
        nums = new int[] {7, 6, 5, 4};
        execTest(nums, 6);
        nums = new int[] {7, 5, 6, 4};
        execTest(nums, 5);
        nums = new int[] {7, 6, 7, 5, 4};
        execTest(nums, 8);
        nums = new int[] {5};
        execTest(nums, 0);
        nums = new int[] {7, 6};
        execTest(nums, 1);
        nums = new int[] {6, 7};
        execTest(nums, 0);
        nums = new int[] {6, 6};
        execTest(nums, 0);
    }

    public void execTest(int[] nums, int expect) {
        log.info("-------------------------------------------------");
        try {
            int[] tmp = null;
            if (null != nums) {
                tmp = new int[nums.length];
                System.arraycopy(nums, 0, tmp, 0, nums.length);
            }
            int result = CostTimeUtil.costMillisecond(() -> solution.inversePairs(nums));
            log.info("Inverse pairs num is {} in {}", result, tmp);
            log.info("Result is {}correct.", result == expect ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
