/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code, in source 
 * and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.datastructure.linkedlist;

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
