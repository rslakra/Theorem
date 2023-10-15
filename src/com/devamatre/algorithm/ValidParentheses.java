/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code, in source 
 * and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
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

		for (int i = 0; i < string.length(); i++) {
			char current = string.charAt(i);
			if (parentheses.keySet().contains(current)) {
				stack.push(current);
			} else if (parentheses.values().contains(current)) {
				if (!stack.isEmpty() && parentheses.get(stack.peek()) == current) {
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
