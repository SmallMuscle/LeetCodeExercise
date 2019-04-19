package NumSequence;

public class L_557_ReverseWordsInAStringIII {

    /*
        2019.04.19

        Given a string, you need to reverse the order of characters
        in each word within a sentence while still preserving
        whitespace and initial word order.

        Example 1:
            Input: "Let's take LeetCode contest"
            Output: "s'teL ekat edoCteeL tsetnoc"
            Note: In the string, each word is separated by single space
            and there will not be any extra space in the string.

     */

    public static void main(String[] args) {
        L_557_ReverseWordsInAStringIII l = new L_557_ReverseWordsInAStringIII();
        String str = "Let's take LeetCode contest";
        System.out.println(l.reverseWords(str));
    }

    public String reverseWords(String s) {
        return reverseWords1(s);
    }


    // inspired by Discuss
    // 逻辑 与 1 相同，但写法精炼
    public String reverseWords2(String s) {
        if (null != s) {
            char[] chs = s.toCharArray();
            int firstIndex = 0;
            int secIndex = 0;
            for (; secIndex < chs.length; ++secIndex) {
                if (' ' == chs[secIndex]) {
                    reverseWordByIndex(chs, firstIndex, secIndex - 1);
                    firstIndex = secIndex + 1;
                }
            }
            reverseWordByIndex(chs, firstIndex, secIndex - 1);
            return new String(chs);
        }
        return s;
    }

    public String reverseWords1(String s) {
        if (null != s) {
            char[] chs = s.toCharArray();
            int firstIndex = -1;
            int secIndex = -1;
            for (int i = 0; i < chs.length; ++i) {
                if (' ' == chs[i]) {
                    firstIndex = secIndex + 1;
                    secIndex = i;
                    reverseWordByIndex(chs, firstIndex, secIndex - 1);
                }
            }
            reverseWordByIndex(chs, secIndex + 1, chs.length - 1);
            return new String(chs);
        }
        return s;
    }

    private void reverseWordByIndex(char[] s, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            ++start;
            -- end;
        }
    }
}
