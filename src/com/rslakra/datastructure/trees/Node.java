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
	private Node<E> parent;
	private Node<E> leftNode;
	private Node<E> rightNode;
	
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
	 * Returns the value of data.
	 *
	 * @return the data
	 */
	public E getData() {
		return data;
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
	
	/**
	 * Adds the left node to the current node.
	 * 
	 * @param newData
	 */
	public void addLeftNode(final E newData) {
		final Node<E> newNode = new Node<E>(newData);
		if (this.hasLeftChild()) {
			newNode.setLeftNode(getLeftNode());
		}
		setLeftNode(newNode);
	}
	
	/**
	 * Adds the right node to the current node.
	 * 
	 * @param newData
	 */
	public void addRightNode(final E newData) {
		final Node<E> newNode = new Node<E>(newData);
		if (hasRightChild()) {
			newNode.setRightNode(getRightNode());
		}
		setRightNode(newNode);
	}
	
}
