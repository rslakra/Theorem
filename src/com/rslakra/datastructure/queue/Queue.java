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

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-06 08:53:49 AM
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Queue<E> {

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions, returning
	 * {@code true} upon success and throwing an {@code IllegalStateException}
	 * if no space is currently available.
	 *
	 * @param e
	 *            the element to add
	 * @return {@code true} (as specified by {@link Collection#add})
	 * @throws IllegalStateException
	 *             if the element cannot be added at this time due to capacity
	 *             restrictions added to this queue
	 * @throws NullPointerException
	 *             if the specified element is null and this queue does not
	 *             permit null elements
	 */
	boolean add(E item);

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions. When using a
	 * capacity-restricted queue, this method is generally preferable to
	 * {@link #add}, which can fail to insert an element only by throwing an
	 * exception.
	 *
	 * @param e
	 *            the element to add
	 * @return {@code true} if the element was added to this queue, else
	 *         {@code false}
	 * @throws NullPointerException
	 *             if the specified element is null and this queue does not
	 *             permit null elements
	 */
	boolean offer(E item);

	/**
	 * Retrieves and removes the head of this queue. This method differs from
	 * {@link #poll poll} only in that it throws an exception if this queue is
	 * empty.
	 *
	 * @return the head of this queue
	 * @throws NoSuchElementException
	 *             if this queue is empty
	 */
	E remove();

	/**
	 * Retrieves and removes the head of this queue, or returns {@code null} if
	 * this queue is empty.
	 *
	 * @return the head of this queue, or {@code null} if this queue is empty
	 */
	E poll();

	/**
	 * Retrieves, but does not remove, the head of this queue. This method
	 * differs from {@link #peek peek} only in that it throws an exception if
	 * this queue is empty.
	 *
	 * @return the head of this queue
	 * @throws NoSuchElementException
	 *             if this queue is empty
	 */
	E element();

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns
	 * {@code null} if this queue is empty.
	 *
	 * @return the head of this queue, or {@code null} if this queue is empty
	 */
	E peek();

	/**
	 * Returns the size of the queue.
	 * 
	 * @return
	 */
	int size();
}
