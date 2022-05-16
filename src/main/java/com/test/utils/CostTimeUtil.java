package com.test.utils;

import com.test.function.ExecVoid;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class CostTimeUtil {

    public static <R> R costMillisecond(Supplier<R> supplier) {
        long start = System.nanoTime();
        R result = null;
        try {
            result = supplier.get();
        } catch (Throwable t) {
            log.error("executing err: ", t);
        }
        log.info("cost time {} ns", System.nanoTime() - start);
        return result;
    }

    public static void costMillisecond(ExecVoid execVoid, Object ... args) {
        long start = System.nanoTime();
        try {
            execVoid.exec();
        } catch (Throwable t) {
            log.error("executing err: ", t);
        }
        log.info("cost time {} ns {}", System.nanoTime() - start, (null == args || 0 == args.length) ? "" : args[0]);
    }

}
