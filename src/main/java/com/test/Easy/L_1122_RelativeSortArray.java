package com.test.Easy;

import utils.PrintUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class L_1122_RelativeSortArray {

    /*
        Given two arrays arr1 and arr2, the elements of arr2 are distinct,
        and all elements in arr2 are also in arr1.

        Sort the elements of arr1 such that the relative ordering of items
        in arr1 are the same as in arr2.  Elements that don't appear in arr2
        should be placed at the end of arr1 in ascending order.

        Example 1:
            Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
            Output: [2,2,2,1,4,3,3,9,6,7,19]

        Constraints:
            arr1.length, arr2.length <= 1000
            0 <= arr1[i], arr2[i] <= 1000
            Each arr2[i] is distinct.
            Each arr2[i] is in arr1.

     */

    public static void main(String[] args) {
        L_1122_RelativeSortArray l = new L_1122_RelativeSortArray();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        PrintUtil.printArray(l.relativeSortArray(arr1, arr2));
        int[] arr3 = {3,19,7,29,5,17,49,45,31,44};
        int[] arr4 = {7,3,5,29,19};
        PrintUtil.printArray(l.relativeSortArray(arr3, arr4));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return relativeSortArray3(arr1, arr2);
    }


    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        if (arr1.length > 1) {
            Map<Integer, Integer> index = new HashMap<>(arr2.length);
            for (int i = 0; i < arr2.length; i++) {
                index.put(arr2[i], i);
            }
            int endIndex = arr1.length - 1;
            for (int i = 0; i <= endIndex; i++) {
                int target = arr1[i];
                if (index.containsKey(target)) {
                    int j;
                    for (j = i - 1; j >= 0; --j) {
                        if (index.get(target).intValue() < index.get(arr1[j]).intValue()) {
                            arr1[j + 1] = arr1[j];
                        } else break;
                    }
                    arr1[j + 1] = target;
                } else {
                    if (i == endIndex) break;
                    if (index.containsKey(arr1[endIndex])) {
                        exchangeElement(arr1, i, endIndex);
                    } else {
                        exchangeElement(arr1, i, endIndex - 1);
                        int j;
                        for (j = endIndex; j < arr1.length; j++) {
                            if (arr1[j] < target) arr1[j - 1] = arr1[j];
                            else break;
                        }
                        arr1[j -1] = target;
                        --endIndex;
                    }
                    --i;
                }
            }
        }
        return arr1;
    }

    // inspired by Discuss
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        if (arr1.length > 1) {
            TreeMap<Integer, Integer> index = new TreeMap<>();
            for (int i = 0; i < arr1.length; i++) {
                index.put(arr1[i], index.containsKey(arr1[i]) ? index.get(arr1[i]) + 1 : 1);
            }
            int i = 0;
            for (int j = 0; j < arr2.length; j++) {
                int n = index.get(arr2[j]);
                for (int k = 0; k < n; k++) arr1[i++] = arr2[j];
                index.remove(arr2[j]);
            }
            Iterator<Integer> it = index.keySet().iterator();
            while (it.hasNext()) {
                int key = it.next();
                for (int j = 0; j < index.get(key); j++) {
                    arr1[i++] = key;
                }
            }
        }
        return arr1;
    }

    // inspired by Discuss
    public int[] relativeSortArray3(int[] arr1, int[] arr2) {
        if (arr1.length > 1) {
            int[] tmp = new int[1001];
            for (int i = 0; i < arr1.length; i++) {
                ++tmp[arr1[i]];
            }
            int index = 0;
            for (int i = 0; i < arr2.length; i++) {
                while (0 != tmp[arr2[i]]) {
                    arr1[index++] = arr2[i];
                    --tmp[arr2[i]];
                }
            }
            for (int i = 0; i < tmp.length; i++) {
                while (0 != tmp[i]) {
                    arr1[index++] = i;
                    --tmp[i];
                }
            }
        }
        return arr1;
    }








    private static void exchangeElement(int[] dest, int a, int b) {
        if (dest != null && a >= 0 && b <= dest.length) {
            if (a != b) {
                int tmp = dest[a];
                dest[a] = dest[b];
                dest[b] = tmp;
            }
        }
    }
}
