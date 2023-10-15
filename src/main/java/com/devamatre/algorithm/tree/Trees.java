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
package com.devamatre.algorithms.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Three Algorithms.
 *
 * @author Rohtash Singh Lakra
 * @date 07/03/2017 04:12:06 PM
 */
public class Trees {
	
	static class Node<T> {
		
		private T data;
		private Node<T> leftChild;
		private Node<T> rightChild;
		
		/**
		 * 
		 * @param data
		 */
		public Node(T data) {
			this.data = data;
			leftChild = null;
			rightChild = null;
		}
		
		/**
		 * Returns the data.
		 * 
		 * @return
		 */
		public T getData() {
			return data;
		}
		
		/**
		 * Returns the leftChild.
		 * 
		 * @return
		 */
		public Node<T> getLeftChild() {
			return leftChild;
		}
		
		/**
		 * The leftChild to be set.
		 * 
		 * @param leftChild
		 */
		public void setLeftChild(Node<T> leftChild) {
			this.leftChild = leftChild;
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean hasLeftChild() {
			return (this.leftChild != null);
		}
		
		/**
		 * Returns the rightChild.
		 * 
		 * @return
		 */
		public Node<T> getRightChild() {
			return rightChild;
		}
		
		/**
		 * The rightChild to be set.
		 * 
		 * @param rightChild
		 */
		public void setRightChild(Node<T> rightChild) {
			this.rightChild = rightChild;
		}
		
		/**
		 * 
		 * @return
		 */
		public boolean hasRightChild() {
			return (this.rightChild != null);
		}
		
		/**
		 * Returns the string representation of this object.
		 * 
		 * Pre-Order Traversal
		 * 
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return preOrderTraversal(this, false);
		}
		
		/**
		 * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
		 * 
		 * Until all nodes are traversed:
		 * Step 1 − Visit root node.
		 * Step 2 − Recursively traverse left subtree.
		 * Step 3 − Recursively traverse right subtree.
		 * 
		 * @param node
		 * @param addBrackets
		 * @return
		 */
		public String preOrderTraversal(Node<T> node, final boolean addBrackets) {
			final StringBuilder nodeBuilder = new StringBuilder();
			if (addBrackets) {
				nodeBuilder.append("[");
			}
			
			/*
			 * Push root node in the stack. Iterate until stack is empty.
			 * Pop all items one by one. Do following for every popped item:
			 * a) print it
			 * b) push its right child
			 * c) push its left child
			 * Note that right child is pushed first so that left is processed
			 * first.
			 */
			if (node != null) {
				final Stack<Node<T>> stack = new Stack<>();
				stack.push(node);
				while (!stack.isEmpty()) {
					node = stack.pop();
					// append root node
					nodeBuilder.append(node.data).append(" ");
					
					// push right node
					if (node.hasRightChild()) {
						stack.push(node.getRightChild());
					}
					
					// push left node
					if (node.hasLeftChild()) {
						stack.push(node.getLeftChild());
					}
				}
				
				// remove last white space.
				TreeUtils.trimLastSpace(nodeBuilder);
			}
			
			if (addBrackets) {
				nodeBuilder.append("]");
			}
			
			return nodeBuilder.toString();
		}
		
		/**
		 * Traverses a tree in an in-order (LEFT-ROOT-RIGHT) manner.
		 * 
		 * Until all nodes are traversed:
		 * Step 1 − Recursively traverse left subtree.
		 * Step 2 − Visit root node.
		 * Step 3 − Recursively traverse right subtree.
		 */
		public String inOrderTraversal(Node<T> node, final boolean addBrackets) {
			final StringBuilder nodeBuilder = new StringBuilder();
			if (addBrackets) {
				nodeBuilder.append("[");
			}
			
			/*
			 * Create empty stack.
			 * Iterate until stack is empty or node != null.
			 * If node != null, push the node into stack and assign traverse to
			 * left tree.
			 * Else pop item from the stack, print it and traverse to right
			 * tree.
			 */
			if (node != null) {
				final Stack<Node<T>> stack = new Stack<>();
				while (!stack.isEmpty() || node != null) {
					if (node != null) {
						stack.push(node);
						node = node.leftChild;
					} else {
						node = stack.pop();
						// append node
						nodeBuilder.append(node.data).append(" ");
						node = node.rightChild;
					}
				}
				
				// remove last white space.
				TreeUtils.trimLastSpace(nodeBuilder);
			}
			
			if (addBrackets) {
				nodeBuilder.append("]");
			}
			
			return nodeBuilder.toString();
		}
		
		/**
		 * Traverses a tree in a post-order (LEFT-RIGHT-ROOT) manner.
		 * 
		 * Until all nodes are traversed:
		 * Step 1 − Recursively traverse left subtree.
		 * Step 2 − Recursively traverse right subtree.
		 * Step 3 − Visit root node.
		 */
		public String postOrderTraversal(Node<T> node, final boolean addBrackets) {
			final StringBuilder nodeBuilder = new StringBuilder();
			if (addBrackets) {
				nodeBuilder.append("[");
			}
			
			/*
			 * Create empty stack.
			 * Set lastVisited to be nulll;
			 * Iterate until stack is empty or node != null
			 * If node != null, push the node into stack and traverse to left
			 * tree.
			 * Else peek item from the stack and do the following
			 * if peekNode.right != null and lastVisited != peekNode.right then
			 * traverse to right tree
			 * node = peekNode.right
			 * else
			 * visit(node)
			 * lastVisited = stack.pop()
			 */
			if (node != null) {
				final Stack<Node<T>> stack = new Stack<>();
				Node<T> lastVisited = null;
				while (!stack.isEmpty() || node != null) {
					if (node != null) {
						stack.push(node);
						node = node.leftChild;
					} else {
						Node<T> peekNode = stack.peek();
						if (peekNode.rightChild != null && lastVisited != peekNode.rightChild) {
							node = peekNode.rightChild;
						} else {
							// append node
							nodeBuilder.append(peekNode.data).append(" ");
							lastVisited = stack.pop();
						}
					}
				}
				
				// remove last white space.
				TreeUtils.trimLastSpace(nodeBuilder);
			}
			
			if (addBrackets) {
				nodeBuilder.append("]");
			}
			
			return nodeBuilder.toString();
		}
		
		/**
		 * Traverses a tree in a level order manner.
		 * 
		 * Until all nodes are traversed:
		 * Step 1 − Visit root node.
		 * Step 2 − Traverse left and right siblings.
		 * Step 3 − Iterate till the leafs.
		 */
		public String levelOrderTraversal(Node<T> node, final boolean addBrackets) {
			final StringBuilder nodeBuilder = new StringBuilder();
			if (addBrackets) {
				nodeBuilder.append("[");
			}
			
			/*
			 * Create empty Queue.
			 * Add root node into the queue.
			 * Iterate until queue is empty
			 * Poll node from the queue.
			 * Visit node.
			 * If node's left child is not null, push into the queue.
			 * If node's right child is not null, push into the queue.
			 */
			if (node != null) {
				final Queue<Node<T>> queue = new LinkedList<>();
				queue.offer(node);
				while (!queue.isEmpty()) {
					node = queue.poll();
					// append node
					nodeBuilder.append(node.data).append(" ");
					if (node.leftChild != null) {
						queue.offer(node.leftChild);
					}
					if (node.rightChild != null) {
						queue.offer(node.rightChild);
					}
				}
				
				// remove last white space.
				TreeUtils.trimLastSpace(nodeBuilder);
			}
			
			if (addBrackets) {
				nodeBuilder.append("]");
			}
			
			return nodeBuilder.toString();
		}
		
		private class TempNode {
			Node<T> node;
			int level;
			
			TempNode(Node<T> node, int level) {
				this.node = node;
				this.level = level;
			}
		}
		
		/**
		 * 
		 * @param node
		 * @param addBrackets
		 * @return
		 */
		public String treeViewTraversal(Node<T> node, final boolean addBrackets) {
			final StringBuilder nodeBuilder = new StringBuilder();
			if (addBrackets) {
				nodeBuilder.append("[");
			}
			
			/*
			 * Create empty Queue.
			 * Add root node into the queue.
			 * Iterate until queue is empty
			 * Poll node from the queue.
			 * Visit node.
			 * If node's left child is not null, push into the queue.
			 * If node's right child is not null, push into the queue.
			 */
			if (node != null) {
				final HashMap<Integer, Node<T>> treeView = new HashMap<>();
				final Queue<TempNode> queue = new LinkedList<>();
				queue.offer(new TempNode(node, 0));
				while (!queue.isEmpty()) {
					TempNode tempNode = queue.poll();
					if (!treeView.containsKey(tempNode.level)) {
						// append node
						nodeBuilder.append(tempNode.node.data).append(" ");
						treeView.put(tempNode.level, tempNode.node);
					}
					
					if (tempNode.node.leftChild != null) {
						queue.offer(new TempNode(tempNode.node.leftChild, tempNode.level - 1));
					}
					
					if (tempNode.node.rightChild != null) {
						queue.offer(new TempNode(tempNode.node.rightChild, tempNode.level + 1));
					}
				}
				
				// remove last white space.
				TreeUtils.trimLastSpace(nodeBuilder);
			}
			
			if (addBrackets) {
				nodeBuilder.append("]");
			}
			
			return nodeBuilder.toString();
		}
		
		/**
		 * 
		 * @param node
		 * @param addBrackets
		 * @return
		 */
		public String treeBottomViewTraversal(Node<T> node, final boolean addBrackets) {
			final StringBuilder nodeBuilder = new StringBuilder();
			if (addBrackets) {
				nodeBuilder.append("[");
			}
			
			/*
			 * Create empty Queue.
			 * Add root node into the queue.
			 * Iterate until queue is empty
			 * Poll node from the queue.
			 * Visit node.
			 * If node's left child is not null, push into the queue.
			 * If node's right child is not null, push into the queue.
			 */
			if (node != null) {
				final Map<Integer, Node<T>> treeBottomView = new TreeMap<>();
				final Queue<TempNode> queue = new LinkedList<>();
				queue.offer(new TempNode(node, 0));
				while (!queue.isEmpty()) {
					TempNode tempNode = queue.poll();
					treeBottomView.put(tempNode.level, tempNode.node);
					if (tempNode.node.leftChild != null) {
						queue.offer(new TempNode(tempNode.node.leftChild, tempNode.level - 1));
					}
					
					if (tempNode.node.rightChild != null) {
						queue.offer(new TempNode(tempNode.node.rightChild, tempNode.level + 1));
					}
				}
				
				treeBottomView.forEach((k, v) -> {
					nodeBuilder.append(v.data).append(" ");
				});
				
				// remove last white space.
				TreeUtils.trimLastSpace(nodeBuilder);
			}
			
			if (addBrackets) {
				nodeBuilder.append("]");
			}
			
			return nodeBuilder.toString();
		}
		
		/**
		 * 
		 * @param node
		 * @param addBrackets
		 * @return
		 */
		public String treeLeftViewTraversal(Node<T> node, final boolean addBrackets) {
			final StringBuilder nodeBuilder = new StringBuilder();
			if (addBrackets) {
				nodeBuilder.append("[");
			}
			
			/*
			 * Create empty Queue.
			 * Add root node into the queue.
			 * Iterate until queue is empty
			 * Poll node from the queue.
			 * Visit node.
			 * If node's left child is not null, push into the queue.
			 * If node's right child is not null, push into the queue.
			 */
			if (node != null) {
				final Map<Integer, Node<T>> treeLeftView = new TreeMap<>();
				final Queue<TempNode> queue = new LinkedList<>();
				queue.offer(new TempNode(node, 0));
				while (!queue.isEmpty()) {
					TempNode tempNode = queue.poll();
					if (!treeLeftView.containsKey(tempNode.level)) {
						treeLeftView.put(tempNode.level, tempNode.node);
					}
					if (tempNode.node.leftChild != null) {
						queue.offer(new TempNode(tempNode.node.leftChild, tempNode.level + 1));
					}
					
					if (tempNode.node.rightChild != null) {
						queue.offer(new TempNode(tempNode.node.rightChild, tempNode.level + 1));
					}
				}
				
				treeLeftView.forEach((k, v) -> {
					nodeBuilder.append(v.data).append(" ");
				});
				
				// remove last white space.
				TreeUtils.trimLastSpace(nodeBuilder);
			}
			
			if (addBrackets) {
				nodeBuilder.append("]");
			}
			
			return nodeBuilder.toString();
		}
		
		/**
		 * 
		 * @param node
		 * @param addBrackets
		 * @return
		 */
		public String treeRightViewTraversal(Node<T> node, final boolean addBrackets) {
			final StringBuilder nodeBuilder = new StringBuilder();
			if (addBrackets) {
				nodeBuilder.append("[");
			}
			
			/*
			 * Create empty Queue.
			 * Add root node into the queue.
			 * Iterate until queue is empty
			 * Poll node from the queue.
			 * Visit node.
			 * If node's left child is not null, push into the queue.
			 * If node's right child is not null, push into the queue.
			 */
			if (node != null) {
				final Map<Integer, Node<T>> treeLeftView = new TreeMap<>();
				final Queue<TempNode> queue = new LinkedList<>();
				queue.offer(new TempNode(node, 0));
				while (!queue.isEmpty()) {
					TempNode tempNode = queue.poll();
					treeLeftView.put(tempNode.level, tempNode.node);
					if (tempNode.node.leftChild != null) {
						queue.offer(new TempNode(tempNode.node.leftChild, tempNode.level + 1));
					}
					
					if (tempNode.node.rightChild != null) {
						queue.offer(new TempNode(tempNode.node.rightChild, tempNode.level + 1));
					}
				}
				
				treeLeftView.forEach((k, v) -> {
					nodeBuilder.append(v.data).append(" ");
				});
				
				// remove last white space.
				TreeUtils.trimLastSpace(nodeBuilder);
			}
			
			if (addBrackets) {
				nodeBuilder.append("]");
			}
			
			return nodeBuilder.toString();
		}
	}
	
