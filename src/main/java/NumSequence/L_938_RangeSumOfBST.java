package NumSequence;

import bean.TreeNode;
import utils.PrintUtil;

public class L_938_RangeSumOfBST {

    /*
        Given the root node of a binary search tree, return the sum of
        values of all nodes with value between L and R (inclusive).

        The binary search tree is guaranteed to have unique values.

        Example 1:
            Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
                            10
                           /  \
                          5    15
                         / \     \
                        3   7     18
            Output: 32
        Example 2:
            Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
                                 10
                               /    \
                              5      15
                            /  \    /  \
                           3    7  13   18
                          /    /
                         1    6
            Output: 23


        Note:
            The number of nodes in the tree is at most 10000.
            The final answer is guaranteed to be less than 2^31.
     */

    public static void main(String[] args) {
        L_938_RangeSumOfBST l = new L_938_RangeSumOfBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        int L = 7;
        int R = 15;
        PrintUtil.printTreeNode(root);
        System.out.println(l.rangeSumBST(root, L, R));
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(13);
        L = 6;
        R = 10;
        PrintUtil.printTreeNode(root);
        System.out.println(l.rangeSumBST(root, L, R));
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        return rangeSumBST2(root, L, R);
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (null == root)
            return 0;
        if (root.val >= L && root.val <= R)
            return root.val + rangeSumBST2(root.left, L, R) + rangeSumBST2(root.right, L, R);
        else if (root.val < L)
            return rangeSumBST2(root.right, L, R);
        else
            return rangeSumBST2(root.left, L, R);
    }

    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (null == root)
            return 0;
        if (root.val >= L && root.val <= R)
            return root.val + rangeSumBST1(root.left, L, R) + rangeSumBST1(root.right, L, R);
        else
            return rangeSumBST1(root.left, L, R) + rangeSumBST1(root.right, L, R);
    }
}
