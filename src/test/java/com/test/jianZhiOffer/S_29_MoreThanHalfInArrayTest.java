package com.test.jianZhiOffer;

import com.test.ds.tree.BinaryTreeNode;
import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_29_MoreThanHalfInArrayTest {

    private S_29_MoreThanHalfInArray solution = new S_29_MoreThanHalfInArray();

    @Test
    public void moreThanHalfInArrayTest() {
        int[] arrs = null;
        execTest(arrs);
        arrs = new int[] {};
        execTest(arrs);
        arrs = new int[] {1};
        execTest(arrs);
        arrs = new int[] {1, 2};
        execTest(arrs);
        arrs = new int[] {1, 2, 2};
        execTest(arrs);
        arrs = new int[] {1,2,1, 2, 2};
        execTest(arrs);
        arrs = new int[] {1,2,3,2,5,2};
        execTest(arrs);
        arrs = new int[] {1,2,3,2,2,2,5,2};
        execTest(arrs);
        arrs = new int[] {1,2,3,2,2,2,5,4,2};
        execTest(arrs);
    }

    public void execTest(int[] arrs) {
        log.info("-------------------------------------------------");
        try {
            int result = CostTimeUtil.costMillisecond(() -> solution.moreThanHalfInArray(arrs));
            log.info("arr {} morn than half element {}", arrs, 0 == result ? "not exists." : "is " + result);
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
