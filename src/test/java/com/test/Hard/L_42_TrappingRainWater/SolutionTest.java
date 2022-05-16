package com.test.Hard.L_42_TrappingRainWater;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void test() {
        int[] height = null;
        execTest(height);
        height = new int[] {};
        execTest(height);
        height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        execTest(height);
        height = new int[] {4,2,0,3,2,5};
        execTest(height);
        height = new int[] {1,2,3,4,5,4,3,2,1};
        execTest(height);
    }

    private void execTest(int [] height) {
        int result = CostTimeUtil.costMillisecond(() -> solution.trap(height));
        log.info("resule: {} \t height: {}", result, height);
    }

}
