package DifficultSequence.Easy;

public class L_917_ReverseOnlyLetters {

    /*
        Given a string S, return the "reversed" string where all characters
        that are not a letter stay in the same place, and all letters reverse
        their positions.

        Example 1:
        Input: "ab-cd"
        Output: "dc-ba"
        Example 2:
        Input: "a-bC-dEf-ghIj"
        Output: "j-Ih-gfE-dCba"
        Example 3:
        Input: "Test1ng-Leet=code-Q!"
        Output: "Qedo1ct-eeLg=ntse-T!"

        Note:
        S.length <= 100
        33 <= S[i].ASCIIcode <= 122
        S doesn't contain \ or "

     */

    public static void main(String[] args) {
        L_917_ReverseOnlyLetters l = new L_917_ReverseOnlyLetters();
        String str = "ab-cd";
        System.out.println(l.reverseOnlyLetters(str));
        str = "a-bC-dEf-ghIj";
        System.out.println(l.reverseOnlyLetters(str));
        str = "Test1ng-Leet=code-Q!";
        System.out.println(l.reverseOnlyLetters(str));
    }

    public String reverseOnlyLetters(String S) {
        return reverseOnlyLetters1(S);
    }

    public String reverseOnlyLetters1(String S) {
        if (null != S && S.length() > 0) {
            char[] chs = S.toCharArray();
            int start = 0;
            int end = chs.length - 1;
            while (start < end) {
                while (start <= end && ! isLetter(chs[start])) ++start;
                while (start <= end && ! isLetter(chs[end])) --end;
                if (start < end) {
                    char tmp = chs[start];
                    chs[start] = chs[end];
                    chs[end] = tmp;
                }
                ++start;
                --end;
            }
            return new String(chs);
        }
        return S;
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }
}
