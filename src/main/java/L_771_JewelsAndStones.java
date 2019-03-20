import java.util.HashSet;

public class L_771_JewelsAndStones {

    public static void main(String[] args) {
        L_771_JewelsAndStones l = new L_771_JewelsAndStones();
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(l.numJewelsInStones_Array(J, S));
    }


    public int numJewelsInStones_Array(String J, String S) {
        if (null != J && null != S && J.length() > 0 && S.length() > 0) {
            int[] dic = new int[256];
            char[] j = J.toCharArray();
            int num = 0;
            for (int i = 0; i < j.length; ++i) {
                dic[j[i]] = 1;
            }
            char[] s = S.toCharArray();
            for (int m = 0; m < s.length; ++m) {
                num += dic[s[m]];
            }
            return num;
        }
        return 0;
    }

    public int numJewelsInStones_forloop(String J, String S) {
        if (null != J && null != S && J.length() > 0 && S.length() > 0) {
            char[] j = J.toCharArray();
            char[] s = S.toCharArray();
            int num = 0;
            for (int i = 0; i < j.length; ++i) {
                for (int m = 0; m < s.length; ++m) {
                    if (j[i] == s[m]) {
                        ++num;
                    }
                }
            }
            return num;
        }
        return 0;
    }
}
