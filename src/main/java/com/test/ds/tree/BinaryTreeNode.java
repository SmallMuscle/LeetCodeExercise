package com.test.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class BinaryTreeNode<T> {

    T data;

    BinaryTreeNode<T> leftChild;

    BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ! getClass().equals(o.getClass())) return false;
        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return null == data ? 0 : data.hashCode();
    }
}
