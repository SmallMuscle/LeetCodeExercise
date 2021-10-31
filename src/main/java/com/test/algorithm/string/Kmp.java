package com.test.algorithm.string;

import com.test.utils.PrintUtil;

public class Kmp {

    public static void main(String[] args) {
        String str = "aaa";
        str = "ababac";
        System.out.println(kmp(str.toCharArray(),  str.substring(2).toCharArray(), 0));
        //PrintUtil.printArray(getNext(str.toCharArray()));
    }

    public static int kmp(char[] src, char[] dest, int pos) {
        if (null == src || null == dest
            || 0 == src.length || 0 == dest.length
            || dest.length > src.length) return -1;
        int[] next = getNext(dest);
        int d = 0;
        while (pos < src.length && d < dest.length) {
            if (src[pos] == dest[d]) {
                ++pos; ++d;
            } else {
                if (0 == d) ++pos;
                else d = next[d];
            }
        }
        if (d == dest.length) return pos - d;
        return -1;
    }

    public static int[] getNext(char[] dest) {
        if (1 == dest.length) return new int[] {0};
        if (2 == dest.length) return new int[] {0, 0};
        int s = 1;
        int d = 0;
        int len = dest.length - 1;
        int[] next = new int[dest.length];
        next[0] = next[1] = 0;
        while (s < len && d < len) {
            if (dest[s] == dest[d]) {
                next[++s] = ++d;
            } else {
                if (d == 0) ++s;
                else d = next[d];
            }
        }
        return next;
    }
}
