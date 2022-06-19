package com.test.dsTest;

import com.test.ds.Pile;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class PileTest {

    @Test
    public void bigPileTest() {
        int len = 100;
        int start = 50;
        int end = start + len;
        Pile<Integer> bigPile = new Pile<>(len, true);
        for (int i = start; i < end; i++) {
            bigPile.add(i);
        }
        log.info("bigPile: {}", bigPile);
    }

}
