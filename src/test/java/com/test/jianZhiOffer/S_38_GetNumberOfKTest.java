package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_38_GetNumberOfKTest {

    private S_38_GetNumberOfK solution = new S_38_GetNumberOfK();

    @Test
    public void getNumberOfKTest() {
        int[] arr = null;
        int k = 5;
        execTest(arr, k, 0);
        arr = new int[] {};
        k = 5;
        execTest(arr, k, 0);
        arr = new int[] {1};
        k = 1;
        execTest(arr, k, 1);
        arr = new int[] {1, 1, 2};
        k = 1;
        execTest(arr, k, 2);
        k = 2;
        execTest(arr, k, 1);
        k = 5;
        execTest(arr, k, 0);
        arr = new int[] {1, 2, 3, 3, 3};
        k = 3;
        execTest(arr, k, 3);
        k = 5;
        execTest(arr, k, 0);
        arr = new int[] {1, 2, 3, 3, 4, 5};
        k = 5;
        execTest(arr, k, 1);
        k = 3;
        execTest(arr, k, 2);
    }

    public void execTest(int[] arr, int k, int expect) {
        log.info("-------------------------------------------------");
        try {
            int result = CostTimeUtil.costMillisecond(() -> solution.getNumberOfk(arr, k));
            log.info("The number {} appears {} times in {}.", k, result, arr);
            log.info("Result is {}correct.", result == expect ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
