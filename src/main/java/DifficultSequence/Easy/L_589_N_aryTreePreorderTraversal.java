package DifficultSequence.Easy;

import bean.Tree.N_Tree.Node;
import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L_589_N_aryTreePreorderTraversal {

    /*
        2019.04.05

        Given an n-ary tree, return the preorder traversal of its nodes' values.

        For example, given a 3-ary tree:
            images/Example_L_589_N_aryTreePreorderTraversal.png

        Return its preorder traversal as: [1,3,5,6,2,4].

        Note:
            Recursive solution is trivial, could you do it iteratively?

     */

    public static void main(String[] args) {
        L_589_N_aryTreePreorderTraversal l = new L_589_N_aryTreePreorderTraversal();
        List<Node> list2 = new ArrayList<>();
        list2.add(new Node(5, null));
        list2.add(new Node(6, null));
        List<Node> list1 = new ArrayList<>();
        list1.add(new Node(3, list2));
        list1.add(new Node(2, null));
        list1.add(new Node(4, null));
        Node root = new Node(1, list1);

        PrintUtil.printList(l.preorder(root));


    }

    public List<Integer> preorder(Node root) {
        return preorder1(root);
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (null != node) {
                result.add(node.val);
                if (null != node.children && 0 < node.children.size()) {
                    for (int i = node.children.size() - 1; i >= 0; --i) {
                        Node n = node.children.get(i);
                        if (null != n) {
                            stack.push(n);
                        }
                    }
                }
            }
        }
        return result;
    }
}
