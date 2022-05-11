package com.test.jianZhiOffer;

import com.test.ds.list.ListNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import org.junit.jupiter.api.Test;

public class S_05_PrintListFromTail2HeadTest {

    private S_05_PrintListFromTail2Head solution = new S_05_PrintListFromTail2Head();

    @Test
    public void printListFromTail2HeadTest() {
        ListNode<Integer> head = null;
        execTest(head);
        head = new ListNode<>(0);
        execTest(head);
        head.setNext(new ListNode<>(1));
        execTest(head);
        head.getNext().setNext(new ListNode<>(2));
        execTest(head);
        head.getNext().getNext().setNext(new ListNode<>(3));
        execTest(head);
    }

    private void execTest(ListNode<Integer> head) {
        PrintUtil.printList(head);
        CostTimeUtil.costMillisecond(() -> solution.printListFromTail2Head(head), "printListFromTail2Head");
        CostTimeUtil.costMillisecond(() -> solution.printListFromTail2HeadRecursive(head), "printListFromTail2HeadRecursive");
    }
}
