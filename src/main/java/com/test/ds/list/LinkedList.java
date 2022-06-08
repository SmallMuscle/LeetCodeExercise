package com.test.ds.list;


public class LinkedList<E> {

    private ListNode<E> emptyHead;

    public LinkedList() {
        emptyHead = new ListNode<>(null);
    }

    public ListNode<E> getEmptyHead() {
        return emptyHead;
    }

    public ListNode<E> getHead() {
        return emptyHead.getNext();
    }

    public E getHeadElement() {
        return null == emptyHead.getNext() ? null : emptyHead.getNext().getData();
    }

    public E popFirstElement() {
        if (null == emptyHead.getNext()) return null;
        ListNode<E> tmpNode = emptyHead.getNext();
        emptyHead.setNext(tmpNode.getNext());
        return tmpNode.getData();
    }

    public ListNode<E> getTail() {
        if (null == emptyHead.getNext()) return emptyHead.getNext();
        ListNode<E> cursor = emptyHead.getNext();
        while (null != cursor.getNext()) cursor = cursor.getNext();
        return cursor;
    }

    public ListNode<E> get(int pos) {
        if (0 > pos) throw new IndexOutOfBoundsException("pos must grant than 0.");
        ListNode<E> cursor = emptyHead.getNext();
        for (int i = 0; i < pos && null != cursor; i++) cursor = cursor.getNext();
        return cursor;
    }

    public LinkedList<E> addHead(ListNode<E> node) {
        if (null != node) {
            node.setNext(emptyHead.getNext());
            emptyHead.setNext(node);
        }
       return this;
    }

    public LinkedList<E> addTail(E element) {
        return addTail(new ListNode<>(element));
    }
    public LinkedList<E> addTail(ListNode<E> node) {
        ListNode<E> cursor = emptyHead;
        while (null != cursor.getNext()) cursor = cursor.getNext();
        cursor.setNext(node);
        node.setNext(null);
        return this;
    }

    public LinkedList<E> remove(ListNode<E> node) {
        if (null == node) return this;
        ListNode<E> cursor = emptyHead;
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
        if (null != emptyHead.getNext()) {
            ListNode<E> toDelNode = emptyHead.getNext();
            emptyHead.setNext(toDelNode.getNext());
            toDelNode.setNext(null);
        }
        return this;
    }

    public LinkedList<E> removeTail() {
        if (null != emptyHead.getNext()) {
            ListNode<E> cursor = emptyHead;
            while (null != cursor.getNext().getNext()) cursor = cursor.getNext();
            cursor.setNext(null);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("[ ");
        ListNode<E> cursor = emptyHead;
        do {
            buffer.append(cursor.getData());
            cursor = cursor.getNext();
        } while (null != cursor && null != buffer.append(", "));
        buffer.append(" ]");
        return buffer.toString();
    }

    public void clear() {
        this.getEmptyHead().setNext(null);
    }

    public boolean isNotEmpty() {
        return ! isEmpty();
    }

    public boolean isEmpty() {
        return null == emptyHead.getNext();
    }
}
