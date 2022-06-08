package com.test.jianZhiOffer;

import com.test.ds.list.LinkedList;
import com.test.ds.list.ListNode;
import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_17_Merge2SortedListTest {

    private S_17_Merge2SortedList solution = new S_17_Merge2SortedList();

    @Test
    public void merge2SortedListTest() {
        LinkedList<Integer> list1 = null;
        LinkedList<Integer> list2 = null;
        execTest(list1, list2);
        list1 = new LinkedList<>();
        execTest(list1, list2);
        list1.addTail(new ListNode<>(1));
        execTest(list1, list2);
        list1.addTail(new ListNode<>(3));
        list2 = new LinkedList<>();
        execTest(list1, list2);
        list1.addTail(new ListNode<>(5));
        list2.addTail(new ListNode<>(4));
        execTest(list1, list2);
        list2.clear();
        list2.addTail(new ListNode<>(0));
        list2.addTail(new ListNode<>(1));
        list2.addTail(new ListNode<>(2));
        list2.addTail(new ListNode<>(4));
        list2.addTail(new ListNode<>(6));
        execTest(list1, list2);
        list2.clear();
        list2.addTail(new ListNode<>(0));
        list1.clear();
        list1.addTail(new ListNode<>(0));
        execTest(list1, list2);
    }
    public void execTest(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        try {
            log.info("Merge: \n\tlist1 {}\n\tlist2 {}", list1, list2);
            LinkedList<Integer> result = CostTimeUtil.costMillisecond(() -> solution.merge(list1, list2));
            log.info("Result: {}", result);
        } catch (Exception e) {
            log.error("err: ", e);
        }
        log.info("");
    }

}
