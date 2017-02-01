package com.rslakra.java.datastructure;

import com.rslakra.java.Node;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 01/31/2017 03:49:55 PM
 *
 */
public class DoublyLinedList<E> {
	
	private Node<E> head;
	
	/**
	 * 
	 * @param newNode
	 */
	public DoublyLinedList() {
	}
	
	/**
	 * Return the head node of the linked list.
	 * 
	 * @return
	 */
	public Node<E> getHead() {
		return this.head;
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
			head.setPrevious(newNode);
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
	 * pointer to tail of linked list.
	 * 
	 * @param newNode
	 */
	public void append(Node<E> newNode) {
		// new node will be the last node, so set it's next to be null;
		newNode.setNext(null);
		
		if(head == null) {
			head = newNode;
		} else {
			Node<E> lastNode = head;
			while(lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(newNode);
			newNode.setPrevious(lastNode);
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
	 * Removes the node of the specified position.
	 * 
	 * @param node
	 */
	public void removeAt(int position) {
		Node<E> currentNode = head;
		Node<E> previous = head;
		for(int i = 0; i < position - 1 && currentNode != null; i++) {
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
	 * Removes the first node of the linked list.
	 */
	public void removeFirst() {
		Node<E> current = head;
		head = current.getNext();
		current.setNext(null);
		current = null;
	}
	
	/**
	 * Removes the first node of the linked list.
	 *
	 * @param node
	 * @return
	 */
	// @Deprecated
	// public Node<E> removeFirst(Node<E> node) {
	// return (node == null ? null : node.getNext());
	// }
	
	/**
	 * Returns the size of the linked list.
	 * 
	 * @return
	 */
	public int size() {
		int size = 0;
		Node<E> current = head;
		while(current != null) {
			current = current.getNext();
			size++;
		}
		
		return size;
	}
	
	/**
	 * Returns the size of the linked list using recursion.
	 * 
	 * Time complexity of size is O(n) where n is the number of nodes in
	 * linked list. Since there is a loop from head to end, the function does
	 * O(n) work.
	 * 
	 * @param node
	 * @return
	 */
	public int size(Node<E> node) {
		return (node == null ? 0 : (1 + size(node.getNext())));
	}
	
	/**
	 * Return true if the linked list contains the specified node for an element
	 * otherwise false. The comparison is case-sensitive.
	 * 
	 * Time complexity of append is O(n) where n is the number of nodes in
	 * linked list. Since there is a loop from head to end, the function does
	 * O(n) work.
	 * 
	 * @param element
	 * @return
	 */
	public boolean contain(E element) {
		boolean contains = false;
		Node<E> current = head;
		while(current != null) {
			if(current.getData().equals(element)) {
				contains = true;
				break;
			}
			current = current.getNext();
		}
		
		return contains;
	}
	
	/**
	 * 
	 * @param node
	 * @param element
	 * @return
	 */
	public boolean contain(Node<E> node, E element) {
		return (node == null ? false : node.getData().equals(element) ? true : contain(node.getNext(), element));
	}
	
	/**
	 * Swaps the source node with the target node.
	 * 
	 * @param source
	 * @param target
	 */
	public void swapNodes(E source, E target) {
		if(source == target) {
			return;
		}
		
		// find source and its previous nodes.
		Node<E> sNode = head;
		Node<E> sPrevious = null;
		while(sNode != null && !sNode.getData().equals(source)) {
			sPrevious = sNode;
			sNode = sNode.getNext();
		}
		
		// find target and its previous nodes.
		Node<E> tNode = head;
		Node<E> tPrevious = null;
		while(tNode != null && !tNode.getData().equals(target)) {
			tPrevious = tNode;
			tNode = tNode.getNext();
		}
		
		// if any node does not exist, nothing to do.
		if(sNode == null || tNode == null) {
			return;
		}
		
		if(sPrevious != null) {
			sPrevious.setNext(tNode);
		} else {
			head = tNode;
		}
		
		if(tPrevious != null) {
			tPrevious.setNext(sNode);
		} else {
			head = sNode;
		}
		
		// swap next pointers
		Node<E> tempNode = sNode.getNext();
		sNode.setNext(tNode.getNext());
		tNode.setNext(tempNode);
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public E getValue(int index) {
		Node<E> current = head;
		int ctr = 0;
		while(current != null) {
			if(ctr == index) {
				break;
			}
			ctr++;
			current = current.getNext();
		}
		
		return (current == null ? null : current.getData());
	}
	
	/**
	 * Returns the string representation of this oject.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		Node<E> current = head;
		sBuilder.append("[");
		
		while(current != null) {
			sBuilder.append(current.getData());
			current = current.getNext();
			if(current != null) {
				sBuilder.append(", ");
			}
		}
		
		sBuilder.append("]");
		return sBuilder.toString();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DoublyLinedList<Integer> linkList = new DoublyLinedList<>();
		//push or prepend
//		linkList.push(new Node<Integer>(1));
//		linkList.push(new Node<Integer>(2));
//		linkList.push(new Node<Integer>(3));
		
		linkList.append(new Node<Integer>(1));
		linkList.append(new Node<Integer>(2));
		linkList.append(new Node<Integer>(3));

		System.out.println(linkList);
	}
	
}
