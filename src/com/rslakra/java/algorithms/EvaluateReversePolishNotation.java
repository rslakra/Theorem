package com.rslakra.java.algorithms;

import java.util.Arrays;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	private String OPERATORS = "+-*/";
	
	/**
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation. Valid operators are +, -, *, /. Each operand may be an integer
	 * or another expression. For example:
	 * 
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 * 
	 * @param strings
	 * @return
	 */
	public int evalReversePolishNotation(String[] strings) {
		int result = 0;
		if(strings != null) {
			Stack<String> stack = new Stack<String>();
			for(String item : strings) {
				if(OPERATORS.contains(item)) {
					int lastOperand = Integer.parseInt(stack.pop());
					int lastFirstOperand = Integer.parseInt(stack.pop());
					int index = OPERATORS.indexOf(item);
					switch(index) {
						case 0:
							stack.push(String.valueOf((lastFirstOperand + lastOperand)));
							break;
						case 1:
							stack.push(String.valueOf((lastFirstOperand - lastOperand)));
							break;
						case 2:
							stack.push(String.valueOf((lastFirstOperand * lastOperand)));
							break;
						case 3:
							stack.push(String.valueOf((lastFirstOperand / lastOperand)));
							break;
					}
				} else {
					stack.push(item);
				}
			}
			
			result = Integer.parseInt(stack.pop());
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
		String[] strings = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(Arrays.toString(strings) + " " + obj.evalReversePolishNotation(strings));
		strings = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(Arrays.toString(strings) + " " + obj.evalReversePolishNotation(strings));
	}
	
}
