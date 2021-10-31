package com.test.Easy;

import com.test.utils.PrintUtil;

public class L_344_ReverseString {

    /*
        2019.04.21
        
        Write a function that reverses a string. The input string is
        given as an array of characters char[].

        Do not allocate extra space for another array, you must do this
        by modifying the input array in-place with O(1) extra memory.

        You may assume all the characters consist of printable ascii characters.

        Example 1:
            Input: ["h","e","l","l","o"]
            Output: ["o","l","l","e","h"]
        Example 2:
            Input: ["H","a","n","n","a","h"]
            Output: ["h","a","n","n","a","H"]

     */

    public static void main(String[] args) {
        L_344_ReverseString l =  new L_344_ReverseString();
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        PrintUtil.printArray(s1);
        l.reverseString(s1);
        PrintUtil.printArray(s1);
        char[] s2 = {'h', 'a', 'n', 'n', 'a', 'h'};
        PrintUtil.printArray(s2);
        l.reverseString(s2);
        PrintUtil.printArray(s2);
    }

    public void reverseString(char[] s) {
        reverseString1(s);
    }

    public void reverseString1(char[] s) {
        for (int i = 0; i < s.length / 2; ++i) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }



}
