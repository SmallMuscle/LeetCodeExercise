package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;

import java.util.Objects;

public class S_18_HaveSubTree {

    public boolean haveSubTree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> subRoot) {
        if (null == subRoot) return true;
        if (null == root) return false;
        if ((Objects.equals(root.getData(), subRoot.getData()) && (doesHaveSubTree(root, subRoot)))
                || haveSubTree(root.getLeftChild(), subRoot)
                || haveSubTree(root.getRightChild(), subRoot)) return true;
        return false;
    }

    private boolean doesHaveSubTree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> subRoot) {
        if (null == subRoot) return true;
        if (null == root) return false;
        if (Objects.equals(root.getData(), subRoot.getData())) {
            boolean leftMatch = doesHaveSubTree(root.getLeftChild(), subRoot.getLeftChild());
            boolean rightMatch = doesHaveSubTree(root.getRightChild(), subRoot.getRightChild());
            return leftMatch && rightMatch;
        } else return false;
    }

}
