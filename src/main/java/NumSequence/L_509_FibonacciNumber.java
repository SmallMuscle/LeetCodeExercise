package NumSequence;

public class L_509_FibonacciNumber {

    /*
        2019.03.31

        The Fibonacci numbers, commonly denoted F(n) form a sequence,
        called the Fibonacci sequence, such that each number is the
        sum of the two preceding ones, starting from 0 and 1. That is,

        F(0) = 0,   F(1) = 1
        F(N) = F(N - 1) + F(N - 2), for N > 1.
        Given N, calculate F(N).

        Example 1:
            Input: 2
            Output: 1
            Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
        Example 2:
            Input: 3
            Output: 2
            Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
        Example 3:
            Input: 4
            Output: 3
            Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

     */

    public static void main(String[] args) {
        L_509_FibonacciNumber l = new L_509_FibonacciNumber();
        int N = 4;
        System.out.println(l.fib(N));
    }

    public int fib(int N) {
        return fib1(N);
    }

    public int fib1(int N) {
        if (0 == N) return 0;
        if (1 == N || 2 == N) return 1;
        int f1 = 1;
        int f2 = 1;
        int result = 0;
        for (int i = 2; i < N; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }


}
