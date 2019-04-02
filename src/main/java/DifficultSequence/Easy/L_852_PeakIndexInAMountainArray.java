package DifficultSequence.Easy;

public class L_852_PeakIndexInAMountainArray {

    /*
        2019.03.29

        Let's call an array A a mountain if the following properties hold:
            A.length >= 3
            There exists some 0 < i < A.length - 1 such that A[0] < A[1]
             < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
        Given an array that is definitely a mountain, return any i such
        that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

        Example 1:
            Input: [0,1,0]
            Output: 1
        Example 2:
            Input: [0,2,1,0]
            Output: 1
        Note:
            3 <= A.length <= 10000
            0 <= A[i] <= 10^6
            A is a mountain, as defined above.
     */

    public static void main(String[] args) {
        L_852_PeakIndexInAMountainArray l = new L_852_PeakIndexInAMountainArray();
        int[] A = {0,1,0};
        System.out.println(l.peakIndexInMountainArray(A));
        int[] B = {0,2,1,0};
        System.out.println(l.peakIndexInMountainArray(B));
        int[] C = {3,4,5,1};
        System.out.println(l.peakIndexInMountainArray(C));
        int[] D = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(l.peakIndexInMountainArray(D));
        int[] E = {18,29,38,59,98,100,99,98,90};
        System.out.println(l.peakIndexInMountainArray(E));
    }

    public int peakIndexInMountainArray(int[] A) {
        return peakIndexInMountainArray1(A);
    }

    public int peakIndexInMountainArray1(int[] A) {
        int result = 0;
        int start = 0;
        int end = A.length - 1;
        int len;
        do {
            len = (end + start) >> 1;
            if (A[len - 1] < A[len] && A[len] < A[len + 1]) {
                start = len + 1;
            } else if (A[len - 1] > A[len] && A[len] > A[len + 1]) {
                end = len - 1;
            } else if (A[len] > A[len - 1] && A[len] > A[len + 1]) {
                return len;
            }
            if (start == end) {
                return start;
            }
        } while (start < end);
        return result;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int result = 0;
        int start = 0;
        int end = A.length - 1;
        int len;
        do {
            len = (end + start) >> 1;
            if (A[len - 1] < A[len] && A[len] < A[len + 1]) {
                start = len;
            } else if (A[len - 1] > A[len] && A[len] > A[len + 1]) {
                end = len;
            } else if (A[len] > A[len - 1] && A[len] > A[len + 1]) {
                return len;
            }
        } while (start < end);
        return result;
    }

}
