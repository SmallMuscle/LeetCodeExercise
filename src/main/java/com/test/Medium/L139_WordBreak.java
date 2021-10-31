package com.test.Medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class L139_WordBreak {

    /**
     * question：已知字符串 s 和字符串 List，
     * 若 s 可由 List 中的字符串组合得到，返回 true
     * 否则返回 false
     *
     * eg：
     * Input: s = "leetcode", wordDict = ["leet","code"]
     * Output: true
     *
     * Input: s = "applepenapple", wordDict = ["apple","pen"]
     * Output: true
     *
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: false
     *
     * analysis:
     * 第一反应暴力。。
     * 暴力需多次递归遍历 dict
     * 在一些用例中耗时太久了。。
     *
     * 参考 Discuss
     * 利用 s.length() 长度的数组，记录 s 可匹配 dict 的index
     * 在遍历 dict 前判断下过去在对应 index 是否匹配过，
     * 若匹配过则返回之前匹配果的结果，否则才遍历
     */
    //纯暴力
    /*public boolean wordBreak(String s, List<String> wordDict) {
        if (null != s && "".equals(s)) return true;
        for (String dict : wordDict) {
            String str;
            if (s.length() >= dict.length()
                    && (str = s.substring(0, dict.length())).equals(dict)
                    && wordBreak(s.substring(str.length()), wordDict)) {
                    return true;
            }
        }
        return false;
    }*/

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] flags = new int[s.length()];
        Arrays.fill(flags, -1);
        return wordBreakRecursive(s, 0, wordDict, flags);
    }

    public boolean wordBreakRecursive(String s, int index, List<String> wordDict, int[] flags) {
        if (index >= s.length()) return true;
        if (flags[index] != -1) return flags[index] == 1;

        int match = 0;
        for (String dict : wordDict) {
            if (s.startsWith(dict, index)
                && wordBreakRecursive(s, index + dict.length(), wordDict, flags)) {
                match = 1;
                break;
            }
        }
        flags[index] = match;
        return match == 1;
    }



    @Test
    public void test() {
        log.info("{}", wordBreak("leetcode",
                Arrays.asList(new String[]{"leet", "code"})));
        log.info("{}", wordBreak("applepenapple",
                Arrays.asList(new String[]{"apple", "pen"})));
        log.info("{}", wordBreak("catsandog",
                Arrays.asList(new String[]{"cat", "dog", "send", "and", "cats"})));
        log.info("{}", wordBreak("cars",
                Arrays.asList(new String[]{"car", "ca", "rs"})));
        // 纯暴力耗时太久了。。。
        log.info("{}", wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList(new String[]{"a", "aa", "aaa", "aaaaa", "aaaaaa", "aaaaaaaa"})));
    }

    @Test
    public void substringTest() {
        log.info("{}", "123".substring(1, 3));
        log.info("{}", "".equals(null));
    }

}
