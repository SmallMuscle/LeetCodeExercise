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
        Character[] chs = null;
        execTest(chs);
        chs = new Character[] {};
        execTest(chs);
        chs = new Character[] {null, null};
        execTest(chs);
        chs = new Character[] {' '};
        execTest(chs);
        chs = new Character[] {' ', null};
        execTest(chs);
        chs = new Character[] {' ', null, null};
        execTest(chs);
        chs = new Character[] {' ', ' ', ' '};
        execTest(chs);
        chs = new Character[] {' ', ' ', ' ', null, null, null, null, null};
        execTest(chs);
        chs = new Character[] {' ', ' ', ' ', null, null, null, null, null, null};
        execTest(chs);
        chs = new Character[] {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.'};
        execTest(chs);
        chs = new Character[] {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', null, null, null};
        execTest(chs);
        chs = new Character[] {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', null, null, null, null};
        execTest(chs);
        chs = new Character[] {' ', 'W', 'e', ' ', ' ', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.'};
        execTest(chs);
        chs = new Character[] {' ', 'W', 'e', ' ', ' ', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', null,
                null, null, null, null, null, null, null, null};
        execTest(chs);
        chs = new Character[] {' ', 'W', 'e', ' ', ' ', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', null,
                null, null, null, null, null, null, null, null, null};
        execTest(chs);
        chs = new Character[] {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' '};
        execTest(chs);
        chs = new Character[] {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' ', null, null, null,
                null, null};
        execTest(chs);
        chs = new Character[] {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' ', null, null, null,
                null, null, null};
        execTest(chs);
        chs = new Character[] {' ', 'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' '};
        execTest(chs);
        chs = new Character[] {' ', 'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' ', null, null,
                null, null, null, null, null};
        execTest(chs);
        chs = new Character[] {' ', 'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', ' ', null, null,
                null, null, null, null, null, null};
        execTest(chs);
    }

    private void execTest(Character[] chs) {
        PrintUtil.printArray(chs);
        CostTimeUtil.costMillisecond(() -> solution.replaceBlankBySymbol(chs));
        PrintUtil.printArray(chs);
    }
}
