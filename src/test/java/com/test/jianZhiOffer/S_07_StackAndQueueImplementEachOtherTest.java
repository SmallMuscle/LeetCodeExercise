package com.test.jianZhiOffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

@Slf4j
public class S_07_StackAndQueueImplementEachOtherTest {

    private S_07_StackAndQueueImplementEachOther soultion = new S_07_StackAndQueueImplementEachOther();
    private S_07_StackAndQueueImplementEachOther.Stack<Integer> stack = soultion.new Stack<>();
    private S_07_StackAndQueueImplementEachOther.Queue<Integer> queue = soultion.new Queue<>();
    private Stack<Integer> officialStack = new Stack<>();
    private Queue<Integer> officialQueue = new ArrayDeque<>();

    @Test
    public void stackAndQueueImplementEachOtherTest() {
        deleteElement(3);
        addElementByRange(5, 10);
        deleteElement(4);
        addElementByRange(4, 5);
        deleteElement(6);
    }

    public void addElementByRange(int start, int end) {
        System.out.print("\nInput: ");
        for (int i = start; i <= end; ++i) {
            System.out.print(i + " ");
            stack.push(i);
            officialStack.push(i);
            queue.appendTail(i);
            officialQueue.add(i);
        }
    }

    private void deleteElement(int num) {
        System.out.print("\nstack pop: ");
        for (int i = 0; i < num; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.print("\nofficial stack pop: ");
        for (int i = 0; i < num; i++) {
            System.out.print((officialStack.size() > 0 ? officialStack.pop() : "null") + " ");
        }
        System.out.print("\nqueue del tail: ");
        for (int i = 0; i < num; i++) {
            System.out.print(queue.deleteHead() + " ");
        }
        System.out.print("\nofficial queue del tail: ");
        for (int i = 0; i < num; i++) {
            System.out.print(officialQueue.poll() + " ");
        }
    }

}
