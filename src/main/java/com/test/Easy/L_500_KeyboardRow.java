package com.test.Easy;

import com.test.utils.PrintUtil;

public class L_500_KeyboardRow {

    /*
        Given a ListNode of words, return the words that can be typed using
        letters of alphabet on only one row's of American keyboard like
        the image below.
            com.test.images/Example_L_500_KeyboardRow.png

        Example:
            Input: ["Hello", "Alaska", "Dad", "Peace"]
            Output: ["Alaska", "Dad"]

        Note:
            You may use one character in the keyboard more than once.
            You may assume the input string will only contain letters of alphabet.
     */

    public static void main(String[] args) {
        L_500_KeyboardRow l = new L_500_KeyboardRow();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        PrintUtil.printArray(l.findWords(words));
    }

    public String[] findWords(String[] words) {
        return findWords1(words);
    }

    // directionary                       a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
    static final int[] first = new int[] {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0};
    static final int[] second = new int[]{1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
    static final int[] third = new int[] {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1};

    public String[] findWords1(String[] words) {
        String[] record = new String[words.length];
        int num = 0;
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            String str = tmp.toLowerCase();
            boolean flag = true;
            int index = str.charAt(0) - 'a';
            if (1 == first[index]) {
                for (int j = 0; flag && j < str.length(); j++) {
                    if (0 == first[str.charAt(j) - 'a']) flag = false;
                }
            } else if (1 == second[index]) {
                for (int j = 0; flag && j < str.length(); j++) {
                    if (0 == second[str.charAt(j) - 'a']) flag = false;
                }
            } else if (1 == third[index]) {
                for (int j = 0; flag && j < str.length(); j++) {
                    if (0 == third[str.charAt(j) - 'a']) flag = false;
                }
            } else flag = false;

            if (flag) record[num++] = tmp;
        }

        String[] result = new String[num];
        for (int i = 0; i < num; i++) {
            result[i] = record[i];
        }
        return result;
    }


}
