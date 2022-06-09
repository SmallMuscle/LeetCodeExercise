package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_23_PrintFromTop2BottomTest {

    private S_23_PrintFromTop2Bottom solution = new S_23_PrintFromTop2Bottom();

    @Test
    public void printFromTop2Bottom() {
        BinaryTreeNode<Integer> root = null;
        execTest(root);
        root = new BinaryTreeNode<>(5);
        execTest(root);
        root.setRightChild(new BinaryTreeNode<>(6));
        execTest(root);
        root.setLeftChild(new BinaryTreeNode<>(4));
        execTest(root);
        root.getRightChild().setLeftChild(new BinaryTreeNode<>(7));
        execTest(root);
        root.getLeftChild().setLeftChild(new BinaryTreeNode<>(2));
        execTest(root);
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(1));
        execTest(root);
        root.getRightChild().setRightChild(new BinaryTreeNode<>(8));
        execTest(root);
    }

    public void execTest(BinaryTreeNode<Integer> root) {
        log.info("-------------------------------------------------");
        try {
            PrintUtil.printTree(root);
            CostTimeUtil.costMillisecond(() -> solution.printFromTop2Bottom(root));
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
