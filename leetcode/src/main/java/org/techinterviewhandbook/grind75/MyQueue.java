package org.techinterviewhandbook.grind75;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> readStack;
    Stack<Integer> writeStack;

    public MyQueue() {
        readStack = new Stack<>();
        writeStack = new Stack<>();
    }

    public void push(int x) {
        writeStack.push(x);
    }

    public int pop() {
        if (this.empty()) {
            return -1;
        }
        this.transferWriteToRead();
        return readStack.pop();
    }

    public int peek() {
        if (this.empty()) {
            return -1;
        }
        this.transferWriteToRead();
        return readStack.peek();
    }

    public boolean empty() {
        return writeStack.isEmpty() && readStack.empty();
    }

    private void transferWriteToRead() {
        if (readStack.isEmpty()) {
            while (!writeStack.isEmpty()) {
                readStack.push(writeStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
