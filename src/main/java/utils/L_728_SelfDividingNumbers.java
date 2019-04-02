package utils;

import java.util.ArrayList;
import java.util.List;

public class L_728_SelfDividingNumbers {

    /*
        2019.04.02

        A self-dividing number is a number that is divisible by
        every digit it contains.

        For example, 128 is a self-dividing number because
        128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

        Also, a self-dividing number is not allowed to contain
        the digit zero.

        Given a lower and upper number bound, output a list of
        every possible self dividing number, including the bounds if possible.

        Example 1:
            Input:
                left = 1, right = 22
            Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        Note:
        The boundaries of each input argument are 1 <= left <= right <= 10000.

     */

    public static void main(String[] args) {
        L_728_SelfDividingNumbers l = new L_728_SelfDividingNumbers();
        int left = 1;
        int right = 22;
        System.out.println(l.selfDividingNumbers(left, right));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        return selfDividingNumbers1(left, right);
    }

    public List<Integer> selfDividingNumbers1(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer i = left; i <= right; i++) {
            if (1 == i.toString().length()) {
                list.add(i);
            } else {
                int len = i.toString().length();
                boolean flag = true;
                for (int j = 0; j < len; j++) {
                    int div = (i.toString().charAt(j) - '0');
                    if (0 == div || 0 != i % div) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(i);
                }
            }
        }
        return list;
    }

}
