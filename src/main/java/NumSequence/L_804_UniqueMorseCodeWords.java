package NumSequence;

import java.util.HashSet;
import java.util.Set;

public class L_804_UniqueMorseCodeWords {

    /*
        2019.03.22

        International Morse Code defines a standard encoding where each letter
        is mapped to a series of dots and dashes, as follows: "a" maps to ".-",
        "b" maps to "-...", "c" maps to "-.-.", and so on.

        For convenience, the full table for the 26 letters of the English
        alphabet is given below:

            [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
            ".--","-..-","-.--","--.."]

        Now, given a list of words, each word can be written as a concatenation
        of the Morse code of each letter. For example, "cba" can be written as
        "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll
        call such a concatenation, the transformation of a word.

        Return the number of different transformations among all words we have.

        Example:
            Input: words = ["gin", "zen", "gig", "msg"]
            Output: 2
            Explanation:
                The transformation of each word is:
                "gin" -> "--...-."
                "zen" -> "--...-."
                "gig" -> "--...--."
                "msg" -> "--...--."

            There are 2 different transformations, "--...-." and "--...--.".
        Note:

            The length of words will be at most 100.
            Each words[i] will have length in range [1, 12].
            words[i] will only consist of lowercase letters.



    */

    public static void main(String[] args) {
        L_804_UniqueMorseCodeWords l = new L_804_UniqueMorseCodeWords();
        String[] strs = {"gin", "zen", "gig", "msg"};
        System.out.println(l.uniqueMorseRepresentations(strs));
    }

    public int uniqueMorseRepresentations(String[] words) {
        if (null != words && words.length > 0) {
            Set<String> set = new HashSet<String>();
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (null != words[i] && words[i].length() > 0) {
                    set.add(this.dealString2(words[i], strb));
                }
            }
            return set.size();
        }
        return 0;
    }

    public static final String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....", "src/main",".---","-.-",
            ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
            ".--","-..-","-.--","--.."};

    private String dealString2(String dest, StringBuilder strb) {
        strb.delete(0, strb.length());
        for (int i = 0; i < dest.length(); i++) {
            strb.append(MORSE[dest.charAt(i) - 'a']);
        }
        return strb.toString();
    }



    private String dealString1(String dest) {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < dest.length(); i++) {
            strb.append(MORSE[dest.charAt(i) - 'a']);
        }
        return strb.toString();
    }
}
