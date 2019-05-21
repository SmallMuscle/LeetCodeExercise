package DifficultSequence.Easy;

public class L_1047_RemoveAllAdjacentDuplicatesInString {

    /*
        Given a string S of lowercase letters, a duplicate removal consists
        of choosing two adjacent and equal letters, and removing them.

        We repeatedly make duplicate removals on S until we no longer can.

        Return the final string after all such duplicate removals have been
        made.  It is guaranteed the answer is unique.

        Example 1:
            Input: "abbaca"
            Output: "ca"
        Explanation:
            For example, in "abbaca" we could remove "bb" since the letters are
            adjacent and equal, and this is the only possible move.  The result
            of this move is that the string is "aaca", of which only "aa" is
            possible, so the final string is "ca".

        Note:
        1 <= S.length <= 20000
        S consists only of English lowercase letters.

     */

    public static void main(String[] args) {
        L_1047_RemoveAllAdjacentDuplicatesInString l = new L_1047_RemoveAllAdjacentDuplicatesInString();
        String str = "abbaca";
        System.out.println(l.removeDuplicates(str));
    }

    public String removeDuplicates(String S) {
        return removeDuplicates1(S);
    }

    public String removeDuplicates1(String S) {
        if (null != S && 0 < S.length()) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                if (0 != result.length() && result.charAt(result.length() - 1) == S.charAt(i)) {
                    result.deleteCharAt(result.length() - 1);
                } else {
                    result.append(S.charAt(i));
                }
            }
            return result.toString();
        }
        return S;
    }


}
