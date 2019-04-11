package NumSequence;

import sun.reflect.generics.tree.Tree;
import utils.PrintUtil;
import utils.TreeNode;

public class L_700_SearchInABinarySearchTree {

    /*
        2019.04.11

        Given the root node of a binary search tree (BST) and a value.
        You need to find the node in the BST that the node's value equals
        the given value. Return the subtree rooted with that node. If
        such node doesn't exist, you should return NULL.

        For example,
            Given the tree:
                       4
                      / \
                     2   7
                    / \
                   1   3

            And the value to search: 2
            You should return this subtree:

                      2
                     / \
                    1   3
        In the example above, if we want to search the value 5, since
        there is no node with value 5, we should return NULL.

        Note that an empty tree is represented by NULL, therefore you
        would see the expected output (serialized tree format) as [],
        not null.

     */

    public static void main(String[] args) {
        L_700_SearchInABinarySearchTree l = new L_700_SearchInABinarySearchTree();
        //TreeNode root = new TreeNode(4);
        //root.left = new TreeNode(2);
        //root.right = new TreeNode(7);
        //root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(3);
        //PrintUtil.printTreeNode(root);
        //TreeNode result = l.searchBST(root, 2);
        //PrintUtil.printTreeNode(result);

        // [18,2,22,null,null,null,63,null,84,null,null]
        // 63

        TreeNode root1 = new TreeNode(18);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(22);
        root1.right.right = new TreeNode(63);
        root1.right.right.right = new TreeNode(84);
        PrintUtil.printTreeNode(root1);
        TreeNode result1 = l.searchBST(root1, 63);
        PrintUtil.printTreeNode(result1);

    }

    public TreeNode searchBST(TreeNode root, int val) {
        return searchBST1(root, val);
    }


    public TreeNode searchBST1(TreeNode root, int val) {
        if (null != root) {
            if (root.val == val) {
                return root;
            } else {
                if (null != root.left) {
                    return searchBST1(root.left, val);
                } else if (null != root.right) {
                    return searchBST1(root.right, val);
                }
            }
        }
        return null;
    }
}
