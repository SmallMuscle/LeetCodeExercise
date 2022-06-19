package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_29_MoreThanHalfInArray {

    public int moreThanHalfInArray(int[] arrs) {
        if (null == arrs || 0 == arrs.length) return 0;
        int result = arrs[0];
        int count = 1;
        for (int i = 1; i < arrs.length; i++) {
            if (0 == count) {
                result = arrs[i];
                ++count;
            }
            else {
                if (result == arrs[i]) ++count;
                else --count;
            }
        }
        return (0 != count && isRealResult(arrs, result)) ? result : 0;
    }

    private boolean isRealResult(int[] arrs, int result) {
        int count = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] == result) ++count;
        }
        return count > arrs.length >> 1;
    }

}
