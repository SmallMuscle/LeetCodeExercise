package com.test.jianZhiOffer;

import java.util.*;

public class S_33_PrintMinNumber {

    public String printMinNumber(int[] nums) {
        if (null == nums || 0 == nums.length) return "";
        StringBuilder buffer = new StringBuilder();
        List<String> list = new ArrayList<>(nums.length);
        Arrays.stream(nums).forEach(n -> list.add(String.valueOf(n)));
        Collections.sort(list, (s1,s2) -> {
            int sumLen = s1.length() + s2.length();
            char[] ch1 = new char[sumLen];
            char[] ch2 = new char[sumLen];
            System.arraycopy(s1.toCharArray(), 0, ch1, 0, s1.length());
            System.arraycopy(s2.toCharArray(), 0, ch1, s1.length(), s2.length());
            System.arraycopy(s2.toCharArray(), 0, ch2, 0, s2.length());
            System.arraycopy(s1.toCharArray(), 0, ch2, s2.length(), s1.length());
            for (int i = 0; i < sumLen; i++) {
                if (ch1[i] < ch2[i]) return -1;
                else if (ch1[i] > ch2[i]) return 1;
            }
            return 0;
        });
        list.forEach(buffer::append);
        return buffer.toString();
    }

}
