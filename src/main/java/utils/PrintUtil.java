package utils;

import bean.TreeNode;

import java.util.List;
import java.util.Vector;

public class PrintUtil {

    public static void main(String[] args) {
        System.out.println(1 << 0);
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
        for (int i = 0; i < len; ++i) System.out.print(" ");
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
        System.out.println(" ------------------------------------------------------------------------------------------------------------ ");
    }
}
