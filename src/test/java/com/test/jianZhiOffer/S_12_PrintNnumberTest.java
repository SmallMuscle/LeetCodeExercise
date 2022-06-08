package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_12_PrintNnumberTest {

    private S_12_PrintNnumber solution = new S_12_PrintNnumber();

    @Test
    public void printNnumberTest() {
        int n = 0;
        execTest(n);
        n = -1;
        execTest(n);
        n = 1;
        execTest(n);
        n = 3;
        execTest(n);
        n = 5;
        execTest(n);
    }

    public void execTest(int n) {
        try {
            log.info("print max len: {}", n);
            CostTimeUtil.costMillisecond(() -> solution.printToMaxOfDigits(n));
            Thread.sleep(1000);
        } catch (RuntimeException | InterruptedException e) {
            log.error("err: ", e);
        }
    }

}
