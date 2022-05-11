package com.test.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class StringTest {

    @Test
    public void codePointTest() {
        String str = "我是开发者，破晓，靇";
        execCodePointTest(str);

    }

    private void execCodePointTest(String str) {
        if (null != str) {
            System.out.println("length: " + str.length());
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i) + " ");
            }
            System.out.println();
            System.out.println("codePointCount: " + str.codePoints().count());
            str.codePoints().forEach(c -> System.out.print(c + " "));
            System.out.println();
            for (int i = 0; i < str.codePoints().count(); i++) {
                System.out.print(str.codePointAt(i) + " ");
            }
            System.out.println();

        }
    }
}
