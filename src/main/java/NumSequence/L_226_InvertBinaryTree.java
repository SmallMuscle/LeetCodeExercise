package NumSequence;

import bean.Tree.binaryTree.TreeNode;
import utils.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class L_226_InvertBinaryTree {

    /*
        Invert a binary tree.

        Example:

        Input:

                 4
               /   \
              2     7
             / \   / \
            1   3 6   9
        Output:

                 4
               /   \
              7     2
             / \   / \
            9   6 3   1
        Trivia:
        This problem was inspired by this original tweet by Max Howell:

        Google: 90% of our engineers use the software you wrote (Homebrew),
        but you can’t invert a binary tree on a whiteboard so f*** off.

     */

    public static void main(String[] args) {
        L_226_InvertBinaryTree l = new L_226_InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        PrintUtil.printTreeNode(root);
        PrintUtil.printTreeNode(l.invertTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        return invertTree2(root);
    }


    // iterative
    public TreeNode invertTree2(TreeNode root) {
        if (null != root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (! queue.isEmpty()) {
                TreeNode t = queue.poll();
                TreeNode tmp = t.left;
                t.left = t.right;
                t.right = tmp;
                if (null != t.left) queue.add(t.left);
                if (null != t.right) queue.add(t.right);
            }
        }
        return root;
    }

    // recursive
    public TreeNode invertTree1(TreeNode root) {
        if (null != root) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            if (null != root.left) invertTree1(root.left);
            if (null != root.right) invertTree1(root.right);
        }
        return root;
    }
}
