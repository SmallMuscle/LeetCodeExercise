package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_06_RebuildBinaryTreeTest {

    private S_06_RebuildBinaryTree solution = new S_06_RebuildBinaryTree();

    @Test
    public void rebuildBinaryTreeTest() {
        int[] preOrder = null;
        int[] inOrder = null;
        execTest(preOrder, inOrder);
        preOrder = new int[] {};
        inOrder = new int[] {};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1,2,4,5,3,6,7};
        inOrder = new int[] {4,2,5,1,6,3,7};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1,2,4,5,3,6,7};
        inOrder = new int[] {4,2,5,1,8,3,7};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1,2,4,7,3,5,6,8};
        inOrder = new int[] {4,7,2,1,5,3,8,6};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1,2,4,7,3,5,6,8};
        inOrder = new int[] {4,7,2,1,5,2,8,6};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1};
        inOrder = new int[] {1};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1};
        inOrder = new int[] {2};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1,2,3,4,5};
        inOrder = new int[] {5,4,3,2,1};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1,2,3,4,5};
        inOrder = new int[] {5,3,3,2,1};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1,2,3,4,5};
        inOrder = new int[] {1,2,3,4,5};
        execTest(preOrder, inOrder);
        preOrder = new int[] {1,2,3,4,5};
        inOrder = new int[] {1,2,9,4,5};
        execTest(preOrder, inOrder);

    }

    private void execTest(int[] preOrder, int[] inOrder) {
        log.info("preOrder: {}", preOrder);
        log.info("inOrder: {}", inOrder);
        BinaryTreeNode<Integer> treeRoot = CostTimeUtil.costMillisecond(() -> solution.construct(preOrder, inOrder));
        PrintUtil.printTree(treeRoot);
    }
}
