package com.test.Easy;

public class L_461_HammingDistance {

    /*
        2019.03.27

        The Hamming distance between two integers is the number of
        positions at which the corresponding bits are different.

        Given two integers x and y, calculate the Hamming distance.

        Note:
            0 ≤ x, y < 231.

        Example:
            Input: x = 1, y = 4
            Output: 2
            Explanation:
            1   (0 0 0 1)
            4   (0 1 0 0)
                   ↑   ↑

        The above arrows point to positions where the corresponding
        bits are different.

     */

    public static void main(String[] args) {
        L_461_HammingDistance l = new L_461_HammingDistance();
        System.out.println(l.hammingDistance(1,4));
    }

    public int hammingDistance(int x, int y) {
        return hammingDistance1(x, y);
    }

    public int hammingDistance1(int x, int y) {
        int num = 0;
        if (x == y) {
            return num;
        }
        x = x ^ y;
        for (int i = 0; i < 32; ++i) {
            if ((x & 1) == 1) {
                ++num;
            }
            x >>= 1;
        }
        return num;
    }
}
