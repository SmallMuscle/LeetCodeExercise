package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class S_22_IsPopOrder {

    public boolean isPopOrder(int[] push, int[] pop) {
        if (null == push || null == pop || push.length != pop.length) return false;
        Stack<Integer> stack = new Stack<>();
        int pushIndex, popIndex = pushIndex = 0;
        while (popIndex < pop.length) {
            if (pushIndex < push.length) {
                if (push[pushIndex] == pop[popIndex]) {
                    ++pushIndex;
                    ++popIndex;
                } else {
                    if (stack.isEmpty()) {
                        stack.push(push[pushIndex++]);
                    } else {
                        int top = stack.peek();
                         if (top == pop[popIndex]) {
                             stack.pop();
                             ++popIndex;
                         } else {
                             stack.push(push[pushIndex++]);
                         }
                    }
                }
            } else {
                int top = stack.pop();
                if (top != pop[popIndex++]) return false;
            }
        }
        return stack.isEmpty();
    }

}
