package com.rslakra.java;

/**
 * This class represents the nodes of the linked list.
 * 
 * @author Rohtash Singh Lakra
 * @date 09/20/2016 01:51:00 PM
 *
 * @param <T>
 */
public class Node<T> {
	private final T data;
	private Node<T> next;
	
	/**
	 * 
	 * @param data
	 */
	public Node(final T data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 * 
	 * @return
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * 
	 * @return
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * The next node to be set.
	 * 
	 * @param next
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * Returns the string representation of this object.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return (data == null ? "" : data.toString());
	}
	
}
