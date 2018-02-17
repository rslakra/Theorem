package com.rslakra.algorithms;

import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 02/16/2017 02:26:33 PM
 *
 */
public class ValidParentheses {
	
	/**
	 * LeetCode – Valid Parentheses (Java)
	 * 
	 * 
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 * 
	 * Analysis
	 * 
	 * A typical problem which can be solved by using a stack data structure.
	 * 
	 * @param parentheses
	 * @return
	 */
	public static boolean validParentheses(String string) {
		HashMap<Character, Character> parentheses = new HashMap<Character, Character>();
		parentheses.put('(', ')');
		parentheses.put('{', '}');
		parentheses.put('[', ']');
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < string.length(); i++) {
			char current = string.charAt(i);
			if(parentheses.keySet().contains(current)) {
				stack.push(current);
			} else if(parentheses.values().contains(current)) {
				if(!stack.isEmpty() && parentheses.get(stack.peek()) == current) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		// String parentheses = "()[]{}";
		String parentheses = "(}";
		System.out.println("validParentheses(" + parentheses + "):" + validParentheses(parentheses));
	}
	
}
