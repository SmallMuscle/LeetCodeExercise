package NumSequence;

public class L_1071_GreatestCommonDivisorOfStrings {

    /*
        For strings S and T, we say "T divides S" if and only if S = T + ... + T
        (T concatenated with itself 1 or more times)

        Return the largest string X such that X divides str1 and X divides str2.

        Example 1:
            Input: str1 = "ABCABC", str2 = "ABC"
            Output: "ABC"
        Example 2:
            Input: str1 = "ABABAB", str2 = "ABAB"
            Output: "AB"
        Example 3:
            Input: str1 = "LEET", str2 = "CODE"
            Output: ""

        Note:
            1 <= str1.length <= 1000
            1 <= str2.length <= 1000
            str1[i] and str2[i] are English uppercase letters.

     */

    public static void main(String[] args) {
        L_1071_GreatestCommonDivisorOfStrings l = new L_1071_GreatestCommonDivisorOfStrings();
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(l.gcdOfStrings(str1, str2));
        str1 = "ABABAB";
        str2 = "ABAB";
        System.out.println(l.gcdOfStrings(str1, str2));
        str1 = "LEET";
        str2 = "CODE";
        System.out.println(l.gcdOfStrings(str1, str2));
        str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(l.gcdOfStrings(str1, str2));
        str1 = "FFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKST";
        str2 = "FFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKST";
        System.out.println(l.gcdOfStrings(str1, str2));
        str1 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        str2 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        System.out.println(l.gcdOfStrings(str1, str2));
        System.out.println(l.gcdOfStrings(str1, str2).length());
    }

    public String gcdOfStrings(String str1, String str2) {
        return gcdOfStrings3(str1, str2);
    }

    public String gcdOfStrings1(String str1, String str2) {
        if (str1.equals(str2)) return str2;
        int len = str1.length() > str2.length() ? str2.length() : str1.length();
        StringBuilder result = new StringBuilder(str2.substring(0, len));
        for (int windowSize = len; windowSize > 0; --windowSize, result.deleteCharAt(windowSize)) {
            if (0 == (str2.length() % result.length()) && 0 == (str1.length() % result.length())) {
                boolean flag = true;
                outer:
                for (int i = result.length(); i < str2.length(); i += result.length()) {
                    for (int j = 0; j < result.length(); j++) {
                        if (result.charAt(j) != str2.charAt(i + j)) {
                            flag = false;
                            break outer;
                        }
                    }
                }
                if (flag) {
                    String s = getResult(str1, result.toString());
                    if (!"".equals(s)) return s;
                }
            }
        }
        return "";
    }

    public String gcdOfStrings2(String str1, String str2) {
        if (str1.equals(str2)) return str2;
        // find maximum common divisor
        int len;
        if (str1.length() > str2.length()) {
            len = getMaxCommonDivisor(str1.length(), str2.length());
        } else {
            len = getMaxCommonDivisor(str2.length(), str1.length());
        }
        StringBuilder result = new StringBuilder(str2.substring(0, len));
        for (int windowSize = len; windowSize > 0; --windowSize, result.deleteCharAt(windowSize)) {
            if (0 == (str2.length() % result.length()) && 0 == (str1.length() % result.length())) {
                boolean flag = true;
                outer:
                for (int i = result.length(); i < str2.length(); i += result.length()) {
                    for (int j = 0; j < result.length(); j++) {
                        if (result.charAt(j) != str2.charAt(i + j)) {
                            flag = false;
                            break outer;
                        }
                    }
                }
                if (flag) {
                    String s = getResult(str1, result.toString());
                    if (!"".equals(s)) return s;
                }
            }
        }
        return "";
    }

    // inspired by Discuss
    // test data looks so weak ...
    public String gcdOfStrings3(String str1, String str2) {
        int num = getMaxCommonDivisor(str1.length(), str2.length());
        return str1.substring(0, num).equals(str2.substring(0, num)) ? str1.substring(0, num) : "";
    }

    private String getResult(String str, String result) {
        if ((str.length() % result.length()) != 0) return "";
        for (int i = 0; i < str.length(); i += result.length()) {
            for (int j = 0; j < result.length(); j++) {
                if (str.charAt(i + j) != result.charAt(j)) return "";
            }
        }
        return result;
    }

    private int getMaxCommonDivisor(int max, int min) {
        return min == 0 ? max : getMaxCommonDivisor(min, max % min);
    }

}
