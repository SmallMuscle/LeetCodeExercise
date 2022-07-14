package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_40_FindNumsAppearOnceTest {

    private S_40_FindNumsAppearOnce solution = new S_40_FindNumsAppearOnce();

    @Test
    public void findNumsAppearOnceTest() {
        int[] arr = null;
        execTest(arr, null);
        arr = new int[] {};
        execTest(arr, null);
        arr = new int[] {1};
        execTest(arr, null);
        arr = new int[] {1, 2};
        execTest(arr, arr);
        arr = new int[] {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2};
        execTest(arr, new int[] {1, 7});
    }

    public void execTest(int[] arr, int[] expect) {
        log.info("-------------------------------------------------");
        try {
            int[] result = CostTimeUtil.costMillisecond(() -> solution.findNumsAppearOnce(arr));
            log.info("Number {} appear onece in {}", null == result ? null : result[0] + "\t" + result[1], arr);
            log.info("Result is {}correct.", checkResult(result, expect) ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

    private boolean checkResult(int[] result, int[] expect) {
        boolean resultIsBlank = null == result || 0 == result.length;
        boolean expectIsBlank = null == expect || 0 == expect.length;
        if (resultIsBlank) return expectIsBlank;
        else {
            if (expectIsBlank) return false;
            return result[0] == expect[0] ? (result[1] == expect[1])
                    : result[0] == expect[1] && result[1] == expect[0];
        }
    }

}
