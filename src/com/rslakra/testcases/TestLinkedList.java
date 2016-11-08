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
		Node<Integer> second = new Node<Integer>(2);
		list.push(new Node<Integer>(1));
		list.append(second);
		list.push(new Node<Integer>(0));
		list.append(new Node<Integer>(3));
		list.insertAfter(second, new Node<Integer>(4));
		System.out.println(list);
	}
	
	/**
	 * 
	 */
	public void listStrings() {
		LinkedList<String> list = new LinkedList<String>();
		list.push(new Node<String>("One"));
		Node<String> second = new Node<String>("Two");
		list.append(second);
		list.push(new Node<String>("Zero"));
		list.append(new Node<String>("Three"));
		list.insertAfter(second, new Node<String>("Four"));
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
