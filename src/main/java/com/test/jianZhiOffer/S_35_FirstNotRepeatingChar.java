package com.test.jianZhiOffer;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public char firstNotRepeatingChar1(char[] chs) {
        char result = '\0';
        if (null != chs && 0 < chs.length) {
            LinkedHashMap<Character, Integer> map =
                    new LinkedHashMap(16, 0.75f, true);
            for (char ch : chs) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (1 == entry.getValue()) {
                    result = entry.getKey();
                    break;
                }
            }
        }
        return result;
    }

}
