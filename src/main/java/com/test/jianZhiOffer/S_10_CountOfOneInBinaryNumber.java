package com.test.jianZhiOffer;

public class S_10_CountOfOneInBinaryNumber {

    public int countOfOneInBinaryNumberByShift(int number) {
        int result = 0;
        for (; number != 0; number >>>= 1) {
            if (1 == (1 & number)) ++result;
        }
        return result;
    }

    public int countOfOneInBinaryNumberBySubtration(int number) {
        int result = 0;
        while (0 != number) {
            int tmp = number - 1;
            number = tmp & number;
            ++result;
        }
        return result;
    }

}
