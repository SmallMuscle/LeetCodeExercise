package com.test.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DoubleTest {

    @Test
    public void equivlaentTest() {
        log.info("3 * 0.1 == 0.3 : {}", 3 * 0.1 == 0.3);
        log.info("5 * 0.1 == 0.5 : {}", 5 * 0.1 == 0.5);
    }

}
