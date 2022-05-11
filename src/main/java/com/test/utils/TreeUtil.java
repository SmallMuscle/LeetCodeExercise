package com.test.utils;

import com.test.bean.Tree.binaryTree.TreeNode;
import com.test.ds.tree.BinaryTreeNode;

public class TreeUtil {

    public static int getTreeDepth(TreeNode tn) {
        if (null == tn) return 0;
        int leftDepth = getTreeDepth(tn.left);
        int rightDepth = getTreeDepth(tn.right);
        return (Math.max(leftDepth, rightDepth)) + 1;
    }

    public static int getTreeDepth(BinaryTreeNode root) {
        if (null == root) return 0;
        int leftDepth = getTreeDepth(root.getLeftChild());
        int rightDepth = getTreeDepth(root.getRightChild());
        return (Math.max(leftDepth, rightDepth)) + 1;
    }
}
