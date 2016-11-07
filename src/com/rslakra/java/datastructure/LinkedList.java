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
	 * @param newNode
	 */
	public void insertFirst(Node<E> newNode) {
		if(head == null) {
			head = newNode;
		} else {
			Node<E> temp = head;
			head = newNode;
			newNode.setNext(temp);
		}
	}
	
	/**
	 * Inserts the new node after the specified parent node.
	 * 
	 * @param parentNode
	 * @param newNode
	 */
	public void insertAt(Node<E> parentNode, Node<E> newNode) {
		if(parentNode == null) {
			parentNode = newNode;
		} else {
			if(parentNode.getNext() == null) {
				newNode.setNext(null);
			} else {
				newNode.setNext(parentNode.getNext());
			}
			parentNode.setNext(newNode);
		}
	}
	
	/**
	 * Inserts the new node at the end of the linked list.
	 * 
	 * @param newNode
	 */
	public void insertLast(Node<E> newNode) {
		Node<E> tempNode = head;
		while(tempNode.getNext() != null) {
			tempNode = tempNode.getNext();
		}
		
		insertAt(tempNode, newNode);
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
