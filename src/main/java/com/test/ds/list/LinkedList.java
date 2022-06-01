package com.test.ds.list;


public class LinkedList<E> {

    private ListNode<E> head;

    public LinkedList() {
        head = new ListNode<>(null);
    }

    public ListNode<E> getEmptyHead() {
        return head;
    }

    public ListNode<E> getHead() {
        return head.getNext();
    }

    public ListNode<E> getTail() {
        if (null == head.getNext()) return head.getNext();
        ListNode<E> cursor = head.getNext();
        while (null != cursor.getNext()) cursor = cursor.getNext();
        return cursor;
    }

    public ListNode<E> get(int pos) {
        if (0 > pos) throw new IndexOutOfBoundsException("pos must grant than 0.");
        ListNode<E> cursor = head.getNext();
        for (int i = 0; i < pos && null != cursor; i++) cursor = cursor.getNext();
        return cursor;
    }

    public LinkedList<E> addHead(ListNode<E> node) {
        if (null != node) {
            node.setNext(head.getNext());
            head.setNext(node);
        }
       return this;
    }
    public LinkedList<E> addTail(ListNode<E> node) {
        ListNode<E> cursor = head;
        while (null != cursor.getNext()) cursor = cursor.getNext();
        cursor.setNext(node);
        node.setNext(null);
        return this;
    }

    public LinkedList<E> remove(ListNode<E> node) {
        if (null == node) return this;
        ListNode<E> cursor = head;
        while (null != cursor.getNext()) {
            if (node == cursor.getNext()) {
                cursor.setNext(node.getNext());
                node.setNext(null);
                break;
            }
        }
        return this;
    }

    public LinkedList<E> removeHead() {
        if (null != head.getNext()) {
            ListNode<E> toDelNode = head.getNext();
            head.setNext(toDelNode.getNext());
            toDelNode.setNext(null);
        }
        return this;
    }

    public LinkedList<E> removeTail() {
        if (null != head.getNext()) {
            ListNode<E> cursor = head;
            while (null != cursor.getNext().getNext()) cursor = cursor.getNext();
            cursor.setNext(null);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("[ ");
        ListNode<E> cursor = head;
        do {
            buffer.append(cursor.getData());
            cursor = cursor.getNext();
        } while (null != cursor && null != buffer.append(", "));
        buffer.append(" ]");
        return buffer.toString();
    }

}
