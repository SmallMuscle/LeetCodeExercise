package DifficultSequence.Easy;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_784_LetterCasePermutation {

    /*
        Given a string S, we can transform every letter individually to be
        lowercase or uppercase to create another string.  Return a list of
        all possible strings we could create.

        Examples:
        Input: S = "a1b2"
        Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

        Input: S = "3z4"
        Output: ["3z4", "3Z4"]

        Input: S = "12345"
        Output: ["12345"]
        Note:

        S will be a string with length between 1 and 12.
        S will consist only of letters or digits.

     */

    public static void main(String[] args) {
        L_784_LetterCasePermutation l = new L_784_LetterCasePermutation();
        String str = "a1b2";
        PrintUtil.printList(l.letterCasePermutation(str));
        str = "3z4";
        PrintUtil.printList(l.letterCasePermutation(str));
        str = "12345";
        PrintUtil.printList(l.letterCasePermutation(str));
        str = "0";
        PrintUtil.printList(l.letterCasePermutation(str));
        str = "c";
        PrintUtil.printList(l.letterCasePermutation(str));
        str = "abc";
        PrintUtil.printList(l.letterCasePermutation(str));
    }

    public List<String> letterCasePermutation(String S) {
        return letterCasePermutation3(S);
    }


    public List<String> letterCasePermutation3(String S) {
        List<String> result = new ArrayList<>();
        letterCasePermutationRecursive4(new StringBuilder(S), 0, S.length(), result);
        return result;
    }

    public void letterCasePermutationRecursive4(StringBuilder str, int start, int end, List<String> list) {
        if (start == end) {
            list.add(str.toString());
        } else {
            while (start != end && ! notDigit(str.charAt(start))) ++start;
            if (start == end) {
                list.add(str.toString());
                return ;
            }
            letterCasePermutationRecursive4(str, start + 1, end, list);
            str.setCharAt(start, transferLetter(str.charAt(start)));
            letterCasePermutationRecursive4(str, start + 1, end, list);
        }
    }

    // inspired by Discuss
    public void letterCasePermutationRecursive3(StringBuilder str, int start, int end, List<String> list) {
        if (start == end) {
            list.add(str.toString());
        } else {
            if (notDigit(str.charAt(start))) {
                letterCasePermutationRecursive3(str, start + 1, end, list);
                str.setCharAt(start, transferLetter(str.charAt(start)));
                letterCasePermutationRecursive3(str, start + 1, end, list);
            } else letterCasePermutationRecursive3(str, start + 1, end, list);
        }
    }

    public void letterCasePermutationRecursive2(StringBuilder str, int start, int end, Set<String> set) {
        for (int i = start; i < end; i++) {
            if (notDigit(str.charAt(i))) {
                set.add(str.toString());
                str.setCharAt(i, transferLetter(str.charAt(i)));
                set.add(str.toString());
                letterCasePermutationRecursive2(str, i + 1, end, set);
                str.setCharAt(i, transferLetter(str.charAt(i)));
            }
            //System.out.println(str.toString());
        }
    }

    public List<String> letterCasePermutation2(String S) {
        List<String> result = new ArrayList<>();
        int start = 0;
        while (start < S.length() && ! notDigit(S.charAt(start))) ++start;
        if (start != S.length())
            letterCasePermutationRecursive1(new StringBuilder(S), start, S.length(), result, new HashSet<String>());
        else result.add(S);
        return result;
    }

    public List<String> letterCasePermutation1(String S) {
        List<String> result = new ArrayList<>();
        letterCasePermutationRecursive1(new StringBuilder(S), 0, S.length(), result, new HashSet<String>());
        return result;
    }

    public void letterCasePermutationRecursive1(StringBuilder str, int start, int end, List<String> list, Set<String> set) {
        if (start == end) {
            System.out.println(str.toString());
            //if (! set.contains(str.toString())) list.add(str.toString());
            //set.add(str.toString());
        } else {
            for (int i = start; i < end; i++) {
                if (notDigit(str.charAt(i))) {
                    //System.out.println(str.toString());
                    letterCasePermutationRecursive1(str, i + 1, end, list, set);
                    str.setCharAt(i, transferLetter(str.charAt(i)));
                    letterCasePermutationRecursive1(str, i + 1, end, list, set);
                    str.setCharAt(i, transferLetter(str.charAt(i)));
                } else letterCasePermutationRecursive1(str, i + 1, end, list, set);
            }
        }
    }

    private boolean notDigit(char c) {
        return c < '0' || c > '9';
    }

    private static final int interval = 'a' - 'A';

    private char transferLetter(char c) {
        return (char) (c >= 'a' && c <= 'z' ? c - interval : c + interval);
    }

}
