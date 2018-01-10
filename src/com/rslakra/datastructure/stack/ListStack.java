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

import java.util.ArrayList;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2017-12-28 05:47:05 PM
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class ListStack<E> extends ArrayList<E> implements Stack<E> {

	public ListStack() {
		super();
	}

	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public E push(E item) {
		super.add(0, item);
		return item;
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#pop()
	 */
	@Override
	public E pop() {
		return remove(0);
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#peek()
	 */
	@Override
	public E peek() {
		return get(0);
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.stack.Stack#empty()
	 */
	@Override
	public boolean empty() {
		return super.isEmpty();
	}

	public int size() {
		return super.size();
	}

	public boolean contains(Object item) {
		return super.contains(item);
	}

}
