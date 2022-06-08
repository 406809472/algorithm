package sort.leetcode.stack;

import java.util.Stack;


    public class MyQueue {
        private Stack stack1;
        private Stack stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (stack1.isEmpty()){
                stack2.push(stack1.pop());
                stack2.push(x);
                stack1.push(stack2.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public void pop() {
            stack1.pop();
        }

        /** Get the front element. */
        public int peek() {
            return (int) stack1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
           return stack1.empty();
        }
    }

