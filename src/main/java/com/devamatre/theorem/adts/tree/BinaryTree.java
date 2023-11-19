/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
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
package com.devamatre.theorem.adts.tree;

import java.util.Queue;

/**
 * Handle the binary tree management. This binary tree does not allow duplicate values.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-13 04:36:00 PM
 * @since 1.0.0
 */
public class BinaryTree<E extends Comparable<E>> {

    private Node<E> rootNode;
    private int size;

    public BinaryTree() {
        rootNode = null;
        size = 0;
    }

    /**
     * Returns the size of the binary tree;
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Inserts the new node at its respective position. It does not allow to add duplicate nodes.
     *
     * @param parentNode
     * @param newNode
     */
    private void insert(Node<E> parentNode, Node<E> newNode) {
        if (newNode.getValue().compareTo(parentNode.getValue()) < 0) {
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(newNode);
                newNode.setParent(parentNode);
                size++;
            } else {
                insert(parentNode.getLeft(), newNode);
            }
        } else if (newNode.getValue().compareTo(parentNode.getValue()) > 0) {
            if (parentNode.getRight() == null) {
                parentNode.setRight(newNode);
                newNode.setParent(parentNode);
                size++;
            } else {
                insert(parentNode.getRight(), newNode);
            }
        } else {
            // nothing to do here, as duplicates are not allowed in this binary
            // tree.
        }
    }

    /**
     * Add the given node in the binary tree.
     *
     * @param data
     */
    public void addNode(E data) {
        Node<E> newNode = new Node<E>(data);
        if (rootNode == null) {
            rootNode = newNode;
            size++;
        } else {
            insert(rootNode, newNode);
        }
    }

    /**
     * Finds and returns the node for the given data, if exists otherwise null.
     *
     * @param data
     * @return
     */
    private Node<E> findNode(E data) {
        Node<E> current = rootNode;
        while (current != null) {
            int result = data.compareTo(current.getValue());
            if (result < 0) {
                current = current.getLeft();
            } else if (result > 0) {
                current = current.getRight();
            } else {
                return current;
            }
        }

        return null;
    }

    /**
     * Returns true if the given node exists otherwise false.
     *
     * @param data
     * @return
     */
    public boolean contain(E data) {
        return (findNode(data) != null);
    }

    /**
     * @param currentNode
     * @param newNode
     */
    private void remove(Node<E> currentNode, Node<E> newNode) {
        if (currentNode == rootNode) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.rootNode = newNode;
        } else if (currentNode.getParent().getRight() == currentNode) {
            currentNode.getParent().setRight(newNode);
        } else {
            currentNode.getParent().setLeft(newNode);
        }
    }

    /**
     * Removes the <code>data</code> node from the tree, if exists.
     *
     * @param data
     * @return
     */
    public boolean remove(E data) {
        boolean deleted = false;
        if (rootNode != null) {
            // find node to be deleted.
            Node<E> delNode = findNode(data);

            // if node found
            if (delNode != null) {
                // easy, if it's the leaf node.
                if (delNode.isLeafNode()) {
                    remove(delNode, null);
                    deleted = true;
                } else if (delNode.hasRight() && !delNode.hasLeft()) {
                    // the node to be deleted has only right node
                    remove(delNode, delNode.getRight());
                    deleted = true;
                } else if (delNode.hasLeft() && !delNode.hasRight()) {
                    // the node to be deleted has only left node.
                    remove(delNode, delNode.getLeft());
                    deleted = true;
                } else {
                    // the node to be deleted has both left and right nodes.
                    Node<E> tempNode = delNode.getLeft();
                    while (tempNode != null && tempNode.hasChildren()) {
                        tempNode = tempNode.getRight();
                    }

                    tempNode.getParent().setRight(null);
                    tempNode.setLeft(delNode.getLeft());
                    tempNode.setRight(delNode.getRight());

                    remove(delNode, tempNode);
                    deleted = true;
                }
            }

            if (deleted) {
                size--;
            }
        }

        return deleted;
    }

    /**
     *
     */
    public void balanceTree() {

    }

    /**
     *
     */
    public void printTree() {

    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        if (rootNode != null) {
            Queue<Node<E>> queue = new java.util.LinkedList<Node<E>>();
            queue.add(rootNode);
            while (!queue.isEmpty()) {
                Node<E> node = queue.poll();
                sBuilder.append(node.getValue().toString());
                if (node.hasLeft()) {
                    queue.add(node.getLeft());
                }

                if (node.hasRight()) {
                    queue.add(node.getRight());
                }

                if (!queue.isEmpty()) {
                    sBuilder.append(", ");
                }
            }
        }

        return sBuilder.append("]").toString();
    }

    /**
     * @return
     */
    public Node<E> getLeftNode() {
        if (rootNode != null) {
            return rootNode.getLeft();
        }

        return null;
    }

    /**
     * @param newData
     */
    public void addLeftChild(final E newData) {
        if (rootNode == null) {
            rootNode = new Node<E>(newData);
        } else {
            rootNode.addLeftNode(newData);
        }
    }

    /**
     * @return
     */
    public Node<E> getRightNode() {
        if (rootNode != null) {
            return rootNode.getRight();
        }

        return null;
    }

    /**
     * @param newData
     */
    public void addRightChild(final E newData) {
        if (rootNode == null) {
            rootNode = new Node<E>(newData);
        } else {
            rootNode.addRightNode(newData);
        }
    }

}
