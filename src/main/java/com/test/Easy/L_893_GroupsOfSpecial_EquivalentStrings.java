package com.test.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L_893_GroupsOfSpecial_EquivalentStrings {

    /*
        2019.04.27

        You are given an array A of strings.

        Two strings S and T are special-equivalent if after any number
        of moves, S == T.

        A move consists of choosing two indices i and j with i % 2 ==
        j % 2, and swapping S[i] with S[j].

        Now, a group of special-equivalent strings from A is a non-empty
        subset S of A such that any string not in S is not special-equivalent
        with any string in S.

        Return the number of groups of special-equivalent strings from A.

        Example 1:
            Input: ["a","b","c","a","c","c"]
            Output: 3
            Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
        Example 2:
            Input: ["aa","bb","ab","ba"]
            Output: 4
            Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
        Example 3:
            Input: ["abc","acb","bac","bca","cab","cba"]
            Output: 3
            Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
        Example 4:
            Input: ["abcd","cdab","adcb","cbad"]
            Output: 1
            Explanation: 1 group ["abcd","cdab","adcb","cbad"]

        Note:
            1 <= A.length <= 1000
            1 <= A[i].length <= 20
            All A[i] have the same length.
            All A[i] consist of only lowercase letters.

     */

    public static void main(String[] args) {
        L_893_GroupsOfSpecial_EquivalentStrings l = new L_893_GroupsOfSpecial_EquivalentStrings();
        String[] A1 = {"a","b","c","a","c","c"};
        System.out.println(l.numSpecialEquivGroups(A1));
        String[] A2 = {"aa","bb","ab","ba"};
        System.out.println(l.numSpecialEquivGroups(A2));
        String[] A3 = {"abc","acb","bac","bca","cab","cba"};
        System.out.println(l.numSpecialEquivGroups(A3));
        String[] A4 = {"abcd","cdab","adcb","cbad"};
        System.out.println(l.numSpecialEquivGroups(A4));
    }

    public int numSpecialEquivGroups(String[] A) {
        return numSpecialEquivGroups4(A);
    }

    // inspired by Discuss
    // 4 ms
    public int numSpecialEquivGroups5(String[] A) {
        Set<String> set = new HashSet();
        for (String str : A) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < str.length(); i += 2) {
                chs[i] += 26;
            }
            Arrays.sort(chs);
            set.add(Arrays.toString(chs));
        }
        return set.size();
    }

    // inspired by Discuss
    // 6 ms
    public int numSpecialEquivGroups4(String[] A) {
        Set<String> set = new HashSet();
        for (String str : A) {
            int[] ints = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ints[i] = str.charAt(i);
            }
            for (int i = 0; i < str.length(); i += 2) {
                ints[i] += 26;
            }
            Arrays.sort(ints);
            set.add(Arrays.toString(ints));
        }
        return set.size();
    }

    // inspired by Solution
    // map the each letter of string in an array at corresponding position
    // the number of different array is the answer
    // 11 ms
    public int numSpecialEquivGroups3(String[] A) {
        Set<String> set = new HashSet();
        for (String str : A) {
            int[] maps = new int[52];
            for (int i = 0; i < str.length(); i++) {
                ++maps[str.charAt(i) - 'a' + 26 * (i & 1)];
            }
            set.add(Arrays.toString(maps));
        }
        return set.size();
    }

    // time out = =
    // put the first string in a map
    // then change the position of each letter in other string by that rule
    // if the map contains any kind of string , solve the next
    // otherwise put that string in this map
    // return the size of map is the answer
    // the change position method is similar to the recursively full permutation
    public int numSpecialEquivGroups1(String[] A) {
        Set<String> set = new HashSet();
        set.add(A[0]);
        for (int i = 1; i < A.length; ++i) {
            String str = A[i];
            if (2 >= str.length()) {
                set.add(str);
            } else {
                if (!set.contains(str)) {
                    StringBuilder strb = new StringBuilder(str);
                    StringBuilder flag = new StringBuilder("1");
                    changePosition(strb, 0, strb.length(), flag, set);
                    if ("1".equals(flag.toString())) set.add(A[i]);
                }
            }
        }
        return set.size();
    }

    // time out = =
    public int numSpecialEquivGroups2(String[] A) {
        Set<String> set = new HashSet();
        for (int i = 0; i < A.length; ++i) {
            StringBuilder strb = new StringBuilder(A[i]);
            StringBuilder flag = new StringBuilder("1");
            changePosition(strb, 0, strb.length(), flag, set);
            if ("1".equals(flag.toString())) set.add(A[i]);
        }
        return set.size();
    }

    public static void changePosition(StringBuilder strb, int start, int cur, StringBuilder flag, Set<String> set) {
        if (start == cur) {
            if (set.contains(strb.toString())) {
                flag.setCharAt(0, '0');
            }
        } else {
            for (int i = start; "1".equals(flag.toString()) && i < cur; i += 2) {
                char tmp = strb.charAt(start);
                strb.setCharAt(start, strb.charAt(i));
                strb.setCharAt(i, tmp);
                changePosition(strb, start + 1, cur, flag, set);
                strb.setCharAt(i, strb.charAt(start));
                strb.setCharAt(start, tmp);
            }
        }
    }
}
