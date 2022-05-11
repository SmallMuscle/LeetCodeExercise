package com.test.utils;

import com.test.bean.Tree.binaryTree.TreeNode;
import com.test.ds.list.ListNode;
import com.test.ds.tree.BinaryTreeNode;

import java.util.*;

public class PrintUtil {

    public static void main(String[] args) {
        printBits(665772);
    }


    public static void printBits(int num) {
        int[] bits = new int[32];
        for (int i = 31; i >= 0; --i) {
            if ((num & 1) == 1) bits[i] = 1;
            num >>= 1;
        }
        for (int i = 0; i < 32; ++i) {
            if ((i % 4) == 0) System.out.print(' ');
            System.out.print(bits[i]);
        }
        System.out.println();
        printSplitResult();
    }

    public static void printArray(String[] s) {
        if (null != s) {
            for (String ss : s) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }
        printSplitResult();
    }

    public static void printArray(Object[] c) {
        if (null != c) {
            for (Object cc : c) {
                if (cc instanceof Character) {
                    System.out.print("'" + cc + "', ");
                } else {
                    System.out.print(cc + " ");
                }
            }
            System.out.println();
        }
        printSplitResult();
    }

    public static void printArray(char[] c) {
        if (null != c) {
            for (char cc : c) {
                System.out.print(cc + " ");
            }
            System.out.println();
        }
        printSplitResult();
    }

