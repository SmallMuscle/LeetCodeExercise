package com.test.Medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class L_166_FractionToRecurringDecimal {

    /**
     * question：已知分子 numerator 分母denominator (均为 int)
     * 返回对应的小数(String)，若是循环小数，循环部分用()扩住
     *
     * eg：
     * Input: numerator = 1, denominator = 2
     * Output: "0.5"
     * Input: numerator = 2, denominator = 3
     * Output: "0.(6)"
     * Input: numerator = 4, denominator = 333
     * Output: "0.(012)"
     * Input: numerator = 1, denominator = 5
     * Output: "0.2"
     *
     * analysis：先取余，余数为0，则可以整除，直接返回结果
     * 否则呢，存在小数，除法运算记录结果整数部分，
     * 小数部分，分子补0直到大于分母，除法得到小数位，
     * 余数继续补0，直到大于分母，直到余数为0或除法后的结果循环
     * 要如何判断除法后的结果循环呢？！
     * 余数，余数出现相同的时候就是开始循环的时候
     *
     * solution：
     * 将分子分母使用 long 类型存储
     * 计算余数，若余数为 0，则返回 String.value(商);
     * 若不为 0，使用 StringBuilder 存储运算结果
     * 商为 0，且分子分母异号时，直接除 - 就没了 。。。得单独处理
     * 其余情况，直接 append(商).append('.')
     * 分子分母正数处理
     * 模拟除法竖式，余数补 0，除以除数 。。。
     * 使用 Map<余数, 该余数第一次产生时对应结果的长度> 存储每次运算的余数，及相应的 index
     * 直到遇到再次出现的余数或余数为 0
     * 若余数为 0，小数不循环，直接 append(商)，返回即可
     * 若遇到相同的余数时，说明是循环小数，
     * 从 map.get(余数) 开始插入 '('，末尾append(')')，返回
     */
    public String fractionToDecimal(int numerator, int denominator) {
        /**
         * [注]
         * int 类型
         * -2^31 / -1 = -2^31
         * -2^31 * -1 = -2^31
         */
        long num = numerator;
        long den = denominator;
        if ((num % den) == 0) return String.valueOf(num/ den);
        StringBuilder result = new StringBuilder();
        long rst = num  / den;
        if (0 == rst && num * den < 0) {
            result.append('-');
        }
        result.append(rst).append('.');

        num = num < 0 ? num * -1 : num;
        den = den < 0 ? den * -1 : den;

        long rem = num % den;
        Map<Long, Integer> remMap = new HashMap();

        while (rem != 0) {
            if (remMap.containsKey(rem)) {
                result.insert(remMap.get(rem).intValue(), '(')
                    .append(')');
                break;
            } else {
                remMap.put(rem, result.length());
                rem *= 10;
                rst = rem / den;
                result.append(rst);
                rem %= den;
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        log.info("result: {}", fractionToDecimal(1, 2));
        log.info("result: {}", fractionToDecimal(2, 1));
        log.info("result: {}", fractionToDecimal(2, 3));
        log.info("result: {}", fractionToDecimal(4, 9));
        log.info("result: {}", fractionToDecimal(-4, 9));
        log.info("result: {}", fractionToDecimal(4, 333));
        log.info("result: {}", fractionToDecimal(1, 5));
        log.info("result: {}", fractionToDecimal(17, 9));
        log.info("result: {}", fractionToDecimal(-17, 9));
        log.info("result: {}", fractionToDecimal(0, 9));
        log.info("result: {}", fractionToDecimal(100, -3));
        log.info("result: {}", fractionToDecimal(-100, 3));
        log.info("result: {}", fractionToDecimal(-100, -3));
        log.info("result: {}", fractionToDecimal(100, 3));
        log.info("result: {}", fractionToDecimal(1, 6));
        log.info("result: {}", fractionToDecimal(-2147483648, -1));
    }

    @Test
    public void hint() {
        log.info("{}", (4 % 9));
        log.info("{}", (4 % 333));
        log.info("{}", (100 % 3));
    }

    @Test
    public void operator() {
        log.info("{}", 0 ^ 0);
        log.info("{}", 1 ^ 0);
        log.info("{}", 0 ^ 1);
        log.info("{}", 1 ^ 1);

        log.info("{}", Integer.toBinaryString(-2147483648));
        log.info("{}", Long.toBinaryString(-2147483648));
        log.info("{}", -2 * -1);
        log.info("{}", -2);
        log.info("{}", -2147483648 * -1);
        log.info("{}", -2147483648);
    }
}
