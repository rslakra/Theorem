package com.rslakra.testcases;

import com.rslakra.java.datastructure.Stack;

public class TestStack {
	
	public static void fixedSizeStack() {
		Stack<String> stack = new Stack<String>(3);
		stack.push("Rohtash");
		stack.push("Singh");
		stack.push("Lakra");
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();
	}
	
	/**
	 * 
	 */
	public static void dynamicStack() {
		Stack<String> stack = new Stack<String>();
		final String line = "A real-world stack allows operations at one end only. For example, we can place or remove a card or plate from top of the stack only. Likewise, Stack ADT allows all data operations at one end only. At any given time, We can only access the top element of a stack.";
		final String[] words = line.split(" ");
		System.out.println("Size:" + words.length);
		for(int i = 0; i < words.length; i++) {
			stack.push(words[i]);
		}
		
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final boolean fixedStack = true;
		if(fixedStack) {
			fixedSizeStack();
		} else {
			dynamicStack();
		}
	}
	
}
