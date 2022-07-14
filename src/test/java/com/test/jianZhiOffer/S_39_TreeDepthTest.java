package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_39_TreeDepthTest {

    private S_39_TreeDepth solution = new S_39_TreeDepth();

    @Test
    public void treeDepthTest() {
        BinaryTreeNode<Integer> root = null;
        execTest(root, 0, true);
        root = new BinaryTreeNode<>(1);
        execTest(root, 1, true);
        root.setLeftChild(new BinaryTreeNode<>(2));
        execTest(root, 2, true);
        root.getLeftChild().setLeftChild(new BinaryTreeNode<>(4));
        execTest(root, 3, false);
        root.setRightChild(new BinaryTreeNode<>(3));
        execTest(root, 3, true);
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(5));
        execTest(root, 3, true);
        root.getRightChild().setLeftChild(new BinaryTreeNode<>(6));
        execTest(root, 3, true);
        root.getRightChild().setRightChild(new BinaryTreeNode<>(7));
        execTest(root, 3, true);
    }

    public void execTest(BinaryTreeNode<Integer> root, int expectDepth, boolean expectBalanced) {
        log.info("-------------------------------------------------");
        try {
            int result = CostTimeUtil.costMillisecond(() -> solution.treeDepth(root));
            boolean isBalance = CostTimeUtil.costMillisecond(() -> solution.isBalanced(root));
            PrintUtil.printTree(root);
            log.info("Tree depth: {}", result);
            log.info("Result is {}correct.", result == expectDepth ? "" : "in");
            log.info("Tree is {}balanced", isBalance ? "" : "not ");
            log.info("Result is {}correct.", isBalance == expectBalanced ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
