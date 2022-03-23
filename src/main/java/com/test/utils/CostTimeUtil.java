package com.test.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
public class CostTimeUtil {

    public static Object costMillisecond(Supplier supplier, Object ... args) {
        long start = System.nanoTime();
        Object result = supplier.get();
        log.info("cost time {} ns", System.nanoTime() - start);
        return result;
    }

}
