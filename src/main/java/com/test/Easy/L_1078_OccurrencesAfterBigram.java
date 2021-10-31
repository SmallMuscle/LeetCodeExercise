package com.test.Easy;

import com.test.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class L_1078_OccurrencesAfterBigram {

    /*
        Given words first and second, consider occurrences in some text
        of the form "first second third", where second comes immediately
        after first, and third comes immediately after second.

        For each such occurrence, add "third" to the answer, and return
        the answer.

        Example 1:
            Input: text = "alice is a good girl she is a good student",
            first = "a", second = "good"
            Output: ["girl","student"]
        Example 2:
            Input: text = "we will we will rock you", first = "we",
            second = "will"
            Output: ["we","rock"]

        Note:
            1 <= text.length <= 1000
            text consists of space separated words, where each word consists
            of lowercase English letters.
            1 <= first.length, second.length <= 10
            first and second consist of lowercase English letters.

     */

    public static void main(String[] args) {
        L_1078_OccurrencesAfterBigram l = new L_1078_OccurrencesAfterBigram();
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        PrintUtil.printArray(l.findOcurrences(text, first, second));
        text = "we will we will rock you";
        first = "we";
        second = "will";
        PrintUtil.printArray(l.findOcurrences(text, first, second));
    }

    public String[] findOcurrences(String text, String first, String second) {
        return findOcurrences1(text, first, second);
    }

    public String[] findOcurrences1(String text, String first, String second) {
        List<Integer> list = new ArrayList<>();
        String[] strs = text.split(" ");
        for (int i = 0; i < strs.length - 2; i++) {
            if (strs[i].equals(first) && strs[i + 1].equals(second)) list.add(i);
        }
        String[] result = new String[list.size()];
        int index;
        for (int i = 0; i < list.size(); i++) {
            index = list.get(i) + 2;
            if (index < strs.length) result[i] = strs[index];
        }
        return result;
    }

}