	static enum TraversalMode {
		PRE_ORDER_TRAVERSAL, IN_ORDER_TRAVERSAL, POST_ORDER_TRAVERSAL;
	}
	
	static class IntBinaryTree {
		Node<Integer> rootNode;
		
		/**
		 * Adds the node as the child of the parent node. the position.
		 * 
		 * @param parentNode
		 * @param currentNode
		 */
		protected void insertNode(Node<Integer> parentNode, Node<Integer> currentNode, boolean isLeft) {
			if (isLeft) {
				parentNode.setLeftChild(currentNode);
			} else {
				parentNode.setRightChild(currentNode);
			}
		}
		
		/**
		 * Inserts an element in a tree/create a tree.
		 * 
		 * 
		 * @param parentNode
		 * @param newNode
		 */
		public void insertNode(int data) {
			Node<Integer> tempNode = new Node<Integer>(data);
			if (rootNode == null) {
				rootNode = tempNode;
			} else {
				Node<Integer> parentNode = rootNode;
				Node<Integer> currentNode = rootNode;
				if (currentNode.getData() != data) {
					while (currentNode != null) {
						if (data < currentNode.getData()) {
							// goto left subtree
							if (currentNode.hasLeftChild()) {
								parentNode = currentNode.getLeftChild();
							}
							currentNode = currentNode.getLeftChild();
							// add new node
							if (currentNode == null) {
								insertNode(parentNode, tempNode, true);
							}
						} else if (data > currentNode.getData()) {
							// goto right subtree
							if (currentNode.hasRightChild()) {
								parentNode = currentNode.getRightChild();
							}
							currentNode = currentNode.getRightChild();
							// add new node
							if (currentNode == null) {
								insertNode(parentNode, tempNode, false);
							}
						}
					}
				}
			}
		}
		
