package DifficultSequence.Easy;

import java.util.HashMap;
import java.util.Map;

public class L_169_MajorityElement {

    /*
        Given an array of size n, find the majority element. The majority
        element is the element that appears more than ⌊ n/2 ⌋ times.

        You may assume that the array is non-empty and the majority element
        always exist in the array.

        Example 1:
            Input: [3,2,3]
            Output: 3
        Example 2:
            Input: [2,2,1,1,1,2,2]
            Output: 2

     */

    public static void main(String[] args) {
        L_169_MajorityElement l = new L_169_MajorityElement();
        int[] nums1 = {3,2,3};
        System.out.println(l.majorityElement(nums1));
        int[] nums2 = {2,2,1,1,1,2,2};
        System.out.println(l.majorityElement(nums2));
    }

    public int majorityElement(int[] nums) {
        return majorityElement2(nums);
    }

    public int majorityElement1(int[] nums) {
        if (1 == nums.length) return nums[0];
        int num = (nums.length >> 1) + 1;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int c = map.get(nums[i]) + 1;
                if (c >= num) return nums[i];
                map.put(nums[i], c);
            } else map.put(nums[i], 1);
        }
        return 0;
    }


    public int majorityElement2(int[] nums) {
        int c = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) ++c;
            else {
                --c;
                if (0 == c) {
                    candidate = nums[++i];
                    ++c;
                }
            }
        }
        return candidate;
    }

}
