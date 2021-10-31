package com.test.Easy;

import java.util.Deque;
import java.util.LinkedList;

public class L_1021_RemoveOutermostParentheses {

    /*
        2019.03.30

        A valid parentheses string is either empty (""), "(" + A + ")",
        or A + B, where A and B are valid parentheses strings, and +
        represents string concatenation.  For example, "", "()", "(())()",
        and "(()(()))" are all valid parentheses strings.

        A valid parentheses string S is primitive if it is nonempty, and
        there does not exist a way to split it into S = A+B, with A and B
        nonempty valid parentheses strings.

        Given a valid parentheses string S, consider its primitive
        decomposition: S = P_1 + P_2 + ... + P_k, where P_i are
        primitive valid parentheses strings.

        Return S after removing the outermost parentheses of every
        primitive string in the primitive decomposition of S.



        Example 1:
            Input: "(()())(())"
            Output: "()()()"
            Explanation:
                The input string is "(()())(())", with primitive
                decomposition "(()())" + "(())".
                After removing outer parentheses of each part,
                this is "()()" + "()" = "()()()".
        Example 2:
            Input: "(()())(())(()(()))"
            Output: "()()()()(())"
            Explanation:
                The input string is "(()())(())(()(()))", with
                primitive decomposition "(()())" + "(())" + "(()(()))".
                After removing outer parentheses of each part,
                this is "()()" + "()" + "()(())" = "()()()()(())".
        Example 3:
            Input: "()()"
            Output: ""
            Explanation:
                The input string is "()()", with primitive
                decomposition "()" + "()".
                After removing outer parentheses of each part,
                this is "" + "" = "".

        Note:
            S.length <= 10000
            S[i] is "(" or ")"
            S is a valid parentheses string
     */

    public static void main(String[] args) {
        L_1021_RemoveOutermostParentheses l = new L_1021_RemoveOutermostParentheses();
        String str = "(()())(())";
        System.out.println(l.removeOuterParentheses(str));
        str = "(()())(())(()(()))";
        System.out.println(l.removeOuterParentheses(str));
        str = "()()";
        System.out.println(l.removeOuterParentheses(str));
    }

    public String removeOuterParentheses(String S) {
        return removeOuterParentheses3(S);
    }

    // inspired by Discuss
    public String removeOuterParentheses3(String S) {
        if (null != S && 0 < S.length()) {
            StringBuilder result = new StringBuilder();
            int num = 0;
            for (int i = 0; i < S.length(); ++i) {
                if ('(' == S.charAt(i) && num++ > 0 || ')' == S.charAt(i) && num-- > 1) result.append(S.charAt(i));
            }
            return result.toString();
        } else {
            return S;
        }
    }

    // inspired by Discuss
    public String removeOuterParentheses2(String S) {
        if (null != S && 0 < S.length()) {
            StringBuilder result = new StringBuilder();
            int num = 0;
            for (int i = 0; i < S.length(); ++i) {
                if ('(' == S.charAt(i)) {
                    ++num;
                    if (num == 1) continue;
                } else if (')' == S.charAt(i)) {
                    --num;
                    if (num == 0) continue;
                }
                result.append(S.charAt(i));
            }
            return result.toString();
        } else {
            return S;
        }
    }

    public String removeOuterParentheses1(String S) {
        if (null != S && 0 < S.length()) {
            Deque<Character> deque = new LinkedList<Character>();
            StringBuilder result = new StringBuilder();
            int num = 0;
            for (int i = 0; i < S.length(); ++i) {
                deque.add(S.charAt(i));
                if ('(' == S.charAt(i)) ++num;
                if (')' == S.charAt(i)) --num;
                if (0 == num && !deque.isEmpty()) {
                    deque.pollLast();
                    deque.pollFirst();
                    while (!deque.isEmpty()) result.append(deque.pollFirst());
                    deque.clear();
                }
            }
            return result.toString();
        } else {
            return S;
        }
    }
}
