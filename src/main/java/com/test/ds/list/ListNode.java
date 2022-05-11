package com.test.ds.list;

import lombok.Data;

@Data
public class ListNode<T> {

    private T data;

    private ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
    }
}
