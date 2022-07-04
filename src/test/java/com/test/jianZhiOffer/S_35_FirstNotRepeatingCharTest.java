package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_35_FirstNotRepeatingCharTest {

    private S_35_FirstNotRepeatingChar solution = new S_35_FirstNotRepeatingChar();

    @Test
    public void firtNotRepeatingCharTest() {
        char[] chs = null;
        execTest(chs, '\0');
        chs = new char[] {};
        execTest(chs, '\0');
        chs = new char[] {'1', '1', '2', '3', '4', '5', '5'};
        execTest(chs, '2');
        chs = new char[] {'1', '1', '2', '2', '2'};
        execTest(chs, '\0');
        chs = new char[] {'1', '2', '3', '4', '5'};
        execTest(chs, '1');
    }

    public void execTest(char[] chs, char expect) {
        log.info("-------------------------------------------------");
        try {
            char result = CostTimeUtil.costMillisecond(() -> solution.firstNotRepeatingChar(chs));
            log.info("First not repeating char is {} in chs: {}", result, chs);
            log.info("exec result {}correct.", expect == result ? "" : "in");
            result = CostTimeUtil.costMillisecond(() -> solution.firstNotRepeatingChar1(chs));
            log.info("First not repeating char is {} in chs: {}", result, chs);
            log.info("exec result {}correct.", expect == result ? "" : "in");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }


}
