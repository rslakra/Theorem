package com.rslakra.datastructure.linkedlist;

public class BasicLinkedList<E> {
	
	Node<E> first;
	Node<E> last;
	int count;
	
	private class Node<E> {
		E data;
		Node<E> next;
		
		Node(E item) {
			data = item;
			next = null;
		}
	}
	
	BasicLinkedList() {
		first = last = null;
	}
	
	public void addNode(E item) {
		Node<E> newNode = new Node<>(item);
		if(first == null) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		count++;
	}
	
	/**
	 * 
	 * @param position
	 * @param item
	 */
	public void insertAt(int position, E item) {
		if(count < position - 1) {
			throw new IllegalStateException("Linked list is already smaller than the position!");
		}
		
		Node<E> parent = null;
		Node<E> current = first;
		for(int i = 1; i < position && current != null; i++) {
			parent = current;
			current = current.next;
		}
		
		Node<E> newNode = new Node<>(item);
		if(parent == null) {
			newNode.next = first;
			first = newNode;
			last = newNode;
		} else {
			if(current == first) {
				newNode.next = first;
				first = newNode;
			} else if(current == last) {
				last.next = newNode;
				last = newNode;
			} else {
				newNode.next = parent.next;
				parent.next = newNode;
			}
		}
		count++;
	}
	
	public E removeFirst() {
		if(first == null) {
			return null;
		} else {
			E data = first.data;
			first = first.next;
			count--;
			return data;
		}
	}
	
	public void removeAt(E item, int position) {
		
	}
	
	public int size() {
		return count;
	}
	
	public String toString() {
		StringBuilder sBuilder = new StringBuilder("[");
		Node<E> temp = first;
		while(temp != null) {
			sBuilder.append(temp.data);
			if(temp.next != null) {
				sBuilder.append(", ");
			}
			temp = temp.next;
		}
		sBuilder.append("]");
		
		return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		BasicLinkedList<Integer> linkList = new BasicLinkedList<>();
		System.out.println(linkList.toString());
		
		linkList.addNode(1);
		linkList.addNode(2);
		linkList.addNode(3);
		System.out.println(linkList.toString());
		
		linkList.removeFirst();
		System.out.println(linkList.toString());
		
		linkList.insertAt(1, 1);
		System.out.println(linkList.toString());
		
		linkList.insertAt(2, 5);
		System.out.println(linkList.toString());
		linkList.insertAt(5, 11);
		System.out.println(linkList.toString());
	}
	
}
