package com.test.Easy;

import com.test.ds.list.ListNode;
import com.test.utils.PrintUtil;

public class L_237_DeleteNodeInALinkedList {

    /*
        Write a function to delete a node (except the tail) in a singly linked list, given
        only access to that node.

        Given linked list -- head = [4,5,1,9], which looks like following:

        Example 1:
        Input: head = [4,5,1,9], node = 5
        Output: [4,1,9]
        Explanation: You are given the second node with value 5, the linked list should
        become 4 -> 1 -> 9 after calling your function.
        Example 2:
        Input: head = [4,5,1,9], node = 1
        Output: [4,5,9]
        Explanation: You are given the third node with value 1, the linked list should
        become 4 -> 5 -> 9 after calling your function.


        Note:
        The linked list will have at least two elements.
        All of the nodes' values will be unique.
        The given node will not be the tail and it will always be a valid node of the
        linked list.
        Do not return anything from your function.

     */

    public static void main(String[] args) {
        L_237_DeleteNodeInALinkedList l = new L_237_DeleteNodeInALinkedList();
        l.initListNode();
        PrintUtil.printList(head);
        l.deleteNode(node5);
        PrintUtil.printList(head);
        l.initListNode();
        PrintUtil.printList(head);
        l.deleteNode(node1);
        PrintUtil.printList(head);

    }

    private static ListNode<Integer> head;
    private static ListNode<Integer> node5;
    private static ListNode<Integer> node1;

    private void initListNode() {
        head = new ListNode(4);
        node5 = new ListNode(5);
        head.setNext(node5);
        node1 = new ListNode(1);
        head.getNext().setNext(node1);
        head.getNext().getNext().setNext(new ListNode(9));
    }

    public void deleteNode(ListNode<Integer> node) {
        deleteNode1(node);
    }


    public void deleteNode1(ListNode<Integer> node) {
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
    }
}
