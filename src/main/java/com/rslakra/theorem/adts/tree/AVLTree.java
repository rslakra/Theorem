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

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-13 08:40:32 PM
 * @since 1.0.0
 */
public class AVLTree {

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

    public AVLTree() {
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
     * @param args
     */
    public static void main(String[] args) {

    }

}
