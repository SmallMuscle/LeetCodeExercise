package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_27_BST2ListTest {

    private S_27_BST2List solution = new S_27_BST2List();

    @Test
    public void bst2ListTest() {
        BinaryTreeNode<Integer> root = null;
        execTest(root);
        root = new BinaryTreeNode<>(4);
        execTest(root);
        root = new BinaryTreeNode<>(4);
        root.setRightChild(new BinaryTreeNode<>(6));
        execTest(root);
        root = new BinaryTreeNode<>(4);
        root.setRightChild(new BinaryTreeNode<>(6));
        root.getRightChild().setRightChild(new BinaryTreeNode<>(7));
        execTest(root);
        root = new BinaryTreeNode<>(4);
        root.setRightChild(new BinaryTreeNode<>(6));
        root.getRightChild().setRightChild(new BinaryTreeNode<>(7));
        root.getRightChild().setLeftChild((new BinaryTreeNode<>(5)));
        execTest(root);
        root = new BinaryTreeNode<>(4);
        root.setRightChild(new BinaryTreeNode<>(6));
        root.getRightChild().setRightChild(new BinaryTreeNode<>(7));
        root.getRightChild().setLeftChild((new BinaryTreeNode<>(5)));
        root.setLeftChild(new BinaryTreeNode<>(2));
        execTest(root);
        root = new BinaryTreeNode<>(4);
        root.setRightChild(new BinaryTreeNode<>(6));
        root.getRightChild().setRightChild(new BinaryTreeNode<>(7));
        root.getRightChild().setLeftChild((new BinaryTreeNode<>(5)));
        root.setLeftChild(new BinaryTreeNode<>(2));
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(3));
        execTest(root);
        root = new BinaryTreeNode<>(4);
        root.setRightChild(new BinaryTreeNode<>(6));
        root.getRightChild().setRightChild(new BinaryTreeNode<>(7));
        root.getRightChild().setLeftChild((new BinaryTreeNode<>(5)));
        root.setLeftChild(new BinaryTreeNode<>(2));
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(3));
        root.getLeftChild().setLeftChild(new BinaryTreeNode<>(1));
        execTest(root);
    }

    public void execTest(BinaryTreeNode<Integer> root) {
        log.info("-------------------------------------------------");
        try {
            PrintUtil.printTree(root);
            BinaryTreeNode<Integer> result = CostTimeUtil.costMillisecond(() -> solution.convert(root));
            if (null != result) {
                StringBuilder buffer = new StringBuilder();
                // todo print
                while (null != result.getRightChild()) {
                    buffer.append(result.getData()).append(' ');
                    result = result.getRightChild();
                }
                buffer.append(result.getData()).append("\n\t");
                while (null != result.getLeftChild()) {
                    buffer.append(result.getData()).append(' ');
                    result = result.getLeftChild();
                }
                buffer.append(result.getData());
                log.info("result: \n\t{}", buffer);
            }
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
