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
 * The binary tree has the following properties:
 *
 * <pre>
 *  1. The maximum number of nodes at level ‘l’ of a binary tree is 2 ^ l:
 *      Note: Here level is the number of nodes on the path from the root to the node (including root and node).
 *      The level of the root is 0.
 *
 *      This can be proved by induction:
 *      For root, l = 0, number of nodes = 2 ^ 0 = 1
 *      Assume that the maximum number of nodes on level ‘l’ is 2 ^ l
 *      Since in a Binary tree every node has at most 2 children, the next level would have twice nodes, i.e. 2 * 2 ^ l
 *
 *  2. The Maximum number of nodes in a binary tree of height ‘h’ is 2 ^ h – 1.
 *      Note: Here the height of a tree is the maximum number of nodes on the root-to-leaf path.
 *      The height of a tree with a single node is considered as 1.
 *
 *      This result can be derived from point 2 above. A tree has maximum nodes if all levels have maximum nodes.
 *      So the maximum number of nodes in a binary tree of height h is 1 + 2 + 4 + .. + 2^h-1. This is a simple geometric
 *      series with h terms and the sum of this series is 2^h – 1.
 *
 *      In some books, the height of the root is considered as 0. In this convention, the above formula becomes 2^h+1 – 1
 *
 *  3. In a Binary Tree with N nodes, the minimum possible height or the minimum number of levels is log2(N+1):
 *      Each level should have at least one element, so the height cannot be more than N. A binary tree of height ‘h’
 *      can have a maximum of 2h – 1 nodes (previous property). So the number of nodes will be less than or equal to
 *      this maximum value
 *
 *      N <=  2^h – 1
 *      2^h >= N+1
 *      log2(2^h) >= log2(N+1)      (Taking log both sides)
 *      h log2 2 >= log2(N+1)       (h is an integer)
 *      h  >= | log2(N+1) |
 *
 *      So the minimum height possible is | log2(N+1) |
 *
 *  4. A Binary Tree with L leaves has at least | Log2L |+ 1  levels:
 *      A Binary tree has the maximum number of leaves (and a minimum number of levels) when all levels are fully
 *      filled. Let all leaves be at level l, then below is valid for the number of leaves L
 *
 *      L   <=  2l-1  [From Point 1] [Note: Here, consider level of root node as 1]
 *      l =   | Log2L | + 1
 *      where l is the minimum number of levels
 *
 *  5. In a Binary tree where every node has 0 or 2 children, the number of leaf nodes is always one more than nodes
 *  with two children:
 *      L = T + 1
 *      Where L = Number of leaf nodes
 *      T = Number of internal nodes with two children
 *
 *      Proof:
 *
 *      No. of leaf nodes (L) i.e. total elements present at the bottom of tree = 2^h-1 (h is height of tree)
 *      No. of internal nodes = {total no. of nodes} – {leaf nodes} = { 2^h – 1 } – {2^h-1} = 2^h-1 (2-1) – 1 = 2^h-1 – 1
 *      So , L = 2^h-1
 *         T = 2^h-1 – 1
 *
 *      Therefore L = T + 1
 *      Hence proved
 *
 *  6. In a non-empty binary tree, if n is the total number of nodes and e is the total number of edges, then e = n-1:
 *
 *      Every node in a binary tree has exactly one parent with the exception of the root node. So if n is the total
 *      number of nodes then n-1 nodes have exactly one parent. There is only one edge between any child and its parent.
 *      So the total number of edges is n-1.
 *
 *  Some extra properties of binary tree are:
 *  i) Each node in a binary tree can have at most two child nodes: In a binary tree, each node can have either zero,
 *      one, or two child nodes. If a node has zero children, it is called a leaf node. If a node has one child, it is
 *      called a unary node. If a node has two children, it is called a binary node.
 *  ii) The node at the top of the tree is called the root node: The root node is the first node in a binary tree and
 *      all other nodes are connected to it. All other nodes in the tree are either child nodes or descendant nodes of
 *      the root node.
 *  iii) Nodes that do not have any child nodes are called leaf nodes: Leaf nodes are the endpoints of the tree and have
 *      no children. They represent the final result of the tree.
 *  iv) The height of a binary tree is defined as the number of edges from the root node to the deepest leaf node: The
 *      height of a binary tree is the length of the longest path from the root node to any of the leaf nodes. The
 *      height of a binary tree is also known as its depth.
 *  v) In a full binary tree, every node except the leaves has exactly two children: In a full binary tree, all non-leaf
 *      nodes have exactly two children. This means that there are no unary nodes in a full binary tree.
 *  vi) In a complete binary tree, every level of the tree is completely filled except for the last level, which can be
 *      partially filled: In a complete binary tree, all levels of the tree except the last level are completely filled.
 *      This means that there are no gaps in the tree and all nodes are connected to their parent nodes.
 *  vii) In a balanced binary tree, the height of the left and right subtrees of every node differ by at most 1: In a
 *      balanced binary tree, the height of the left and right subtrees of every node is similar. This ensures that the
 *      tree is balanced and that the height of the tree is minimized.
 *  viii) The in-order, pre-order, and post-order traversal of a binary tree are three common ways to traverse the
 *      tree:
 *      - In-order (In-order traversal visits the left subtree, the node itself, and then the right subtree.),
 *      - pre-order (Pre-order traversal visits the node itself, the left subtree, and then the right subtree.), and
 *      - post-order (Post-order traversal visits the left subtree, the right subtree, and then the node itself.)
 *      are three different ways to traverse a binary tree.
 *
 * </pre>
 *
 * <url>https://www.geeksforgeeks.org/types-of-binary-tree</url>
 * <url>https://www.geeksforgeeks.org/handshaking-lemma-and-interesting-tree-properties</url>
 * <p>
 * Handle the binary tree management. This binary tree does not allow duplicate values.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-13 04:36:00 PM
 * @since 1.0.0
 */
