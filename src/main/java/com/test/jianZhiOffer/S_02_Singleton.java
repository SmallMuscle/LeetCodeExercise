package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_02_Singleton {

    private S_02_Singleton() {}

    public static S_02_Singleton getInstance() {
        return InnerClass.instance;
    }

    static class InnerClass {

        private InnerClass() {}

        static {
            log.info("load class");
        }

        private static final S_02_Singleton instance = new S_02_Singleton();
    }
}
