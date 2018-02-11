/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 * 
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
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
