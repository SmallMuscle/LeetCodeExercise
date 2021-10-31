package com.test.Easy;

import com.test.utils.PrintUtil;

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
        return uncommonFromSentences2(A, B);
    }

    // inspired by solution
    public String[] uncommonFromSentences2(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new LinkedList<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        for (String aa : a) {
            if (map.containsKey(aa)) map.put(aa, map.get(aa) + 1);
            else map.put(aa, 1);
        }
        for (String bb : b) {
            if (map.containsKey(bb)) map.put(bb, map.get(bb) + 1);
            else map.put(bb, 1);
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (1 == map.get(key)) list.add(key);
        }
        return list.toArray(new String[list.size()]);
    }


    // fix
    public String[] uncommonFromSentences1(String A, String B) {
        Set<String> seta = new HashSet<>();
        Set<String> setb = new HashSet<>();
        Set<String> repeats = new HashSet<>();
        int num = 0;
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        for (String aa : a) {
            if (seta.contains(aa)) {
                repeats.add(aa);
            } else {
                seta.add(aa);
            }
        }
        for (String bb : b) {
            if (setb.contains(bb)) {
                repeats.add(bb);
            } else {
                setb.add(bb);
            }
        }
        Iterator<String> ita = seta.iterator();
        while (ita.hasNext()) {
            String tmpa = ita.next();
            if (setb.contains(tmpa)) repeats.add(tmpa);
        }

        for (String aa : a) {
            if (!repeats.contains(aa)) ++num;
        }
        for (String bb : b) {
            if (!repeats.contains(bb)) ++ num;
        }
        String[] result = new String[num];
        int index = 0;
        for (String aa : a) {
            if (!repeats.contains(aa)) result[index++] = aa;
        }
        for (String bb : b) {
            if (!repeats.contains(bb)) result[index++] = bb;
        }
        return result;
    }
}
