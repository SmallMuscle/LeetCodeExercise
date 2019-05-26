package NumSequence;

import bean.Tree.binaryTree.TreeNode;
import utils.TreeUtil;

public class L_104_MaximumDepthOfBinaryTree {

    /*
        Given a binary tree, find its maximum depth.

        The maximum depth is the number of nodes along the longest path
        from the root node down to the farthest leaf node.

        Note: A leaf is a node with no children.

        Example:

            Given binary tree [3,9,20,null,null,15,7],
                3
               / \
              9  20
                /  \
               15   7
            return its depth = 3.

     */

    public static void main(String[] args) {
        L_104_MaximumDepthOfBinaryTree l = new L_104_MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(l.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        return maxDepth1(root);
    }

    public int maxDepth1(TreeNode root) {
        return TreeUtil.getTreeDepth(root);
    }
}
