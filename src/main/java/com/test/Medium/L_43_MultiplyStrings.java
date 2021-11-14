package com.test.Medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class L_43_MultiplyStrings {

    /**
     * question：输入两个 String 类型的数（均为非负）
     * 返回 String 类型的乘法的结果
     *
     * eg：
     * Input: num1 = "2", num2 = "3"
     * Output: "6"
     *
     * Input: num1 = "123", num2 = "456"
     * Output: "56088"
     *
     * analysis：
     * 模拟乘法竖式计算
     *
     * solution：
     * 记录两数长度，结果最长为两数长度之和
     * 若长度小于等于 18，说明可以被 long 表示，则转为 long，计算结果并 format 为 String
     * 若长度大于 18，long 可能表示不了了
     * 将入参分割为多个 9 位 long，进行竖式乘法
     * 分割时，数字低位储存在分割结果的低位，
     * 按块乘，结果存储在一个 long 数组里，
     * 同时取余到 9 位，进位加入下一块
     * 最终将结果按块格式格式化为 String，
     * 首位无需处理，非首位不满 9 位补 0
     */

    public String multiply(String num1, String num2) {
        int longMaxLen = 18;
        int blockSize = longMaxLen >> 1;
        int resultLen = num1.length() + num2.length();
        if (resultLen <= longMaxLen) {
            long resultLong = Long.valueOf(num1) * Long.valueOf(num2);
            return Long.toString(resultLong);
        }

        String zero = "0";
        if (zero.equals(num1) || zero.equals(num2)) {
            return zero;
        }
        long[] nums1 = splitArray(num1, blockSize);
        long[] nums2 = splitArray(num2, blockSize);
        int block = nums1.length + nums2.length;
        long[] result = new long[block];

        long carryBorder = 1;
        for (int i = 0; i < blockSize; i++) {
            carryBorder *= 10;
        }

        int resultIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                long subRst = nums1[i] * nums2[j];
                long carry = subRst / carryBorder;
                subRst %= carryBorder;
                resultIndex = i + j;
                result[resultIndex] += subRst;
                carry += result[resultIndex] / carryBorder;
                result[resultIndex] %= carryBorder;
                result[++resultIndex] += carry;

            }
        }

        StringBuilder resultStr = new StringBuilder(result.length * blockSize);
        String subRstStr;

        while (resultIndex >= 0 && result[resultIndex] == 0) {
            --resultIndex;
        }
        resultStr.append(result[resultIndex]);
        while (--resultIndex >= 0) {
            subRstStr = Long.toString(result[resultIndex]);
            resultStr.append(fillZero(subRstStr, blockSize));
        }
        return resultStr.toString();
    }

    // 比较慢呐。。
    /*public String multiply(String num1, String num2) {
        // 题目已知不可考虑负数
        *//*boolean negative1 = false, negative2 = false, addNegative;
        if (num1.startsWith("-")) {
            negative1 = true;
            num1 = num1.substring(1);
        }
        if (num2.startsWith("-")) {
            negative2 = true;
            num2 = num2.substring(1);
        }
        addNegative = negative1 ^ negative2;
*//*
        int longMaxLen = 18;
        int blockSize = longMaxLen >> 1;
        int resultLen = num1.length() + num2.length();
        if (resultLen <= longMaxLen) {
            long resultLong = Long.valueOf(num1) * Long.valueOf(num2);
            return Long.toString(*//*addNegative ? (~ resultLong) + 1 : *//*resultLong);
        }

        long[] nums1 = splitArray(num1, blockSize);
        long[] nums2 = splitArray(num2, blockSize);
        char[] result = new char[*//*addNegative ? resultLen + 1 : *//*resultLen];

        List<Long>[] resultList = new List[nums1.length + nums2.length - 1];
        for (int i = 0; i < resultList.length; i++) {
            resultList[i] = new LinkedList();
        }

        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                Long subRst = nums1[i] * nums2[j];
                String subRstStr = subRst.toString();
                String carry = null;
                if (subRstStr.length() > blockSize) {
                    int ind = subRstStr.length() - blockSize;
                    carry = subRstStr.substring(0, ind);
                    subRstStr = subRstStr.substring(ind);
                }

                int carryIndex = i + j;
                if (carryIndex == resultList.length - 1) {
                    String rst = subRstStr;
                    if (rst.length() < blockSize) {
                        rst = fillZero(rst, blockSize);
                    }
                    copyToArray(result, result.length - blockSize, rst);
                } else {
                    resultList[carryIndex + 1].add(Long.valueOf(subRstStr));
                }
                if (null != carry) {
                    resultList[carryIndex].add(Long.valueOf(carry));
                }
            }
        }

        int insertIndex = 0;
        for (int i = resultList.length - 1; i >= 0; i--) {
            Long subRst = 0L;
            for (Long num : resultList[i]) {
                subRst += num;
            }
            String subRstStr = subRst.toString();

            String carry = null;
            if (subRstStr.length() > blockSize) {
                int ind = subRstStr.length() - blockSize;
                carry = subRstStr.substring(0, ind);
                subRstStr = subRstStr.substring(ind);
            }

            insertIndex = result.length - blockSize * (resultList.length - i + 1);
            if (insertIndex > 0) {
                if (i != 0) {
                    subRstStr = fillZero(subRstStr, blockSize);
                }
                copyToArray(result, insertIndex, subRstStr);
                if (null != carry) {
                    resultList[i - 1].add(Long.valueOf(carry));
                }
            } else {
                insertIndex = result.length - blockSize * (resultList.length - i) - subRstStr.length();
                if (insertIndex >= 0) {
                    copyToArray(result, insertIndex, subRstStr);
                }
            }
        }
        *//*if (addNegative) {
            int i;
            for (i = 0; i < result.length; i++) {
                if ( result[i] >= '0' && result[i] <= '9') {
                    break;
                }
            }
            copyToArray(result, i - 1, "-");
        }*//*
        int startIndex = 0;
        for (; startIndex < result.length
                && (result[startIndex] <= '0'
                || result[startIndex] > '9'); startIndex++);
        return new String(result, startIndex, result.length - startIndex);
    }
*/

    private long[] splitArray(String str, int block) {
        int num = str.length() / block;
        if ((str.length() % block) != 0) {
            num += 1;
        }
        long[] rst = new long[num];
        int startIndex, lastIndex = str.length();
        for (int i = 0; i < num; i++) {
            startIndex = str.length() - (i + 1) * block;
            if (startIndex < 0) startIndex = 0;
            rst[i] = Long.valueOf(str.substring(startIndex, lastIndex));
            lastIndex = startIndex;
        }
        return rst;
    }

    public void copyToArray(char[] chs, int index, String str) {
        for (int i = 0; i < str.length(); i++) {
            chs[index + i] = str.charAt(i);
        }
    }

    private String fillZero(String num, int len) {
        if (num.length() < len) {
            StringBuilder strb = new StringBuilder(len);
            for (int i = len - num.length(); i > 0; i--)
                strb.append('0');
            return strb.append(num).toString();
        }
        return num;
    }

    @Test
    public void multiplyTest() {
        String n1 = "22";
        String n2 = "3";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "12345678";
        n2 = "87654321";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "1234567890";
        n2 = "9876543210";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "123456789000000";
        n2 = "987654321000000";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "12000000000000000";
        n2 = n1;
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "498828660196";
        n2 = "840477629533";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));

