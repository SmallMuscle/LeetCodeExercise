package com.test.jianZhiOffer;

public class S_32_NumberOf1Between1andN {

    public int numberOf1Between1andN(int n) {
        if (n < 1) return 0;
        char[] nChs = String.valueOf(n).toCharArray();
        return numberOf1Between1andN(nChs, 0);
    }

    private int numberOf1Between1andN(char[] n, int start) {
        if (start == n.length) return 0;
        int len = n.length - start;
        if (1 == len) return '0' < n[start] ? 1 : 0;
        int firstBit = n[start] - '0';
        int firstPart = firstBit * powerOf10(len - 2) * (len - 1);
        int secondPart = 0;
        if (1 == firstBit) secondPart = 1 + Integer.parseInt(new String(n, start + 1, len - 1));
        else if (1 < firstBit) secondPart = powerOf10(len - 1);
        return firstPart + secondPart + numberOf1Between1andN(n, start + 1);
    }

    private int powerOf10(int exp) {
        if (0 > exp) return 0;
        int base = 10;
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

}
