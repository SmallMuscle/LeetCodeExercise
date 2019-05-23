package DifficultSequence.Easy;

public class L_824_GoatLatin {

    /*
        A sentence S is given, composed of words separated by spaces.
        Each word consists of lowercase and uppercase letters only.

        We would like to convert the sentence to "Goat Latin" (a
        made-up language similar to Pig Latin.)

        The rules of Goat Latin are as follows:

        If a word begins with a vowel (a, e, i, o, or u), append
        "ma" to the end of the word.
        For example, the word 'apple' becomes 'applema'.

        If a word begins with a consonant (i.e. not a vowel), remove
        the first letter and append it to the end, then add "ma".
        For example, the word "goat" becomes "oatgma".

        Add one letter 'a' to the end of each word per its word index
        in the sentence, starting with 1.
        For example, the first word gets "a" added to the end, the s
        econd word gets "aa" added to the end and so on.
        Return the final sentence representing the conversion from S
        to Goat Latin.

        Example 1:
            Input: "I speak Goat Latin"
            Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        Example 2:
            Input: "The quick brown fox jumped over the lazy dog"
            Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa
            overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

        Notes:
        S contains only uppercase, lowercase and spaces. Exactly one space
        between each word.
        1 <= S.length <= 150.

     */

    public static void main(String[] args) {
        L_824_GoatLatin l = new L_824_GoatLatin();
        String str = "I speak Goat Latin";
        System.out.println(l.toGoatLatin(str));
        str = "The quick brown fox jumped over the lazy dog";
        System.out.println(l.toGoatLatin(str));
    }

    public String toGoatLatin(String S) {
        return toGoatLatin1(S);
    }


    private static final char[] aeiou = {1, 0, 0 , 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};

    public String toGoatLatin1(String S) {
        // count num of letters in result
        int len = S.length();
        int wordNum = 1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ' ') ++wordNum;
        }
        len += (wordNum * (wordNum + 5)) >> 1;
        // generate result
        char[] result = new char[len];
        char last = '-';
        int resInd = 0;
        wordNum = 0;
        int index = S.charAt(0) - 'a';
        if (index < 0) index = S.charAt(0) - 'A';
        if (aeiou[index] == 0) last = S.charAt(0);
        else result[resInd++] = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == ' ' && ++i < S.length()) {
                ++wordNum;
                if (last != '-') {
                    result[resInd++] = last;
                    last = '-';
                }
                result[resInd++] = 'm';
                result[resInd++] = 'a';
                for (int j = 0; j < wordNum; j++) {
                    result[resInd++] = 'a';
                }
                result[resInd++] = c;
                index = S.charAt(i) - 'a';
                if (index < 0) index = S.charAt(i) - 'A';
                if (aeiou[index] == 1) {
                    result[resInd++] = S.charAt(i);
                } else {
                    last = S.charAt(i);
                }
            } else {
                result[resInd++] = S.charAt(i);
            }
        }
        if (last != '-') {
            result[resInd++] = last;
        }
        result[resInd++] = 'm';
        result[resInd++] = 'a';
        ++wordNum;
        for (int i = 0; i < wordNum; i++) {
            result[resInd++] = 'a';
        }
        return new String(result);
    }


}
