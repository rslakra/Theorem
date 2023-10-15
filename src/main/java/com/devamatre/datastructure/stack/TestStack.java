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
package com.devamatre.datastructure.stack;

/**
 * 
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-02-23 09:18:50 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class TestStack {

	public static void fixedSizeStack() {
		StackArray<String> stack = new StackArray<String>(3);
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
		StackArray<String> stack = new StackArray<String>();
		final String line = "A real-world stack allows operations at one end only. For example, we can place or remove a card or plate from top of the stack only. Likewise, Stack ADT allows all data operations at one end only. At any given time, We can only access the top element of a stack.";
		final String[] words = line.split(" ");
		System.out.println("Size:" + words.length);
		for (int i = 0; i < words.length; i++) {
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
		if (fixedStack) {
			fixedSizeStack();
		} else {
			dynamicStack();
		}
	}

}
