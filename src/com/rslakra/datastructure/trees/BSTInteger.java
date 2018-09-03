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
		
		/**
		 * Returns true if the current node has left node.
		 * 
		 * @return
		 */
		public boolean hasLeft() {
			return (left != null);
		}
		
		/**
		 * Returns true if the current node is the left node of the given
		 * parent.
		 * 
		 * @param parent
		 * @return
		 */
		public boolean isLeftOf(Node parent) {
			return (parent != null && parent.hasLeft() && this.compareTo(parent.left) == 0);
		}
		
		/**
		 * Returns true if the current node is the right node of the given
		 * parent.
		 * 
		 * @param parent
		 * @return
		 */
		public boolean isRightOf(Node parent) {
			return (parent != null && parent.hasRight() && this.compareTo(parent.right) == 0);
		}
		
		/**
		 * Returns true if the current node has right node.
		 * 
		 * @return
		 */
		public boolean hasRight() {
			return (right != null);
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean hasChildren() {
			return (hasLeft() && hasRight());
		}
		
		/**
		 * @param other
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Node other) {
			return (other != null ? other.data - data : -1);
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
	 * Removes the given node recursively.
	 * 
	 * @param parent
	 * @param current
	 * @param data
	 */
	private void removeNode(Node parent, Node current, int data) {
		if (data < current.data && current.hasLeft()) {
			removeNode(current, current.left, data);
		} else if (data > current.data && current.hasRight()) {
			removeNode(current, current.right, data);
		} else if (current.data == data) {
			// Case 1 - Node has no child.
			if (parent != null) {
				if (current.isLeftOf(parent)) {
					// case has both parents.
					if (current.hasChildren()) {
						parent.left = current.right;
						pushNode(current.right, current.left);
					}
					// Case 2 - Node has only 1 child
					else if (current.hasLeft()) {
						parent.left = current.left;
					} else if (current.hasRight()) {
						parent.left = current.right;
					}
					
					// Node has no child
					else {
						parent.left = null;
					}
				} else if (current.isRightOf(parent)) {
					// Case 3 - Node has both children
					if (current.hasChildren()) {
						parent.right = current.right;
						pushNode(current.right, current.left);
					}
					// Case 2 - Node has only 1 child
					else if (current.hasLeft()) {
						parent.left = current.left;
					} else if (current.hasRight()) {
						parent.right = current.right;
					}
					
					// Node has no child
					else {
						parent.right = null;
					}
				}
			} else {
				// Case 3 - Node has both children
				if (current.hasChildren()) {
					pushNode(current.right, current.left);
					rootNode = current.right;
				}
				// Case 2 - Node has only 1 child
				else if (current.hasLeft()) {
					if (current.left.hasChildren()) {
						rootNode = current.left.right;
						current.left.right = null;
						pushNode(rootNode, current.left);
					} else if (current.left.hasLeft()) {
						rootNode = current.left.left;
					} else if (current.left.hasRight()) {
						rootNode = current.left.right;
					}
				} else if (current.hasRight()) {
					rootNode = current.right;
				}
				
				// Node has no child
				else {
					rootNode = null;
				}
			}
		}
	}
	
	/**
	 * Removes the given node.
	 * 
	 * @param data
	 */
	public void removeNode(int data) {
		if (rootNode != null) {
			removeNode(null, rootNode, data);
		}
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
		// 50, 76, 21, 4, 16, 3, 32, 100, 64, 52, 102
		
		// Add Nodes
		bst.addNode(50);
		// bst.addNode(76);
		
		bst.addNode(21);
		bst.addNode(4);
		bst.addNode(16);
		bst.addNode(3);
		bst.addNode(32);
		
		// bst.addNode(100);
		// bst.addNode(64);
		// bst.addNode(52);
		// bst.addNode(102);
		System.out.println(bst);
		
		// Find Node
		System.out.println("Finding ... 32");
		Node found = bst.findNode(32);
		System.out.println("Found:" + found);
		
		System.out.println("Finding ... 64");
		found = bst.findNode(64);
		System.out.println("Found:" + found);
		
		System.out.println("Finding ... 80");
		found = bst.findNode(80);
		System.out.println("Found:" + found);
		
		// Delete Node.
		bst.removeNode(50);
		System.out.println(bst);
	}
	
}
