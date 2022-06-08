package com.test.jianZhiOffer;

import com.test.ds.list.LinkedList;
import com.test.ds.list.ListNode;

public class S_16_ReverseList {

    public void reverseList(LinkedList<Integer> list) {
        if (null == list || null == list.getHead()) return ;
        ListNode<Integer> newHead;
        newHead = reverseIteration(list.getHead());
        //newHead = reverseRecursion(list.getHead());
        list.getEmptyHead().setNext(newHead);
    }

    private ListNode<Integer> reverseIteration(ListNode<Integer> head) {
        if (null == head || null == head.getNext()) return head;
        ListNode<Integer> newHead = null,
                newTail = null,
                lastNode = head;
        while (null != lastNode) {
            newTail = newHead;
            newHead = lastNode;
            lastNode = lastNode.getNext();
            newHead.setNext(newTail);
        }
        return newHead;
    }

    private ListNode<Integer> reverseRecursion(ListNode<Integer> head) {
         if (null == head.getNext()) return head;
         ListNode<Integer> newHead = reverseRecursion(head.getNext());
         head.getNext().setNext(head);
         head.setNext(null);
         return newHead;
    }


}
