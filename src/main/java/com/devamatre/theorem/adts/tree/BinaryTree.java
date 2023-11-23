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
import java.util.Objects;
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

    private Node<E> root;
    private int size;

    public BinaryTree() {
        setRoot(null);
        size = 0;
    }

    /**
     * Returns the <code>root</code> node.
     *
     * @return
     */
    public Node<E> getRoot() {
        return this.root;
    }

    /**
     * The <code>root</code> node to be set.
     *
     * @return
     */
    private void setRoot(Node<E> root) {
        this.root = root;
        if (this.root != null) {
            root.setParent(null);
        }
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
     * Adds the new node at its respective position.
     *
     * @param parentNode
     * @param newNode
     */
    public void addNode(Node<E> parentNode, Node<E> newNode) {
        // Case 1: The tree is empty - allocate the head
        if (BeanUtils.isNull(parentNode)) {
            setRoot(newNode);
            size++;
        } else {
            /* Case 2: The tree is not empty so find the right location to insert  */

            // Case 1: if the parentNode's data >= newNode, then add newNode as left child.
            if (parentNode.compareTo(newNode) >= 0) {
                // if parent node has left child, add it to the left node
                if (parentNode.hasLeft()) {
                    addNode(parentNode.getLeft(), newNode);
                } else {
                    // there is no left child, make it the new left node
                    parentNode.setLeft(newNode);
                    newNode.setParent(parentNode);
                    size++;
                }
            } else {
                /**
                 Case 2: if the parentNode's data < newNode, then add newNode as right child.
                 */
                if (parentNode.hasRight()) {
                    addNode(parentNode.getRight(), newNode);
                } else {
                    // there is no right child, make it the new right node
                    parentNode.setRight(newNode);
                    newNode.setParent(parentNode);
                    size++;
                }
            }
        }
    }

    /**
     * Adds the <code>data</code> to the binary tree.
     *
     * @param data
     * @return
     */
    public void addNode(final Node<E> parentNode, final E data) {
        addNode(parentNode, new Node<E>(data));
    }

    /**
     * Add the given node in the binary tree.
     *
     * @param data
     */
    public void addNode(E data) {
        addNode(getRoot(), new Node<E>(data));
    }

    /**
     * Finds and returns the node for the given data, if exists otherwise null.
     *
     * @param data
     * @return
     */
    private Node<E> findNode(E data) {
        // find node's in the tree with the provided <code>value</code>
        Node<E> current = getRoot();
        while (current != null) {
            if (current.isGreaterThan(data)) {
                // if the current node is greater than data, find in left.
                current = current.getLeft();
            } else if (current.isLessThan(data)) {
                // if the current node is less than data, find in right.
                current = current.getRight();
            } else {
                // find a match
                break;
            }
        }

        return current;
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
     * Removes the node.
     *
     * @param delNode
     * @param nextNode
     */
    private void removeNodeWithoutParentHandling(Node<E> delNode, Node<E> nextNode) {
        // if removing node is root node, the delNode should be equal to root.
        if (getRoot() == delNode) {
            if (BeanUtils.isNotNull(nextNode)) {
                nextNode.setParent(null);
                nextNode.setLeft(delNode.getLeft());
                nextNode.setRight(delNode.getRight());
            }
            setRoot(nextNode);
            delNode = null;
        } else if (delNode.getParent().getRight() == delNode) {
            // if removing node is right node, the current node's parent should be equal to its parent node.
            delNode.getParent().setRight(nextNode);
        } else {
            // if removing node is left node, the current node's parent should be equal to it's parent node.
            delNode.getParent().setLeft(nextNode);
        }
    }

    /**
     * Removes the <code>nodeData</code> node from the tree, if exists and the node class has no parent handling.
     *
     * @param nodeData
     * @return
     */
    public boolean removeNodeWithoutParentHandling(E nodeData) {
        boolean deleted = false;
        if (Objects.nonNull(getRoot())) {
            // find node to be deleted.
            Node<E> delNode = findNode(nodeData);
            // if found
            if (delNode != null) {
                // easy, if it's the leaf node.
                if (delNode.isLeafNode()) {
                    removeNodeWithoutParentHandling(delNode, null);
                    deleted = true;
                } else if (delNode.hasRight() && !delNode.hasLeft()) {
                    // the node to be deleted has only right node
                    removeNodeWithoutParentHandling(delNode, delNode.getRight());
                    deleted = true;
                } else if (delNode.hasLeft() && !delNode.hasRight()) {
                    // the node to be deleted has only left node.
                    removeNodeWithoutParentHandling(delNode, delNode.getLeft());
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

                    removeNodeWithoutParentHandling(delNode, tempNode);
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
     * Removes the first occurrence of the provided <code>nodeData</code> from the tree, if exists and the node class
     * has parent handling.
     *
     * @param nodeData
     */
    public boolean removeNodeWithParentHandling(final E nodeData) {
        boolean deleted = false;
        Node<E> delNode = findNode(nodeData);
        if (Objects.nonNull(delNode)) {
            // decrease the node count
            size--;

            // Get delNode's parent node
            final Node<E> parent = delNode.getParent();

            //Case 1: if the delNode is a leaf node (no children), just remove it (easy)
            if (delNode.isLeafNode()) {
                delNode = null;
            } else if (!delNode.hasRight()) {
                /* Case 2: If delNode node has no right child (only left), then delNode's left replaces delNode node.*/
                if (Objects.isNull(parent)) {
                    // delNode's left replaces the root node.
                    setRoot(delNode.getLeft());
                } else {
                    if (parent.isGreaterThan(nodeData)) {
                        /**
                         * if parent node's nodeData is greater than delNode node's nodeData; make the delNode's left child node
                         * as left child of parent's node
                         */
                        parent.setLeft(delNode.getLeft());
                    } else if (parent.isLessThan(nodeData)) {
                        /**
                         * if parent node's nodeData is less than delNode node's nodeData; make the delNode's left child node
                         * as right child of parent's node
                         */
                        parent.setRight(delNode.getLeft());
                    }
                }
            } else if (delNode.hasRight() && !delNode.getRight().hasLeft()) {
                /* Case 3: If delNode's right child has no left child, then delNode's right child replaces delNode */
                delNode.getRight().setLeft(delNode.getLeft());
                if (Objects.isNull(parent)) {
                    setRoot(delNode.getRight());
                } else {
                    if (parent.isGreaterThan(nodeData)) {
                        /**
                         * if parent node's nodeData is greater than delNode's nodeData; make the delNode's right child,
                         * a left child of parent
                         */
                        parent.setLeft(delNode.getRight());
                    } else if (parent.isLessThan(nodeData)) {
                        /**
                         * if parent node's nodeData is less than delNode's nodeData; make the delNode's left child, a right
                         * child of parent
                         */
                        parent.setRight(delNode.getRight());
                    }
                }
            } else if (delNode.hasChildren()) {
                /**
                 * Case 4: If delNode's right child has a left child, replace delNode with delNode's right child's left-most child
                 */
                // find the right's left-most child
//                ListNode<E> leftMostParent = delNode.getRight();
//                ListNode<E> leftMost = delNode.getRight().getLeft();
//                while (leftMost.hasLeft()) {
//                    leftMostParent = leftMost;
//                    leftMost = leftMost.getLeft();
//                }

                Node<E> leftMost = delNode.getRight().findLeftMost();

                // the parent's left subtree becomes the left-most's right subtree
//                leftMostParent.setLeft(leftMost.getRight());
                leftMost.getParent().setLeft(leftMost.getRight());

                // assign left-most's left and right to delNode's left and right children
                leftMost.setLeft(delNode.getLeft());
                leftMost.setRight(delNode.getRight());

                // if parent is null, it's root node.
                if (Objects.isNull(parent)) {
                    // then the left-most node becomes the root
                    setRoot(leftMost);
                } else {
                    if (parent.isGreaterThan(nodeData)) {
                        /**
                         * if parent's nodeData is greater than delNode's nodeData; make the leftMost,
                         * a left child of parent.
                         */
                        parent.setLeft(leftMost);
                    } else if (parent.isLessThan(nodeData)) {
                        /**
                         * if parent's nodeData is less than delNode's nodeData; make the leftMost, a right
                         * child of parent.
                         */
                        parent.setRight(leftMost);
                    }
                }
            }

            deleted = true;
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
        if (root != null) {
            Queue<Node<E>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<E> node = queue.poll();
                sBuilder.append(node.getData().toString());
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
     * Returns the left node of the root node, if root node is not null otherwise root node.
     *
     * @return
     */
    public Node<E> getLeftNode() {
        return getRoot().getLeft();
    }

    /**
     * Adds the new node as the left child of the root node if root is not null otherwise as root node.
     *
     * @param newData
     */
    public void addLeftNode(E newData) {
        if (Objects.isNull(getRoot())) {
            setRoot(new Node<E>(newData));
            size++;
        } else {
            /**
             * <pre>
             *       1
             *      /
             *    2
             *  /
             * 3
             * </pre>
             */
            Node<E> newNode = new Node<E>(newData);
            Node<E> current = getRoot();
            while (Objects.nonNull(current) && Objects.nonNull(current.getLeft())) {
                current = current.getLeft();
            }

            // set this node as the parent of the new node
            newNode.setParent(current);
            current.setLeft(newNode);
            size++;
        }
    }

    /**
     * Returns the right node of the root node, if root node is not null otherwise root node.
     *
     * @return
     */
    public Node<E> getRightNode() {
        return getRoot().getRight();
    }

    /**
     * Adds the new node as the right child of the root node if root is not null otherwise as root node.
     *
     * @param newData
     */
    public void addRightNode(E newData) {
        if (Objects.isNull(getRoot())) {
            setRoot(new Node<E>(newData));
            size++;
        } else {
            /**
             * <pre>
             *  1
             *   \
             *    2
             *     \
             *      3
             * </pre>
             */
            Node<E> newNode = new Node<E>(newData);
            Node<E> current = getRoot();
            while (Objects.nonNull(current) && Objects.nonNull(current.getRight())) {
                current = current.getRight();
            }

            // set this node as the parent of the new node
            newNode.setParent(current);
            current.setRight(newNode);
            size++;
        }
    }

}
