package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_24_VerifySequenceOfBSTtest {

    private S_24_VerifySequenceOfBST solution = new S_24_VerifySequenceOfBST();

    @Test
    public void verifySequenceOfBST() {
        int[] sequence = null;
        execTest(sequence);
        sequence = new int[] {};
        execTest(sequence);
        sequence = new int[] {1};
        execTest(sequence);
        sequence = new int[] {5,4,3,2,1};
        execTest(sequence);
        sequence = new int[] {1,2,3,4,5};
        execTest(sequence);
        sequence = new int[] {7,4,6,5};
        execTest(sequence);
        sequence = new int[] {5,7,6,9,11,10,8};
        execTest(sequence);
        sequence = new int[] {1,3,2,5,7,6,4};
        execTest(sequence);
    }

    public void execTest(int[] sequence) {
        log.info("-------------------------------------------------");
        try {
            log.info("sequence {} \n\tis{} BST post order.", sequence,
                    CostTimeUtil.costMillisecond(() -> solution.verifySequenceOfBST(sequence)) ? "" : "'t");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
