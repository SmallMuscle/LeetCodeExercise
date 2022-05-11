package com.test.Easy;

import com.test.ds.list.ListNode;
import com.test.utils.PrintUtil;

public class L_206_ReverseLinkedList {

    /*

        Reverse a singly linked list.

        Example:
            Input: 1->2->3->4->5->NULL
            Output: 5->4->3->2->1->NULL

        Follow up:
            A linked list can be reversed either iteratively or recursively. Could you implement both?

     */

    public static void main(String[] args) {
        L_206_ReverseLinkedList l = new L_206_ReverseLinkedList();
        ListNode<Integer> head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        head.getNext().getNext().getNext().setNext(new ListNode(5));
        PrintUtil.printList(head);
        PrintUtil.printList(l.reverseList(head));
    }

    public ListNode<Integer> reverseList(ListNode<Integer> head) {
        return reverseList1(head);
    }

    static ListNode result = null;

    // recursively
    public ListNode<Integer> reverseList2(ListNode<Integer> head) {
        if (null == head || null == head.getNext()) return head;
        ListNode result = reverseList2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return result;
    }

    // iteratively
    public ListNode<Integer> reverseList1(ListNode<Integer> head) {
        ListNode<Integer> first = head;
        ListNode<Integer> second = null;
        ListNode<Integer> third = null;
        for (;first != null;) {
            third = second;
            second = first;
            first = first.getNext();
            second.setNext(third);
        }
        return second;
    }
}
