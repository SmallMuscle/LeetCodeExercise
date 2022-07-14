package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;

public class S_39_TreeDepth {

    public int treeDepth(BinaryTreeNode<Integer> root) {
        if (null == root) return 0;
        int left = treeDepth(root.getLeftChild());
        int right = treeDepth(root.getRightChild());
        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(BinaryTreeNode<Integer> root) {
        int[] depth = new int[1];
        return isBalanced(root, depth);
    }

    private boolean isBalanced(BinaryTreeNode<Integer> root, int[] depth) {
        if (null == root) return true;
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced(root.getLeftChild(), left)
                && isBalanced(root.getRightChild(), right)) {
            int diff = left[0] - right[0];
            if (1 >= diff && -1 <= diff) {
                depth[0] = 1 + Math.max(left[0], right[0]);
                return true;
            }
        }
        return false;
    }

}
