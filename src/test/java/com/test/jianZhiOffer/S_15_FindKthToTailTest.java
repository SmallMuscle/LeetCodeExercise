package com.test.jianZhiOffer;

import com.test.ds.list.LinkedList;
import com.test.ds.list.ListNode;
import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.function.Function;

@Slf4j
public class S_15_FindKthToTailTest {

    private S_15_FindKthToTail solution = new S_15_FindKthToTail();

    @Test
    public void findKthToTailTest() {
        LinkedList<Integer> list = null;
        int k = -1;
        execTest(list, k);
        list = new LinkedList<>();
        execTest(list, k);
        list.addTail(new ListNode<>(5));
        execTest(list, k);
        list.addTail(new ListNode<>(4));
        k = 0;
        execTest(list, k);
        list.addTail(new ListNode<>(3));
        k = 1;
        execTest(list, k);
        list.addTail(new ListNode<>(2));
        k = 4;
        execTest(list, k);
        list.addTail(new ListNode<>(1));
        k = 5;
        execTest(list, k);
        k = 6;
        execTest(list, k);
        k = 10;
        execTest(list, k);
    }
    public void execTest(LinkedList<Integer> list, int k) {
        try {
            log.info("The {}th to list {} tail.", k, list);
            ListNode<Integer> result = CostTimeUtil.costMillisecond(
                    () -> solution.findKthToTail(null == list ? null : list.getHead(), k));
            log.info("Result: {}", result);
        } catch (Exception e) {
            log.error("err: ", e);
        }
        log.info("");
    }

}
