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

import java.util.NoSuchElementException;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-06 08:54:30 AM
 * @version 1.0.0
 * @since 1.0.0
 */
public class ArrayQueue<E> implements Queue<E> {

	static final int DEFAULT_SIZE = 16;

	protected int capacity;
	protected Object[] items;
	protected int lastIndex;

	/**
	 * 
	 * @param capacity
	 */
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		items = new Object[capacity];
		lastIndex = 0;
	}

	/**
	 * 
	 */
	public ArrayQueue() {
		this(DEFAULT_SIZE);
	}

	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#add(java.lang.Object)
	 */
	@Override
	public boolean add(E item) {
		if (item == null) {
			throw new NullPointerException("Item is null!");
		}

		if (lastIndex == capacity) {
			throw new IllegalStateException("Overflow!");
		}

		items[lastIndex++] = item;
		return true;
	}

	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#offer(java.lang.Object)
	 */
	@Override
	public boolean offer(E item) {
		return add(item);
	}

	/**
	 * Removes the first item.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private E removeFirst() {
		E item = null;
		if (lastIndex > 0) {
			item = (E) items[0];
			System.arraycopy(items, 1, items, 0, lastIndex);
			lastIndex--;
		}

		return item;
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#remove()
	 */
	@Override
	public E remove() {
		if (lastIndex <= 0) {
			throw new NoSuchElementException("Underflow!");
		}

		return removeFirst();
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#poll()
	 */
	@Override
	public E poll() {
		return removeFirst();
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#element()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E element() {
		if (lastIndex <= 0) {
			throw new NoSuchElementException("Underflow!");
		}

		return (E) items[0];
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#peek()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		return (E) (lastIndex <= 0 ? null : items[0]);
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#size()
	 */
	@Override
	public int size() {
		return lastIndex;
	}

	/**
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sBuilder = new StringBuilder("[");
		if (lastIndex > 0) {
			for (int index = 0; index < lastIndex; index++) {
				sBuilder.append(items[index].toString());
				if (index < lastIndex - 1) {
					sBuilder.append(", ");
				}
			}
		}

		sBuilder.append("]");

		return sBuilder.toString();
	}

}
