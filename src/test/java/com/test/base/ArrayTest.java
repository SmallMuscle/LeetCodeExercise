package com.test.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class ArrayTest {

    @Test
    public void sortTest() {
        int[][] arrs = new int[][] {{3, 2, 1}, {1, 2}, {}, {2, 1}, {2, 3}};
        int[][] result = new int[][] {{3, 2, 1}, {1, 2}, {}, {2, 1}, {2, 3}};
        Arrays.sort(result, (a1, a2) -> {
            if (a1 == a2) return 0;
            if (null == a1) return -1;
            if (null == a2) return 1;
            Arrays.sort(a1);
            Arrays.sort(a2);
            int minLen = Math.min(a1.length, a2.length);
            for (int i = 0; i < minLen; i++) {
                if (a1[i] > a2[i]) return 1;
                else if (a1[i] < a2[i]) return -1;
            }
            return a1.length - a2.length;
        });
        log.info("origin: {}\tresult: {}", arrs, result);
    }
}
