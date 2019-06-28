package DifficultSequence.Easy;

import utils.PrintUtil;

public class L_283_MoveZeroes {

    /*
        Given an array nums, write a function to move all 0's to the end of it
        while maintaining the relative order of the non-zero elements.

        Example:
        Input: [0,1,0,3,12]
        Output: [1,3,12,0,0]

        Note:
        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.
     */

    public static void main(String[] args) {
        L_283_MoveZeroes l = new L_283_MoveZeroes();
        int[] nums = {0,1,0,3,12};
        PrintUtil.printArray(nums);
        l.moveZeroes(nums);
        PrintUtil.printArray(nums);
    }

    public void moveZeroes(int[] nums) {
        moveZeroes2(nums);
    }

    public void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (++index; index < nums.length ; ++index) {
                    if (nums[index] != 0) {
                        nums[i] = nums[index];
                        nums[index] = 0;
                        break;
                    }
                }
            } else ++index;
        }
    }

    public void moveZeroes1(int[] nums) {
        int index = 0;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) tmp[index++] = nums[i];
        }
        if (index != nums.length) System.arraycopy(tmp, 0, nums, 0, tmp.length);
    }


}
