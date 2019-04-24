package NumSequence;

import utils.PrintUtil;

public class L_821_ShortestDistanceToACharacter {

    /*
        2019.04.24

        Given a string S and a character C, return an array of integers
        representing the shortest distance from the character C in the string.

        Example 1:
            Input: S = "loveleetcode", C = 'e'
            Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

        Note:
            S string length is in [1, 10000].
            C is a single character, and guaranteed to be in string S.
            All letters in S and C are lowercase.

     */

    public static void main(String[] args) {
        L_821_ShortestDistanceToACharacter l = new L_821_ShortestDistanceToACharacter();
        String str1 = "loveleetcode";
        char c1 = 'e';
        PrintUtil.printArray(l.shortestToChar(str1, c1));
    }

    public int[] shortestToChar(String S, char C) {
        return shortestToChar1(S, C);
    }

    // 从左往右扫描，遇到目标 char，回溯重新标号，直到新标号不小于原标号
    public int[] shortestToChar1(String S, char C) {
        int[] result = new int[S.length()];
        // 第一次遇到需要对之前的全部标号
        boolean flag = true;
        int len = 0;
        for (int i = 0; i < S.length(); i++) {
            if (C == S.charAt(i)) {
                len = 0;
                result[i] = len;
                int num = i;
                if (flag) {
                    while (0 < num) result[--num] = ++len;
                    flag = false;
                } else {
                    while (result[--num] > ++len) result[num] = len;
                }
                len = 0;
            } else {
                if (!flag)
                result[i] = ++len;
            }

        }
        return result;
    }
}

