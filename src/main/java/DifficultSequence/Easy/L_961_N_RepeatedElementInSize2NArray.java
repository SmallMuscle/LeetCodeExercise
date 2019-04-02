package DifficultSequence.Easy;

import java.util.HashSet;
import java.util.Set;

public class L_961_N_RepeatedElementInSize2NArray {


    /*
        2019.03.24

        In a array A of size 2N, there are N+1 unique elements,
        and exactly one of these elements is repeated N times.

        Return the element repeated N times.

        Example 1:
            Input: [1,2,3,3]
            Output: 3
        Example 2:
            Input: [2,1,2,5,3,2]
            Output: 2
        Example 3:
            Input: [5,1,5,2,5,3,5,4]
            Output: 5

        Note:
            4 <= A.length <= 10000
            0 <= A[i] < 10000
            A.length is even
    */

    public static void main(String[] args) {
        L_961_N_RepeatedElementInSize2NArray l = new L_961_N_RepeatedElementInSize2NArray();
        int[] a = {1,2,3,3};
        System.out.println(l.repeatedNTimes2(a));
        int[] b = {2,1,2,5,3,2};
        System.out.println(l.repeatedNTimes2(b));
        int[] c = {5,1,5,2,5,3,5,4};
        System.out.println(l.repeatedNTimes2(c));
    }

    // 除了要返回的那个重复的其他都唯一。。。
    public int repeatedNTimes2(int[] A) {
        if (A != null && A.length > 0) {
            Set<Integer> set = new HashSet();
            int i;
            for (i = -1;set.add(A[++i]););  // 鄙人不才，才发现这个 。。
            return A[i];
        }
        return 0;
    }


    public int repeatedNTimes1(int[] A) {
        if (A != null && A.length > 0) {
            Set<Integer> set = new HashSet();
            int i;
            for (i = 0;!set.contains(A[i]); set.add(A[i++]) );
            return A[i];
        }
        return 0;
    }
}