		/**
		 * Searches an element in a tree.
		 * 
		 * @param findWhat
		 */
		public Node<Integer> searchNode(final Integer findWhat) {
			Node<Integer> currentNode = rootNode;
			while (currentNode != null) {
				if (findWhat < currentNode.getData()) {
					// goto left subtree
					currentNode = currentNode.getLeftChild();
				} else if (findWhat > currentNode.getData()) {
					// goto right subtree
					currentNode = currentNode.getRightChild();
				} else {
					break;
				}
			}
			
			return currentNode;
		}
		
		/**
		 * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
		 * 
		 * Until all nodes are traversed:
		 * Step 1 − Visit root node.
		 * Step 2 − Recursively traverse left subtree.
		 * Step 3 − Recursively traverse right subtree.
		 */
		public void preOrderTraversal() {
			System.out.println(rootNode.preOrderTraversal(rootNode, true));
		}
		
		/**
		 * Traverses a tree in an in-order (LEFT-ROOT-RIGHT) manner.
		 * 
		 * Until all nodes are traversed:
		 * Step 1 − Recursively traverse left subtree.
		 * Step 2 − Visit root node.
		 * Step 3 − Recursively traverse right subtree.
		 */
		public void inOrderTraversal() {
			System.out.println(rootNode.inOrderTraversal(rootNode, true));
		}
		
