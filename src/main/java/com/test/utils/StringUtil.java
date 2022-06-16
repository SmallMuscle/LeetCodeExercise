package com.test.utils;

public class StringUtil {

    public static boolean equals(String str1, String str2) {
        return null == str1 ? str1 == str2 : str1.equals(str2);
    }

    public static boolean isEmpty(String str) {
        return null == str || 0 == str.length();
    }

}
