package com.test.jianZhiOffer;

import com.test.ds.list.ComplexListNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_26_CloneComplexList {

    public ComplexListNode<Integer> cloneComplexList(ComplexListNode<Integer> head) {
        if (null == head) return null;
        cloneNode(head);
        fixSibling(head);
        return splitResult(head);
    }

    private void cloneNode(ComplexListNode<Integer> head) {
        ComplexListNode<Integer> cursor = head;
        while (null != cursor) {
            ComplexListNode<Integer> newNode = new ComplexListNode<>(cursor.getData());
            newNode.setNext(cursor.getNext());
            cursor.setNext(newNode);
            cursor = newNode.getNext();
        }
    }

    private void fixSibling(ComplexListNode<Integer> head) {
        ComplexListNode<Integer> cursor = head;
        while (null != cursor) {
            if (null != cursor.getSibling()) {
                cursor.getNext().setSibling(cursor.getSibling().getNext());
            }
            cursor = cursor.getNext().getNext();
        }
    }

    private ComplexListNode<Integer> splitResult(ComplexListNode<Integer> head) {
        ComplexListNode<Integer> newHead = head.getNext();
        ComplexListNode<Integer> cursor = head;
        while (null != cursor) {
            ComplexListNode<Integer> newNode = cursor.getNext();
            cursor.setNext(newNode.getNext());
            if (null != cursor.getNext()) newNode.setNext(cursor.getNext().getNext());
            cursor = cursor.getNext();
        }
        return newHead;
    }
}