		/**
		 * Traverses a tree in a post-order (LEFT-RIGHT-ROOT) manner.
		 * 
		 * Until all nodes are traversed:
		 * Step 1 − Recursively traverse left subtree.
		 * Step 2 − Recursively traverse right subtree.
		 * Step 3 − Visit root node.
		 */
		public void postOrderTraversal() {
			System.out.println(rootNode.postOrderTraversal(rootNode, true));
		}
		
		/**
		 * Prints the level order traversal order manner.
		 */
		public void levelOrderTraversal() {
			System.out.println(rootNode.levelOrderTraversal(rootNode, true));
		}
		
		/**
		 * 
		 * @return
		 */
		public void treeViewTraversal() {
			System.out.println(rootNode.treeViewTraversal(rootNode, true));
		}
		
		/**
		 * 
		 * @return
		 */
		public void treeBottomViewTraversal() {
			System.out.println(rootNode.treeBottomViewTraversal(rootNode, true));
		}
		
		/**
		 * 
		 * @return
		 */
		public void treeLeftViewTraversal() {
			System.out.println(rootNode.treeLeftViewTraversal(rootNode, true));
		}
		
		/**
		 * 
		 * @return
		 */
		public void treeRightViewTraversal() {
			System.out.println(rootNode.treeRightViewTraversal(rootNode, true));
		}
		
