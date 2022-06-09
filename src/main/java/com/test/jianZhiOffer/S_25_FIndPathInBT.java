package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class S_25_FIndPathInBT {

    public void findPathInBT(BinaryTreeNode<Integer> root, int expoectSum) {
        if (null == root) return ;
        LinkedList<Integer> stack = new LinkedList<>();
        findPathInBTCore(root, expoectSum, stack, 0);
    }

    private void findPathInBTCore(BinaryTreeNode<Integer> node, int expoectSum, LinkedList<Integer> stack, int parentSum) {
        stack.addLast(node.getData());
        int currentSum = parentSum + node.getData();
        if (null == node.getLeftChild() && null == node.getRightChild()) {
            if (expoectSum == currentSum) {
                StringBuilder buffer = new StringBuilder();
                for (Integer value : stack) buffer.append(value).append(' ');
                log.info("Path: {}", buffer);
            }
        } else {
            if (null != node.getLeftChild()) {
                findPathInBTCore(node.getLeftChild(), expoectSum, stack, currentSum);
            }
            if (null != node.getRightChild()) {
                findPathInBTCore(node.getRightChild(), expoectSum, stack, currentSum);
            }
        }
        stack.removeLast();
    }

}
