package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_32_NumberOf1Between1andNTest {

    private S_32_NumberOf1Between1andN solution = new S_32_NumberOf1Between1andN();

    @Test
    public void numberOf1Between1andNtest() {
        int n = -1;
        execTest(n, 0);
        n = 0;
        execTest(n, 0);
        n = 1;
        execTest(n, 1);
        n = 100;
        execTest(n, 21);
        n = 500;
        execTest(n, 200);
        n = 501;
        execTest(n, 201);
        n = 502;
        execTest(n, 201);
        n = 21345;
        execTest(n, 4000 * 2 + 10000 + 300 + 346 + 20 * 3 + 100 + 1 * 4 + 10 + 1);
    }

    public void execTest(int n, int expect) {
        log.info("-------------------------------------------------");
        try {
            int result = CostTimeUtil.costMillisecond(() -> solution.numberOf1Between1andN(n));
            log.info("number of 1 between 1 and {} expect result: {}\t exec result: {}", n , expect, result);
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }


}
