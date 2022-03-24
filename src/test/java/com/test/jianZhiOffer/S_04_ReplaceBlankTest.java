package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import com.test.utils.PrintUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_04_ReplaceBlankTest {

    S_04_ReplaceBlank solution = new S_04_ReplaceBlank();

    @Test
    public void replaceBlankTest() {
        char[] chs = null;
        execTest(chs);
        chs = new char[] {};
        execTest(chs);
        chs = new char[] {' '};
        execTest(chs);
        chs = new char[] {' ', ' ', ' '};
        execTest(chs);
        chs = new char[] {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.'};
        execTest(chs);
        chs = new char[] {' ', 'W', 'e', ' ', ' ', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.'};
        execTest(chs);
        chs = new char[] {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' '};
        execTest(chs);
        chs = new char[] {' ', 'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' '};
        execTest(chs);
    }

    private void execTest(char[] chs) {
        PrintUtil.printArray(chs);
        CostTimeUtil.costMillisecond(() -> solution.replaceBlankBySymbol(chs));
        PrintUtil.printArray(chs);
    }
}
