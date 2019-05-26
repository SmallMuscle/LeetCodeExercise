package NumSequence;

import bean.Tree.N_Tree.Node;

import java.util.*;

public class L_559_MaximumDepthOfN_AryTree {

    /*
        2019.04.20

        Given a n-ary tree, find its maximum depth.

        The maximum depth is the number of nodes along the longest path
        from the root node down to the farthest leaf node.

        For example, given a 3-ary tree:
            images/Example_L_559_MaximumDepthOfN_AryTree.png

        We should return its max depth, which is 3.

        Note:
            The depth of the tree is at most 1000.
            The total number of nodes is at most 5000.
     */

    public static void main(String[] args) {


        L_559_MaximumDepthOfN_AryTree l  = new L_559_MaximumDepthOfN_AryTree();
        List<Node> ch3 = new ArrayList<>();
        ch3.add(new Node(5, null));
        ch3.add(new Node(6, null));
        Node node3 = new Node(3, ch3);
        List<Node> ch1 = new ArrayList<>();
        ch1.add(node3);
        List<Node> ch8 = new ArrayList<>();
        ch8.add(new Node(9, null));
        List<Node> ch7 = new ArrayList<>();
        ch7.add(new Node(8, ch8));
        List<Node> ch2 = new ArrayList<>();
        ch2.add(new Node(7, ch7));
        ch1.add(new Node(2, ch2));
        ch1.add(new Node(4, null));
        Node root = new Node(1, ch1);
        System.out.println(l.maxDepth(root));
    }

    int maxDepth = 0;

    public int maxDepth(Node root) {
        return maxDepth3(root);
    }

    // inspired by Discuss
    public int maxDepth3(Node root) {
        if (null != root) {
            int dep = 1;
            if (null != root.children) {
                int tmp = 0;
                for (Node n : root.children) {
                    tmp = maxDepth3(n) + 1;
                    dep = dep > tmp ? dep : tmp;
                }
            }
            return dep;
        }
        return 0;
    }


    public void maxDepth2(Node root, int dep) {
        if (null != root) {
            ++dep;
            if (maxDepth < dep) {
                maxDepth = dep;
            }
            if (null != root.children) {
                for (Node child : root.children) {
                    maxDepth2(child, dep);
                }
            }
        }
    }

    public int maxDepth1(Node root) {
        int result = 0;
        if (null != root) {
            int depth = 1;
            Stack<Node> stack = new Stack<>();
            // 记录 叶子结点的数量
            Stack<Integer> childNum = new Stack<>();
            stack.push(root);
            childNum.push(1);
            while (!stack.isEmpty()) {
                Node n = stack.pop();
                if (null != n.children && 0 < n.children.size()) {
                    childNum.push(n.children.size());
                    for (int i = n.children.size() - 1; i >= 0; --i) {
                        stack.push(n.children.get(i));
                    }
                    ++depth;
                } else {
                    if (result < depth) {
                        result = depth;
                    }
                    int num = childNum.pop() - 1;
                    // 同级叶子结点 没遍历完
                    if (0 < num) {
                        childNum.push(num);
                    } else {
                        // 同级叶子结点遍历完，修正叶子结点的数量
                        while (!childNum.isEmpty() && 0 >= num) {
                            --depth;
                            num = childNum.pop() - 1;
                        }
                        if (childNum.isEmpty()) break;
                        childNum.push(num);
                    }
                }
            }
        }
        return result;
    }
}

