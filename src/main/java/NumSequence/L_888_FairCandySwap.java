package NumSequence;

import utils.PrintUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_888_FairCandySwap {

    /*
        Alice and Bob have candy bars of different sizes: A[i] is the size of
        the i-th bar of candy that Alice has, and B[j] is the size of the j-th
        bar of candy that Bob has.

        Since they are friends, they would like to exchange one candy bar each
        so that after the exchange, they both have the same total amount of
        candy.  (The total amount of candy a person has is the sum of the sizes
        of candy bars they have.)

        Return an integer array ans where ans[0] is the size of the candy bar
        that Alice must exchange, and ans[1] is the size of the candy bar that
        Bob must exchange.

        If there are multiple answers, you may return any one of them.  It is
        guaranteed an answer exists.

        Example 1:
            Input: A = [1,1], B = [2,2]
            Output: [1,2]
        Example 2:
            Input: A = [1,2], B = [2,3]
            Output: [1,2]
        Example 3:
            Input: A = [2], B = [1,3]
            Output: [2,3]
        Example 4:
            Input: A = [1,2,5], B = [2,4]
            Output: [5,4]

        Note:
        1 <= A.length <= 10000
        1 <= B.length <= 10000
        1 <= A[i] <= 100000
        1 <= B[i] <= 100000
        It is guaranteed that Alice and Bob have different total amounts of candy.
        It is guaranteed there exists an answer.

     */

    public static void main(String[] args) {
        L_888_FairCandySwap l = new L_888_FairCandySwap();
        int[] A1 = {1, 1};
        int[] B1 = {2, 2};
        PrintUtil.printArray(l.fairCandySwap(A1, B1));
        int[] A2 = {1, 2};
        int[] B2 = {2, 3};
        PrintUtil.printArray(l.fairCandySwap(A2, B2));
        int[] A3 = {2};
        int[] B3 = {1, 3};
        PrintUtil.printArray(l.fairCandySwap(A3, B3));
        int[] A4 = {1, 2, 5};
        int[] B4 = {2, 4};
        PrintUtil.printArray(l.fairCandySwap(A4, B4));
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        return fairCandySwap2(A, B);
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        int[] result = new int[2];
        int[] aa = new int[100001];
        int suma = 0;
        int sumb = 0;
        for (int a : A) {
            aa[a] = 1;
            suma += a;
        }
        for (int b : B) {
            sumb += b;
        }
        int interval = (suma - sumb) >> 1;
        for (int b : B) {
            if (b + interval >= 0 && b + interval < 100001 && aa[b + interval] == 1) {
                result[0] = b + interval;
                result[1] = b;
                break;
            }
        }
        return result;
    }


    public int[] fairCandySwap1(int[] A, int[] B) {
        int[] result = new int[2];
        Set am = new HashSet();
        Set bm = new HashSet();
        int suma = 0;
        int sumb = 0;
        for (int a : A) {
            am.add(a);
            suma += a;
        }
        for (int b : B) {
            bm.add(b);
            sumb += b;
        }
        int interval;
        if (suma > sumb) {
            interval = (suma - sumb) >> 1;
            for (int a : A) {
                if (bm.contains(a - interval)) {
                    result[0] = a;
                    result[1] = a - interval;
                }
            }
        } else {
            interval = (sumb - suma) >> 1;
            for (int b : B) {
                if (am.contains(b - interval)) {
                    result[0] = b - interval;
                    result[1] = b;
                }
            }
        }
        return result;
    }

}
