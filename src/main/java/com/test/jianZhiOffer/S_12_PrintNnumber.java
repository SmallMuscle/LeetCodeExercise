package com.test.jianZhiOffer;

import java.nio.charset.StandardCharsets;

public class S_12_PrintNnumber {

    public void printToMaxOfDigits(int n) {
        if (1 > n) {
            throw new RuntimeException("Invalid input.");
        } else {
            byte[] buffer = new byte[n];
            for (int i = 0; i < n; i++) {
                buffer[i] = 48;
            }
            int nowLen = 1;
            while (n >= (nowLen = increase(buffer, nowLen))) {
                System.out.println(new String(buffer, n - nowLen, nowLen, StandardCharsets.US_ASCII));
            }
        }
    }

    /**
     * increase number.
     * @param number, use an array of length 5 to present 12 as [48, 48, 48, 49, 50] (ascii)
     * @param len, the length of the actual number(must grant than 0),  2 ╍╍╍┛
     * @return length of result
     */
    private int increase(byte[] number, int len) {
        int cursor = number.length;
        while (0 <= --cursor) {
            if (58 > ++number[cursor]) {
                break;
            } else {
                number[cursor] = 48;
                if (len == number.length - cursor) ++len;
            }
        }
        return len;
    }

}
