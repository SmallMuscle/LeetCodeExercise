package com.test.dsTest.tree;

import com.test.bean.Tree.binaryTree.TreeNode;
import com.test.utils.PrintUtil;
import sun.reflect.generics.tree.Tree;

public class TreeTest {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        PrintUtil.printTreeNode(node1);
        transferToList(node1);
        PrintUtil.printTreeNode(node1);

    }

    public static TreeNode transferToList(TreeNode root) {
        if (null == root) return null;
        if (null != root.left && null != root.right) {
            TreeNode last = transferToList(root.left);
            transferToList(root.right);
            last.right = root.right;
            root.right = root.left;
            root.left = null;
            return transferToList(last.right);
        } else if (null != root.left) {
            root.right = root.left;
            root.left = null;
            return transferToList(root.right);
        } else if (null != root.right) {
            return transferToList(root.right);
        } else {
            return root;
        }
    }
}
