package NumSequence;

import utils.ArrayUtil;
import utils.PrintUtil;

public class L_985_SumOfEvenNumbersAfterQueries {

    /*
        2019.04.15

        We have an array A of integers, and an array queries of queries.

        For the i-th query [
        val = queries[i][0], index = queries[i][1],
        we add val to A[index].  Then, the answer to the i-th query is
        the sum of the even values of A.

        (Here, the given index = queries[i][1] is a 0-based index, and
        each query permanently modifies the array A.)

        Return the answer to all queries.  Your answer array should have
        answer[i] as the answer to the i-th query.

        Example 1:
            Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
            Output: [8,6,2,4]
            Explanation:
                At the beginning, the array is [1,2,3,4].
                After adding 1 to A[0], the array is [2,2,3,4],
                and the sum of even values is 2 + 2 + 4 = 8.
                After adding -3 to A[1], the array is [2,-1,3,4],
                and the sum of even values is 2 + 4 = 6.
                After adding -4 to A[0], the array is [-2,-1,3,4],
                and the sum of even values is -2 + 4 = 2.
                After adding 2 to A[3], the array is [-2,-1,3,6],
                and the sum of even values is -2 + 6 = 4.

        Note:
            1 <= A.length <= 10000
            -10000 <= A[i] <= 10000
            1 <= queries.length <= 10000
            -10000 <= queries[i][0] <= 10000
            0 <= queries[i][1] < A.length
     */

    public static void main(String[] args) {
        L_985_SumOfEvenNumbersAfterQueries l = new L_985_SumOfEvenNumbersAfterQueries();
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        PrintUtil.printArray(l.sumEvenAfterQueries(A, queries));
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        return sumEvenAfterQueries2(A, queries);
    }



    // 计算出第一次，之后根据第一次的结果进行修正
    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int[] result = ArrayUtil.getArray(queries.length);
        A[queries[0][1]] = A[queries[0][1]] + queries[0][0];
        for (int i = 0; i < A.length; i++) {
            if ((1 & A[i]) == 0) result[0] += A[i];
        }
        int tmp;
        for (int i = 1; i < queries.length; ++i) {
            tmp = A[queries[i][1]] + queries[i][0];
            // 偶偶 偶奇 奇偶 奇奇
            if ((1 & tmp) == 0) {
                if ((1 & A[queries[i][1]]) == 0) {
                    result[i] = result[i - 1] - A[queries[i][1]] + tmp;
                } else {
                    result[i] = result[i - 1] + tmp;
                }
            } else if ((1 & A[queries[i][1]]) == 0) {
                result[i] = result[i - 1] - A[queries[i][1]];
            } else {
                result[i] = result[i - 1];
            }
            A[queries[i][1]] = tmp;
        }
        return result;
    }


    static int[] tmps = new int[10000];

    // 每次 计算新值，统计一次
    public int[] sumEvenAfterQueries1(int[] A, int[][] queries) {
        int[] result = ArrayUtil.getArray(queries.length);
        for (int i = 0; i < A.length; ++i) {
            tmps[i] = ((1 & A[i]) == 0) ? A[i] : 0;
        }
        for (int i = 0; i < queries.length; ++i) {
            A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
            tmps[queries[i][1]] = ((1 & A[queries[i][1]]) == 0) ? A[queries[i][1]] : 0;
            for (int j = 0; j < A.length; j++) {
                result[i] += tmps[j];
            }
        }
        for (int i = 0; i < A.length; tmps[i++] = 0);
        return result;
    }
}
