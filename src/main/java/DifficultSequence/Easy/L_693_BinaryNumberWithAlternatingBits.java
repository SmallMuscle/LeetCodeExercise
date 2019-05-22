package DifficultSequence.Easy;

public class L_693_BinaryNumberWithAlternatingBits {

    /*
        Given a positive integer, check whether it has alternating bits: namely,
        if two adjacent bits will always have different values.

        Example 1:
            Input: 5
            Output: True
            Explanation:
                The binary representation of 5 is: 101
        Example 2:
            Input: 7
            Output: False
            Explanation:
                The binary representation of 7 is: 111.
        Example 3:
            Input: 11
            Output: False
            Explanation:
                The binary representation of 11 is: 1011.
        Example 4:
            Input: 10
            Output: True
            Explanation:
                The binary representation of 10 is: 1010.
     */

    public static void main(String[] args) {
        L_693_BinaryNumberWithAlternatingBits l = new L_693_BinaryNumberWithAlternatingBits();
        int n = 5;
        System.out.println(l.hasAlternatingBits(n));
        n = 7;
        System.out.println(l.hasAlternatingBits(n));
        n = 11;
        System.out.println(l.hasAlternatingBits(n));
        n = 10;
        System.out.println(l.hasAlternatingBits(n));
    }

    public boolean hasAlternatingBits(int n) {
        return hasAlternatingBits1(n);
    }

    public boolean hasAlternatingBits1(int n) {
        int firstBit = n & 1;
        while (n > 0) {
            n >>= 1;
            if ((n & 1) == firstBit) return false;
            firstBit = n & 1;
        }
        return true;
    }
}
