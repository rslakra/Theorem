/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 * 
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 * 
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 * 
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.rslakra.datastructure.trees;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-08-30 08:28:16 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class BSTInteger {
	
	static class Node implements Comparable<Node> {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
		
		public boolean hasLeft() {
			return (left != null);
		}
		
		public boolean hasRight() {
			return (right != null);
		}
		
		/**
		 * @param other
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Node other) {
			return (other.data - data);
		}
		
		/**
		 * 
		 * @param data
		 * @return
		 */
		public Node findNode(int data) {
			if (data < this.data && hasLeft()) {
				return left.findNode(data);
			} else if (data > this.data && hasRight()) {
				return right.findNode(data);
			} else if (this.data == data) {
				return this;
			}
			
			return null;
		}
		
		/**
		 * 
		 * @param data
		 * @return
		 */
		public Node removeNode(int data) {
			Node deleted = null;
			
			return deleted;
		}
		
		/**
		 * 
		 * @return
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			final StringBuilder strBuilder = new StringBuilder();
			// add left node.
			if (this.hasLeft()) {
				strBuilder.append(left.toString());
			}
			
			// add root node.
			if (this.hasLeft()) {
				strBuilder.append(" ");
			}
			strBuilder.append(this.data);
			
			// add right node.
			if (this.hasRight()) {
				strBuilder.append(" ").append(this.right.toString());
			}
			
			return strBuilder.toString();
		}
	}
	
	private Node rootNode;
	
	public BSTInteger() {
	}
	
	/**
	 * 
	 * @param parent
	 * @param newNode
	 */
	private final void pushNode(Node parent, Node newNode) {
		if (parent.compareTo(newNode) <= 0) {
			if (parent.hasLeft()) {
				pushNode(parent.left, newNode);
			} else {
				parent.left = newNode;
			}
		} else if (parent.compareTo(newNode) > 0) {
			if (parent.hasRight()) {
				pushNode(parent.right, newNode);
			} else {
				parent.right = newNode;
			}
		}
	}
	
	/**
	 * 
	 * @param data
	 */
	public void addNode(int data) {
		final Node newNode = new Node(data);
		if (rootNode == null) {
			rootNode = newNode;
		} else {
			pushNode(rootNode, newNode);
		}
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public Node findNode(int data) {
		return (rootNode == null ? null : rootNode.findNode(data));
	}
	
	/**
	 * Returns the string representation of this object.
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("[" + (rootNode == null ? "" : rootNode.toString()) + "]");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BSTInteger bst = new BSTInteger();
		// 50, 76, 21, 4, 32, 100, 64, 52
		bst.addNode(50);
		bst.addNode(76);
		bst.addNode(21);
		bst.addNode(4);
		bst.addNode(32);
		bst.addNode(100);
		bst.addNode(64);
		bst.addNode(52);
		System.out.println(bst);
		
		System.out.println("Finding ... 32");
		Node found = bst.findNode(32);
		System.out.println("Found:" + found);
		
		System.out.println("Finding ... 64");
		found = bst.findNode(64);
		System.out.println("Found:" + found);
		
		System.out.println("Finding ... 80");
		found = bst.findNode(80);
		System.out.println("Found:" + found);
		
	}
	
}
