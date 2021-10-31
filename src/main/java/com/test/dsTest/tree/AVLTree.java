package com.test.dsTest.tree;

import com.test.bean.Tree.binaryTree.TreeNode;
import com.test.utils.PrintUtil;

public class AVLTree {

        private TreeNode root;
        private int count;

        public void put(TreeNode node) {
            if (null == root) {
                root = node;
                return;
            }
            this.root = putNode(this.root, node);
        }

        private TreeNode putNode(TreeNode root, TreeNode node ){
            // 先实现一版 key 不能相同的
            if (root.val == node.val) return null;
            if (root.val > node.val) {
                root.left = null == root.left ? node : putNode(root.left, node);
            } else {
                root.right = null == root.right ? node : putNode(root.right, node);
            }
            return checkBalance(root);
        }

        public TreeNode get(int val) {
            return null;
        }

        public void remove(int val) {
            if (isEmpty()) return;
            this.root = removeNode(this.root, val);
        }

        private TreeNode removeNode(TreeNode root, int val) {
            if (root.val == val) {
                if (null == root.left && null == root.right) {
                    return null;
                } else if (null == root.right) {
                    return root.left;
                } else if (null == root.left) {
                    return root.right;
                } else {
                    if (null != root.left.right) {
                        TreeNode maxNode = getMaxNode(root.left.right);
                        root.left.right = removeNode(root.left.right, maxNode.val);
                        root.left = checkBalance(root.left);
                        maxNode.left = root.left;
                        maxNode.right = root.right;
                        root = maxNode;
                    } else {
                        root.left.right = root.right;
                        root = root.left;
                    }
                }
            }else if (root.val > val && null != root.left) {
                root.left = removeNode(root.left, val);
            } else if (root.val < val && null != root.right) {
                root.right = removeNode(root.right, val);
            }
            return checkBalance(root);
        }

        private TreeNode getMaxNode(TreeNode root) {
            if (null != root.right) return getMaxNode(root.right);
            return root;
        }

        private TreeNode checkBalance(TreeNode root) {
            if (null != root.left) {
                root.leftMaxDepth = 1 + (root.left.leftMaxDepth > root.left.rightMaxDepth
                        ? root.left.leftMaxDepth : root.left.rightMaxDepth);
                root.leftMinDepth = 1 + (root.left.leftMinDepth < root.left.rightMinDepth
                        ? root.left.leftMinDepth : root.left.rightMinDepth);
            } else {
                root.leftMinDepth = root.leftMaxDepth = 0;
            }
            if (null != root.right) {
                root.rightMaxDepth = 1 + (root.right.leftMaxDepth > root.right.rightMaxDepth
                        ? root.right.leftMaxDepth : root.right.rightMaxDepth);
                root.rightMinDepth = 1 + (root.right.leftMinDepth < root.right.rightMinDepth
                        ? root.right.leftMinDepth : root.right.rightMinDepth);
            } else {
                root.rightMinDepth = root.rightMaxDepth = 0;
            }
            if (2 <= root.leftMaxDepth - root.rightMinDepth) {
                // LL
                if (root.left.leftMaxDepth >= root.left.rightMaxDepth) {
                    root = turnRight(root);
                } else if (root.left.leftMaxDepth < root.left.rightMaxDepth){ // LR
                    root.left = turnLeft(root.left);
                    root = turnRight(root);
                }
            }
            if (-2 >= root.leftMinDepth - root.rightMaxDepth) {
                if (root.right.leftMaxDepth <= root.right.rightMaxDepth) {
                    root = turnLeft(root);
                } else if (root.right.leftMaxDepth > root.right.rightMaxDepth) {
                    root.right = turnRight(root.right);
                    root = turnLeft(root);
                }
            }
            return root;
        }


        public boolean isEmpty() {
            return null == this.root;
        }

        private TreeNode turnLeft(TreeNode root) {
            TreeNode newRoot = root.right;
            root.right = newRoot.left;
            newRoot.left = root;
            if (null == root.right) root.rightMinDepth = root.rightMaxDepth = 0;
            else {
                root.rightMaxDepth = 1 + root.right.rightMaxDepth;
                root.rightMinDepth = 1 + root.right.rightMinDepth;
            }
            newRoot.leftMaxDepth = 1 + root.leftMaxDepth;
            newRoot.leftMinDepth = 1 + root.leftMinDepth;
            return newRoot;
        }

        private TreeNode turnRight(TreeNode root) {
            TreeNode newRoot = root.left;
            root.left = newRoot.right;
            newRoot.right = root;
            if (null == root.left) root.leftMinDepth = root.leftMaxDepth = 0;
            else {
                root.leftMaxDepth = 1 + root.left.leftMaxDepth;
                root.leftMinDepth = 1 + root.left.leftMinDepth;
            }
            newRoot.rightMaxDepth = 1 + root.rightMaxDepth;
            newRoot.rightMinDepth = 1 + root.rightMinDepth;
            return newRoot;
        }

        public void printTree() {
            PrintUtil.printTreeNode(this.root);
        }

}
