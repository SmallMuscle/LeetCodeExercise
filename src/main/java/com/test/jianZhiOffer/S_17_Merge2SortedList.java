package com.test.jianZhiOffer;

import com.test.ds.list.LinkedList;
import com.test.ds.list.ListNode;

public class S_17_Merge2SortedList {

    public LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;
        ListNode<Integer> newHead = mergeIteration(list1.getHead(), list2.getHead());
        //ListNode<Integer> newHead = mergeRecursion(list1.getHead(), list2.getHead());
        list1.getEmptyHead().setNext(newHead);
        return list1;
    }

    private ListNode<Integer> mergeIteration(ListNode<Integer> node1, ListNode<Integer> node2) {
        if (null == node1) return node2;
        if (null == node2) return node1;
        ListNode<Integer> newHead;
        if (node1.getData() > node2.getData()) {
            newHead = node2;
            node2 = node2.getNext();
        } else {
            newHead = node1;
            node1 = node1.getNext();
        }
        ListNode<Integer> cursor = newHead;
        while (null != node1 && null != node2) {
            if (node1.getData() > node2.getData()) {
                cursor.setNext(node2);
                node2 = node2.getNext();
            } else {
                cursor.setNext(node1);
                node1 = node1.getNext();
            }
            cursor = cursor.getNext();
        }
        if (null != node1) cursor.setNext(node1);
        else if (null != node2) cursor.setNext(node2);
        return newHead;
    }

    private ListNode<Integer> mergeRecursion(ListNode<Integer> node1, ListNode<Integer> node2) {
        if (null == node1) return node2;
        if (null == node2) return node1;
        if (node1.getData() > node2.getData()) {
            ListNode<Integer> newTail = mergeRecursion(node1, node2.getNext());
            node2.setNext(newTail);
            return node2;
        } else {
            ListNode<Integer> newTail = mergeRecursion(node1.getNext(), node2);
            node1.setNext(newTail);
            return node1;
        }
    }

}
