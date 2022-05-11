package com.test.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BinaryTreeNode<T> {

    T data;

    BinaryTreeNode<T> leftChild;

    BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
