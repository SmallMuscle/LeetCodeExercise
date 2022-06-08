package com.test.jianZhiOffer;

import com.test.ds.list.LinkedList;
import com.test.ds.list.ListNode;
import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_16_ReverseListTest {

    private S_16_ReverseList solution = new S_16_ReverseList();

    @Test
    public void reverseListTest() {
        LinkedList<Integer> list = null;
        execTest(list);
        list = new LinkedList<>();
        execTest(list);
        list.addTail(new ListNode<>(5));
        execTest(list);
        list.addTail(new ListNode<>(4));
        execTest(list);
        list.addTail(new ListNode<>(3));
        execTest(list);
        list.addTail(new ListNode<>(2));
        execTest(list);
        list.addTail(new ListNode<>(1));
        execTest(list);
    }
    public void execTest(LinkedList<Integer> list) {
        try {
            log.info("Reverse list {}", list);
            CostTimeUtil.costMillisecond(() -> solution.reverseList(list));
            log.info("Result: {}", list);
        } catch (Exception e) {
            log.error("err: ", e);
        }
        log.info("");
    }

}