    public static void printList(List list) {
        if (null != list) {
            for (Object o : list) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
        printSplitResult();
    }

    public static void printList(ListNode list) {
        ListNode node = list;
        while (null != node) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        printSplitResult();
    }

    public static void printIntegerListsList(List<List<Integer>> list) {
        if (null != list) {
            for (List o : list) {
                for (Object oo : o) {
                    System.out.print(oo + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        printSplitResult();
    }

    public static void printTree(BinaryTreeNode root) {
        if (null != root) {
            int depth = TreeUtil.getTreeDepth(root);
            if (depth > 0) {
                List<BinaryTreeNode> list = new LinkedList<>();
                list.add(root);
                int maxNum = 1 << depth - 1;
                int[] index = ArrayUtil.getArray(maxNum);
                index[0] = 1;
                int rank = 0;
                while (! list.isEmpty()) {
                    printTreeBranch(depth, rank, index);
                    printTreeNodeByRank(list, depth, rank, index);
                    recordTreeIndex(list, index, rank);
                    ++rank;
                }
            }
        } else {
            System.out.println("empty tree");
        }
        printSplitResult();
    }

    public static void printTreeNode(TreeNode tn) {
        if (null != tn) {
            int depth = TreeUtil.getTreeDepth(tn);
            if (depth > 0) {
                // 入队列
                Vector<TreeNode> vector = new Vector();
                vector.add(tn);
                // 记录节点 index
                int maxNum = (1 << depth - 1);
                int[] index = ArrayUtil.getArray(maxNum);
                index[0] = 1;
                int rank = 0;
                while(!vector.isEmpty()) {
                    printTreeBranch(depth, rank, index);
                    printTreeNodeByRank(vector, depth, rank, index);
                    recordTreeIndex(vector, index, rank);
                    ++rank;
                }
            }
        } else {
            System.out.println("null");
        }
        printSplitResult();
    }

    private static void recordTreeIndex(List<BinaryTreeNode> list, int[] index, int rank) {
        // 记录 index
        int[] nextIndex = ArrayUtil.getArray(index.length);
        int loopNum = 1 << rank;
        if (loopNum > index.length) return;
        int newPos = 0;
        for (int i = 0; i < loopNum; i++) {
            if (1 == index[i]) {
                newPos = i << 1;
                BinaryTreeNode t = list.remove(0);
                if (null != t.getLeftChild()) {
                    nextIndex[newPos] = 1;
                    list.add(t.getLeftChild());
                }
                if (null != t.getRightChild()) {
                    nextIndex[newPos + 1] = 1;
                    list.add(t.getRightChild());
                }
            }
        }
        ArrayUtil.copy(nextIndex, index);
    }

    private static void printTreeNodeByRank(List<BinaryTreeNode> list, int depth, int rank, int[] index) {
        printTreeNodeForwardBlank(depth, rank);
        Iterator<BinaryTreeNode> nodeIterator = list.iterator();
        for (int i = 0; i < (1 << rank); i++) {
            if (index[i] == 1 && nodeIterator.hasNext()) {
                System.out.print(nodeIterator.next().getData());
            } else {
                System.out.print(" ");
            }
            printTreeNodeBetweenBlank(depth, rank);
        }
        System.out.println();
    }

    private static void recordTreeIndex(Vector<TreeNode> vector, int[] index, int rank) {
        // 记录 index
        int[] nextIndex = ArrayUtil.getArray(index.length);
        int loopNum = 1 << rank;
        if (loopNum > index.length) return;
        int newPos = 0;
        for (int i = 0; i < loopNum; i++) {
            if (1 == index[i]) {
                newPos = i << 1;
                TreeNode t = vector.remove(0);
                if (null != t.left) {
                    nextIndex[newPos] = 1;
                    vector.add(t.left);
                }
                if (null != t.right) {
                    nextIndex[newPos + 1] = 1;
                    vector.add(t.right);
                }
            }
        }
        ArrayUtil.copy(nextIndex, index);
    }

    private static void printTreeNodeByRank(Vector<TreeNode> vector, int depth, int rank, int[] index) {
        printTreeNodeForwardBlank(depth, rank);
        int j = 0;
        for (int i = 0; i < (1 << rank); i++) {
            if (index[i] == 1) {
                System.out.print(vector.get(j++).val);
            } else {
                System.out.print(" ");
            }
            printTreeNodeBetweenBlank(depth, rank);
        }
        System.out.println();
    }

    private static void printTreeNodeForwardBlank(int depth, int rank) {
        int count = 0;
        for (int i = 1; i < depth - rank; i++) {
            count <<= 1;
            count += 2;
        }
        printBlankByNum(count);
    }

    private static void printTreeNodeBetweenBlank(int depth, int rank) {
        int count = 3;
        for (int i = 1; i < depth - rank; i++) {
            count <<= 1;
            ++count;
        }
        printBlankByNum(count);
    }

    private static void printTreeBranchBetweenBlank(int depth, int rank) {
        int count = 1;
        for (int i = 1; i < depth - rank; i++) {
            count <<= 1;
            count += 3;
        }
        printBlankByNum(count);
    }

    private static void printTreeBranchForwardBlank(int depth, int rank) {
        int count = 1;
        for (int i = 1; i < depth - rank; i++) {
            count <<= 1;
            ++count;
        }
        printBlankByNum(count);
    }

    private static void printBlankByNum(int len) {
        for (int i = 0; i < len; ++i) System.out.print(' ');
    }

    private static void printTreeBranch(int depth, int rank, int[] index) {
        if (0 != rank) {
            printTreeBranchForwardBlank(depth, rank);
            for (int i = 0; i < 1 << rank; i++) {
                if (index[i] == 1) {
                    if ((i & 1) == 0) {
                        System.out.print("/");
                    } else {
                        System.out.print("\\");
                    }
                } else {
                    System.out.print(" ");
                }
                if ((i & 1) == 1) {
                    // 弥补一位 node
                    System.out.print("    ");
                    //printTreeNodeBetweenBlank(depth, rank + 1);
                }
                printTreeBranchBetweenBlank(depth, rank);
            }
            System.out.println();
        }
    }



    public static void printArray(int[] a) {
        if (null != a) {
            for (int aa : a) {
                System.out.print(aa + " ");
            }
            System.out.println();
        }
        printSplitResult();
    }


    public static void printArray(int[][] a) {
        if (null != a) {
            for (int[] aa : a) {
                for (int aaa : aa)
                    System.out.print(aaa + " ");
                System.out.println();
            }
        }
        printSplitResult();
    }

    public static void printSplitResult() {
        System.out.println(" \n------------------------------------------------------------------------------------------------------------ ");
    }
}
