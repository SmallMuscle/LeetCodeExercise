package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_33_PrintMinNumberTest {

    private S_33_PrintMinNumber solution = new S_33_PrintMinNumber();

    @Test
    public void printMinNumberTest() {
        int[] nums = null;
        execTest(nums, "");
        nums = new int[] {};
        execTest(nums, "");
        nums = new int[] {3,32,321};
        execTest(nums, "321323");
        nums = new int[] {1,2,3,4,123};
        execTest(nums, "1123234");
    }

    public void execTest(int[] nums, String expect) {
        log.info("-------------------------------------------------");
        try {
            String result = CostTimeUtil.costMillisecond(() -> solution.printMinNumber(nums));
            log.info("nums: {} combine min number: {}.", nums , result);
            log.info("exec result {}correct.", expect.equals(result) ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }


}
