package DifficultSequence.Easy;

public class L_1009_ComplementOfBase10Integer {

    /*
        Every non-negative integer N has a binary representation.
        For example, 5 can be represented as "101" in binary, 11
        as "1011" in binary, and so on.  Note that except for
        N = 0, there are no leading zeroes in any binary representation.

        The complement of a binary representation is the number in
        binary you get when changing every 1 to a 0 and 0 to a 1.
        For example, the complement of "101" in binary is "010" in binary.

        For a given number N in base-10, return the complement of
        it's binary representation as a base-10 integer.

        Example 1:
            Input: 5
            Output: 2
            Explanation: 5 is "101" in binary, with complement "010"
            in binary, which is 2 in base-10.
        Example 2:
            Input: 7
            Output: 0
            Explanation: 7 is "111" in binary, with complement "000"
            in binary, which is 0 in base-10.
        Example 3:
            Input: 10
            Output: 5
            Explanation: 10 is "1010" in binary, with complement "0101"
            in binary, which is 5 in base-10.

        Note:
        0 <= N < 10^9

     */

    public static void main(String[] args) {
        L_1009_ComplementOfBase10Integer l = new L_1009_ComplementOfBase10Integer();
        int N = 5;
        System.out.println(l.bitwiseComplement(N));
        N = 7;
        System.out.println(l.bitwiseComplement(N));
        N = 10;
        System.out.println(l.bitwiseComplement(N));
    }

    public int bitwiseComplement(int N) {
        return bitwiseComplement2(N);
    }

    // inspired by Discuss
    public int bitwiseComplement2(int N) {
        int filter = 1;
        while (N > filter) filter = (filter << 1) + 1;
        return filter - N;
    }

    public int bitwiseComplement1(int N) {
        if (0 == N) return 1;
        int maxBit1 = 0;
        int filter = -1;
        int n = N;
        for (; n > 0; n >>= 1, ++maxBit1);
        if (0 != maxBit1) {
            filter = -2;
            filter <<= --maxBit1;
        }
        n = N ^ filter;
        return ~n;
    }


}
