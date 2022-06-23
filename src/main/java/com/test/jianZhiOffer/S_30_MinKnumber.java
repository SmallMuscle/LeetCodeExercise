package com.test.jianZhiOffer;

import com.test.ds.Pile;
import com.test.utils.ArrayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class S_30_MinKnumber {

    public void minKnumberByPartition(int[] arrs, int k) {
        if (null == arrs || 0 == arrs.length || k < 1 || k > arrs.length) return ;
        StringBuilder buffer = new StringBuilder();
        if (arrs.length == k) {
            Arrays.stream(arrs).forEach(e -> buffer.append(e).append(' '));
        } else {
            int start = 0;
            int end = arrs.length - 1;
            int index = partition(arrs, 0, start, end);
            while (k != index) {
                if (index > k) end = index - 1;
                else start = index + 1;
                index = partition(arrs, start, start, end);
            }
            for (int i = 0; i < k; i++) buffer.append(arrs[i]).append(' ');
        }
        log.info("Result: {}", buffer);
    }

    private int partition(int[] arrs, int index, int start, int end) {
        if (start == end) return start;
        ArrayUtil.swap(arrs, index, end);
        int small = start;
        for (int i = start; i < end; i++) {
            if (arrs[i] < arrs[end]) {
                if (small != i) ArrayUtil.swap(arrs, i, small);
                ++small;
            }
        }
        ArrayUtil.swap(arrs, small, end);
        return small;
    }

    public void minKnumberByPile(int[] arrs, int k) {
        if (null == arrs || 0 == arrs.length || k < 1 || k > arrs.length) return ;
        Pile<Integer> bigPile = new Pile<>(k, true);
        for (int i = 0; i < arrs.length; i++) {
            if (bigPile.isFull()) {
                int bigElement = bigPile.getHead();
                if (arrs[i] < bigElement) {
                    bigPile.removeHead();
                    bigPile.add(arrs[i]);
                }
            } else {
                bigPile.add(arrs[i]);
            }
        }
        log.info("Pile: {}", bigPile.toTreeString());
        StringBuilder buffer = new StringBuilder();
        while (! bigPile.isEmpty()) {
            buffer.append(bigPile.removeHead()).append(' ');
        }
        log.info("Result: {}", buffer);
    }

}
