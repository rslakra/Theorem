package com.rslakra.testcases;

import com.rslakra.java.Node;
import com.rslakra.java.datastructure.LinkedList;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 11/03/2016 04:45:23 PM
 *
 */
public class TestLinkedList {
	
	/**
	 * 
	 */
	public void listNumbers() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertFirst(new Node<Integer>(1));
		Node<Integer> second = new Node<Integer>(2);
		list.insertLast(second);
		list.insertFirst(new Node<Integer>(0));
		list.insertLast(new Node<Integer>(3));
		list.insertAt(second, new Node<Integer>(4));
		System.out.println(list);
	}
	
	/**
	 * 
	 */
	public void listStrings() {
		LinkedList<String> list = new LinkedList<String>();
		list.insertFirst(new Node<String>("One"));
		Node<String> second = new Node<String>("Two");
		list.insertLast(second);
		list.insertFirst(new Node<String>("Zero"));
		list.insertLast(new Node<String>("Three"));
		list.insertAt(second, new Node<String>("Four"));
		System.out.println(list);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestLinkedList linkList = new TestLinkedList();
		linkList.listNumbers();
		linkList.listStrings();
	}
	
}
