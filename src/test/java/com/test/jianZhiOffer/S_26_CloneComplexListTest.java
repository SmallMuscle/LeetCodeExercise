package com.test.jianZhiOffer;

import com.test.ds.list.ComplexListNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_26_CloneComplexListTest {

    private S_26_CloneComplexList solution = new S_26_CloneComplexList();

    @Test
    public void cloneComplexListTest() {
        ComplexListNode<Integer> head = null;
        execTest(head);
        head = new ComplexListNode<>(1);
        execTest(head);
        head.setNext(new ComplexListNode<>(2));
        head.getNext().setNext(new ComplexListNode<>(3));
        head.setSibling(head.getNext().getNext());
        head.getNext().getNext().setNext(new ComplexListNode<>(4));
        head.getNext().getNext().getNext().setSibling(head.getNext());
        head.getNext().getNext().getNext().setNext(new ComplexListNode<>(5));
        head.getNext().getNext().getNext().getNext().setSibling(head.getNext());
        head.getNext().setSibling(head.getNext().getNext().getNext().getNext());
        execTest(head);
        head.setSibling(head);
        execTest(head);
        head.getNext().getNext().getNext().getNext().setNext(new ComplexListNode<>(6));
        execTest(head);
    }

    public void execTest(ComplexListNode<Integer> head) {
        log.info("-------------------------------------------------");
        try {
            PrintUtil.printList(head);
            ComplexListNode<Integer> result = CostTimeUtil.costMillisecond(() -> solution.cloneComplexList(head));
            PrintUtil.printList(head);
            PrintUtil.printList(result);
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
