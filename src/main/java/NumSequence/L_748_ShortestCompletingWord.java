package NumSequence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class L_748_ShortestCompletingWord {

    /*
        Find the minimum length word from a given dictionary words, which has
        all the letters from the string licensePlate. Such a word is said to
        complete the given string licensePlate

        Here, for letters we ignore case. For example, "P" on the licensePlate
        still matches "p" on the word.

        It is guaranteed an answer exists. If there are multiple answers, return
        the one that occurs first in the array.

        The license plate might have the same letter occurring multiple times.
        For example, given a licensePlate of "PP", the word "pair" does not
        complete the licensePlate, but the word "supper" does.

        Example 1:
            Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
            Output: "steps"
            Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
            Note that the answer is not "step", because the letter "s" must occur in the word twice.
            Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
        Example 2:
            Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
            Output: "pest"
            Explanation: There are 3 smallest length words that contains the letters "s".
            We return the one that occurred first.
        Note:
            licensePlate will be a string with length in range [1, 7].
            licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
            words will have a length in the range [10, 1000].
            Every words[i] will consist of lowercase letters, and have length in range [1, 15].

     */

    public static void main(String[] args) {
        L_748_ShortestCompletingWord l = new L_748_ShortestCompletingWord();
        String licensePlate = "1s3 PSt";
        String[] words1 = {"step", "steps", "stripe", "stepple"};
        System.out.println(l.shortestCompletingWord(licensePlate, words1));
        licensePlate = "1s3 456";
        String[] words2 = {"looks", "pest", "stew", "show"};
        System.out.println(l.shortestCompletingWord(licensePlate, words2));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        return shortestCompletingWord2(licensePlate, words);
    }

    public String shortestCompletingWord2(String licensePlate, String[] words) {
        String result = null;
        int[] index = projectStringToArray(licensePlate);
        for (int i = 0; i < words.length; i++) {
            if (result == null || result.length() > words[i].length()) {
                if (passedLicense2(index, words[i])) {
                    result = words[i];
                }
            }
        }
        return result;
    }

    private boolean passedLicense2(int[] index, String word) {
        int[] arrays = projectStringToArray(word);
        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0 && index[i] > arrays[i]) return false;
        }
        return true;
    }

    private int[] projectStringToArray(String word) {
        if (word != null && word.length() > 0) {
            int[] arrays = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                    if (c < 'a') c += 'a' - 'A';
                    ++arrays[c - 'a'];
                }
            }
            return arrays;
        }
        return null;
    }





    public String shortestCompletingWord1(String licensePlate, String[] words) {
        String result = null;
        Map<Character, Integer> index = projectStringToMap(licensePlate);
        for (int i = 0; i < words.length; i++) {
            if (result == null || result.length() > words[i].length()) {
                if (passedLicense1(index, words[i])) {
                    result = words[i];
                }
            }
        }
        return result;
    }

    private boolean passedLicense1(Map<Character, Integer> index, String word) {
        Map<Character, Integer> map = projectStringToMap(word);
        Iterator<Character> it = index.keySet().iterator();
        while (it.hasNext()) {
            char c = it.next();
            if (c < 'a') c += 'a' - 'A';
            if (!map.containsKey(c) || map.get(c) < index.get(c)) return false;
        }
        return true;
    }

    private Map<Character, Integer> projectStringToMap(String word) {
        if (word != null && word.length() > 0) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                    if (c < 'a') c += 'a' - 'A';
                    Integer num = map.get(c);
                    map.put(c, num == null ? 1 : num + 1);
                }
            }
            return map;
        }
        return null;
    }
}
