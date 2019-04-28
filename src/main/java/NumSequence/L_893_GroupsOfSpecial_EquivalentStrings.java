package NumSequence;

import java.util.HashSet;
import java.util.Set;

public class L_893_GroupsOfSpecial_EquivalentStrings {

    /*
        2019.04.25

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
        return numSpecialEquivGroups2(A);
    }

    public int numSpecialEquivGroups3(String[] A) {
        Set<String> set = new HashSet();
        for (int i = 0; i < A.length; ++i) {
            StringBuilder strb = new StringBuilder(A[i]);
            StringBuilder flag = new StringBuilder("1");
            checkEquivalent(strb, 0, strb.length(), flag, set);
            if ("1".equals(flag.toString())) set.add(A[i]);
        }
        return set.size();
    }

    // 超时了= =
    // 第一个字符串放在 map 里，之后的字符串每次变换判断 有没有
    // 有，下一个
    // 没有 放入 map
    // 变换实现，类似递归版全排列
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
                    checkEquivalent(strb, 0, strb.length(), flag, set);
                    if ("1".equals(flag.toString())) set.add(A[i]);
                }
            }
        }
        return set.size();
    }

    // 超时了= =
    public int numSpecialEquivGroups2(String[] A) {
        Set<String> set = new HashSet();
        for (int i = 0; i < A.length; ++i) {
            StringBuilder strb = new StringBuilder(A[i]);
            StringBuilder flag = new StringBuilder("1");
            checkEquivalent(strb, 0, strb.length(), flag, set);
            if ("1".equals(flag.toString())) set.add(A[i]);
        }
        return set.size();
    }

    public static void checkEquivalent(StringBuilder strb, int start, int cur, StringBuilder flag, Set<String> set) {
        if (start == cur) {
            if (set.contains(strb.toString())) {
                flag.setCharAt(0, '0');
            }
        } else {
            for (int i = start; "1".equals(flag.toString()) && i < cur; i += 2) {
                char tmp = strb.charAt(start);
                strb.setCharAt(start, strb.charAt(i));
                strb.setCharAt(i, tmp);
                checkEquivalent(strb, start + 1, cur, flag, set);
                strb.setCharAt(i, strb.charAt(start));
                strb.setCharAt(start, tmp);
            }
        }
    }
}
