package com.rslakra.java.datastructure;

import java.util.Arrays;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 09/20/2016 02:00:49 PM
 *
 * @param <E>
 */
public class Stack<E> {
	
	private static final int MAX_CAPACITY = 16;
	private int index;
	private Object[] elements;
	
	/**
	 * 
	 * @param capacity
	 */
	public Stack(int capacity) {
		elements = new Object[capacity];
		index = 0;
	}
	
	/**
	 * 
	 */
	public Stack() {
		this(MAX_CAPACITY);
	}
	
	/**
	 * Returns true if the stack is full otherwise false.
	 * 
	 * @return
	 */
	public boolean isFull() {
		return (index == elements.length - 1);
	}
	
	/**
	 * Returns true if the stack is empty otherwise false.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (index == 0);
	}
	
	/**
	 * Adds the new element into the stack.
	 * 
	 * @param element
	 */
	public void push(E element) {
		if(isFull()) {
			int newSize = elements.length + MAX_CAPACITY;
			elements = Arrays.copyOf(elements, newSize, Object[].class);
		}
		elements[index] = element;
		index++;
	}
	
	/**
	 * Removes the top element from the stack.
	 * 
	 * @return
	 */
	public E pop() {
		E element = peek();
		if(element != null && !isEmpty()) {
			elements[index - 1] = null;
			index--;
		}
		
		return element;
	}
	
	/**
	 * Returns the element at the specified index.
	 * 
	 * @param index
	 * @return
	 */
	protected E peekElement(int index) {
		return (E) (isEmpty() ? null : elements[index]);
	}
	
	/**
	 * Returns the top element of the stack without removing it.
	 * 
	 * @return
	 */
	public E peek() {
		E element = null;
		if(!isEmpty()) {
			element = peekElement(index - 1);
		}
		
		return element;
	}
	
	/**
	 * Returns the string representation of this object.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sBuilder = new StringBuilder("[");
		if(!isEmpty()) {
			for(int i = elements.length - 1; i >= 0; i--) {
				Object element = peekElement(i);
				if(element != null) {
					sBuilder.append(peekElement(i));
					if(i > 0) {
						sBuilder.append(", ");
					}
				}
			}
		}
		sBuilder.append("]");
		return sBuilder.toString();
	}
	
}
