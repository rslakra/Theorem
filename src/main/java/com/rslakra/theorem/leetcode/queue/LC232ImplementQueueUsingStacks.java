package com.rslakra.theorem.leetcode.queue;

import java.util.Stack;

/**
 * <pre>
 * Your LC232ImplementQueueUsingStacks object will be instantiated and called as such:
 * LC232ImplementQueueUsingStacks instance = new LC232ImplementQueueUsingStacks();
 * instance.push(x);
 * int param_2 = instance.pop();
 * int param_3 = instance.peek();
 * boolean param_4 = instance.empty();
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 1/31/24 12:12 PM
 */
public class LC232ImplementQueueUsingStacks {

    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public LC232ImplementQueueUsingStacks() {
    }

    public void push(int x) {
        pushStack.push(x);
    }

    private void fillPopStack() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public int pop() {
        fillPopStack();
        if (popStack.isEmpty()) {
            return -1;
        }

        return popStack.pop();
    }

    public int peek() {
        fillPopStack();
        if (popStack.isEmpty()) {
            return -1;
        }

        return popStack.peek();
    }

    public boolean empty() {
        return (popStack.isEmpty() && pushStack.isEmpty());
    }
}
