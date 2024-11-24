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
package com.rslakra.theorem.adts.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * The binary tree has the following properties:
 *
 *
 * <url>https://en.wikipedia.org/wiki/Rope_(data_structure)</url>
 * <url>https://www.geeksforgeeks.org/ropes-data-structure-fast-string-concatenation</url>
 * <p>
 * Handle the binary tree management. This binary tree does not allow duplicate values.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-13 04:36:00 PM
 * @since 1.0.0
 */
public class RopeTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RopeTree.class);

    /**
     * Helps to handle if the binary tree allows duplicates or not.
     * <p>
     * By default, this binary search tree allows duplicates.
     *
     * @param allowDuplicates
     */
    public RopeTree(boolean allowDuplicates) {
        super(allowDuplicates);
    }

    /**
     * Helps to handle if the binary tree allows duplicates or not.
     * <p>
     * By default, this binary search tree allows duplicates.
     */
    public RopeTree() {
        this(true);
    }

    /**
     * Adds the <code>childNode</code> node as the child node of the <code>rootNode</code> node.
     * <p>
     * By default, tree allows duplicate values, so a binary tree should handle it separately if it doesn't allow
     * duplicate values.
     *
     * @param rootNode
     * @param childNode
     * @return
     */
    @Override
    public Node<E> addNode(Node<E> rootNode, Node<E> childNode) {
        LOGGER.debug("+addNode({}, {})", rootNode, childNode);
        // Case 1: The tree is empty - create the root node.
        if (Objects.isNull(rootNode)) {
            if (!childNode.isBinary()) {
                childNode.setBinary(true);
            }
            rootNode = childNode;
            // make sure the root of the tree is set
            if (Objects.isNull(getRoot())) {
                setRoot(rootNode);
            }
            increaseSize(rootNode.getSize());
        } else if (rootNode.compareTo(childNode) < 0) {
            /* Case 2: The tree is not empty, and the root's data < data, then add data as right child.*/
            rootNode.setRight(addNode(rootNode.getRight(), childNode));
        } else if (rootNode.compareTo(childNode) > 0) {
            /* Case 3: The tree is not empty, and the root's data > data, then add data as left child.*/
            rootNode.setLeft(addNode(rootNode.getLeft(), childNode));
        } else {
            /* Case 4: The tree is not empty, and the root's data == data, and the tree allow duplicates, just increase the count.*/
            if (isAllowDuplicates()) {
                /**
                 * Case 4: Handling duplicates and binary tree allows duplicates, just increase the count.
                 * Duplicate values creates complexity and need to handle separately at multiple levels like:
                 * 1. removing the nodes.
                 * 2. counting the nodes, etc.
                 */
                if (isAllowDuplicates() && rootNode.compareTo(childNode) == 0) {
                    rootNode.increaseCount();
                    increaseSize(rootNode.getSize());
                }
            }
        }

        LOGGER.debug("-addNode(), rootNode:{}", rootNode);
        return rootNode;
    }

    /**
     * Finds the node with the provided <code>data</code>. If exists return node otherwise null.
     * <p>
     * On most machines, the iterative version is found to be more efficient.
     *
     * @param rootNode
     * @param data
     * @return
     */
    @Override
    protected Node<E> findNode(Node<E> rootNode, E data) {
        return findIteratively(rootNode, data);
    }

    /**
     * Returns true if the node is deleted otherwise false.
     *
     * @param rootNode
     * @param data
     * @return
     */
    @Override
    public Node<E> removeNode(Node<E> rootNode, E data) {
        if (Objects.nonNull(rootNode) && rootNode.isBinary()) {
            if (rootNode.isGreaterThan(data)) {
                rootNode.setLeft(removeNode(rootNode.getLeft(), data));
            } else if (rootNode.isLessThan(data)) {
                rootNode.setRight(removeNode(rootNode.getRight(), data));
            } else if (rootNode.isEquals(data)) {
                /**
                 * Handle 4 cases:
                 * - If tree supports duplicate values, just decrease the count
                 * - Node is a leaf node (just return null)
                 * - Node has only 1 child (return either left or right)
                 * - Node has left & right children:
                 *  1. Find in-order successor
                 *  2. Replace the value of root node with in-order successor value,
                 *  3. Remove in-order successor (which should be handled by either case 1 or 2).
                 */
                if (isAllowDuplicates() && rootNode.getCount() > 1) {
                    rootNode.decreaseCount();
                    return rootNode;
                }
                // leaf node, just return null
                if (rootNode.isLeaf()) {
                    decreaseSize();
                    return null;
                } else if (Objects.isNull(rootNode.getLeft()) && rootNode.hasRight()) { // has only right
                    decreaseSize();
                    return rootNode.getRight();
                } else if (Objects.isNull(rootNode.getRight()) && rootNode.hasLeft()) { // has only left
                    decreaseSize();
                    return rootNode.getLeft();
                } else if (rootNode.hasLeft() && rootNode.hasRight()) {
                    //  find in-order successor
                    Node<E> inOrderSuccessor = TreeUtils.findInOrderSuccessor(rootNode);
                    rootNode.setData(inOrderSuccessor.getData());
                    rootNode.setRight(removeNode(rootNode.getRight(), inOrderSuccessor.getData()));
                }
            }
        }

        return rootNode;
    }

    /**
     * Removes the <code>removeNode</code> and updates the tree with <code>nextNode</code>.
     *
     * @param removeNode
     * @param nextNode
     */
    private void removeNodeWithoutParentHandling(Node<E> removeNode, Node<E> nextNode) {
        // if removing node is root node, the removeNode should be equal to root.
        if (getRoot().equals(removeNode)) {
            if (Objects.nonNull(nextNode)) {
                nextNode.setParent(null);
                nextNode.setLeft(removeNode.getLeft());
                nextNode.setRight(removeNode.getRight());
            }
            setRoot(nextNode);
            removeNode = null;
        } else if (removeNode.getParent().getRight() == removeNode) {
            // if removing node is right node, the current node's parent should be equal to its parent node.
            removeNode.getParent().setRight(nextNode);
        } else {
            // if removing node is left node, the current node's parent should be equal to it's parent node.
            removeNode.getParent().setLeft(nextNode);
        }
    }

    /**
     * Removes the <code>data</code> node from the tree, if exists and the node class has no parent handling.
     *
     * @param data
     * @return
     */
    public boolean removeNodeWithoutParentHandling(E data) {
        boolean nodeDeleted = false;
        if (Objects.nonNull(getRoot())) {
            // find node to be nodeDeleted.
            Node<E> removeNode = findNode(data);
            // if found the node to be nodeDeleted
            if (Objects.nonNull(removeNode)) {
                // easy, if it's the leaf node (means doesn't have any nodes)
                if (removeNode.isLeaf()) {
                    removeNodeWithoutParentHandling(removeNode, null);
                    nodeDeleted = true;
                } else if (removeNode.hasRight() && !removeNode.hasLeft()) {
                    // the node to be deleted has only right node
                    removeNodeWithoutParentHandling(removeNode, removeNode.getRight());
                    nodeDeleted = true;
                } else if (removeNode.hasLeft() && !removeNode.hasRight()) {
                    // the node to be deleted has only left node.
                    removeNodeWithoutParentHandling(removeNode, removeNode.getLeft());
                    nodeDeleted = true;
                } else {
                    // the node to be deleted has both left and right nodes.
                    Node<E> tempNode = removeNode.getLeft();
                    while (tempNode != null && !tempNode.isLeaf()) {
                        tempNode = tempNode.getRight();
                    }

                    tempNode.getParent().setRight(null);
                    tempNode.setLeft(removeNode.getLeft());
                    tempNode.setRight(removeNode.getRight());

                    removeNodeWithoutParentHandling(removeNode, tempNode);
                    nodeDeleted = true;
                }
            }

            if (nodeDeleted) {
                decreaseSize();
            }
        }

        return nodeDeleted;
    }

    /**
     * Updates the <code>parentNode</code>'s child with the <code>nextNode</code>.
     *
     * @param parentNode
     * @param parentNode
     * @param nextNode
     */
    private void updateParentAfterRemoval(Node<E> parentNode, E data, Node<E> nextNode) {
        if (Objects.isNull(parentNode)) { // no parent node
            setRoot(nextNode);
        } else if (parentNode.isGreaterThan(data)) { // parent is > data
            parentNode.setLeft(nextNode);
        } else if (parentNode.isLessThan(data)) { // parent is < data
            parentNode.setRight(nextNode);
        }
    }

    /**
     * Removes the first occurrence of the provided <code>data</code> from the tree, if exists and the node class has
     * parent handling.
     *
     * @param data
     */
    public boolean removeNodeWithParentHandling(final E data) {
        boolean deleted = false;
        Node<E> delNode = findNode(data);
        if (Objects.nonNull(delNode)) {
            // when the binary tree allow duplicates
            if (isAllowDuplicates() && delNode.getCount() > 1) {
                // decrease only the count.
                delNode.decreaseCount();
            } else {
                // decrease the node count
                decreaseSize();

                // Get delNode's parent node
                final Node<E> parent = delNode.getParent();

                //Case 1: if the delNode is a leaf node (no children), just remove it (easy)
                if (delNode.isLeaf()) {
                    delNode = null;
                } else if (!delNode.hasRight()) {
                    /**
                     * Case 2: If delNode node has no right child (only left), then delNode's left replaces the delNode node.
                     *  - If parent is null, then <code>delNode</code>'s left replaces it.
                     *  - If parent node's data is greater than delNode node's data; make the delNode's left child node as
                     *      left child of parent's node.
                     *  - If parent node's data is less than delNode node's data; make the delNode's left child node as
                     *      right child of parent's node
                     */
                    // update the nodes with delNode.left
                    updateParentAfterRemoval(parent, data, delNode.getLeft());
                } else if (delNode.hasRight() && !delNode.getRight().hasLeft()) {
                    /**
                     * Case 3: If delNode's right child has no left child, then delNode's right child replaces delNode
                     *  - If parent is null, then <code>delNode</code>'s right replaces it.
                     *  - If parent node's data is greater than delNode's data; make the delNode's right child, a left
                     *      child of parent.
                     *  - If parent node's data is less than delNode's data; make the delNode's left child, a right child
                     *      of parent
                     */
                    delNode.getRight().setLeft(delNode.getLeft());
                    // update the nodes with delNode.right
                    updateParentAfterRemoval(parent, data, delNode.getRight());
                } else if (!delNode.isLeaf()) {
                    /**
                     * Case 4: If delNode's right child has a left child, replace delNode with delNode's right child's
                     * left-most child.
                     *  - If parent is null, then <code>inOrderSuccessor</code> replaces it.
                     *  - If parent node's data is greater than delNode's data; make the delNode's right child, a left
                     *      child of parent.
                     *  - If parent node's data is less than delNode's data; make the delNode's left child, a right child
                     *      of parent
                     */
                    // find the right's left-most child
                    Node<E> inOrderSuccessor = TreeUtils.findInOrderSuccessor(delNode);

                    // the parent's left subtree becomes the left-most's right subtree
                    inOrderSuccessor.getParent().setLeft(inOrderSuccessor.getRight());

                    // assign left-most's left and right to delNode's left and right children
                    inOrderSuccessor.setLeft(delNode.getLeft());
                    inOrderSuccessor.setRight(delNode.getRight());

                    // update the nodes with inOrderSuccessor
                    updateParentAfterRemoval(parent, data, inOrderSuccessor);
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

//    /**
//     * Returns the string representation of this object.
//     *
//     * @return
//     */
//    @Override
//    public String toString() {
// return inOrderTraversal().toString();
//    }

    /**
     * Prints the binary tree.
     *
     * @param showDetails
     */
    @Override
    public void printPrettyTree(boolean showDetails) {
        TreeUtils.printBinaryTree(getRoot());
    }

    /**
     * Adds the new node as the left child of the root node if root is not null otherwise as root node.
     *
     * @param nodeData
     */
    public void addLeftNode(E nodeData) {
        if (Objects.isNull(getRoot())) {
            setRoot(new Node<E>(nodeData));
            increaseSize();
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
            Node<E> newNode = new Node<E>(nodeData);
            // find left-most child node as the parent of new node
            Node<E> parentNode = TreeUtils.findLeftMostChild(getRoot());
            // set this node as the parent of the new node
            newNode.setParent(parentNode);
            parentNode.setLeft(newNode);
            increaseSize();
        }
    }

    /**
     * Adds the new node as the right child of the root node if root is not null otherwise as root node.
     *
     * @param newData
     */
    public void addRightNode(E newData) {
        if (Objects.isNull(getRoot())) {
            setRoot(new Node<E>(newData));
            increaseSize();
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
            // find right-most child node as a parent of new node
            Node<E> parentNode = TreeUtils.findRightMostChild(getRoot());
            // set this node as the parent of the new node
            newNode.setParent(parentNode);
            parentNode.setRight(newNode);
            increaseSize();
        }
    }

}
