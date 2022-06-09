package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class S_23_PrintFromTop2Bottom {

    public void printFromTop2Bottom(BinaryTreeNode<Integer> root) {
        if (null == root) return ;
        StringBuilder buffer = new StringBuilder();
        List<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.remove(0);
            buffer.append(node.getData()).append(' ');
            if (null != node.getLeftChild()) queue.add(node.getLeftChild());
            if (null != node.getRightChild()) queue.add(node.getRightChild());
        }
        log.info("result: {}", buffer);
    }

}
