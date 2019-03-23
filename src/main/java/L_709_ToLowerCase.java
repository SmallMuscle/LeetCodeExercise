public class L_709_ToLowerCase {

    /*
        2019.03.20

        Implement function ToLowerCase() that has a string parameter str,
        and returns the same string in lowercase.

        Example 1:
            Input: "Hello"
            Output: "hello"
        Example 2:
            Input: "here"
            Output: "here"
        Example 3:
            Input: "LOVELY"
            Output: "lovely"

    */

    public static void main(String[] args) {
        L_709_ToLowerCase l = new L_709_ToLowerCase();
        String str = "fsdSFSDF";
        char[] chs = str.toCharArray();
        System.out.println(String.valueOf(chs));
        System.out.println(l.toLowerCase(str));
    }

    public String toLowerCase(String str) {
        if (null != str && str.length() > 0) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; ++i) {
                if (chs[i] >= 'A' && chs[i] <= 'Z') {
                    chs[i] = (char)(chs[i] + 'a' - 'A');
                }
            }
            return new String(chs);
        }
        return str;
    }
}
