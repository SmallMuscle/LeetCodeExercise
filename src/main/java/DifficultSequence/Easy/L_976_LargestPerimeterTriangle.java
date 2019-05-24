package DifficultSequence.Easy;

import java.util.Arrays;

public class L_976_LargestPerimeterTriangle {

    /*
        Given an array A of positive lengths, return the largest perimeter(周长)
        of a triangle(三角形   ) with non-zero area, formed from 3 of these lengths.

        If it is impossible to form any triangle of non-zero area, return 0.

        Example 1:
        Input: [2,1,2]
        Output: 5
        Example 2:
        Input: [1,2,1]
        Output: 0
        Example 3:
        Input: [3,2,3,4]
        Output: 10
        Example 4:
        Input: [3,6,2,3]
        Output: 8


        Note:
        3 <= A.length <= 10000
        1 <= A[i] <= 10^6

     */

    public static void main(String[] args) {
        L_976_LargestPerimeterTriangle l = new L_976_LargestPerimeterTriangle();
        int[] A1 = {2,1,2};
        System.out.println(l.largestPerimeter(A1));
        int[] A2 = {1,2,1};
        System.out.println(l.largestPerimeter(A2));
        int[] A3 = {3,2,3,4};
        System.out.println(l.largestPerimeter(A3));
        int[] A4 = {3,6,2,3};
        System.out.println(l.largestPerimeter(A4));
    }

    public int largestPerimeter(int[] A) {
        return largestPerimeter1(A);
    }

    public int largestPerimeter1(int[] A) {
        int result = 0;
        if (A.length == 3) {
            if (isTriangle(A[0], A[1], A[2])) {
                result = A[0] + A[1] + A[2];
            }
        } else if (A.length > 3) {
            Arrays.sort(A);
            for (int i = A.length - 1; i > 1; --i) {
                if (isTriangle(A[i], A[i - 1], A[i - 2])) {
                    result = A[i] + A[i - 1] + A[i - 2];
                    break;
                }
            }
        }
        return result;
    }

    private boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && c + b > a;
    }

}
