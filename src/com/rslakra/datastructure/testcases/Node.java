package com.rslakra.datastructure.testcases;

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
	private Node<T> previous;

	/**
	 * 
	 * @param data
	 */
	public Node(final T data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	/**
	 * 
	 * @return
	 */
	public T getData() {
		return data;
	}

	/**
	 * Returns the next node.
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
	 * Returns the previous node.
	 * 
	 * @return
	 */
	public Node<T> getPrevious() {
		return previous;
	}

	/**
	 * The previous node to be set.
	 * 
	 * @param previous
	 */
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
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
