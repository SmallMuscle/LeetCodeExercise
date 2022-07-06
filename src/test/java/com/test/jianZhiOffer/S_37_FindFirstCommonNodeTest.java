package com.test.jianZhiOffer;

import com.test.ds.list.ListNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_37_FindFirstCommonNodeTest {

    private S_37_FindFirstCommonNode solution = new S_37_FindFirstCommonNode();

    @Test
    public void findFirstCommonNodeTest() {
        ListNode<Integer> l1 = null;
        ListNode<Integer> l2 = null;
        execTest(l1, l2, null);
        l1 = new ListNode<>(1);
        l2 = new ListNode<>(4);
        execTest(l1, l2, null);
        l1.setNext(new ListNode<>(2));
        l2.setNext(new ListNode<>(5));
        execTest(l1, l2, null);
        l1.getNext().setNext(new ListNode<>(3));
        execTest(l1, l2, null);
        l1.getNext().getNext().setNext(new ListNode<>(6));
        l2.getNext().setNext(l1.getNext().getNext().getNext());
        execTest(l1, l2, l1.getNext().getNext().getNext());
        l2.getNext().getNext().setNext(new ListNode<>(7));
        execTest(l1, l2, l1.getNext().getNext().getNext());
    }

    public void execTest(ListNode<Integer> l1, ListNode<Integer> l2, ListNode<Integer> expect) {
        log.info("-------------------------------------------------");
        try {
            ListNode<Integer> result = CostTimeUtil.costMillisecond(() -> solution.findFirstCommonNode(l1, l2));
            log.info("List1: ");
            PrintUtil.printList(l1);
            log.info("List2: ");
            PrintUtil.printList(l2);
            log.info("First common node is {}", result);
            log.info("Result is {}correct.", result == expect ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
