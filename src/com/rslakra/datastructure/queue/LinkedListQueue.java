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
package com.rslakra.datastructure.queue;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-06 08:55:49 AM
 * @version 1.0.0
 * @since 1.0.0
 */
public class LinkedListQueue<E> implements Queue<E> {

	/**
	 * 
	 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
	 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
	 * @created 2018-01-06 03:03:08 PM
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	private class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
			next = null;
		}

		public String toString() {
			return (data != null ? data.toString() : "");
		}
	}

	private Node<E> root;
	private int size;
	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#add(java.lang.Object)
	 */
	@Override
	public boolean add(E item) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#offer(java.lang.Object)
	 */
	@Override
	public boolean offer(E item) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#remove()
	 */
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#poll()
	 */
	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#element()
	 */
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#peek()
	 */
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
