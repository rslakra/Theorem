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

import com.devamatre.appsuite.core.BeanUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Handle the binary tree management. This binary tree does not allow duplicate values.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-13 04:36:00 PM
 * @since 1.0.0
 */
public class CountSortTree<E extends Comparable<E>> {

    private CountSortNode<E> rootNode;
    private int size;

    public CountSortTree() {
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
    private void insert(CountSortNode<E> parentNode, CountSortNode<E> newNode) {
        // if parentNode is null, make it the root node
        if (BeanUtils.isNull(parentNode)) {
            rootNode = newNode;
            rootNode.incrementCount();
            size++;
        } else {
            // if parentNode is not null, add the new node as the child node or increment the count if value is duplicate.
            if (newNode.compareTo(parentNode) < 0) {
                if (parentNode.hasLeft()) {
                    insert(parentNode.getLeft(), newNode);
                } else {
                    parentNode.setLeft(newNode);
                    newNode.setParent(parentNode);
                    size++;
                }
            } else if (newNode.compareTo(parentNode) > 0) {
                if (parentNode.getRight() == null) {
                    parentNode.setRight(newNode);
                    newNode.setParent(parentNode);
                    size++;
                } else {
                    insert(parentNode.getRight(), newNode);
                }
            } else {
                // In case of duplicates, just increment the count of the node.
                parentNode.incrementCount();
            }
        }
    }

    /**
     * Add the given node in the binary tree.
     *
     * @param data
     */
    public void addNode(E data) {
        insert(rootNode, new CountSortNode<E>(data));
    }

    /**
     * Finds and returns the node for the given data, if exists otherwise null.
     *
     * @param data
     * @return
     */
    private CountSortNode<E> findNode(E data) {
        CountSortNode<E> current = rootNode;
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
    private void remove(CountSortNode<E> currentNode, CountSortNode<E> newNode) {
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
     * Deletes the given node, if exists.
     *
     * @param data
     */
    public boolean delete(E data) {
        boolean deleted = false;
        if (rootNode != null) {
            // find node to be deleted.
            CountSortNode<E> delNode = findNode(data);

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
                    CountSortNode<E> tempNode = delNode.getLeft();
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
     * @see Object#toString()
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        if (rootNode != null) {
            Queue<CountSortNode<E>> queue = new LinkedList<>();
            queue.add(rootNode);
            while (!queue.isEmpty()) {
                CountSortNode<E> node = queue.poll();
                sBuilder.append(node.getValue());
                int count = node.getCount();
                while (count > 0) {
                    sBuilder.append(", ");
                    sBuilder.append(node.getValue());
                    count--;
                }
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
    public CountSortNode<E> getLeftNode() {
        return (rootNode != null ? rootNode.getLeft() : null);
    }

    /**
     * @param newData
     */
    public void addLeftChild(final E newData) {
        if (rootNode == null) {
            rootNode = new CountSortNode<>(newData);
        } else {
            rootNode.addLeftNode(newData);
        }
    }

    /**
     * @return
     */
    public CountSortNode<E> getRightNode() {
        return (rootNode != null ? rootNode.getRight() : null);
    }

    /**
     * @param newData
     */
    public void addRightChild(E newData) {
        if (rootNode == null) {
            rootNode = new CountSortNode<>(newData);
        } else {
            rootNode.addRightNode(newData);
        }
    }

}
