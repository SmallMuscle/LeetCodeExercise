package com.test.jianZhiOffer;

import java.util.*;

public class S_34_UglyNumber {

    public int uglyNumber(int num) {
        if (1 > num) return -1;
        int[] uglyArray = new int[num];
        uglyArray[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int index = 0;
        while (++index < num) {
            uglyArray[index] = Math.min(uglyArray[index2] * 2, Math.min(uglyArray[index3] * 3, uglyArray[index5] * 5));
            while (uglyArray[index2] * 2 <= uglyArray[index]) ++index2;
            while (uglyArray[index3] * 3 <= uglyArray[index]) ++index3;
            while (uglyArray[index5] * 5 <= uglyArray[index]) ++index5;
        }
        return uglyArray[num - 1];
    }

}
