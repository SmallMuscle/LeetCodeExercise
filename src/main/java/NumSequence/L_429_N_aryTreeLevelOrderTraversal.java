package NumSequence;

import bean.Tree.N_Tree.Node;
import utils.PrintUtil;

import java.util.*;

public class L_429_N_aryTreeLevelOrderTraversal {

    /*
        Given an n-ary tree, return the level order traversal of
        its nodes' values. (ie, from left to right, level by level).

        For example, given a 3-ary tree:
            images/Example_L_429_N_aryTreeLevelOrderTraversal.png

        We should return its level order traversal:

            [
                 [1],
                 [3,2,4],
                 [5,6]
            ]


        Note:
            The depth of the tree is at most 1000.
            The total number of nodes is at most 5000.

     */

    public static void main(String[] args) {
        L_429_N_aryTreeLevelOrderTraversal l = new L_429_N_aryTreeLevelOrderTraversal();
        List<Node> list3 = new ArrayList<>();
        list3.add(new Node(5, null));
        list3.add(new Node(6, null));
        List<Node> list1 = new ArrayList<>();
        list1.add(new Node(3, list3));
        list1.add(new Node(2, null));
        list1.add(new Node(4, null));
        Node root = new Node(1, list1);
        PrintUtil.printIntegerListsList(l.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(Node root) {
        return levelOrder2(root);
    }

    // recursive
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null != root) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            this.recordResult(queue, queue.size(), result);
        }
        return result;
    }

    private void recordResult(Queue<Node> queue, int len, List<List<Integer>> result) {
        if (len > 0) {
            List<Integer> list = new ArrayList<>();
            Node n = null;
            for (int i = 0; i < len; i++) {
                n = queue.poll();
                list.add(n.val);
                if (null != n.children && 0 < n.children.size()) {
                    queue.addAll(n.children);
                }
            }
            result.add(list);
            recordResult(queue, queue.size(), result);
        }
    }

    // iterative
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null != root) {
            Queue<Node> nodes1 = new LinkedList<>();
            Queue<Node> nodes2 = new LinkedList<>();
            nodes1.add(root);
            List<Integer> list = null;
            while (! nodes1.isEmpty() || ! nodes2.isEmpty()) {
                list = new ArrayList<>();
                Node n = null;
                if (nodes1.isEmpty()) {
                    this.recordNode(nodes2, nodes1, list);
                } else {
                    this.recordNode(nodes1, nodes2, list);
                }
                result.add(list);
            }
        }
        return result;
    }

    private void recordNode(Queue<Node> parent, Queue<Node> childs, List<Integer> list) {
        Node p = null;
        while (! parent.isEmpty()) {
            p = parent.poll();
            list.add(p.val);
            if (null != p.children && 0 < p.children.size()) {
                childs.addAll(p.children);
            }
        }
    }

}
