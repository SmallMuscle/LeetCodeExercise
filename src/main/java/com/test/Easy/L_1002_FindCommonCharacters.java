package com.test.Easy;

import com.test.utils.ArrayUtil;
import com.test.utils.PrintUtil;

import java.util.*;

public class L_1002_FindCommonCharacters {

    /*
        2019.04.13

        Given an array A of strings made only from lowercase letters,
        return a list of all characters that show up in all strings
        within the list (including duplicates).
        For example, if a character occurs 3 times in all strings but
        not 4 times, you need to include that character three times in
        the final answer.

        You may return the answer in any order.

        Example 1:
            Input: ["bella","label","roller"]
            Output: ["e","l","l"]
        Example 2:
            Input: ["cool","lock","cook"]
            Output: ["c","o"]

        Note:
            1 <= A.length <= 100
            1 <= A[i].length <= 100
            A[i][j] is a lowercase letter
     */

    public static void main(String[] args) {

        L_1002_FindCommonCharacters l = new L_1002_FindCommonCharacters();
        String[] strs1 = {"bella","label","roller"};
        PrintUtil.printList(l.commonChars(strs1));
        String[] strs2 = {"cool","lock","cook"};
        PrintUtil.printList(l.commonChars(strs2));
    }

    public List<String> commonChars(String[] A) {
        return commonChars2(A);
    }

    // 数组挺快的
    public List<String> commonChars2(String[] A) {
        List<String> list = new LinkedList<>();
        int[] dir = ArrayUtil.getArray(26);
        int[] var = ArrayUtil.getArray(26);
        for (char c : A[0].toCharArray()) {
            ++dir[c - 'a'];
        }
        for (int i = 1; i < A.length; ++i) {
            for (char c : A[i].toCharArray()) {
                ++var[c - 'a'];
            }
            for (int j = 0; j < dir.length; j++) {
                if (0 != dir[j]) {
                    dir[j] = dir[j] > var[j] ? var[j] : dir[j];
                }
            }
            ArrayUtil.initArray(var);
        }
        for (int i = 0; i < dir.length; i++) {
            while (0 != dir[i]) {
                list.add((char)('a' + i) + "");
                --dir[i];
            }
        }
        return list;
    }

    public List<String> commonChars3(String[] A) {
        List<String> list = new ArrayList<>();
        if (null != A && 0 < A.length) {
            Map<String, Integer> dir = new HashMap<>();
            Map<String, Integer> var = new HashMap<>();
            // 初始化参照
            initMap(dir, A[0]);
            // 遍历，过滤
            for (int i = 1; i < A.length; ++i) {
                initMap(var, A[i]);
                Iterator<String> it = dir.keySet().iterator();
                while (it.hasNext()) {
                    String s = it.next();
                    if (var.containsKey(s)) {
                        dir.put(s, dir.get(s) > var.get(s) ? var.get(s) : dir.get(s));
                    } else {
                        list.add(s);
                    }
                }
            }
            // 删除无用 String
            for (String s : list) {
                dir.remove(s);
            }
            list.clear();
            // 存储结果
            Iterator it = dir.keySet().iterator();
            while (it.hasNext()) {
                String s = it.next().toString();
                for (int i = 0; i < dir.get(s); i++) {
                    list.add(s);
                }
            }
        }
        return list;
    }

    public List<String> commonChars1(String[] A) {
        List<String> list = new LinkedList<>();

        if (null != A && 0 < A.length) {
            Map<String, Integer> dir = new HashMap<>();
            Map<String, Integer> var = new HashMap<>();
            // 初始化参照
            initMap(dir, A[0]);
            // 遍历，过滤
            for (int i = 1; i < A.length; ++i) {
                initMap(var, A[i]);
                Iterator<String> it = dir.keySet().iterator();
                while (it.hasNext()) {
                    String s = it.next();
                    if (var.containsKey(s)) {
                        dir.put(s, dir.get(s) > var.get(s) ? var.get(s) : dir.get(s));
                    } else {
                        list.add(s);
                    }
                }
            }
            // 删除无用 String
            for (String s : list) {
                dir.remove(s);
            }
            list.clear();
            // 存储结果
            Iterator it = dir.keySet().iterator();
            while (it.hasNext()) {
                String s = it.next().toString();
                for (int i = 0; i < dir.get(s); i++) {
                    list.add(s);
                }
            }
        }
        return list;
    }

    private void initMap(Map<String, Integer> dir, String str) {
        dir.clear();
        for (Character c : str.toCharArray()) {
            if (dir.containsKey(c.toString())) {
                dir.put(c.toString(), dir.get(c.toString()) + 1);
            } else {
                dir.put(c.toString(), 1);
            }
        }
    }

}
