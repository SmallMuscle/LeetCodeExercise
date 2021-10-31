package com.test.Easy;

public class L_788_RotatedDigits {

    /*
        X is a good number if after rotating each digit individually by 180
        degrees, we get a valid number that is different from X.  Each digit
        must be rotated - we cannot choose to leave it alone.

        A number is valid if each digit remains a digit after rotation. 0, 1,
        and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate
        to each other, and the rest of the numbers do not rotate to any other
        number and become invalid.

        Now given a positive number N, how many numbers X from 1 to N are good?

        Example:
            Input: 10
            Output: 4
            Explanation:
            There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
            Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
        Note:
            N  will be in range [1, 10000].

     */

    public static void main(String[] args) {
        L_788_RotatedDigits l = new L_788_RotatedDigits();
        int N = 10;
        System.out.println(l.rotatedDigits(N));
    }

    public int rotatedDigits(int N) {
        return rotatedDigits3(N);
    }




    public int rotatedDigits1(int N) {
        int result = 0;
        for (int i = 2; i <= N; i++) {
            if (isGoodNum2(i)) ++result;
        }
        return result;
    }

    private boolean isGoodNum1(int N) {
        String str = Integer.toString(N);
        int diff = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '2':
                case '5':
                case '6':
                case '9':
                    ++diff;
                    break;
                case '0':
                case '1':
                case '8':
                    break;
                default:
                    return false;
            }
        }
        return diff > 0;
    }

    private static final int[] index = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    // Inspired by Discuss
    private boolean isGoodNum2(int N) {
        int diff = 0;
        while (N > 0) {
            int num = N % 10;
            if (index[num] == -1) return false;
            diff += index[num];
            N /= 10;
        }
        return diff > 0;
    }












    private static final int[] dictionary = new int[10000];

    public L_788_RotatedDigits() {
        preDeal();
    }

    private void preDeal() {
        int result = 0;
        for (int i = 1; i <= 10000; i++) {
            if (isGoodNum2(i)) ++result;
            dictionary[i - 1] = result;
            System.out.println(result);
        }
    }

    public int rotatedDigits2(int N) {
        return dictionary[N - 1];
    }








    
    private static int pos = 1;
    private static int rst = 0;

    public int rotatedDigits3(int N) {
        for (; pos <= N; ++pos) {
            if (isGoodNum2(pos)) ++rst;
            dictionary[pos - 1] = rst;
        }
        return dictionary[N - 1];
    }










}
