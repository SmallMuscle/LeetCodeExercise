package com.test.utils;

import com.test.function.ExecVoid;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class CostTimeUtil {

    public static <R> R costMillisecond(Supplier<R> supplier) {
        long start = System.nanoTime();
        R result = supplier.get();
        log.info("cost time {} ns", System.nanoTime() - start);
        return result;
    }

    public static void costMillisecond(ExecVoid execVoid) {
        long start = System.nanoTime();
        execVoid.exec();
        log.info("cost time {} ns", System.nanoTime() - start);
    }

}
