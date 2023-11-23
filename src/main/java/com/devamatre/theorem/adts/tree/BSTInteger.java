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
package com.devamatre.theorem.adts.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-30 08:28:16 PM
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
         * Returns true if the current node is the left node of the given parent.
         *
         * @param parent
         * @return
         */
        public boolean isLeftOf(Node parent) {
            return (parent != null && parent.hasLeft() && this.compareTo(parent.left) == 0);
        }

        /**
         * Returns true if the current node is the right node of the given parent.
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
            // Case 1 - PairNode has no child.
            if (parent != null) {
                if (current.isLeftOf(parent)) {
                    // case has both parents.
                    if (current.hasChildren()) {
                        parent.left = current.right;
                        pushNode(current.right, current.left);
                    } else if (current.hasLeft()) {
                        // Case 2 - PairNode has only 1 child
                        parent.left = current.left;
                    } else if (current.hasRight()) {
                        parent.left = current.right;
                    } else {
                        // PairNode has no child
                        parent.left = null;
                    }
                } else if (current.isRightOf(parent)) {
                    // Case 3 - PairNode has both children
                    if (current.hasChildren()) {
                        parent.right = current.right;
                        pushNode(current.right, current.left);
                    } else if (current.hasLeft()) {
                        // Case 2 - PairNode has only 1 child
                        parent.left = current.left;
                    } else if (current.hasRight()) {
                        parent.right = current.right;
                    } else {
                        // PairNode has no child
                        parent.right = null;
                    }
                }
            } else {
                // Case 3 - PairNode has both children
                if (current.hasChildren()) {
                    pushNode(current.right, current.left);
                    rootNode = current.right;
                } else if (current.hasLeft()) {
                    // Case 2 - PairNode has only 1 child
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
                } else {
                    // PairNode has no child
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
     * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Visit root node. Step 2 − Recursively traverse left subtree. Step 3 −
     * Recursively traverse right subtree.
     *
     * @param addBrackets
     * @return
     */
    public String preOrderTraversal(final boolean addBrackets) {
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
        if (rootNode != null) {
            final Stack<Node> stack = new Stack<>();
            stack.push(rootNode);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                // append root node
                nodeBuilder.append(node.data).append(" ");

                // push right node
                if (node.hasRight()) {
                    stack.push(node.right);
                }

                // push left node
                if (node.hasLeft()) {
                    stack.push(node.left);
                }
            }

            // remove last white space.
            int lastIndex = nodeBuilder.lastIndexOf(" ");
            if (lastIndex != -1) {
                nodeBuilder.deleteCharAt(lastIndex);
            }
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * @return
     */
    public Iterator<Node> preOrderIterator() {
        return new PreOrderIterator();
    }

    /**
     * @return
     */
    public Iterator<Node> inOrderIterator() {
        return new InOrderIterator();
    }

    /**
     * @return
     */
    public Iterator<Node> postOrderIterator() {
        return new PostOrderIterator();
    }

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-09-13 09:46:28 PM
     * @since 1.0.0
     */
    private abstract class BSTIterator implements Iterator<Node> {

        // stack
        protected Stack<Node> stack = new Stack<>();

        /**
         *
         */
        public BSTIterator() {

        }

        /**
         * @return
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return (!stack.isEmpty());
        }

        /**
         * We shall leave the method remove() unimplemented. Since a binary tree has a nonlinear structure, removing a
         * node might cause the major tree rearrangement, which will lead to incorrect output from next():
         *
         * @see java.util.Iterator#remove()
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class InOrderIterator extends BSTIterator {

        public InOrderIterator() {
            if (rootNode != null) {
                pushLeft(rootNode);
            }
        }

        /**
         * Pushes the left nodes to the stack.
         *
         * @param node
         */
        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /**
         * If there is a left child, we push the child on a stack and return a parent node. If there is no left child,
         * we check for a right child. If there is a right child, we push the right child on a stack and return a parent
         * node. If there is no right child, we move back up the tree (while-loop) until we find a node with a right
         * child.
         *
         * @return
         * @see java.util.Iterator#next()
         */
        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            Node current = stack.pop();
            pushLeft(current.right);
            return current;
        }
    }

    /**
     * Iterator is the API interface. A class which implements Iterator should implement three methods
     * <p>
     * boolean hasNext() - Returns true if the iteration has more elements. Object next() - Returns the next element in
     * the iteration. void remove() - (optional operation) Removes from the underlying collection the last element
     * returned by next().
     * <p>
     * We implement a pre-order traversal by ading a new method iterator to the BSTree class. This method returns an
     * iterator over the nodes of a binary tree in pre-order.
     *
     * @param <E>
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-09-11 10:02:18 PM
     * @since 1.0.0
     */
    private class PreOrderIterator extends BSTIterator {

        public PreOrderIterator() {
            if (rootNode != null) {
                stack.push(rootNode);
            }
        }

        /**
         * If there is a left child, we push the child on a stack and return a parent node. If there is no left child,
         * we check for a right child. If there is a right child, we push the right child on a stack and return a parent
         * node. If there is no right child, we move back up the tree (while-loop) until we find a node with a right
         * child.
         *
         * @return
         * @see java.util.Iterator#next()
         */
        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            Node current = stack.peek();
            if (current != null) {
                if (current.left != null) {
                    stack.push(current.left);
                } else {
                    Node node = stack.pop();
                    while (node.right == null) {
                        if (stack.isEmpty()) {
                            return current;
                        }
                        node = stack.pop();
                    }

                    stack.push(node.right);
                }
            }

            return current;
        }
    }

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-09-13 09:38:14 PM
     * @since 1.0.0
     */
    private class PostOrderIterator extends BSTIterator {

        public PostOrderIterator() {
            if (rootNode != null) {
                pushLeft(rootNode);
            }
        }

        /**
         * Pushes the left nodes to the stack.
         *
         * @param node
         */
        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (stack.isEmpty()) {
                return;
            }

            node = stack.peek();
            if (node.right != null) {
                pushLeft(node.right);
            }
        }

        /**
         * If there is a left child, we push the child on a stack and return a parent node. If there is no left child,
         * we check for a right child. If there is a right child, we push the right child on a stack and return a parent
         * node. If there is no right child, we move back up the tree (while-loop) until we find a node with a right
         * child.
         *
         * @return
         * @see java.util.Iterator#next()
         */
        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            Node current = stack.pop();
            if (hasNext()) {
                Node node = stack.peek();
                if (current != node.right) {
                    pushLeft(node.right);
                }
            }

            return current;
        }
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

        // Find PairNode
        System.out.println("Finding ... 32");
        Node found = bst.findNode(32);
        System.out.println("Found:" + found);

        System.out.println("Finding ... 64");
        found = bst.findNode(64);
        System.out.println("Found:" + found);

        System.out.println("Finding ... 80");
        found = bst.findNode(80);
        System.out.println("Found:" + found);

        // Delete PairNode.
        // bst.removeNode(50);
        System.out.println(bst);

        System.out.println("PreOrder:" + bst.preOrderTraversal(true));
        System.out.println("\nPreOrderIterator Results:");
        Iterator<Node> itr = bst.preOrderIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("\nInOrderIterator Results:");
        itr = bst.inOrderIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("\nPostOrderIterator Results:");
        itr = bst.postOrderIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
