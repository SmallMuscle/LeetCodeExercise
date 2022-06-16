package com.test.jianZhiOffer;

import com.test.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class S_28_Permutation {

    int lineSize = 100;

    public void permutation(String str) {
        if (StringUtil.isEmpty(str)) return ;
        char[] chs = str.toCharArray();
        StringBuilder printBuffer = new StringBuilder("\t");
        permutation(chs, 0, printBuffer);
        printBuffer(printBuffer);
    }

    private void permutation(char[] chs, int index, StringBuilder buffer) {
        if (index == chs.length - 1) {
            buffer.append(chs).append(' ');
        } else {
            for (int i = index; i < chs.length; i++) {
                char tmp = chs[index];
                chs[index] = chs[i];
                chs[i] = tmp;
                permutation(chs, index + 1, buffer);
                tmp = chs[index];
                chs[index] = chs[i];
                chs[i] = tmp;
            }
        }
    }

    public void combination(String str) {
        if (StringUtil.isEmpty(str)) return ;
        char[] chs = str.toCharArray();
        StringBuilder printBuffer = new StringBuilder("\t");
        for (int i = 1; i <= chs.length; i++) {
            combination(chs, 0, i, new StringBuilder(), printBuffer);
        }
        printBuffer(printBuffer);
    }

    private void combination(char[] chs, int start, int length, StringBuilder buffer, StringBuilder printBuffer) {
        buffer.append(chs[start++]);
        if (1 == length) {
            printBuffer.append(buffer).append(' ');
        } else {
            if (start != chs.length)
                combination(chs, start, length - 1, buffer, printBuffer);
        }
        buffer.deleteCharAt(buffer.length() - 1);
        if (start != chs.length)
            combination(chs, start, length, buffer, printBuffer);
    }

    public boolean permutationSum(int[] arrs) {
        if (null == arrs || 8 != arrs.length) return false;
        int[] tmpArrs = new int[arrs.length];
        System.arraycopy(arrs, 0, tmpArrs, 0, arrs.length);
        return permutationSum(tmpArrs, 0);
    }

    private boolean permutationSum(int[] arrs, int index) {
        if (index == arrs.length - 1) {
            if (arrs[0] + arrs[1] + arrs[2] + arrs[3] == arrs[4] + arrs[5] + arrs[6] + arrs[7]
                    && arrs[0] + arrs[1] + arrs[4] + arrs[5] == arrs[2] + arrs[3] + arrs[6] + arrs[7]
                    && arrs[0] + arrs[2] + arrs[4] + arrs[6] == arrs[1] + arrs[3] + arrs[5] + arrs[7]) {
                log.info("result: {}", arrs);
                return true;
            }
        } else {
            for (int i = index; i < arrs.length; i++) {
                int tmp = arrs[index];
                arrs[index] = arrs[i];
                arrs[i] = tmp;
                boolean result = permutationSum(arrs, index + 1);
                if (result) return true;
                tmp = arrs[index];
                arrs[index] = arrs[i];
                arrs[i] = tmp;
            }
        }
        return false;
    }

    private void printBuffer(StringBuilder buffer) {
        for (int insertLnIndex = lineSize - 1; insertLnIndex < buffer.length(); insertLnIndex += lineSize) {
            while (' ' != buffer.charAt(insertLnIndex)) --insertLnIndex;
            buffer.insert(insertLnIndex + 1, "\n\t");
        }
        log.info(buffer.toString());
    }

    public void nQuene(int n) {
        if (3 > n) return ;
        int[] queues = new int[n];
        for (int i = 0; i < n; ++i) queues[i] = i;
        List<int[]> result = new LinkedList<>();
        nQueueCore(queues, 0, result);
        printNqueue(result, n);
    }

    private void nQueueCore(int[] queues, int index, List<int[]> result) {
        if (index == queues.length - 1) {
            for (int i = 0; i < queues.length; i++) {
                for (int other = i + 1; other < queues.length; ++other) {
                    if (queues[other] == queues[i] + other - i || queues[other] == queues[i] - other + i) return ;
                }
            }
            int[] subResult = new int[queues.length];
            System.arraycopy(queues, 0, subResult, 0, queues.length);
            result.add(subResult);
        } else {
            for (int i = index; i < queues.length; i++) {
                int tmp = queues[i];
                queues[i] = queues[index];
                queues[index] = tmp;
                nQueueCore(queues, index + 1, result);
                tmp = queues[i];
                queues[i] = queues[index];
                queues[index] = tmp;
            }
        }
    }

    public void printNqueue(List<int[]> result, int n) {
        if (result.isEmpty()) {
            log.info("{} queues no result.", n);
        } else {
            int resultIndex = 1;
            StringBuilder buffer = new StringBuilder();
            for (Iterator<int[]> it = result.iterator(); it.hasNext();) {
                int[] subResult = it.next();
                buffer.append("\t").append(subResult.length).append(" queues result ").append(resultIndex++).append(":\n");
                for (int q = 0; q < subResult.length; ++q) {
                    buffer.append("\t\t").append(0 == q ? '┏' : '┣');
                    for (int top = subResult.length; top > 0; --top) buffer.append("━━━━━")
                            .append(0 == q ? (1 == top ? "┓\n" : '┳') : (1 == top ? "┫\n" : '╋'));
                    buffer.append("\t\t┃");
                    int headBlankNum = subResult[q];
                    int tailBlankNum = subResult.length - headBlankNum - 1;
                    for (; headBlankNum > 0; --headBlankNum) buffer.append("     ┃");
                    buffer.append("  *  ┃");
                    for (; tailBlankNum > 0; --tailBlankNum) buffer.append("     ┃");
                    buffer.append("\n");

                }
                buffer.append("\t\t").append('┗');
                for (int top = subResult.length; top > 0; --top) buffer.append("━━━━━")
                        .append(1 == top ? "┛\n" : '┻');
            }
            log.info(buffer.toString());
        }
    }

}
