package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_34_UglyNumberTest {

    private S_34_UglyNumber solution = new S_34_UglyNumber();

    @Test
    public void uglyNumberTest() {
        int n = -1;
        execTest(n, -1);
        n = 0;
        execTest(n, -1);
        n = 1;
        execTest(n, 1);
        n = 2;
        execTest(n, 2);
        n = 3;
        execTest(n, 3);
        n = 4;
        execTest(n, 4);
        n = 5;
        execTest(n, 5);
        n = 6;
        execTest(n, 6);
        n = 7;
        execTest(n, 8);
        n = 8;
        execTest(n, 9);
        n = 9;
        execTest(n, 10);
        n = 10;
        execTest(n, 12);
    }

    public void execTest(int n, int expect) {
        log.info("-------------------------------------------------");
        try {
            int result = CostTimeUtil.costMillisecond(() -> solution.uglyNumber(n));
            log.info("The {} ugly number is {}", n, result);
            log.info("exec result {}correct.", expect == result ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }


}
