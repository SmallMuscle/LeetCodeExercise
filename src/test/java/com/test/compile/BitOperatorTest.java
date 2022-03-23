package com.test.compile;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BitOperatorTest {

    @Test
    public void shiftTest() {
        int i = 16;
        i /= 4;
        log.info("i: {}", i);
        i = 16;
        i >>= 2;
        log.info("i: {}", i);
    }
}
