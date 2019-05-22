package DifficultSequence.Easy;

import utils.PrintUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class L_937_ReorderLogFiles {

    /*
        You have an array of logs.  Each log is a space delimited string of words.

        For each log, the first word in each log is an alphanumeric(字母) identifier.  Then, either:

        Each word after the identifier will consist only of lowercase letters, or;
        Each word after the identifier will consist only of digits.
        We will call these two varieties of logs letter-logs and digit-logs.
        It is guaranteed that each log has at least one word after its identifier.

        Reorder the logs so that all of the letter-logs come before any digit-log.
        The letter-logs are ordered lexicographically(字典顺序) ignoring identifier,
        with the identifier used in case of ties(联系).  The digit-logs should be put in
        their original order.

        Return the final order of the logs.

        Example 1:
            Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
            Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

        Note:
            0 <= logs.length <= 100
            3 <= logs[i].length <= 100
            logs[i] is guaranteed to have an identifier, and a word after the identifier.
            ["a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
     */

    public static void main(String[] args) {
        L_937_ReorderLogFiles l = new L_937_ReorderLogFiles();
        String[] logs1 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        PrintUtil.printArray(l.reorderLogFiles(logs1));
        String[] logs2 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        PrintUtil.printArray(l.reorderLogFiles(logs2));
    }

    public String[] reorderLogFiles(String[] logs) {
        return reorderLogFiles1(logs);
    }

    public String[] reorderLogFiles1(String[] logs) {
        // put the digit behind the letters
        int first = logs.length - 1;
        int second = first;
        while (first >= 0) {
            if (isDigitLog(logs[first])) {
                if (first != second) {
                    String tmp = logs[first];
                    logs[first] = logs[second];
                    logs[second] = tmp;
                }
                --second;
            }
            --first;
        }
        // reorder letters log
        Map<String, String> map = new TreeMap();
        for (int i = 0; i <= second; i++) {
            String str = logs[i];
            map.put(str.substring(str.indexOf(' ') + 1) + str.substring(0, str.indexOf(' ')), str);
        }
        Iterator<String> it = map.values().iterator();
        for (int i = 0; i <= second && it.hasNext(); i++) {
            logs[i] = it.next();
        }
        return logs;
    }

    boolean isDigitLog(String log) {
        char tmp = log.charAt(log.length() - 1);
        return tmp >= '0' && tmp <= '9';
    }


}
