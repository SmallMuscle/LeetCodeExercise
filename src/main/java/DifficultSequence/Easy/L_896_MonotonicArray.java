package DifficultSequence.Easy;

public class L_896_MonotonicArray {

    /*
        An array is monotonic if it is either monotone increasing or monotone decreasing.

        An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is
        monotone decreasing if for all i <= j, A[i] >= A[j].

        Return true if and only if the given array A is monotonic.

        Example 1:
            Input: [1,2,2,3]
            Output: true
        Example 2:
            Input: [6,5,4,4]
            Output: true
        Example 3:
            Input: [1,3,2]
            Output: false
        Example 4:
            Input: [1,2,4,5]
            Output: true
        Example 5:
            Input: [1,1,1]
            Output: true

        Note:
            1 <= A.length <= 50000
            -100000 <= A[i] <= 100000

     */

    public static void main(String[] args) {
        L_896_MonotonicArray l = new L_896_MonotonicArray();
        int[] A1 = {1,2,2,3};
        System.out.println(l.isMonotonic(A1));
        int[] A2 = {6,5,4,4};
        System.out.println(l.isMonotonic(A2));
        int[] A3 = {1,3,2};
        System.out.println(l.isMonotonic(A3));
        int[] A4 = {1,2,4,5};
        System.out.println(l.isMonotonic(A4));
        int[] A5 = {1,1,1};
        System.out.println(l.isMonotonic(A5));
    }

    public boolean isMonotonic(int[] A) {
        return isMonotonic1(A);
    }

    public boolean isMonotonic1(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] > 0) {
                for (i += 1; i < A.length - 1; i++) {
                    if (A[i + 1] - A[i] < 0) return false;
                }
            } else if (A[i + 1] - A[i] < 0){
                for (i += 1; i < A.length - 1; i++) {
                    if (A[i + 1] - A[i] > 0) return false;
                }
            } else continue;
        }
        return true;
    }

}
