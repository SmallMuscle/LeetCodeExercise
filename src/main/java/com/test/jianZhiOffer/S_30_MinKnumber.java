package com.test.jianZhiOffer;

import com.test.ds.Pile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_30_MinKnumber {

    public void minKnumberByPartition(int[] arrs, int k) {
        if (null == arrs || 0 == arrs.length || k < 1 || k > arrs.length) return ;
        int start = 0;
        int end = arrs.length - 1;
        int index = partition(arrs, 0, start,  end);
        while (k != index) {
            if (index > k) end = index - 1;
            else start = index + 1;
            index = partition(arrs, start, start, end);
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < k; i++) buffer.append(arrs[i]).append(' ');
        log.info("Result: {}", buffer);
    }

    private int partition(int[] arrs, int index, int start, int end) {
        int tmp = arrs[index];
        arrs[index] = arrs[end];
        arrs[end] = tmp;
        index = end--;
        int sLimit = start;
        int eLimit = end;
        while (start < end) {
            while (start <= eLimit && arrs[start] <= arrs[index]) ++start;
            while (end >= sLimit && arrs[end] > arrs[index]) --end;
            if (start < end) {
                tmp = arrs[start];
                arrs[start] = arrs[end];
                arrs[end] = tmp;
            }
        }
        tmp = arrs[start];
        arrs[start] = arrs[index];
        arrs[index] = tmp;
        return start;
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
        log.info("Pile: {}", bigPile);
        StringBuilder buffer = new StringBuilder();
        while (! bigPile.isEmpty()) {
            buffer.append(bigPile.removeHead()).append(' ');
        }
        log.info("Result: {}", buffer);
    }

}
