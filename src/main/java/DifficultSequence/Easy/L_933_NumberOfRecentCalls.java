package DifficultSequence.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class L_933_NumberOfRecentCalls {

    /*
        2019.04.03

        Write a class RecentCounter to count recent requests.

        It has only one method: ping(int t), where t represents
        some time in milliseconds.

        Return the number of pings that have been made from 3000
        milliseconds ago until now.

        Any ping with time in [t - 3000, t] will count, including
        the current ping.

        It is guaranteed that every call to ping uses a strictly
        larger value of t than before.

        Example 1:
            Input: inputs = ["RecentCounter","ping","ping","ping","ping"],
                   inputs = [[],[1],[100],[3001],[3002]]
            Output: [null,1,2,3,3]
        Note:
            Each test case will have at most 10000 calls to ping.
            Each test case will call ping with strictly increasing values of t.
            Each call to ping will have 1 <= t <= 10^9.
     */

    public static void main(String[] args) {
        L_933_NumberOfRecentCalls.RecentCounter rc = new L_933_NumberOfRecentCalls().new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(2));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));

    }

    class RecentCounter {

        public RecentCounter() {

        }

        // 面向接口。。。
        private final Queue<Integer> list = new LinkedList();

        public int ping(int t) {
            list.add(t);
            while (list.size() > 0 && list.peek() < (t - 3000)) {
                list.poll();
            }
            return list.size();
        }
    }

}
