package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_11_PowerTest {

    private S_11_Power solution = new S_11_Power();

    @Test
    public void countOfOneInBinaryNumber() {
        double base = 0.0;
        int exponent = 0;
        execTest(base, exponent);
        base = 0.0;
        exponent = 100;
        execTest(base, exponent);
        base = 0.0;
        exponent = -100;
        execTest(base, exponent);
        base = 0.5;
        exponent = 100;
        execTest(base, exponent);
        base = 0.5;
        exponent = -100;
        execTest(base, exponent);
        base = 0.5;
        exponent = 0;
        execTest(base, exponent);
        base = 5.0;
        exponent = 100;
        execTest(base, exponent);
        base = 5.0;
        exponent = -100;
        execTest(base, exponent);
        base = 5.0;
        exponent = 0;
        execTest(base, exponent);
        base = 5.0;
        exponent = 1;
        execTest(base, exponent);
        base = 5.0;
        exponent = -1;
        execTest(base, exponent);
    }

    public void execTest(double base, int exponent) {
        log.info("{} exp {} = {}", base, exponent, CostTimeUtil.costMillisecond(() ->
                solution.power(base, exponent)));
    }

}
