/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 * 
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.datastructure.trees;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-13 04:35:49 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class Node<E> {

	private E data;
	private Node<E> leftNode;
	private Node<E> rightNode;
	private Node<E> parent;

	/**
	 * Returns the value of data.
	 *
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * 
	 * @param data
	 */
	public Node(E data) {
		this.data = data;
		leftNode = null;
		rightNode = null;
		parent = null;
	}

	/**
	 * Returns true if the left node is not null otherwise false.
	 * 
	 * @return
	 */
	public boolean hasLeftChild() {
		return (leftNode != null);
	}

	/**
	 * Returns the value of leftNode.
	 *
	 * @return the leftNode
	 */
	public Node<E> getLeftNode() {
		return leftNode;
	}

	/**
	 * The leftNode to be set.
	 *
	 * @param leftNode
	 *            the leftNode to set
	 */
	public void setLeftNode(Node<E> leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * Returns true if the right node is not null otherwise false.
	 * 
	 * @return
	 */
	public boolean hasRightChild() {
		return (rightNode != null);
	}

	/**
	 * Returns the value of rightNode.
	 *
	 * @return the rightNode
	 */
	public Node<E> getRightNode() {
		return rightNode;
	}

	/**
	 * The rightNode to be set.
	 *
	 * @param rightNode
	 *            the rightNode to set
	 */
	public void setRightNode(Node<E> rightNode) {
		this.rightNode = rightNode;
	}

	/**
	 * Returns the value of parent.
	 *
	 * @return the parent
	 */
	public Node<E> getParent() {
		return parent;
	}

	/**
	 * The parent to be set.
	 *
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Node<E> parent) {
		this.parent = parent;
	}

	/**
	 * Returns true if this is leaf node (means both left and right nodes are
	 * empty of this node).
	 * 
	 * @return
	 */
	public boolean isLeafNode() {
		return (leftNode == null && rightNode == null);
	}

	/**
	 * Returns true if the node has both left and right children otherwise
	 * false.
	 * 
	 * @return
	 */
	public boolean hasChildren() {
		return (leftNode != null && rightNode != null);
	}

}
