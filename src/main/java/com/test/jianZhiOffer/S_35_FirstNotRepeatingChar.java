package com.test.jianZhiOffer;

public class S_35_FirstNotRepeatingChar {

    public char firstNotRepeatingChar(char[] chs) {
        char result = '\0';
        if (null != chs && 0 < chs.length) {
            char[] indexArray = new char[256];
            for (int i = 0; i < chs.length; i++) {
                indexArray[chs[i]]++;
            }
            for (int i = 0; i < chs.length; i++) {
                if (1 == indexArray[chs[i]]) {
                    result = chs[i];
                    break;
                }
            }
        }
        return result;
    }

}
