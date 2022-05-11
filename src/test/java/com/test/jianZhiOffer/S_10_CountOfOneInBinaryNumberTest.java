package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_10_CountOfOneInBinaryNumberTest {

    private S_10_CountOfOneInBinaryNumber solution = new S_10_CountOfOneInBinaryNumber();

    @Test
    public void countOfOneInBinaryNumber() {
        int n = 0;
        execTest(n);
        n = 1;
        execTest(n);
        n = -1;
        execTest(n);
        n = 100;
        execTest(n);
        n = 128;
        execTest(n);
        n = 512;
        execTest(n);
        n = 555;
        execTest(n);
        n = 1 << 31;
        execTest(n);
    }

    public void execTest(int n) {
        log.info("There are {} (binary: {}) 1 in the number {} by shift.", n, Integer.toBinaryString(n), CostTimeUtil.costMillisecond(() ->
                solution.countOfOneInBinaryNumberByShift(n)));
        log.info("There are {} (binary: {}) 1 in the number {} by subtration.", n, Integer.toBinaryString(n), CostTimeUtil.costMillisecond(() ->
                solution.countOfOneInBinaryNumberBySubtration(n)));
    }

    @Test
    public void negetiveNumberTest() {
        int i = 1 << 31;
        i ^= 1 << 30;
        int tmp = i - 1;
        log.info("\ni: {}\ntmp: {}", i, tmp);
        log.info("\n\t{} \n&\t{}\n=\t{}", Integer.toBinaryString(i), Integer.toBinaryString(tmp),
                Integer.toBinaryString(i & tmp));

        int i2 = -1;
        log.info("i2: {}", i2);
        i2 >>= 1;
        log.info("i2 >>= 1 : {} // 有符号 右移", i2);
        i2 >>>= 1;
        log.info("i2 >>>= 1 : {} // 无符号 右移", i2);
    }

}
