package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_08_MinNumberInRotateArrayTest {

    private S_08_MinNumberInRotateArray solution = new S_08_MinNumberInRotateArray();

    @Test
    public void minNumberInRotateArrayTest() {
        int[] arrs = null;
        execTest(arrs);
        arrs = new int[] {};
        execTest(arrs);
        arrs = new int[] {1};
        execTest(arrs);
        arrs = new int[] {1,2,3,4,5};
        execTest(arrs);
        arrs = new int[] {4,5,1,2,3};
        execTest(arrs);
        arrs = new int[] {0,0,1,1,1};
        execTest(arrs);
        arrs = new int[] {1,1,1,1,1};
        execTest(arrs);
    }

    private void execTest(int[] arrs) {
        PrintUtil.printArray(arrs);
        log.info("min number by loop: {}", CostTimeUtil.costMillisecond(() -> solution.minNumberInRotateArray(arrs)));
        log.info("min number by recursive : {}", CostTimeUtil.costMillisecond(() -> solution.minNumberInRotateArrayByRecursive(arrs)));
    }
}
