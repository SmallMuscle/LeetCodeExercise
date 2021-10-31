package com.test.Easy;

import com.test.bean.Tree.N_Tree.Node;
import com.test.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L_590_N_aryTreePostorderTraversal {

    /*
        2019.04.06

        Given an n-ary tree, return the preorder traversal of its nodes' values.

        For example, given a 3-ary tree:
            com.test.images/Example_L_590_N_aryTreePostorderTraversal.png

        Return its postorder traversal as: [5,6,3,2,4,1].

        Note:
            Recursive solution is trivial, could you do it iteratively?

     */

    public static void main(String[] args) {
        L_590_N_aryTreePostorderTraversal l = new L_590_N_aryTreePostorderTraversal();
        List<Node> list2 = new ArrayList<>();
        list2.add(new Node(5, null));
        list2.add(new Node(6, null));
        List<Node> list1 = new ArrayList<>();
        list1.add(new Node(3, list2));
        list1.add(new Node(2, null));
        list1.add(new Node(4, null));
        Node root = new Node(1, list1);

        PrintUtil.printList(l.postorder(root));


    }

    public List<Integer> postorder(Node root) {
        return postorder1(root);
    }

    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if (null != root) {
            // 记录 所有结点
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            // 记录 有叶子结点的 根节点
            Stack<Node> roots = new Stack<>();
            while (!stack.isEmpty()) {
                Node n = stack.peek();
                // 区分 根节点的叶子结点是否被记录过
                if (!roots.isEmpty() && n == roots.peek()) {
                    list.add(stack.pop().val);
                    roots.pop();
                    continue;
                }
                if (null != n.children && 0 < n.children.size()) {
                    roots.push(n);
                    for (int i = n.children.size() - 1; i >= 0; --i) {
                        stack.push(n.children.get(i));
                    }
                } else {
                    list.add(stack.pop().val);
                }
            }
        }
        return  list;
    }
}
