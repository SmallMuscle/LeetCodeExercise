package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_22_IsPopOrderTest {

    private S_22_IsPopOrder solution = new S_22_IsPopOrder();

    @Test
    public void isPopOrderTest() {
        int[] push = null;
        int[] pop = null;
        execTest(push, pop);
        push = new int[] {1,2,3,4,5};
        pop = new int[] {1,2,4,3,5};
        execTest(push, pop);
        pop = new int[] {4,5,3,2,1};
        execTest(push, pop);
        pop = new int[] {4,5,3,2,1,6};
        execTest(push, pop);
        pop = new int[] {4,3,5,1,2};
        execTest(push, pop);
        pop = new int[] {1,2,3,4,5};
        execTest(push, pop);
        pop = new int[] {1,2,4,5,3};
        execTest(push, pop);
        pop = new int[] {3,2,1,5,4};
        execTest(push, pop);
        pop = new int[] {2,3,1,4,5};
        execTest(push, pop);
        pop = new int[] {1};
        push = new int[] {1};
        execTest(push, pop);
    }

    public void execTest(int[] push, int[] pop) {
        log.info("-------------------------------------------------");
        try {
            log.info("\tpop: {} is{} \n\tpush: {} pop order", pop,
                    CostTimeUtil.costMillisecond(() -> solution.isPopOrder(push, pop)) ? "" : "'t", push);
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
