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

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * In computer science, a tree is a widely used abstract data type that represents a hierarchical tree structure with a
 * set of connected nodes. Each node in the tree can be connected to many children (depending on the type of tree), but
 * must be connected to exactly one parent, except for the root node, which has no parent (i.e., the root node as the
 * top-most node in the tree hierarchy). These constraints mean there are no cycles or "loops" (no node can be its own
 * ancestor), and also that each child can be treated like the root node of its own subtree, making recursion a useful
 * technique for tree traversal. In contrast to linear data structures, many trees cannot be represented by
 * relationships between neighboring nodes (parent and children nodes of a node under consideration if they exist) in a
 * single straight line (called edge or link between two adjacent nodes).
 * <p>
 * I'm using only 1 node class for all implementations, which might differ based on <code>TreeType</code> values.
 *
 * <url>https://en.wikipedia.org/wiki/Tree_(data_structure)</url>
 * <url>https://www.geeksforgeeks.org/types-of-binary-tree</url>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-13 04:35:49 PM
 * @since 1.0.0
 */
public class Node<E extends Comparable<? super E>> implements Comparable<Node<E>> {

    private Node<E> parent;
    private E data;
    /* handles duplicate nodes in the binary search tree. */
    private int count;
    private Node<E> left;
    private Node<E> right;
    private List<Node<E>> children;
    private int size;

