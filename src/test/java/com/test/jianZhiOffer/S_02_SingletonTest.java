package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_02_SingletonTest {

    @Test
    public void singletonTest() {
        execTest(S_02_Singleton.getInstance());
        execTest(S_02_Singleton.getInstance());
        execTest(S_02_Singleton.getInstance());
    }

    private void execTest(S_02_Singleton singleton) {
        log.info("instance: {}", singleton);
    }
}
