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
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertFirst(new Node<Integer>(1));
		Node<Integer> second = new Node<Integer>(2);
		list.insertLast(second);
		list.insertFirst(new Node<Integer>(0));
		list.insertLast(new Node<Integer>(3));
		list.insertAt(second, new Node<Integer>(4));
		System.out.println(list);
	}
	
}
