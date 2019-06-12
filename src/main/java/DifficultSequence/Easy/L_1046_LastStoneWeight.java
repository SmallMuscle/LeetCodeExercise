package DifficultSequence.Easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L_1046_LastStoneWeight {

    /*
        We have a collection of rocks, each rock has a positive integer weight.

        Each turn, we choose the two heaviest rocks and smash(粉碎) them together.
        Suppose the stones have weights x and y with x <= y.  The result of this
        smash is:

        If x == y, both stones are totally destroyed;
        If x != y, the stone of weight x is totally destroyed, and the stone of
        weight y has new weight y-x.
        At the end, there is at most 1 stone left.  Return the weight of this
        stone (or 0 if there are no stones left.)



        Example 1:
            Input: [2,7,4,1,8,1]
            Output: 1
        Explanation:
            We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
            we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
            we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
            we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

        Note:
            1 <= stones.length <= 30
            1 <= stones[i] <= 1000

     */

    public static void main(String[] args) {
        L_1046_LastStoneWeight l = new L_1046_LastStoneWeight();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(l.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        return lastStoneWeight1(stones);
    }

    // inspried by Discuss
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) queue.offer(s);
        while (1 != queue.size()) queue.offer(queue.poll() - queue.poll());
        return queue.poll();
    }

    public int lastStoneWeight1(int[] stones) {
        if (1 == stones.length) return stones[0];
        Arrays.sort(stones);
        while (0 != stones[stones.length - 2]) {
            for (int i = stones.length - 1; i > 0; i--) {
                stones[i] = stones[i] > stones[i - 1] ? stones[i] - stones[i - 1] : stones[i - 1] - stones[i];
                stones[i - 1] = 0;
            }
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }

}
