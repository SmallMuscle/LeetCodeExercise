package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_31_ContinuousSubArrayMaxSumTest {

    private S_31_ContinuousSubArrayMaxSum solution = new S_31_ContinuousSubArrayMaxSum();

    @Test
    public void continuousSubArrayMaxSumTest() {
        int[] arrs = null;
        execTest(arrs, 0);
        arrs = new int[] {};
        execTest(arrs, 0);
        arrs = new int[] {1};
        execTest(arrs, 1);
        arrs = new int[] {1, 2};
        execTest(arrs, 3);
        arrs = new int[]{1, -10, 2};
        execTest(arrs, 2);
        arrs = new int[] {1,2,-5, 2, 2};
        execTest(arrs, 4);
        arrs = new int[] {1,-1,3,-2,5,-1};
        execTest(arrs, 6);
        arrs = new int[] {1,5,3,2,-10,2,5,2};
        execTest(arrs, 11);
        arrs = new int[] {1,2,-3,2,2,2,5,-4,2};
        execTest(arrs, 11);
        arrs = new int[] {1,-2,3,10,-4,7,2,-5};
        execTest(arrs, 18);
    }

    public void execTest(int[] arr, int  expectResult) {
        log.info("-------------------------------------------------");
        try {
            int result = CostTimeUtil.costMillisecond(() -> solution.continousSubArrayMaxSum(arr));
            log.info("arr {} continuous sub array max sum: {} solution result: {}", arr, expectResult, result);
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }


}
