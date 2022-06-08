package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class S_21_MinMethodInStackTest {

    private S_21_MinMethodInStack solution = new S_21_MinMethodInStack();

    @Test
    public void stackTest() {
        S_21_MinMethodInStack.Stack<Integer> stack = solution.new Stack<>(10);
        log.info("\nMin {} in stack {}", stack.min(), stack);
        stack.push(3);
        log.info("\nMin {} in stack {}", stack.min(), stack);
        stack.push(4);
        log.info("\nMin {} in stack {}", stack.min(), stack);
        stack.push(5);
        log.info("\nMin {} in stack {}", stack.min(), stack);
        stack.push(1);
        log.info("\nMin {} in stack {}", stack.min(), stack);
        stack.push(2);
        log.info("\nMin {} in stack {}", stack.min(), stack);
        stack.push(3);
        log.info("\nMin {} in stack {}", stack.min(), stack);
        stack.pop();
        log.info("\nMin {} in stack {}", stack.min(), stack);
        stack.pop();
        log.info("Min {} in stack {}", stack.min(), stack);
        stack.pop();
        log.info("Min {} in stack {}", stack.min(), stack);
        stack.pop();
        log.info("Min {} in stack {}", stack.min(), stack);
        stack.pop();
        log.info("Min {} in stack {}", stack.min(), stack);
        stack.pop();
        log.info("Min {} in stack {}", stack.min(), stack);
    }

}
