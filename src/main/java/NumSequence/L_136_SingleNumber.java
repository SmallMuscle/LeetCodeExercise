package NumSequence;

public class L_136_SingleNumber {

    /*
        Given a non-empty array of integers, every element appears twice except for one. Find that single one.

        Note:
            Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:
            Input: [2,2,1]
            Output: 1
        Example 2:
            Input: [4,1,2,1,2]
            Output: 4

     */

    public static void main(String[] args) {
        L_136_SingleNumber l = new L_136_SingleNumber();
        int[] nums1 = {2,2,1};
        System.out.println(l.singleNumber(nums1));
        int[] nums2 = {4,1,2,1,2};
        System.out.println(l.singleNumber(nums2));
    }


    public int singleNumber(int[] nums) {
        return singleNumber1(nums);
    }

    public int singleNumber1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
