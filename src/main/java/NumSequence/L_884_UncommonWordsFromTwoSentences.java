package NumSequence;

import utils.PrintUtil;

import java.util.*;

public class L_884_UncommonWordsFromTwoSentences {

    /*
        We are given two sentences A and B.  (A sentence is a string
        of space separated words.  Each word consists only of lowercase
        letters.)

        A word is uncommon if it appears exactly once in one of the
        sentences, and does not appear in the other sentence.

        Return a list of all uncommon words.

        You may return the list in any order.



        Example 1:
            Input: A = "this apple is sweet", B = "this apple is sour"
            Output: ["sweet","sour"]
        Example 2:
            Input: A = "apple apple", B = "banana"
            Output: ["banana"]

        Note:
            0 <= A.length <= 200
            0 <= B.length <= 200
            A and B both contain only spaces and lowercase letters.

     */

    public static void main(String[] args) {
        L_884_UncommonWordsFromTwoSentences l = new L_884_UncommonWordsFromTwoSentences();
        String A1 = "this apple is sweet";
        String B1 = "this apple is sour";
        PrintUtil.printArray(l.uncommonFromSentences(A1, B1));
        String A2 = "apple apple";
        String B2 = "banana";
        PrintUtil.printArray(l.uncommonFromSentences(A2, B2));
    }

    public String[] uncommonFromSentences(String A, String B) {
        return uncommonFromSentences1(A, B);
    }

    // It got defect
    public String[] uncommonFromSentences1(String A, String B) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        for (String s : a) {
            if (!set1.contains(s)) set1.add(s);
            else set1.remove(s);
        }
        for (String s : b) {
            if (!set2.contains(s)) set2.add(s);
            else set2.remove(s);
        }
        if (0 < set1.size() && 0 < set2.size()){
            Iterator<String> it = set1.iterator();
            for (int i = 0; i < set1.size(); i++) {
                String str = it.next();
                if (set2.contains(str)) {
                    it.remove();
                    set2.remove(str);
                    --i;
                }
            }
            String[] result = new String[set1.size() + set2.size()];
            int num = 0;
            if (0 < set1.size()) {
                Iterator<String> it1 = set1.iterator();
                while (it1.hasNext()) result[num++] = it1.next();
            }
            if (0 < set2.size()) {
                Iterator<String> it2 = set2.iterator();
                while (it2.hasNext()) result[num++] = it2.next();
            }
            return result;
        } else if (0 < set1.size()) {
            String[] result = new String[set1.size()];
            Iterator<String> it = set1.iterator();
            int num = 0;
            while (it.hasNext()) {
                result[num++] = it.next();
            }
            return result;
        } else if (0 < set2.size()) {
            String[] result = new String[set2.size()];
            Iterator<String> it = set2.iterator();
            int num = 0;
            while (it.hasNext()) {
                result[num++] = it.next();
            }
            return result;
        }
        return null;
    }
}
