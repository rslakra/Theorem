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

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-13 04:35:49 PM
 * @since 1.0.0
 */
public class Node<E> implements Comparable<Node> {

    private Node<E> parent;
    private final E value;
    private Node<E> left;
    private Node<E> right;

    /**
     * @param value
     */
    public Node(E value) {
        parent = null;
        this.value = value;
        left = null;
        right = null;
    }

    /**
     * Returns the value of data.
     *
     * @return the data
     */
    public E getValue() {
        return value;
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
     * @param parent the parent to set
     */
    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    /**
     * Returns true if the left node is not null otherwise false.
     *
     * @return
     */
    public boolean hasLeft() {
        return (left != null);
    }

    /**
     * Returns the value of leftNode.
     *
     * @return the leftNode
     */
    public Node<E> getLeft() {
        return left;
    }

    /**
     * The leftNode to be set.
     *
     * @param left the leftNode to set
     */
    public void setLeft(Node<E> left) {
        this.left = left;
    }

    /**
     * Returns true if the right node is not null otherwise false.
     *
     * @return
     */
    public boolean hasRight() {
        return (right != null);
    }

    /**
     * Returns the value of rightNode.
     *
     * @return the rightNode
     */
    public Node<E> getRight() {
        return right;
    }

    /**
     * The rightNode to be set.
     *
     * @param right the rightNode to set
     */
    public void setRight(Node<E> right) {
        this.right = right;
    }

    /**
     * Returns true if this is leaf node (means both left and right nodes are empty of this node).
     *
     * @return
     */
    public boolean isLeafNode() {
        return (left == null && right == null);
    }

    /**
     * Returns true if the node has both left and right children otherwise false.
     *
     * @return
     */
    public boolean hasChildren() {
        return (left != null && right != null);
    }

    /**
     * Adds the left node to the current node.
     *
     * @param newData
     */
    public void addLeftNode(final E newData) {
        final Node<E> newNode = new Node<E>(newData);
        if (this.hasLeft()) {
            newNode.setLeft(getLeft());
        }
        setLeft(newNode);
    }

    /**
     * Adds the right node to the current node.
     *
     * @param newData
     */
    public void addRightNode(final E newData) {
        final Node<E> newNode = new Node<E>(newData);
        if (hasRight()) {
            newNode.setRight(getRight());
        }
        setRight(newNode);
    }

    /**
     * @param other
     * @return
     */
    public boolean equals(Node<E> other) {
        return (other != null && getValue().equals(other.getValue()));
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that
     * {@code x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
     * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Node other) {
        return ((Comparable) getValue()).compareTo((other.getValue()));
    }
}
