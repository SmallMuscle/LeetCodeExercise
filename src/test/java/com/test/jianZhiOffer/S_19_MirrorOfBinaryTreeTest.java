package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_19_MirrorOfBinaryTreeTest {

    private S_19_MirrorOfBinaryTree solution = new S_19_MirrorOfBinaryTree();

    @Test
    public void mirrorOfBinaryTreeTest() {
        BinaryTreeNode<Integer> root = null;
        execTest(root);
        root = new BinaryTreeNode<>(5);
        execTest(root);
        root.setLeftChild(new BinaryTreeNode<>(2));
        execTest(root);
        root.getRightChild().setLeftChild(new BinaryTreeNode<>(4));
        execTest(root);
        root.setRightChild(new BinaryTreeNode<>(3));
        execTest(root);
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(5));
        execTest(root);
        root.getRightChild().setRightChild(new BinaryTreeNode<>(6));
        execTest(root);
        root.getRightChild().setRightChild(new BinaryTreeNode<>(7));
        execTest(root);
    }

    public void execTest(BinaryTreeNode<Integer> root) {
        log.info("-------------------------------------------------");
        try {
            log.info("Root tree: ");
            PrintUtil.printTree(root);
            CostTimeUtil.costMillisecond(() -> solution.mirrorOfBinaryTree(root));
            log.info("Result: ");
            PrintUtil.printTree(root);
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
