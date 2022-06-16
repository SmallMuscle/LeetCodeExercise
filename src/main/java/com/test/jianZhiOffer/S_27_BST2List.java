package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class S_27_BST2List {

    public BinaryTreeNode<Integer> convert(BinaryTreeNode<Integer> root) {
        if (null == root) return null;
        return convertCore(root , new HashMap<>());
    }

    private BinaryTreeNode<Integer> convertCore(BinaryTreeNode<Integer> root,
                                                Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> lastMap) {
        BinaryTreeNode<Integer> newHead = null;
        if (null == root.getLeftChild()) {
            newHead = root;
        } else {
            newHead = convertCore(root.getLeftChild(), lastMap);
            BinaryTreeNode<Integer> headTail = lastMap.get(newHead);
            headTail.setRightChild(root);
            root.setLeftChild(headTail);
        }
        if (null == root.getRightChild()) {
            lastMap.put(newHead, root);
        } else {
            BinaryTreeNode<Integer> tailList = convertCore(root.getRightChild(), lastMap);
            lastMap.put(newHead, lastMap.get(tailList));
            root.setRightChild(tailList);
            tailList.setLeftChild(root);
        }
        return newHead;
    }

}
