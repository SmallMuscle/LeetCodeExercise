package DifficultSequence.Easy;

import utils.PrintUtil;
import utils.TreeNode;

public class L_617_MergeTwoBinaryTrees {

    /*
        2019.03.27

        Given two binary trees and imagine that when you put one of
        them to cover the other, some nodes of the two trees are
        overlapped while the others are not.

        You need to merge them into a new binary tree. The merge rule
        is that if two nodes overlap, then sum node values up as the new
        value of the merged node. Otherwise, the NOT null node will be
        used as the node of new tree.

        Example 1:
            Input:
            	Tree 1                     Tree 2
                      1                         2
                     / \                       / \
                    3   2                     1   3
                   /                           \   \
                  5                             4   7
            Output:
                Merged tree:
                	     3
                	    / \
                	   4   5
                	  / \   \
                	 5   4   7

        Note: The merging process must start from the root nodes of both trees.

     */

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        PrintUtil.printTreeNode(t1);

        PrintUtil.printTreeNode(t2);

        L_617_MergeTwoBinaryTrees l = new L_617_MergeTwoBinaryTrees();
        TreeNode t3 = l.mergeTrees(t1, t2);
        PrintUtil.printTreeNode(t3);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return mergeTrees1(t1, t2);
    }

    // 合并到 t1
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        } else if (null == t1 && null != t2) {
            return t2;
        } else if (null != t1 && null == t2) {
            return t1;
        } else {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees1(t1.left, t2.left);
            t1.right = mergeTrees1(t1.right, t2.right);
            return t1;
        }
    }


}
