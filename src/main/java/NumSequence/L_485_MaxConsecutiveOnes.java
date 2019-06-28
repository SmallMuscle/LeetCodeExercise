package NumSequence;

public class L_485_MaxConsecutiveOnes {

    /*
        Given a binary array, find the maximum number of consecutive 1s in this array.

        Example 1:
            Input: [1,1,0,1,1,1]
            Output: 3
            Explanation: The first two digits or the last three digits are consecutive 1s.
                The maximum number of consecutive 1s is 3.
        Note:
            The input array will only contain 0 and 1.
            The length of input array is a positive integer and will not exceed 10,000

     */

    public static void main(String[] args) {
        L_485_MaxConsecutiveOnes l = new L_485_MaxConsecutiveOnes();
        int[] nums = {1,1,0,1,1,1};
        System.out.println(l.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        return findMaxConsecutiveOnes1(nums);
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (tmp > result) result = tmp;
                tmp = 0;
            } else {
                ++tmp;
            }
        }
        if (tmp > result) result = tmp;
        return result;
    }


}
