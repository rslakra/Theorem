package com.rslakra.datastructure.trees;

import java.util.Queue;

/**
 *
 * @author Rohtash Singh Lakra
 */
public class Tree<E extends Comparable<E>> {

	private Node<E> root;
	private int size;

	public Tree() {
		root = null;
		size = 0;
	}

	/**
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	public void add(E data) {
		Node<E> newNode = new Node<>(data);
		if (root == null) {
			root = newNode;
			size++;
		} else {
			insert(root, newNode);
		}
	}

	/**
	 * 
	 * @param parent
	 * @param child
	 * @return
	 */
	private void insert(Node<E> parent, Node<E> child) {
		// check, if node need to add in left side.
		if (child.getData().compareTo(parent.getData()) < 0) {
			if (child.getLeftNode() == null) {
				parent.setLeftNode(child);
				child.setParent(parent);
				size++;
			} else {
				insert(child.getLeftNode(), child);
			}
		} else if (child.getData().compareTo(parent.getData()) > 0) {
			if (child.getRightNode() == null) {
				parent.setRightNode(child);
				child.setParent(parent);
				size++;
			} else {
				insert(child.getRightNode(), child);
			}
		} else {
			// same data, don't allow duplicates in binary tree.
		}
	}

	/**
	 * Returns true if the node contain otherwise false.
	 * 
	 * @param data
	 * @return
	 */
	public boolean contain(E data) {
		return (findNode(data) != null);
	}

	/**
	 * Returns the node for the given data.
	 * 
	 * @param data
	 * @return
	 */
	private Node<E> findNode(E data) {
		if (data != null) {
			Node<E> current = root;
			while (current != null) {
				int result = data.compareTo(current.getData());
				if (result < 0) {
					current = current.getLeftNode();
				} else if (result > 0) {
					current = current.getRightNode();
				} else {
					return current;
				}
			}
		}

		return null;
	}

	/**
	 * 
	 * @param current
	 * @param newNode
	 */
	private void unlink(Node<E> current, Node<E> newNode) {
		if (root == current) {
			if (newNode != null) {
				newNode.setLeftNode(current.getLeftNode());
				newNode.setRightNode(current.getRightNode());
				root = newNode;
			}
		} else if (current.getParent().getRightNode() == current) {
			current.getParent().setRightNode(newNode);
		} else if (current.getParent().getLeftNode() == current) {
			current.getParent().setLeftNode(newNode);
		}
	}

	/**
	 * Returns true if the node is deleted otherwise false.
	 * 
	 * @param data
	 * @return
	 */
	public boolean delete(E data) {
		boolean deleted = false;

		// if not empty, check which node to delete.
		if (root != null) {
			Node<E> delNode = findNode(data);

			// if node exists, delete it.
			if (delNode != null) {
				// check, if it's a leaf node
				if (delNode.isLeafNode()) {
					unlink(delNode, null);
					deleted = true;
				}
				// check if it only has right child.
				else if (delNode.hasLeftChild()) {
					unlink(delNode, delNode.getRightNode());
					deleted = true;
				}
				// check if it only has left child.
				else if (delNode.hasLeftChild()) {
					unlink(delNode, delNode.getLeftNode());
					deleted = true;
				}
				// node has both children
				else {
					Node<E> child = delNode;
					// find right most child
					if (child.hasRightChild() && child.hasLeftChild()) {
						child = child.getRightNode();
					}

					// now replace it's right node.
					child.getParent().setRightNode(null);

					child.setLeftNode(delNode.getLeftNode());
					child.setRightNode(delNode.getRightNode());

					unlink(delNode, child);
					deleted = true;
				}
			}

			delNode = null;
		}

		if (deleted) {
			size--;
		}

		return deleted;
	}

	/**
	 * Returns the string representation of this object.
	 */
	public String toString() {
		StringBuilder sBuilder = new StringBuilder("[");
		if (root != null) {
			Queue<Node<E>> queue = new java.util.LinkedList<Node<E>>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node<E> node = queue.poll();
				sBuilder.append(node.getData().toString());
				if (node.hasLeftChild()) {
					queue.add(node.getLeftNode());
				}

				if (node.hasRightChild()) {
					queue.add(node.getRightNode());
				}

				if (!queue.isEmpty()) {
					sBuilder.append(", ");
				}
			}
		}

		return sBuilder.append("]").toString();
	}

}
