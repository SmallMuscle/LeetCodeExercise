package com.test.Easy;

public class L_476_NumberComplement {

    /*
        2019.04.24

        Given a positive integer, output its complement number. The complement
        strategy is to flip the bits of its binary representation.

        Note:
            The given integer is guaranteed to fit within the range of a 32-bit signed integer.
            You could assume no leading zero bit in the integer’s binary representation.
        Example 1:
            Input: 5
            Output: 2
            Explanation: The binary representation of 5 is 101 (no leading zero
            bits), and its complement is 010. So you need to output 2.
        Example 2:
            Input: 1
            Output: 0
            Explanation: The binary representation of 1 is 1 (no leading zero
            bits), and its complement is 0. So you need to output 0.
     */

    public static void main(String[] args) {
        L_476_NumberComplement l = new L_476_NumberComplement();
        System.out.println(l.findComplement(5));
        System.out.println(l.findComplement(1));
    }

    public int findComplement(int num) {
        return findComplement1(num);
    }

    public int findComplement1(int num) {
        int bit = 1;
        while (bit < num) bit |= bit << 1;
        return ~num & bit;
    }
}
