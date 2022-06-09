package com.test.ds.list;

import lombok.Data;

@Data
public class ComplexListNode<T> {

    private T data;
    private ComplexListNode<T> next;
    private ComplexListNode<T> sibling;

    public ComplexListNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data: " + data + "\tnext: " + (null == next ? null : next.getData()) + "\tsibling: " +
                (null == sibling ? null : sibling.getData());
    }
}
