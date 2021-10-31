package com.test.Easy;

import com.test.utils.PrintUtil;
import com.test.bean.Tree.binaryTree.TreeNode;

public class L_965_UnivaluedBinaryTree {

    /*
        2019.04.12

        A binary tree is univalued if every node in the tree has the same value.

        Return true if and only if the given tree is univalued.

        Example 1:
            Input: [1,1,1,1,1,null,1]
            Output: true
        Example 2:
            Input: [2,2,2,5,2]
            Output: false

        Note:
            The number of nodes in the given tree will be in the range [1, 100].
            Each node's value will be an integer in the range [0, 99].

     */

    public static void main(String[] args) {
        L_965_UnivaluedBinaryTree l = new L_965_UnivaluedBinaryTree();
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(1);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(1);
        tree1.right.right = new TreeNode(1);

        PrintUtil.printTreeNode(tree1);
        System.out.println(l.isUnivalTree(tree1));


        tree1 = new TreeNode(2);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(5);
        tree1.left.right = new TreeNode(2);
        PrintUtil.printTreeNode(tree1);
        System.out.println(l.isUnivalTree(tree1));
    }

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree1(root);
    }

    public boolean isUnivalTree1(TreeNode root) {
        if (null != root) {
            if (null != root.left && root.left.val != root.val) {
                return false;
            }
            if (null != root.right && root.right.val != root.val) {
                return false;
            }
            return isUnivalTree1(root.left) && isUnivalTree1(root.right);
        }
        return true;
    }

}
