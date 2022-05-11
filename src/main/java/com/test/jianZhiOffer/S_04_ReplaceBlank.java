package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_04_ReplaceBlank {

    /**
     * Question: 请实现一个函数，把字符串中的每个空格替换成"%20"。
     *
     * Example:
     * Input: We are happy.
     * Output: We%20are%20happy.
     */

    public void replaceBlankBySymbol(Character[] chs) {
        if (null == chs || 0 == chs.length) return ;
        int nonBlandNum = 0;
        int blankNum = 0;
        for (int i = 0; i < chs.length && null != chs[i]; i++) {
            if (' ' == chs[i]) ++blankNum;
            else ++nonBlandNum;
        }
        int newLength = nonBlandNum + blankNum * 3;
        if (newLength > chs.length) {
            log.warn("char array space not enough, need {} but only {}", newLength, chs.length);
            return ;
        }
        for (int newIndex = newLength - 1, oldIndex = nonBlandNum + blankNum - 1;
                newIndex != oldIndex;) {
            char ch = chs[oldIndex--];
            if (' ' == ch) {
                chs[newIndex--] = '0';
                chs[newIndex--] = '2';
                chs[newIndex--] = '%';
            } else {
                chs[newIndex--] = ch;
            }
        }
    }
}
