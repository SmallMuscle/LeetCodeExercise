package NumSequence;

import bean.TreeNode;
import sun.reflect.generics.tree.Tree;
import utils.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L_897_IncreasingOrderSearchTree {


    /*
        2019.04.18

        Given a tree, rearrange the tree in in-order so that the leftmost
        node in the tree is now the root of the tree, and every node has
        no left child and only 1 right child.

        Example 1:
            Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

                   5
                  / \
                3    6
               / \    \
              2   4    8
             /        / \
            1        7   9

            Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

             1
              \
               2
                \
                 3
                  \
                   4
                    \
                     5
                      \
                       6
                        \
                         7
                          \
                           8
                            \
                             9
        Note:
            The number of nodes in the given tree will be between 1 and 100.
            Each node will have a unique integer value from 0 to 1000.

     */

    public static void main(String[] args) {
        L_897_IncreasingOrderSearchTree l = new L_897_IncreasingOrderSearchTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        PrintUtil.printTreeNode(root);
        PrintUtil.printTreeNode(l.increasingBST(root));
    }

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST6(root);
    }


    private TreeNode curNode = null;

    // inspired by Solution
    // 递归 中序遍历 队列，再构造树
    public TreeNode increasingBST6(TreeNode root) {
        if (null != root) {
            TreeNode r = new TreeNode(666);
            curNode = r;
            inOrderTree6(root);
            return r.right;
        }
        return root;
    }

    public void inOrderTree6(TreeNode root) {
        if (null != root.left) inOrderTree6(root.left);
        root.left = null;
        curNode.right = root;
        curNode = curNode.right;
        if (null != root.right) inOrderTree6(root.right);
    }

    // inspired by Solution
    // 递归 中序遍历 队列，再构造树
    public TreeNode increasingBST5(TreeNode root) {
        if (null != root) {
            Queue<TreeNode> queue = new LinkedList<>();
            inOrderTree5(root, queue);
            root = queue.poll();
            TreeNode t = root;
            t.left = null;
            while (!queue.isEmpty()) {
                t.right = queue.poll();
                t = t.right;
                t.left = null;
            }
        }
        return root;
    }

    public void inOrderTree5(TreeNode root, Queue<TreeNode> queue) {
        if (null != root.left) inOrderTree5(root.left, queue);
        queue.add(root);
        if (null != root.right) inOrderTree5(root.right, queue);
    }


    // 递归更改树结构
    public TreeNode increasingBST4(TreeNode root) {
        if (null != root) {
            if (null != root.right) {
                root.right = increasingBST4(root.right);
            }
            if (null != root.left) {
                TreeNode left = increasingBST4(root.left);
                TreeNode t = left;
                while (null != t.right) {
                    t = t.right;
                }
                root.left = null;
                t.right = root;
                return left;
            }
        }
        return root;
    }

    // 递归更改树结构 思路 ，只改了引用，没有返回 正确的 root 节点
    public TreeNode increasingBST3(TreeNode root) {
        if (null != root) {
            TreeNode left = increasingBST3(root.left);
            if (null != left) {
                left.right = root;
            }
            root.left = null;
            root.right = increasingBST3(root.right);
            while (null != root.right) {
                root = root.right;
            }
        }
        return root;
    }

    // 中序遍历过程中 更改树结构
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode r = null;
        if (null != root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            boolean isRoot = true;
            boolean flag = true;
            TreeNode t = null;
            while (!stack.isEmpty()) {
                if (flag) {
                    while (null != stack.peek().left) {
                        stack.push(stack.peek().left);
                    }
                }
                TreeNode treeNode = stack.pop();
                if (isRoot) {
                    r = treeNode;
                    t = r;
                    isRoot = false;
                } else {
                    t.right = treeNode;
                    t = treeNode;
                }
                t.left = null;
                if (null != treeNode.right) {
                    stack.push(treeNode.right);
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }
        return r;
    }

    // 中序遍历入队列，出队列构造新树（内存超限了 。。。）
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode r = null;
        if (null != root) {
            Queue<TreeNode> queue = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            boolean flag = true;
            while (!stack.isEmpty()) {
                if (flag) {
                    while (null != stack.peek().left) {
                        stack.push(stack.peek().left);
                    }
                }
                TreeNode treeNode = stack.pop();
                queue.add(treeNode);
                if (null != treeNode.right) {
                    stack.push(treeNode.right);
                    flag = true;
                } else {
                    flag = false;
                }
            }
            r = queue.poll();
            TreeNode t = r;
            while (!queue.isEmpty()) {
                t.right = queue.poll();
                t.left = null;
                t = t.right;
            }
        }
        return r;
    }
}
