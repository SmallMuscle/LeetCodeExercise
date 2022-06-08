package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_18_HaveSubTreeTest {

    private S_18_HaveSubTree solution = new S_18_HaveSubTree();

    @Test
    public void haveSubTreeTest() {
        BinaryTreeNode<Integer> root = null;
        BinaryTreeNode<Integer> subRoot = null;
        execTest(root, subRoot);
        root = new BinaryTreeNode<>(5);
        execTest(root, subRoot);
        root = null;
        subRoot = new BinaryTreeNode<>(3);
        execTest(root, subRoot);
        root = new BinaryTreeNode<>(1);
        execTest(root, subRoot);
        root.setLeftChild(new BinaryTreeNode<>(2));
        root.setRightChild(new BinaryTreeNode<>(3));
        root.getLeftChild().setLeftChild(new BinaryTreeNode<>(4));
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(5));
        root.getRightChild().setLeftChild(new BinaryTreeNode<>(6));
        root.getRightChild().setRightChild(new BinaryTreeNode<>(7));
        execTest(root, subRoot);
        subRoot.setLeftChild(new BinaryTreeNode<>(7));
        execTest(root, subRoot);
        subRoot.setLeftChild(new BinaryTreeNode<>(6));
        subRoot.setRightChild(new BinaryTreeNode<>(7));
        execTest(root, subRoot);
    }

    public void execTest(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> subRoot) {
        log.info("-------------------------------------------------");
        try {
            log.info("Root tree: ");
            PrintUtil.printTree(root);
            log.info("Sub root tree: ");
            PrintUtil.printTree(subRoot);
            boolean result = CostTimeUtil.costMillisecond(() -> solution.haveSubTree(root, subRoot));
            log.info("Result: {}have sub tree.", result ? "" : "not ");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