/*        n1 = "-12345678";
        n2 = "87654321";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "-1234567890";
        n2 = "9876543210";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "-123456789000000";
        n2 = "987654321000000";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "-12000000000000000";
        n2 = "12000000000000000";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));

        n1 = "12345678";
        n2 = "-87654321";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "1234567890";
        n2 = "-9876543210";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "123456789000000";
        n2 = "-987654321000000";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "12000000000000000";
        n2 = "-12000000000000000";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));

        n1 = "-12345678";
        n2 = "-87654321";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "-1234567890";
        n2 = "-9876543210";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "-123456789000000";
        n2 = "-987654321000000";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));
        n1 = "-12000000000000000";
        n2 = n1;
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));

        n1 = "18582506933032752";
        n2 = "366213329703";
        log.info("{} * {} = {}", n1, n2, multiply(n1, n2));*/
    }

    @Test
    public void xorTest() {
        log.info("{}", true ^ true);
        log.info("{}", true ^ false);
        log.info("{}", false ^ true);
        log.info("{}", false ^ false);
    }

    @Test
    public void intMaxTest() {
        log.info("{}", -1 >>> 1);
    }

    @Test
    public void negitiveTest() {
        int a = 1;
        long start, end;
        start = System.nanoTime();
        log.info("{}", -a);
        end = System.nanoTime();
        log.info("{}",  end - start);
        log.info("{}", ~ a + 1);
        log.info("{}", System.nanoTime() - end);
    }

    @Test
    public void charCompareTest() {
        char[] chs = new char[1];
        log.info("###{}###", (byte)chs[0]);
        log.info("###{}###", (byte)'0');
        log.info("###{}###", (byte)'9');
        log.info("###{}###", chs[0] >= '0');
        log.info("###{}###", chs[0] <= '9');
    }
}
