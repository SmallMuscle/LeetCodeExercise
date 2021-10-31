package com.test.Easy;

import com.test.bean.Tree.binaryTree.TreeNode;
import com.test.utils.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_637_AverageOfLevelsInBinaryTree {

    /*
        Given a non-empty binary tree, return the average value of the
        nodes on each level in the form of an array.

        Example 1:
            Input:
                3
               / \
              9  20
                /  \
               15   7
            Output: [3, 14.5, 11]
            Explanation:
            The average value of nodes on level 0 is 3,  on level 1 is 14.5,
            and on level 2 is 11. Hence return [3, 14.5, 11].
        Note:
            The range of node's value is in the range of 32-bit signed integer.

     */

    public static void main(String[] args) {
        L_637_AverageOfLevelsInBinaryTree l = new L_637_AverageOfLevelsInBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        PrintUtil.printList(l.averageOfLevels(root));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        return averageOfLevels1(root);
    }

    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()) {
            int parNum = queue.size();
            double sum = 0;
            for (int i = 0; i < parNum; i++) {
                TreeNode n = queue.poll();
                sum += n.val;
                if (null != n.left) queue.add(n.left);
                if (null != n.right) queue.add(n.right);
            }
            list.add(sum / parNum);
        }
        return list;
    }
}
