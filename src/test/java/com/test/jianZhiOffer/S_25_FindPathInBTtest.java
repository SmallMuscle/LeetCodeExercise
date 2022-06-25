package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_25_FindPathInBTtest {

    private S_25_FIndPathInBT solution = new S_25_FIndPathInBT();

    @Test
    public void findPathInBTtest() {
        BinaryTreeNode<Integer> root = null;
        int expectSum = 22;
        execTest(root, expectSum);
        root = new BinaryTreeNode<>(10);
        execTest(root, expectSum);
        root.setLeftChild(new BinaryTreeNode<>(5));
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(7));
        execTest(root, expectSum);
        root.getLeftChild().setLeftChild(new BinaryTreeNode<>(4));
        execTest(root, expectSum);
        root.setRightChild(new BinaryTreeNode<>(12));
        execTest(root, expectSum);
    }

    public void execTest(BinaryTreeNode<Integer> root, int expectSum) {
        log.info("-------------------------------------------------");
        try {
            PrintUtil.printTree(root);
            log.info("Expect sum {} :", expectSum);
            CostTimeUtil.costMillisecond(() -> solution.findPathInBT(root, expectSum));
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
