/**
 *
 */
package com.devamatre.theorem.geeksforgeeks.stack;

import java.util.Stack;

/**
 * @author Rohtash Lakra
 */
public class MinStack extends Stack<Integer> {

    private static final long serialVersionUID = 1L;
    private Stack<Integer> minStack;

    public MinStack() {
        super();
        minStack = new Stack<>();
    }

    /**
     *
     */
    public Integer push(Integer item) {
        if (isEmpty()) {
            super.push(item);
            minStack.push(item);
        } else {
            super.push(item);
            if (item < minStack.peek()) {
                minStack.push(item);
            }
        }

        return item;
    }

    public Integer pop() {
        Integer result = super.pop();
        if (result == minStack.peek()) {
            minStack.pop();
        }

        return result;
    }

    /**
     * @return
     */
    public Integer getMin() {
        Integer result = minStack.peek();
        if (result > super.peek()) {
            result = super.peek();
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println("Min: " + stack.getMin());

        System.out.println("Removed:" + stack.pop());
        System.out.println("Removed:" + stack.pop());
        System.out.println("Removed:" + stack.pop());

        System.out.println(stack);
        System.out.println("Min: " + stack.getMin());

    }

}
