package com.test.jianZhiOffer;

import com.test.ds.list.ListNode;

import java.util.Stack;

public class S_05_PrintListFromTail2Head {

    /**
     * Question: 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
     *
     * Emample:
     * Input: 1 -> 2 -> 3
     * Output: 3 2 1
     *
     * Analysis:
     * 先进后出 stack
     * 循环、递归均可
     */

    public void printListFromTail2Head(ListNode<Integer> head) {
        if (null == head) return ;
        Stack<Integer> stack = new Stack<>();
        ListNode<Integer> node = head;
        do {
            stack.push(node.getData());
            node = node.getNext();
        } while (null != node);
        while (! stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }

    public void printListFromTail2HeadRecursive(ListNode<Integer> head) {
        printListFromTail2HeadRecursiveCore(head);
        System.out.println();
    }

    public void printListFromTail2HeadRecursiveCore(ListNode<Integer> head) {
        if (null == head) return ;
        printListFromTail2HeadRecursiveCore(head.getNext());
        System.out.print(head.getData() + " ");
    }

}
