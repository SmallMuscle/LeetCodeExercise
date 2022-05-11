package com.test.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class TmpTest {

    @Test
    public void tmp() {
        log.info("7 + 1 = {}", 7 + 1);
        log.info("47 + 1= {}", 47 + 1);
        log.info("2147483647 + 1 = {}", 2147483647 + 1);
    }

    @Test
    public void countDownLatchTest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        latch.countDown();
        latch.await();
    }
}
