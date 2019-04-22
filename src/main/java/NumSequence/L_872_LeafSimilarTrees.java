package NumSequence;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L_872_LeafSimilarTrees {

    /*
        2019.04.22

        Consider all the leaves of a binary tree.  From left to right
        order, the values of those leaves form a leaf value sequence.
        images/L_872_LeafSimilarTrees.png

        For example, in the given tree above, the leaf value sequence
        is (6, 7, 4, 9, 8).

        Two binary trees are considered leaf-similar if their leaf
        value sequence is the same.

        Return true if and only if the two given trees with head nodes
        root1 and root2 are leaf-similar.

        Note:
            Both of the given trees will have between 1 and 100 nodes.

     */

    public static void main(String[] args) {
        L_872_LeafSimilarTrees l = new L_872_LeafSimilarTrees();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        System.out.println(l.leafSimilar(root1, root1));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leafSimilar1(root1, root2);
    }

    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) return true;
        else if (null == root1 && null != root2) return false;
        else if (null != root1 && null == root1) return false;
        else {
            List<TreeNode> leaf = new ArrayList<TreeNode>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root1);
            // 先序
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                if (null == t.left && null  == t.right) leaf.add(t);
                else {
                    if (null != t.right) stack.push(t.right);
                    if (null != t.left) stack.push(t.left);
                }
            }
            stack.push(root2);
            int index = 0;
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                if (null == t.left && null  == t.right) {
                    if (index >= leaf.size() || t.val != leaf.get(index).val) {
                        return false;
                    }
                    ++index;
                }
                else {
                    if (null != t.right) stack.push(t.right);
                    if (null != t.left) stack.push(t.left);
                }
            }
            return true;
        }
    }
}
