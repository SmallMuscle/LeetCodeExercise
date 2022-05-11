package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_09_Fibonacci {

    public long fibonacci(long n) {
        if (0 >= n) return 0;
        long fn = 1, fn1 = fn, fn2 = 0;
        for (int i = 2; i <= n; i++) {
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
            log.info("F({}) = {}", i, fn);
        }
        return fn;
    }
}
