package NumSequence;

public class L_696_CountBinarySubstrings {

    /*
        Give a string s, count the number of non-empty (contiguous)
        substrings that have the same number of 0's and 1's, and all
        the 0's and all the 1's in these substrings are grouped
        consecutively.

        Substrings that occur multiple times are counted the number
        of times they occur.

        Example 1:
            Input: "00110011"
            Output: 6
            Explanation: There are 6 substrings that have equal number
            of consecutive 1's and 0's: "0011", "01", "1100", "10",
            "0011", and "01".

            Notice that some of these substrings repeat and are counted
            the number of times they occur.

            Also, "00110011" is not a valid substring because all the 0's
            (and 1's) are not grouped together.
        Example 2:
            Input: "10101"
            Output: 4
            Explanation: There are 4 substrings: "10", "01", "10", "01" that
            have equal number of consecutive 1's and 0's.
        Note:
            s.length will be between 1 and 50,000.
            s will only consist of "0" or "1" characters.

     */

    public static void main(String[] args) {
        L_696_CountBinarySubstrings l = new L_696_CountBinarySubstrings();
        String s = "00110011";
        System.out.println(l.countBinarySubstrings(s));
        s = "10101";
        System.out.println(l.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        return countBinarySubstrings2(s);
    }

    public int countBinarySubstrings1(String s) {
        if (s.length() == 1) return 0;
        int result = 0;
        int[] index = new int[s.length()];
        int num = 1;
        int section = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) ++num;
            else {
                index[section++] = num;
                num = 1;
            }
        }
        index[section++] = num;
        for (int i = 1; i < section; i++) {
            result += index[i] > index[i - 1] ? index[i - 1] : index[i];
        }
        return result;
    }

    public int countBinarySubstrings2(String s) {
        int result = 0;
        int num1 = 1;
        int num2 = 1;
        boolean flag = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) ++num1;
            else {
                if (flag) result += num1 > num2 ? num2 : num1;
                num2 = num1;
                num1 = 1;
                if (!flag) flag = true;
            }
        }
        return flag ? result + (num1 > num2 ? num2 : num1) : 0;
    }


}
