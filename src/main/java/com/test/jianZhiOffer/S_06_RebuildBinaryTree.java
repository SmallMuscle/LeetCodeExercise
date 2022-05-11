package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S_06_RebuildBinaryTree {

    /**
     * Question: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建出图 static/images/S_06_RebuildBinaryTree_01.jpg 所示的二叉树并输出它的头结点。
     *
     * Analysis:
     * 前序遍历 可知 root 结点位置
     * 中序遍历 可区分 左右子树
     */

    public BinaryTreeNode<Integer> construct(int[] preOrder, int[] inOrder) {
        if (null == preOrder || null == inOrder || 0 == preOrder.length || preOrder.length != inOrder.length) {
            log.error("Empty input.");
            return null;
        }
        try {
            return buildBinaryTree(preOrder, 0,
                    inOrder, 0, inOrder.length - 1);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    private BinaryTreeNode<Integer> buildBinaryTree(int[] preOrder, int preStart,
                                                    int[] inOrder, int inStart, int inEnd) {
        // 前序 确定 root
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(preOrder[preStart]);
        // 中序 确定 左右子树
        int i;
        for (i = inStart; i <= inEnd && preOrder[preStart] != inOrder[i]; ++i);
        if (i >= inOrder.length || preOrder[preStart] != inOrder[i]) throw new RuntimeException("Invalid input.");
        if (inStart < i) {
            node.setLeftChild(buildBinaryTree(preOrder, preStart + 1, inOrder, inStart, i - 1));
        }
        if (inEnd > i) {
            node.setRightChild(buildBinaryTree(preOrder, preStart + 1 + i - inStart, inOrder, i + 1, inEnd));
        }
        return node;
    }

}