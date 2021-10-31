package com.test.Easy;

import com.test.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class L_412_FizzBuzz {

    /*
        Write a program that outputs the string representation of
        numbers from 1 to n.

        But for multiples of three it should output “Fizz” instead
        of the number and for the multiples of five output “Buzz”.
        For numbers which are multiples of both three and five
        output “FizzBuzz”.

        Example:

        n = 15,

        Return:
        [
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz"
        ]
     */

    public static void main(String[] args) {
        L_412_FizzBuzz l = new L_412_FizzBuzz();
        PrintUtil.printList(l.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        return fizzBuzz2(n);
    }

    private static final String three = "Fizz";

    private static final String five = "Buzz";

    private static final String threeFive = "FizzBuzz";


    public List<String> fizzBuzz1(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (0 == (i % 5) && 0 == (i % 3)) list.add(threeFive);
            else if (0 == (i % 3)) list.add(three);
            else if (0 == (i % 5)) list.add(five);
            else list.add(Integer.toString(i));
        }
        return list;
    }

    // inspired by Discuss
    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>(n);
        int threeIndex = 3;
        int fiveIndex = 5;
        for (int i = 1; i <= n; i++) {
            if (i == fiveIndex && i == threeIndex) {
                list.add(threeFive);
                threeIndex += 3;
                fiveIndex += 5;
            }
            else if (threeIndex == i) {
                list.add(three);
                threeIndex += 3;
            }
            else if (fiveIndex == i) {
                list.add(five);
                fiveIndex += 5;
            }
            else list.add(Integer.toString(i));
        }
        return list;
    }


}
