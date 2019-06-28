package NumSequence;

import bean.ListNode;
import utils.PrintUtil;

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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        PrintUtil.printListNode(head);
        PrintUtil.printListNode(l.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        return reverseList1(head);
    }

    static ListNode result = null;

    // recursively
    public ListNode reverseList2(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode result = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    // iteratively
    public ListNode reverseList1(ListNode head) {
        ListNode first = head;
        ListNode second = null;
        ListNode third = null;
        for (;first != null;) {
            third = second;
            second = first;
            first = first.next;
            second.next = third;
        }
        return second;
    }
}