public class BinaryTree<E extends Comparable<? super E>> extends AbstractTree<E> {

    public BinaryTree() {
        super();
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
            incrementSize();
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
                    incrementSize();
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
                    incrementSize();
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
        addNode(root, new Node<E>(data));
    }

    /**
     * Finds and returns the node for the given data, if exists otherwise null.
     *
     * @param data
     * @return
     */
    @Override
    protected Node<E> findNode(E data) {
        // find node's in the tree with the provided <code>value</code>
        Node<E> current = root;
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
     * Removes the node.
     *
     * @param delNode
     * @param nextNode
     */
    private void removeNodeWithoutParentHandling(Node<E> delNode, Node<E> nextNode) {
        // if removing node is root node, the delNode should be equal to root.
        if (root == delNode) {
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
        if (Objects.nonNull(root)) {
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
                decrementSize();
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
            decrementSize();

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
        return root.getLeft();
    }

    /**
     * Adds the new node as the left child of the root node if root is not null otherwise as root node.
     *
     * @param newData
     */
    public void addLeftNode(E newData) {
        if (Objects.isNull(root)) {
            setRoot(new Node<E>(newData));
            incrementSize();
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
            Node<E> current = root;
            while (Objects.nonNull(current) && Objects.nonNull(current.getLeft())) {
                current = current.getLeft();
            }

            // set this node as the parent of the new node
            newNode.setParent(current);
            current.setLeft(newNode);
            incrementSize();
        }
    }

    /**
     * Returns the right node of the root node, if root node is not null otherwise root node.
     *
     * @return
     */
    public Node<E> getRightNode() {
        return root.getRight();
    }

    /**
     * Adds the new node as the right child of the root node if root is not null otherwise as root node.
     *
     * @param newData
     */
    public void addRightNode(E newData) {
        if (Objects.isNull(root)) {
            setRoot(new Node<E>(newData));
            incrementSize();
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
            Node<E> current = root;
            while (Objects.nonNull(current) && Objects.nonNull(current.getRight())) {
                current = current.getRight();
            }

            // set this node as the parent of the new node
            newNode.setParent(current);
            current.setRight(newNode);
            incrementSize();
        }
    }

}