		/**
		 * Removes the node of the tree.
		 * 
		 * @param node
		 */
		public void removeNode(Node<Integer> node) {
		}
		
		/**
		 * 
		 */
		public String toString() {
			return "[" + (rootNode == null ? "" : rootNode.toString()) + "]";
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		IntBinaryTree bTree = new IntBinaryTree();
		bTree.insertNode(50);
		bTree.insertNode(21);
		bTree.insertNode(4);
		bTree.insertNode(32);
		bTree.insertNode(3);
		bTree.insertNode(16);
		bTree.insertNode(60);
		bTree.insertNode(55);
		bTree.insertNode(75);
		System.out.println(bTree);
		System.out.println();
		Node<Integer> nodeFound = bTree.searchNode(16);
		System.out.println(nodeFound);
		
		System.out.println("PreOrder Traversal");
		bTree.preOrderTraversal();
		System.out.println("InOrder Traversal");
		bTree.inOrderTraversal();
		System.out.println("PostOrder Traversal");
		bTree.postOrderTraversal();
		
		System.out.println("Level Order Traversal");
		bTree.levelOrderTraversal();
		
		System.out.println("Tree TopView Traversal");
		bTree.treeViewTraversal();
		System.out.println("Tree BottomView Traversal");
		bTree.treeBottomViewTraversal();
		System.out.println("Tree LeftView Traversal");
		bTree.treeLeftViewTraversal();
		System.out.println("Tree RightView Traversal");
		bTree.treeRightViewTraversal();
	}
	
}
