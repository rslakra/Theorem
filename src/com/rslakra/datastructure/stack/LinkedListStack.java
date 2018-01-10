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
 * @created 2017-12-28 04:41:02 PM
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class LinkedListStack<E> implements Stack<E> {

	/**
	 * 
	 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
	 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
	 * @created 2018-01-06 03:03:08 PM
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	private class Node {
		E data;
		Node next;

		Node(E data) {
			this.data = data;
			next = null;
		}

		public String toString() {
			return (data != null ? data.toString() : "");
		}
	}

	private Node root;
	private int size;

	public LinkedListStack() {
		root = null;
		size = 0;
	}

	public E push(E data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
		} else {
			node.next = root;
			root = node;
		}
		size++;
		return data;
	}

	public E pop() {
		if (empty()) {
			return null;
		}

		Node node = root;
		root = root.next;
		size--;
		return (E) node;
	}

	public E peek() {
		if (empty()) {
			return null;
		}

		return (E) root.data;
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#empty()
	 */
	@Override
	public boolean empty() {
		return root == null;
	}

	public int size() {
		return size;
	}

	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(E item) {
		if (!empty()) {
			Node temp = root;
			while (temp != null) {
				if (temp.data == item) {
					return true;
				}
				temp = temp.next;
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
			Node temp = root;
			while (temp != null) {
				stackString.append(temp.data.toString());
				if (temp.next != null) {
					stackString.append(", ");
				}
				temp = temp.next;
			}
		}
		stackString.append("]");
		return stackString.toString();
	}

}
