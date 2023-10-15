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
package com.devamatre.datastructure.queue;

import java.util.NoSuchElementException;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-06 08:55:38 AM
 * @version 1.0.0
 * @since 1.0.0
 */
public class ListQueue<E> extends ArrayQueue<E> implements Queue<E> {

	/**
	 * 
	 * @param capacity
	 */
	public ListQueue(int capacity) {
		super(capacity);
	}

	/**
	 * 
	 */
	public ListQueue() {
		super();
	}

	private void checkCapacity() {
		if (lastIndex == capacity) {
			Object[] oldItems = items;
			items = new Object[capacity * 2];
			System.arraycopy(oldItems, 0, items, 0, oldItems.length);
		}
	}

	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.queue.Queue#add(java.lang.Object)
	 */
	@Override
	public boolean add(E item) {
		checkCapacity();
		// if (item == null) {
		// throw new NullPointerException("Item is null!");
		// }

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
