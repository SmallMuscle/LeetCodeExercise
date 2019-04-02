package NumSequence;

import utils.PrintUtil;

public class L_942_DIStringMatch {

    /*
        2019.03.26

        Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

        Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

        If S[i] == "I", then A[i] < A[i+1]
        If S[i] == "D", then A[i] > A[i+1]

        Example 1:
            Input: "IDID"
            Output: [0,4,1,3,2]
                     0,1,2,3,4
                     0,4,1,2,3
                     0,4,1,3,2
        Example 2:
            Input: "III"
            Output: [0,1,2,3]
                     0,1,2,3
        Example 3:
            Input: "DDI"
            Output: [3,2,0,1]
                     0,1,2,3

        Note:
            1 <= S.length <= 10000
            S only contains characters "I" or "D".
     */

    public static void main(String[] args) {
        L_942_DIStringMatch l = new L_942_DIStringMatch();
        String str = "IDID";
        PrintUtil.printArray(l.diStringMatch(str));
        str = "III";
        PrintUtil.printArray(l.diStringMatch(str));
        str = "DDI";
        PrintUtil.printArray(l.diStringMatch(str));
    }


    public int[] diStringMatch(String S) {
        return diStringMatch1(S);
    }

    public int[] diStringMatch1(String S) {
        int[] ints = null;
        if (null != S && S.length() > 0) {
             ints = new int[S.length() + 1];
             int max = S.length();
             int min = 0;
             int index = 0;
            for (; index < S.length(); index++) {
                if (S.charAt(index) == 'D') {
                    ints[index] = max--;
                } else {
                    ints[index] = min++;
                }
            }
            ints[index] = min;
        }
        return ints;
    }


}
