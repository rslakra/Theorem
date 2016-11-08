package com.rslakra.java.datastructure;

import com.rslakra.java.Node;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 11/03/2016 04:28:44 PM
 *
 */
public class LinkedList<E> {
	
	private Node<E> head;
	// private transient Node<E> tail;
	
	/**
	 * 
	 * @param newNode
	 */
	public LinkedList() {
	}
	
	/**
	 * Returns true if the linked list is empty otherwise false.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 * Inserts the new node at the first position of the linked list.
	 * 
	 * Time complexity of insertion is O(1), because it takes constant amount of
	 * time.
	 * 
	 * @param newNode
	 */
	public void push(Node<E> newNode) {
		if(head != null) {
			newNode.setNext(head);
		}
		head = newNode;
	}
	
	/**
	 * Inserts the new node after the specified parent node.
	 * 
	 * Time complexity of insertAfter() is O(1) as it does constant amount of
	 * work.
	 * 
	 * @param parentNode
	 * @param newNode
	 */
	public void insertAfter(Node<E> parentNode, Node<E> newNode) {
		if(parentNode == null) {
			parentNode = newNode;
			// tail = newNode;
		} else {
			newNode.setNext(parentNode.getNext());
			parentNode.setNext(newNode);
		}
	}
	
	/**
	 * Inserts the new node at the end of the linked list.
	 * 
	 * Time complexity of append is O(n) where n is the number of nodes in
	 * linked list. Since there is a loop from head to end, the function does
	 * O(n) work.
	 * 
	 * This method can also be optimized to work in O(1) by keeping an extra
	 * pointer to tail of linked list/
	 * 
	 * @param newNode
	 */
	public void append(Node<E> newNode) {
		// new node will be the last node, so set it's next to be null;
		newNode.setNext(null);
		
		if(head == null) {
			head = newNode;
		} else {
			Node<E> last = head;
			while(last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(newNode);
		}
	}
	
	/**
	 * Removes the provided node.
	 * 
	 * @param node
	 */
	public void remove(E element) {
		Node<E> currentNode = head;
		Node<E> previous = head;
		while(currentNode != null && !currentNode.getData().equals(element)) {
			previous = currentNode;
			currentNode = currentNode.getNext();
		}
		
		if(previous != null && currentNode != null) {
			if(previous == currentNode) {
				head = currentNode.getNext();
			} else {
				previous.setNext(currentNode.getNext());
			}
			
			// make available for garbage collection
			currentNode.setNext(null);
			currentNode = null;
		}
	}
	
	/**
	 * Returns the string representation of this oject.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		Node<E> tempNode = head;
		sBuilder.append("[");
		
		while(tempNode != null) {
			sBuilder.append(tempNode.getData());
			tempNode = tempNode.getNext();
			if(tempNode != null) {
				sBuilder.append(", ");
			}
		}
		
		sBuilder.append("]");
		return sBuilder.toString();
	}
	
}
