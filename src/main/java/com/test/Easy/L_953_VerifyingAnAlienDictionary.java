package com.test.Easy;

import java.util.HashMap;
import java.util.Map;

public class L_953_VerifyingAnAlienDictionary {

    /*
        In an alien language, surprisingly they also use english lowercase
        letters, but possibly in a different order. The order of the alphabet
        is some permutation of lowercase letters.

        Given a sequence of words written in the alien language, and the order
        of the alphabet, return true if and only if the given words are sorted
        lexicographicaly in this alien language.

        Example 1:
            Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
            Output: true
            Explanation: As 'h' comes before 'l' in this language, then the sequence
            is sorted.
        Example 2:
            Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
            Output: false
            Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1],
            hence the sequence is unsorted.
        Example 3:
            Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
            Output: false
            Explanation: The first three characters "app" match, and the second string is
            shorter (in size.) According to lexicographical rules "apple" > "app", because
            'l' > '∅', where '∅' is defined as the blank character which is less than any
            other character (More info).

        Note:
            1 <= words.length <= 100
            1 <= words[i].length <= 20
            order.length == 26
            All characters in words[i] and order are english lowercase letters.

     */

    public static void main(String[] args) {
        L_953_VerifyingAnAlienDictionary l = new L_953_VerifyingAnAlienDictionary();
        String[] words1 = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(l.isAlienSorted(words1, order));
        String[] words2 = {"word","world","row"};
        order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(l.isAlienSorted(words2, order));
        String[] words3 = {"apple","app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(l.isAlienSorted(words3, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        return isAlienSorted2(words, order);
    }

    public boolean isAlienSorted2(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare2(words[i], words[i + 1], index)) return false;
        }
        return true;
    }

    private boolean compare2(String word1, String word2, int[] index) {
        int minLen = word1.length() > word2.length() ? word2.length() : word1.length();
        for (int i = 0; i < minLen; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return index[word1.charAt(i) - 'a'] > index[word2.charAt(i) - 'a'];
            }
        }
        return word1.length() > word2.length();
    }

    public boolean isAlienSorted1(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare1(words[i], words[i + 1], map)) return false;
        }
        return true;
    }

    private boolean compare1(String word1, String word2, Map<Character, Integer> map) {
        int minLen = word1.length() > word2.length() ? word2.length() : word1.length();
        for (int i = 0; i < minLen; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
               return map.get(word1.charAt(i)) > map.get(word2.charAt(i));
            }
        }
        return word1.length() > word2.length();
    }



}
