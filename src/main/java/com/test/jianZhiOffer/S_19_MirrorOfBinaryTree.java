package com.test.jianZhiOffer;

import com.test.ds.list.LinkedList;
import com.test.ds.list.ListNode;
import com.test.ds.tree.BinaryTreeNode;

public class S_19_MirrorOfBinaryTree {

    public void mirrorOfBinaryTree(BinaryTreeNode<Integer> root) {
        //mirrorOfBinaryTreeRecursion(root);
        mirrorOfBinaryTreeIteration(root);
    }

    private void mirrorOfBinaryTreeIteration(BinaryTreeNode<Integer> root) {
        if (null == root) return ;
        LinkedList<BinaryTreeNode<Integer>> list = new LinkedList<>();
        list.addTail(root);
        while (list.isNotEmpty()) {
            BinaryTreeNode<Integer> node = list.popFirstElement();
            boolean existsChild = false;
            if (null != node.getLeftChild()) {
                existsChild = true;
                list.addTail(node.getLeftChild());
            }
            if (null != node.getRightChild()) {
                existsChild = true;
                list.addTail(node.getRightChild());
            }
            if (existsChild) {
                BinaryTreeNode<Integer> tmpChild = node.getLeftChild();
                node.setLeftChild(node.getRightChild());
                node.setRightChild(tmpChild);
            }
        }
    }

    private void mirrorOfBinaryTreeRecursion(BinaryTreeNode<Integer> root) {
        if (null == root || (null == root.getLeftChild() && null == root.getRightChild())) return ;
        BinaryTreeNode<Integer> tmp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(tmp);
        mirrorOfBinaryTree(root.getLeftChild());
        mirrorOfBinaryTree(root.getRightChild());
    }



}
