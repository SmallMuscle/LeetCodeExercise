package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.function.Function;

@Slf4j
public class S_14_ChangeSequenceByRuleTest {

    private S_14_ChangeSequenceByRule solution = new S_14_ChangeSequenceByRule();

    @Test
    public void countOfOneInBinaryNumber() {
        int[] arrs = null;
        Function<Integer, Boolean> rule = null;
        execTest(arrs, rule);
        rule = S_14_ChangeSequenceByRule.oddEven;
        execTest(arrs, rule);
        arrs = new int[] {};
        rule = null;
        execTest(arrs, rule);
        rule = S_14_ChangeSequenceByRule.oddEven;
        execTest(arrs, rule);
        arrs = new int[] {1};
        rule = null;
        execTest(arrs, rule);
        rule = S_14_ChangeSequenceByRule.oddEven;
        execTest(arrs, rule);
        arrs = new int[] {1,2,3,4,5,6,7};
        rule = null;
        execTest(arrs, rule);
        arrs = new int[] {1,2,3,4,5,6,7};
        rule = S_14_ChangeSequenceByRule.oddEven;
        execTest(arrs, rule);
        arrs = new int[] {1,2,3,4,5,6,7};
        rule = S_14_ChangeSequenceByRule.div3;
        execTest(arrs, rule);
        arrs = new int[] {1,2,3,4,5,6,7};
        rule = S_14_ChangeSequenceByRule.negitive;
        execTest(arrs, rule);
        arrs = new int[] {-3,-2,-1,0,1,2,3};
        rule = S_14_ChangeSequenceByRule.negitive;
        execTest(arrs, rule);
        arrs = new int[] {-3,-2,-1,0,1,2,3};
        rule = S_14_ChangeSequenceByRule.div3;
        execTest(arrs, rule);
        arrs = new int[] {-3,-2,-1,0,1,2,3};
        rule = S_14_ChangeSequenceByRule.oddEven;
        execTest(arrs, rule);
    }
    public void execTest(int[] arrs, Function<Integer, Boolean> rule) {
        try {
            Field[] fields = S_14_ChangeSequenceByRule.class.getFields();
            String ruleName = null;
            for (Field field : fields) {
                if (rule == field.get(solution)) {
                    ruleName = field.getName();
                }
            }
            log.info("Reorder {} by {}", arrs, ruleName);
            CostTimeUtil.costMillisecond(() -> solution.reorderArrayByRule(arrs, rule));
            log.info("Result: {}", arrs);
        } catch (Exception e) {
            log.error("err: ", e);
        }
        log.info("");
    }

}
