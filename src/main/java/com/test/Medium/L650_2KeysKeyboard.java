package com.test.Medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class L650_2KeysKeyboard {

    /**
     * question: 初始有一个 A，仅存在两种操作
     * 一：copy
     * 二：paste
     * 给定最终的 A 的数量 n，
     * 返回 使用最少达到该数量的 操作的次数
     *
     * eg:
     * Input: 3
     * Output: 3
     * Explanation:
     * Intitally, we have one character 'A'.
     * In step 1, we use Copy All operation.
     * In step 2, we use Paste operation to get 'AA'.
     * In step 3, we use Paste operation to get 'AAA'.
     *
     * analysis:
     * cp cpp cppp
     *  2  3   4
     *
     *  经过 1 次 copy 1 次 paste 结果有 2 个
     *  经过 1 次 copy 2 次 paste 结果有 6 个
     *  经过 1 次 copy 3 次 paste 结果有 24 个
     * n = 2 * 3 * 4 = 24
     * copy 后 paste 会翻倍 <----------------------------------┐
     *                                                        |
     * cppp cp cpp                                            |
     *  4   2   3                                             |
     * n = 4 * 2 * 3 = 24                                     |
     * n 一定，copy、paste 组合 顺序变化不会影响结果，            |
     * copy、paste 组合的个数会影响，组合尽可能多，次数越少，毕竟  -┘
     * 组合多意味着因式不会很大，因式小，组合才多~
     *
     * solution：直接取 n 的因式呐
     * 从小到大取
     * 因数之和为 执行次数
     */
    public int minSteps(int n) {
        int result = 0;
        int i = 2;
        while (n > 1) {
            for (;(n % i) != 0; i++);
            n /= i;
            result += i;
        }
        return result;
    }

    public int minSteps1(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }

    @Test
    public void test() {
        int num = 0;
        /*log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 1;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 2;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 3;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 4;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 5;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 6;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 7;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 8;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 9;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 10;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        num = 16;
        log.info("num: {}\tmin step: {}", num, minSteps(num));*/
        num = 12;
        log.info("num: {}\tmin step: {}", num, minSteps(num));
        System.out.println("");
    }
}
