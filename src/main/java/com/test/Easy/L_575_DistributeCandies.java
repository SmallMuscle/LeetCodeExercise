package com.test.Easy;

import java.util.HashSet;
import java.util.Set;

public class L_575_DistributeCandies {

    /*
        Given an integer array with even length, where different numbers
        in this array represent different kinds of candies. Each number
        means one candy of the corresponding kind. You need to distribute
        these candies equally in number to brother and sister. Return the
        maximum number of kinds of candies the sister could gain.

        Example 1:
            Input: candies = [1,1,2,2,3,3]
            Output: 3
            Explanation:
                There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
                Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
                The sister has three different kinds of candies.
        Example 2:
            Input: candies = [1,1,2,3]
            Output: 2
            Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
                The sister has two different kinds of candies, the brother has only one kind of candies.
        Note:
            The length of the given array is in range [2, 10,000], and will be even.
            The number in given array is in range [-100,000, 100,000].
     */

    public static void main(String[] args) {
        L_575_DistributeCandies l = new L_575_DistributeCandies();
        int[] candies1 = {1,1,2,2,3,3};
        System.out.println(l.distributeCandies(candies1));
        int[] candies2 = {1,1,2,3};
        System.out.println(l.distributeCandies(candies2));
    }

    public int distributeCandies(int[] candies) {
        return distributeCandies2(candies);
    }

    public int distributeCandies1(int[] candies) {
        int num = candies.length >>  1;
        Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }
        return num > set.size() ? set.size() : num;
    }

    public int distributeCandies2(int[] candies) {
        int[] index = new int[200001];
        int num = candies.length >> 1;
        int type = 0;
        for (int c : candies) {
            index[c + 100000] = 1;
        }
        for (int i : index) {
            if (1 == i) ++type;
        }
        return num > type ? type : num;
    }
}
