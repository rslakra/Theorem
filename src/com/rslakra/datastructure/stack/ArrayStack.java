/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
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
package com.rslakra.datastructure.stack;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2017-12-28 04:41:23 PM
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class ArrayStack<E> implements Stack<E> {

	private final static int DEFAULT_SIZE = 16;

	private int capacity;
	private Object[] items;
	private int index;

	/**
	 * 
	 * @param capacity
	 */
	public ArrayStack(int capacity) {
		this.capacity = capacity;
		items = new Object[capacity];
		index = 0;
	}

	/**
	 * 
	 */
	public ArrayStack() {
		this(DEFAULT_SIZE);
	}

	/**
	 * 
	 * @return
	 */
	public boolean isFull() {
		return index == capacity;
	}

	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public E push(E item) {
		if (isFull()) {
			throw new RuntimeException("Overflow!");
		}

		items[index++] = item;
		return item;
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#pop()
	 */
	@Override
	public E pop() {
		if (empty()) {
			throw new RuntimeException("Underflow!");
		}

		return (E) items[--index];
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#peek()
	 */
	@Override
	public E peek() {
		if (empty()) {
			throw new RuntimeException("Underflow!");
		}

		int topIndex = index;
		return (E) items[--topIndex];
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#empty()
	 */
	@Override
	public boolean empty() {
		return index == 0;
	}

	@Override
	public int size() {
		return index;
	}

	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(E item) {
		if (!empty()) {
			for (int i = index; i >= 0; i--) {
				if (items[i] == item) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder stackString = new StringBuilder("[");
		if (!empty()) {
			for (int i = index - 1; i >= 0; i--) {
				stackString.append(items[i].toString());
				if (i > 0) {
					stackString.append(", ");
				}
			}
		}
		stackString.append("]");
		return stackString.toString();
	}

}
