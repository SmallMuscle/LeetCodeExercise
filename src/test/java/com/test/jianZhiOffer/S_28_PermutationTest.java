package com.test.jianZhiOffer;

import com.test.utils.CostTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_28_PermutationTest {

    private S_28_Permutation solution = new S_28_Permutation();

    @Test
    public void cloneComplexListTest() {
        String str = null;
        execTest(str);
        str = "";
        execTest(str);
        str = "a";
        execTest(str);
        str = "abc";
        execTest(str);
        str = "aabc";
        execTest(str);
        str = "abcde";
        execTest(str);
    }

    @Test
    public void permutation() {
        int[] arrs = null;
        execPermutationSum(arrs);
        arrs = new int[] {};
        execPermutationSum(arrs);
        arrs = new int[] {1,2,3,4,5,6,7};
        execPermutationSum(arrs);
        arrs = new int[] {0,1,2,3,4,5,6,7,8};
        execPermutationSum(arrs);
        arrs = new int[] {0,1,2,3,4,5,6,7};
        execPermutationSum(arrs);
    }

    @Test
    public void nQueueTest() {
        solution.nQuene(-1);
        solution.nQuene(0);
        solution.nQuene(1);
        solution.nQuene(2);
        solution.nQuene(3);
        solution.nQuene(4);
        solution.nQuene(5);
        solution.nQuene(6);
        solution.nQuene(7);
        solution.nQuene(8);
    }

    public void execPermutationSum(int[] arrs) {
        log.info("-------------------------------------------------");
        try {
            log.info("arrs: {} is{} permutation sum.", arrs,
                    CostTimeUtil.costMillisecond(() -> solution.permutationSum(arrs)) ? "" : "'t");
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }
    public void execTest(String str) {
        log.info("-------------------------------------------------");
        try {
            log.info("str: {} permutation: ", str);
            CostTimeUtil.costMillisecond(() -> solution.permutation(str));
            log.info("str: {} combination: ", str);
            CostTimeUtil.costMillisecond(() -> solution.combination(str));
        } catch (Exception e) {
            log.error("err: ", e);
        }
    }

}
