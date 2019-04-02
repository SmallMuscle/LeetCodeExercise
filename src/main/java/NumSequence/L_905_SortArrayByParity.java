package NumSequence;

public class L_905_SortArrayByParity {

    /*
        2019.03.25

        Given an array A of non-negative integers, return an array
        consisting of all the even elements of A, followed by all the
        odd elements of A.

        You may return any answer array that satisfies this condition.

        Example 1:
            Input: [3,1,2,4]
            Output: [2,4,3,1]
        The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

        Note:
            1 <= A.length <= 5000
            0 <= A[i] <= 5000


    */

    public static void main(String[] args) {
        L_905_SortArrayByParity l = new L_905_SortArrayByParity();
        int[] A = {3,1,2,4};
        for (int a : l.sortArrayByParity(A))
            System.out.print(a + " ");

        int[] B = {0, 2};
        for (int a : l.sortArrayByParity(B))
            System.out.print(a + " ");
    }

    public int[] sortArrayByParity(int[] A) {
        return sortArrayByParity1(A);
    }

    public int[] sortArrayByParity1(int[] A) {
        if (null != A && A.length > 1) {
            int s = -1;
            int e = A.length;
            while (s < e) {
                while (++s < A.length && (A[s] & 1) == 0);
                while (--e >= 0 && (A[e] & 1) == 1);
                if (s < e) {
                    int tmp = A[s];
                    A[s] = A[e];
                    A[e] = tmp;
                } else {
                    break;
                }
            }
        }
        return A;
    }
}
