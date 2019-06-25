package DifficultSequence.Easy;

import utils.PrintUtil;

public class L_1089_DuplicateZeros {

    /*
        Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

        Note that elements beyond the length of the original array are not written.

        Do the above modifications to the input array in place, do not return anything from your function.

        Example 1:
            Input: [1,0,2,3,0,4,5,0]
            Output: null
            Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
        Example 2:
            Input: [1,2,3]
            Output: null
            Explanation: After calling your function, the input array is modified to: [1,2,3]

        Note:
            1 <= arr.length <= 10000
            0 <= arr[i] <= 9

     */

    public static void main(String[] args) {
        L_1089_DuplicateZeros l = new L_1089_DuplicateZeros();
        int[] arr1 = {1,0,2,3,0,4,5,0};
        l.duplicateZeros(arr1);
        PrintUtil.printArray(arr1);

        int[] arr2 = {1,2,3};
        l.duplicateZeros(arr2);
        PrintUtil.printArray(arr2);
    }

    public void duplicateZeros(int[] arr) {
        duplicateZeros2(arr);
    }

    public void duplicateZeros2(int[] arr) {
        int[] tmp = new int[arr.length];
        int interval = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (arr[i - interval] != 0) tmp[i] = arr[i - interval];
            else {
                tmp[i] = 0;
                if (++i >= tmp.length) break;
                tmp[i] = 0;
                ++interval;
            }
        }
        System.arraycopy(tmp, 0, arr, 0, tmp.length);
    }

    public void duplicateZeros1(int[] arr) {
        int zeroSequenceNum = 1;
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] == 0) {
                if (arr[i + 1] != 0) {
                    shiftNum(arr, i + 1, zeroSequenceNum);
                    for (int j = 1; i + j < arr.length && j <= zeroSequenceNum; j++) {
                        arr[i + j] = 0;
                    }
                    i += zeroSequenceNum;
                    zeroSequenceNum = 1;
                } else {
                    ++zeroSequenceNum;
                }
            }
        }
    }

    private void shiftNum(int[] arr, int start, int interval) {
        if (arr.length - start > interval) {
            for (int i = arr.length - 1; i > start; --i) {
                arr[i] = arr[i - interval];
            }
        } else {
            for (int i = start; i < arr.length; i++) {
                arr[i] = 0;
            }
        }
    }





}
