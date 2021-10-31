package com.test.Easy;

public class L_1051_HeightChecker_doubt {

    /*
        Students are asked to stand in non-decreasing order of heights for an annual photo.

        Return the minimum number of students not standing in the right positions.  (This
        is the number of students that must move in order for all students to be standing
        in non-decreasing order of height.)

        Example 1:
            Input: [1,1,4,2,1,3]
            Output: 3
            Explanation:
            Students with heights 4, 3 and the last 1 are not standing in the right positions.

            // doubt: I think the output shoud be 2, just 4, 2 ...

        Note:
            1 <= heights.length <= 100
            1 <= heights[i] <= 100

     */

    public static void main(String[] args) {
        L_1051_HeightChecker_doubt l = new L_1051_HeightChecker_doubt();
        int[] heights = {1,1,4,2,1,3};
        System.out.println(l.heightChecker(heights));
    }

    public int heightChecker(int[] heights) {
        return heightChecker1(heights);
    }

    public int heightChecker1(int[] heights) {

        return 0;
    }


}
