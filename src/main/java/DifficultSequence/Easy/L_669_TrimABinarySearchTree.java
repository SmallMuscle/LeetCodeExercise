package DifficultSequence.Easy;

import bean.Tree.binaryTree.TreeNode;
import utils.PrintUtil;

public class L_669_TrimABinarySearchTree {

    /*
        Given a binary search tree and the lowest and highest boundaries
        as L and R, trim the tree so that all its elements lies in [L, R]
        (R >= L). You might need to change the root of the tree, so the
        result should return the new root of the trimmed binary search tree.

        Example 1:
            Input:
                1
               / \
              0   2

              L = 1
              R = 2

            Output:
                1
                  \
                   2
        Example 2:
            Input:
                3
               / \
              0   4
               \
                2
               /
              1

              L = 1
              R = 3

            Output:
                  3
                 /
               2
              /
             1

     */

    public static void main(String[] args) {
        L_669_TrimABinarySearchTree l = new L_669_TrimABinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        int L = 1;
        int R = 2;
        PrintUtil.printTreeNode(l.trimBST(root, L, R));

        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        R = 3;
        PrintUtil.printTreeNode(l.trimBST(root, L, R));

    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        return trimBST1(root, L, R);
    }

    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (null != root) {
            if (root.val > L) {
                root.left = trimBST1(root.left, L, R);
            } else if (root.val < L) {
                root = trimBST1(root.right, L, R);
            } else root.left = null;

            if (root.val > R) {
                root = trimBST1(root.left, L, R);
            } else if (root.val < R) {
                root.right = trimBST1(root.right, L, R);
            } else root.right = null;
        }
        return root;
    }
}
