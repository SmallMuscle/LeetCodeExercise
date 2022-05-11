package com.test.jianZhiOffer;

public class S_07_StackAndQueueImplementEachOther {


    /**
     * Question: 用两个栈实现一个队列。
     * 队列的声明如下，请实现它的两个函数appendTail和deleteHead，
     * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
     *
     * 用两个队列实现一个栈。
     *
     * Analysis:
     * Queue implement:
     * appendTail 时，stack1 push，
     * deleteHead 时 stack1 -> stack2，stack2 再 pop 即可
     * 当 stack2 不为空时 不可 stack1 -> stack2
     *
     * Stack implement:
     * 两个 queue 必须有一个保证为空，
     * push 时 选择非空 queue appendTail，
     * pop 时 先将 非空 queue 除了最后一个元素 给了 空 queue，
     * 返回 对应元素 即可
     */

    class Queue<T> {

        private java.util.Stack<T> stack1 = null;
        private java.util.Stack<T> stack2 = null;

        public Queue() {
            stack1 = new java.util.Stack<>();
            stack2 = new java.util.Stack<>();
        }

        public void appendTail(T data) {
            stack1.push(data);
        }

        public T deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                //System.out.println("Queue empty.");
                return null;
            } else return stack2.pop();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public int size() {
            return stack1.size() + stack2.size();
        }
    }

    class Stack<T> {
        private Queue<T> queue1 = null;
        private Queue<T> queue2 = null;

        public Stack() {
            queue1 = new Queue<>();
            queue2 = new Queue<>();
        }

        public void push(T data) {
            if (queue1.isEmpty()) {
                queue2.appendTail(data);
            } else {
                queue1.appendTail(data);
            }
        }

        public T pop() {
            if (isEmpty()) {
                //System.out.println("Stack empty.");
                return null;
            }
            if (queue1.isEmpty()) {
                while (queue2.size() != 1) queue1.appendTail(queue2.deleteHead());
                return queue2.deleteHead();
            } else {
                while (queue1.size() != 1) queue2.appendTail(queue1.deleteHead());
                return queue1.deleteHead();

            }
        }

        public boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}
