package leetcode.stack;

import java.util.Stack;


public class MyQueue {
    private Stack stack1;
    private Stack stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        while (stack1.isEmpty()) {
            stack2.push(stack1.pop());
            stack2.push(x);
            stack1.push(stack2.pop());
        }
    }

    public void pop() {
        stack1.pop();
    }

    public int peek() {
        return (int) stack1.peek();
    }

    public boolean empty() {
        return stack1.empty();
    }
}

