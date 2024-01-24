/**
 *
 */
package com.devamatre.theorem.geeksforgeeks.stack;

import java.util.Stack;

/**
 * @author Rohtash Lakra
 */
public class MaxStack extends Stack<Integer> {

    private static final long serialVersionUID = 1L;
    private Stack<Integer> maxStack;

    public MaxStack() {
        super();
        maxStack = new Stack<>();
    }

    /**
     *
     */
    public Integer push(Integer item) {
        if (isEmpty()) {
            super.push(item);
            maxStack.push(item);
        } else {
            super.push(item);
            if (item >= maxStack.peek()) {
                maxStack.push(item);
            }
        }

        return item;
    }

    public Integer pop() {
        Integer result = super.pop();
        if (!maxStack.isEmpty()) {
            if (result == maxStack.peek()) {
                maxStack.pop();
            }
        }

        return result;
    }

    /**
     * @return
     */
    public Integer getMax() {
        Integer result = super.peek();
        if (!maxStack.isEmpty()) {
            if (result < maxStack.peek()) {
                result = maxStack.peek();
            }
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println("Max: " + stack.getMax());

        System.out.println("Removed:" + stack.pop());
        System.out.println("Removed:" + stack.pop());
        System.out.println("Removed:" + stack.pop());
        System.out.println("Removed:" + stack.pop());
        System.out.println("Removed:" + stack.pop());

        System.out.println(stack);
        System.out.println("Max: " + stack.getMax());

    }

}
