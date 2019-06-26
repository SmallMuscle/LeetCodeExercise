package DifficultSequence.Easy;

import bean.Tree.binaryTree.TreeNode;
import utils.PrintUtil;

public class L_1022_SumOfRootToLeafBinaryNumbers {

    /*
        Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path
        represents a binary number starting with the most significant bit.  For
        example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent
        01101 in binary, which is 13.

        For all leaves in the tree, consider the numbers represented by the path
        from the root to that leaf.

        Return the sum of these numbers.

        Example 1:
            images/Example_L_1022_SumOfRootToLeafBinaryNumbers.png
            Input: [1,0,1,0,1,0,1]
            Output: 22
            Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

        Note:
            The number of nodes in the tree is between 1 and 1000.
            node.val is 0 or 1.
            The answer will not exceed 2^31 - 1.

     */

    public static void main(String[] args) {
        L_1022_SumOfRootToLeafBinaryNumbers l = new L_1022_SumOfRootToLeafBinaryNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        PrintUtil.printTreeNode(root);
        System.out.println(l.sumRootToLeaf(root));
    }

    public int sumRootToLeaf(TreeNode root) {
        result = 0;
        sumRootToLeaf1(root, 0);
        return result;
    }

    private static int result;

    private void sumRootToLeaf1(TreeNode root, int num) {
        if (null != root) {
            num <<= 1;
            num += root.val;
            if (null == root.left && null == root.right) result += num;
            else {
                sumRootToLeaf1(root.left, num);
                sumRootToLeaf1(root.right, num);
            }
        }
    }

}
