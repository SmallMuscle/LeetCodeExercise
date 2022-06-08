package com.test.jianZhiOffer;

import com.test.ds.list.LinkedList;
import com.test.ds.list.ListNode;
import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_13_DeleteListNodeAtO1TimeTest {

    private S_13_DeleteListNodeAtO1Time solution = new S_13_DeleteListNodeAtO1Time();

    @Test
    public void deleteListNodeAtO1TimeTest() {
        LinkedList<Integer> list = null;
        execTest(list, null);
        list = new LinkedList<>();
        execTest(list, null);
        list.addTail(new ListNode<>(1));
        execTest(list, null);
        list.addTail(new ListNode<>(2));
        list.addTail(new ListNode<>(3));
        list.addTail(new ListNode<>(4));
        list.addTail(new ListNode<>(5));
        execTest(list, null);
        execTest(list, list.get(2));
        execTest(list, list.getHead());
        execTest(list, list.getTail());
    }

    public void execTest(LinkedList<Integer> list, ListNode<Integer> toBeDelete) {
        try {
            log.info("List: {} \t to be delete node: {}", list, toBeDelete);
            CostTimeUtil.costMillisecond(() -> solution.deleteNode(list, toBeDelete));
            log.info("Result list: {}", list);
        } catch (Exception e) {
            log.error("err: ", e);
        }
        log.info("");
    }

}
