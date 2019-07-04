package NumSequence;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class L_448_FindAllNumbersDisappearedInAnArray {

    /*

        Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
        some elements appear twice and others appear once.

        Find all the elements of [1, n] inclusive that do not appear in
        this array.

        Could you do it without extra space and in O(n) runtime? You may
        assume the returned list does not count as extra space.

        Example:
            Input:
            [4,3,2,7,8,2,3,1]
            Output:
            [5,6]

     */

    public static void main(String[] args) {
        L_448_FindAllNumbersDisappearedInAnArray l = new L_448_FindAllNumbersDisappearedInAnArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        PrintUtil.printList(l.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        return findDisappearedNumbers1(nums);
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            while (nums[index - 1] != nums[i]) {
                int tmp = nums[index - 1];
                nums[index - 1] = nums[i];
                nums[i] = tmp;
                index = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = i + 1;
            if (num != nums[i]) result.add(num);
        }
        return result;
    }

}