    /**
     * @param data
     */
    public Node(E data) {
        this.parent = null;
        this.data = data;
        this.count = 1;
        this.left = null;
        this.right = null;
        this.children = new LinkedList<>();
        this.size = 1;
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
     * Returns true if the parent node is not null otherwise false.
     *
     * @return
     */
    public boolean hasParent() {
        return Objects.nonNull(getParent());
    }

    /**
     * Returns the value of data.
     *
     * @return the data
     */
    public E getData() {
        return data;
    }

    /**
     * The <code>data</code> to be set.
     *
     * @param data
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Returns the <code>count</code> of the node.
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * The <code>count</code> of the node to be set.
     *
     * @param count
     */
    public void setCount(int count) {
        if (count >= 0) {
            this.count = count;
        }
    }

    /**
     * Increases the <code>count</code> by 1.
     */
    protected void increaseCount() {
        count++;
    }

    /**
     * Increases the <code>count</code> by 1.
     */
    protected void decreaseCount() {
        if (this.count > 0) {
            this.count--;
        }
    }

    /**
     * Returns true if the left node is not null otherwise false.
     *
     * @return
     */
    public boolean hasLeft() {
        return Objects.nonNull(getLeft());
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
        if (this.left != null) {
            this.left.setParent(this);
        }
    }

    /**
     * Returns true if the current node is the left node of the <code>parent</code.
     *
     * @param parent
     * @return
     */
    public boolean isLeftOf(Node<E> parent) {
        return (parent != null && parent.hasLeft() && this.compareTo(parent.left) == 0);
    }

    /**
     * Returns true if the current node is the right node of the<code>parent</code.
     *
     * @param parent
     * @return
     */
    public boolean isRightOf(Node<E> parent) {
        return (parent != null && parent.hasRight() && this.compareTo(parent.right) == 0);
    }

    /**
     * Returns true if the right node is not null otherwise false.
     *
     * @return
     */
    public boolean hasRight() {
        return Objects.nonNull(getRight());
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
        if (this.right != null) {
            this.right.setParent(this);
        }
    }

    /**
     * Returns true if the node neither has left child nor the right child otherwise false.
     * <p>
     * The leaf node has both left and right children as null.
     *
     * @return
     */
    public boolean isLeaf() {
        return (left == null && right == null);
    }

    /**
     * @return
     */
    public List<Node<E>> getChildren() {
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(List<Node<E>> children) {
        this.children = children;
    }

    /**
     * Returns true if the node has both left and right children otherwise false.
     *
     * @return
     */
    public boolean hasChildren() {
        return (children.size() > 0);
    }

    /**
     * Returns the <code>size</code>.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * The <code>size</code> to be set.
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Increases the size by 1.
     */
    protected void increaseSize(int size) {
        this.size += size;
    }

    /**
     * Increases the <code>count</code> by 1.
     */
    protected void increaseSize() {
        increaseSize(1);
    }

    /**
     * Decreases the size by 1.
     */
    protected void decreaseSize(int size) {
        if ((this.size - size) >= 0) {
            this.size -= size;
        }
    }

    /**
     * Decreases the <code>count</code> by 1.
     */
    protected void decreaseSize() {
        decreaseSize(1);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getData());
    }

    /**
     * @param other
     * @return
     */
    public boolean equals(Node<E> other) {
        return (other != null && getData().equals(other.getData()));
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return TreeUtils.preOrder(this).toString();
    }

    /**
     * Adds the <code>rootNode</code> as children of the tree.
     *
     * @param rootNode
     */
    protected void addChild(Node<E> rootNode) {
        if (Objects.nonNull(rootNode)) {
            if (!rootNode.hasParent()) {
                rootNode.setParent(this);
            }

//            // if duplicate node exists, increase the count of that node.
//            if (children.contains(rootNode)) {
//                rootNode.increaseCount();
//            }
            children.add(rootNode);
            increaseSize(rootNode.getSize());
        }
    }

    /**
     * @param data
     */
    void addChild(E data) {
        addChild(new Node<>(data));
    }

    /**
     * Finds the node with the provided <code>data</code>. If exists return node otherwise null.
     *
     * @param data
     * @return
     */
    protected Node<E> findNode(Node<E> rootNode, E data) {
        if (rootNode != null) {
            if (rootNode.isEquals(data)) {
                return rootNode;
            } else if (rootNode.isGreaterThan(data)) {
                return findNode(rootNode.getLeft(), data);
            } else if (rootNode.isLessThan(data)) {
                return findNode(rootNode.getRight(), data);
            }
        }

        return null;
    }

    /**
     * Finds the child with the provided <code>data</code>. If exists return node otherwise null.
     *
     * @param rootNode
     * @param data
     * @return
     */
    protected Node<E> findChild(Node<E> rootNode, E data) {
        // base case, check if rootNode is not null otherwise return null.
        if (Objects.nonNull(rootNode)) {
            // check the data matches with the rootNode or not
            if (rootNode.isEquals(data)) {
                return rootNode;
            } else {
                // check if any children of the rootNode contains the data node
                for (Node<E> childNode : rootNode.getChildren()) {
                    Node<E> nodeFound = findChild(childNode, data);
                    if (Objects.nonNull(nodeFound)) {
                        return nodeFound;
                    }
                }
            }
        }

        return null;
    }

    /**
     * Finds the child with the provided <code>data</code>. If exists return node otherwise null.
     *
     * @param data
     * @return
     */
    protected Node<E> findChild(E data) {
        return findChild(this, data);
    }

    /**
     * Finds the node with the provided <code>data</code>. If exists return node otherwise null.
     *
     * @param data
     * @return
     */
    protected Node<E> findNode(E data) {
        return findNode(this, data);
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
    public int compareTo(Node<E> other) {
        return (getData()).compareTo((other.getData()));
    }

    /**
     * Helper methods.
     */

    /**
     * Returns true if the current node's <code>data</code>  is greater than the <code>data</code> node's value
     * otherwise false.
     *
     * @param data
     * @return
     */
    public boolean isGreaterThanEqualTo(E data) {
        return (getData().compareTo(data) >= 0);
    }

    /**
     * Returns true if the current node's <code>data</code>  is greater than the <code>data</code> node's value
     * otherwise false.
     *
     * @param data
     * @return
     */
    public boolean isGreaterThan(E data) {
        return (getData().compareTo(data) > 0);
    }

    /**
     * Returns true if current node's <code>data</code>  is less than the <code>data</code> node's value otherwise
     * false.
     *
     * @param data
     * @return
     */
    public boolean isLessThan(E data) {
        return (getData().compareTo(data) < 0);
    }

    /**
     * Returns true if current node's <code>data</code>  is equals to the <code>data</code> node's value otherwise
     * false.
     *
     * @param data
     * @return
     */
    public boolean isEquals(E data) {
        return (getData().compareTo(data) == 0);
    }

}
