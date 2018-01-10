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
package com.rslakra.datastructure.lists;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-06 10:00:21 AM
 * @version 1.0.0
 * @since 1.0.0
 */
public class ArrayList<E> implements List<E> {

	private static final int DEFAULT_SIZE = 16;
	private int capacity;
	private Object[] items;
	private int size;

	/**
	 * 
	 * @param capacity
	 */
	public ArrayList(int capacity) {
		this.capacity = capacity;
		items = new Object[capacity];
		size = 0;
	}

	/**
	 * 
	 */
	public ArrayList() {
		this(DEFAULT_SIZE);
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.lists.List#size()
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * @return
	 * @see com.devamatre.algorithms.lists.List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param item
	 * @return
	 * @see com.devamatre.algorithms.lists.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object item) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param e
	 * @return
	 * @see com.devamatre.algorithms.lists.List#add(java.lang.Object)
	 */
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param o
	 * @return
	 * @see com.devamatre.algorithms.lists.List#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param items
	 * @return
	 * @see com.devamatre.algorithms.lists.List#containsAll(com.devamatre.algorithms.lists.List)
	 */
	@Override
	public boolean containsAll(List<?> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param newItems
	 * @return
	 * @see com.devamatre.algorithms.lists.List#addAll(com.devamatre.algorithms.lists.List)
	 */
	@Override
	public boolean addAll(List<? extends E> newItems) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param index
	 * @param newItems
	 * @return
	 * @see com.devamatre.algorithms.lists.List#addAll(int,
	 *      com.devamatre.algorithms.lists.List)
	 */
	@Override
	public boolean addAll(int index, List<? extends E> newItems) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param items
	 * @return
	 * @see com.devamatre.algorithms.lists.List#removeAll(com.devamatre.algorithms.lists.List)
	 */
	@Override
	public boolean removeAll(List<?> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param items
	 * @return
	 * @see com.devamatre.algorithms.lists.List#retainAll(com.devamatre.algorithms.lists.List)
	 */
	@Override
	public boolean retainAll(List<?> items) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * @see com.devamatre.algorithms.lists.List#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param index
	 * @return
	 * @see com.devamatre.algorithms.lists.List#get(int)
	 */
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param index
	 * @param element
	 * @return
	 * @see com.devamatre.algorithms.lists.List#set(int, java.lang.Object)
	 */
	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param index
	 * @param element
	 * @see com.devamatre.algorithms.lists.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param index
	 * @return
	 * @see com.devamatre.algorithms.lists.List#remove(int)
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param o
	 * @return
	 * @see com.devamatre.algorithms.lists.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param o
	 * @return
	 * @see com.devamatre.algorithms.lists.List#lastIndexOf(java.lang.Object)
	 */
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 * @see com.devamatre.algorithms.lists.List#subList(int, int)
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
