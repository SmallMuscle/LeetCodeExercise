package NumSequence;

import java.util.HashMap;
import java.util.Map;

public class L_1029_TwoCityScheduling {

    /*
        There are 2N people a company is planning to interview. The cost
        of flying the i-th person to city A is costs[i][0], and the cost
        of flying the i-th person to city B is costs[i][1].

        Return the minimum cost to fly every person to a city such that
        exactly N people arrive in each city.

        Example 1:
        Input: [[10,20],[30,200],[400,50],[30,20]]
        Output: 110
        Explanation:
        The first person goes to city A for a cost of 10.
        The second person goes to city A for a cost of 30.
        The third person goes to city B for a cost of 50.
        The fourth person goes to city B for a cost of 20.
        The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half
        the people interviewing in each city.

        Note:
        1 <= costs.length <= 100
        It is guaranteed that costs.length is even.
        1 <= costs[i][0], costs[i][1] <= 1000

     */

    public static void main(String[] args) {
        L_1029_TwoCityScheduling l = new L_1029_TwoCityScheduling();
        int[][] costs1 = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(l.twoCitySchedCost(costs1));
        int[][] costs2 = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println(l.twoCitySchedCost(costs2));
    }

    public int twoCitySchedCost(int[][] costs) {
        return twoCitySchedCost1(costs);
    }

    public int twoCitySchedCost1(int[][] costs) {
        int result = 0;
        int num = costs.length >> 1;
        int[] index = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            if (0 == i) index[i] = costs[i][0] - costs[i][1];
            else {
                int ind = costs[i][0] - costs[i][1];
                int j = i - 1;
                int[] tmp = costs[i];
                for (; j >= 0; --j) {
                    if (index[j] > ind) {
                        index[j + 1] = index[j];
                        costs[j + 1] = costs[j];
                    }
                    else break;
                }
                index[j + 1] = ind;
                costs[j + 1] = tmp;
            }
        }
        for (int i = 0; i < costs.length; i++) {
            result += i < num ? costs[i][0] : costs[i][1];
        }
        return result;
    }
}
