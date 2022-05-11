package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_09_FibonacciTest {

    private S_09_Fibonacci solution = new S_09_Fibonacci();

    @Test
    public void fibonacciTest() {
        int n = 0;
        exec(n);
        n = 1;
        exec(n);
        n = 5;
        exec(n);
        n = 10;
        exec(n);
        n = 50;
        exec(n);
    }

    private void exec(int n) {
        log.info("n = {}", n);
        long result = CostTimeUtil.costMillisecond(() -> solution.fibonacci(n));
        log.info("Fibonacci ({}) = {}", n , result);
    }
}
