package DifficultSequence.Easy;

public class L_762_PrimeNumberOfSetBitsInBinaryRepresentation {

    /*
        Given two integers L and R, find the count of numbers in the range
        [L, R] (inclusive) having a prime number of set bits in their binary
        representation.

        (Recall that the number of set bits an integer has is the number of
        1s present when written in binary. For example, 21 written in binary
        is 10101 which has 3 set bits. Also, 1 is not a prime.)

        Example 1:
            Input: L = 6, R = 10
            Output: 4
            Explanation:
            6 -> 110 (2 set bits, 2 is prime)
            7 -> 111 (3 set bits, 3 is prime)
            9 -> 1001 (2 set bits , 2 is prime)
            10->1010 (2 set bits , 2 is prime)
        Example 2:
            Input: L = 10, R = 15
            Output: 5
            Explanation:
            10 -> 1010 (2 set bits, 2 is prime)
            11 -> 1011 (3 set bits, 3 is prime)
            12 -> 1100 (2 set bits, 2 is prime)
            13 -> 1101 (3 set bits, 3 is prime)
            14 -> 1110 (3 set bits, 3 is prime)
            15 -> 1111 (4 set bits, 4 is not prime)
        Note:
            L, R will be integers L <= R in the range [1, 10^6].
            R - L will be at most 10000.

     */

    public static void main(String[] args) {
        L_762_PrimeNumberOfSetBitsInBinaryRepresentation l = new L_762_PrimeNumberOfSetBitsInBinaryRepresentation();
        int L = 6;
        int R = 10;
        System.out.println(l.countPrimeSetBits(L, R));
        L = 10;
        R = 15;
        System.out.println(l.countPrimeSetBits(L, R));
    }

    public int countPrimeSetBits(int L, int R) {
        return countPrimeSetBits3(L, R);
    }

    // inspired by Discuss
    // map the array of prime number bit to an int number
    public int countPrimeSetBits3(int L, int R) {
        int count = 0;
        while (L <= R)
            count += 665772 >> Integer.bitCount(L++) & 1;
        return count;
    }

    public int countPrimeSetBits2(int L, int R) {
        int result = 0;
        if (L <= R) {
            for (int i = L; i <= R; i++) {
                if (isPrime2(Integer.bitCount(i))) ++result;
            }
        }
        return result;
    }

    public int countPrimeSetBits1(int L, int R) {
        int result = 0;
        if (L <= R) {
            for (int i = L; i <= R; i++) {
                if (isPrime2(getBits(i))) ++result;
            }
        }
        return result;
    }

    private int getBits(int num) {
        int bits = 0;
        while (0 < num) {
            if ((num & 1) == 1) ++bits;
            num >>= 1;
        }
        return bits;
    }

    // int type got 32 bit
    // the prime number of less then 32 and R is less then 10^6
    // so the prime number are 2, 3, 5, 7, 11, 13, 17, 19
    private static final int[] primeList = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};

    private boolean isPrime2(int num) {
        return primeList[num] == 1;
    }

    private boolean isPrime1(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        for (int i = 2; i * i <= num; i++) {
            if ((num % i) == 0) return false;
        }
        return true;
    }

}
