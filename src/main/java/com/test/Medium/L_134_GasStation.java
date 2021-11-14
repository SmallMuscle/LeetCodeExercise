package com.test.Medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class L_134_GasStation {

    /**
     * question: 环形加油站，选取一个起始位置，加油去下一站，
     * 判断能否跑完一圈，结果保证唯一
     * 能：返回下标
     * 不能:返回-1
     * gas：每一站的油量
     * cost：到下一站消耗的油量
     *
     * eg:
     * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * Output: 3
     * Explanation:
     * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
     * Travel to station 4. Your tank = 4 - 1 + 5 = 8
     * Travel to station 0. Your tank = 8 - 2 + 1 = 7
     * Travel to station 1. Your tank = 7 - 3 + 2 = 6
     * Travel to station 2. Your tank = 6 - 4 + 3 = 5
     * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
     * Therefore, return 3 as the starting index.
     *
     * Input: gas = [2,3,4], cost = [3,4,3]
     * Output: -1
     * Explanation:
     * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
     * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
     * Travel to station 0. Your tank = 4 - 3 + 2 = 3
     * Travel to station 1. Your tank = 3 - 3 + 3 = 3
     * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
     * Therefore, you can't travel around the circuit once no matter where you start.
     *
     * analysis：显然 gas 数组之和小于 cost 数组之和直接返 -1
     * 否则呢？！
     * 大于等于 均可以跑完一圈，
     * 等于也会有不为一的结果，但是题目保证唯一。。
     * 1 0 2 0 2
     * 1 1 1 1 1
     *
     * 所以挨个儿试呗
     *
     * solution：从左到右遍历，记录开始的下标，油不够，就看下一站,
     * 初始化下标，直到最后
     * 同时记录数组 gas - cost 的和 sum
     * 若 sum < 0 返回  -1
     * 否则 返回上次记录的下标
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int resultIndex = 0;
        int tank = 0;
        int sum = 0;
        int left;
        for (int i = 0; i < gas.length; i++) {
            left = gas[i] - cost[i];
            tank += left;
            sum += left;
            if (tank < 0) {
                tank = 0;
                resultIndex = i + 1;
            }
        }
        return sum < 0 ? -1 : resultIndex;
    }

    @Test
    public void test1() {
        int[] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};
        log.info("test1 result: {}", canCompleteCircuit(gas, cost));
    }

    @Test
    public void test2() {
        int[] gas = new int[] {2,3,4};
        int[] cost = new int[] {3,4,3};
        log.info("test2 result: {}", canCompleteCircuit(gas, cost));
    }


}
