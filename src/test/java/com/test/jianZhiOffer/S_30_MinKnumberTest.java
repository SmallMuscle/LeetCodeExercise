package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_30_MinKnumberTest {

    private S_30_MinKnumber solution = new S_30_MinKnumber();

    @Test
    public void minKnumber() {
        int[] arrs = null;
        int k = 0;
        execTest(arrs, k);
        arrs = new int[] {};
        execTest(arrs, k);
        arrs = new int[] {1};
        execTest(arrs, k);
        arrs = new int[] {1, 2};
        k = 1;
        execTest(arrs, k);
        arrs = new int[]{1, 2, 2};
        execTest(arrs, k);
        arrs = new int[] {1,2,1, 2, 2};
        k = 2;
        execTest(arrs, k);
        arrs = new int[] {1,2,3,2,5,2};
        k = 3;
        execTest(arrs, k);
        arrs = new int[] {1,2,3,2,2,2,5,2};
        k = 6;
        execTest(arrs, k);
        arrs = new int[] {1,2,3,2,2,2,5,4,2};
        execTest(arrs, k);
    }

    public void execTest(int[] arrs, int k) {
        log.info("-------------------------------------------------");
        try {
            log.info("arr {} min {} element: ", arrs, k);
            solution.minKnumberByPile(arrs, k);
            solution.minKnumberByPartition(arrs, k);
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }


    @Test
    public void shiftTest() {
        log.info("result: {}", 1 << 0);
    }
}
