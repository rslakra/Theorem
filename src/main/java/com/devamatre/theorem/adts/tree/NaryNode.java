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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-22 09:42:10 PM
 * @since 1.0.0
 */
public class NaryNode<E extends Comparable<? super E>> {

    private final static boolean SHOW_DEPTH = true;
    private NaryNode parent;
    private final E data;
    private List<NaryNode<E>> children;

    /**
     * Creates the new node.
     *
     * @param parent
     * @param data
     */
    public NaryNode(NaryNode<E> parent, E data) {
        this.parent = parent;
        if (BeanUtils.isEmpty(data)) {
            throw new IllegalArgumentException("The value is null!");
        }
        this.data = data;
        this.children = new ArrayList<>();
    }

    /**
     * @param data
     */
    public NaryNode(E data) {
        this(null, data);
    }

    /**
     * return a N-ary tree based on the preorder values
     */
    public static <E> Node createNaryTree(List<E> nodeValues) {
        return null;
    }

    /**
     * Returns the length of the path to its root.
     *
     * @param naryNode
     * @return
     */
    public static int maxDepth(final NaryNode naryNode) {
        return (BeanUtils.isNull(naryNode) ? 0 : (maxDepth(naryNode.getParent()) + 1));
    }

    /**
     * Returns the length of the path to a leaf.
     *
     * @param naryNode
     * @return
     */
    public static <E> int maxHeight(NaryNode naryNode) {
        int maxHeight = 1;
        if (BeanUtils.isNotNull(naryNode) && naryNode.hasChildren()) {
            for (int i = 0; i < naryNode.getChildren().size(); i++) {
                NaryNode childNode = (NaryNode) naryNode.getChildren().get(i);
                maxHeight = Math.max(maxHeight(childNode) + 1, maxHeight);
            }
        }

        return maxHeight;
    }

    /**
     * Returns the edge count of the node.
     *
     * @param treeNode
     * @return
     */
    public static <E> int maxEdges(NaryNode treeNode) {
        int maxEdges = 0;
        if (BeanUtils.isNotNull(treeNode) && treeNode.hasChildren()) {
            for (NaryNode childNode : (List<NaryNode>) treeNode.getChildren()) {
                maxEdges += maxEdges(childNode) + 1;
            }
        }

        return maxEdges;
    }

    /**
     * @return
     */
    public NaryNode getParent() {
        return parent;
    }

    /**
     * The parent node to be set.
     *
     * @param parent
     */
    public void setParent(final NaryNode parent) {
        this.parent = parent;
    }

    /**
     * Returns true if the node has the parent othewise false.
     *
     * @return
     */
    public boolean hasParent() {
        return (getParent() != null);
    }

    /**
     * @return
     */
    public E getData() {
        return data;
    }

    /**
     * Returns true if the node has children otherwise false.
     *
     * @return
     */
    public boolean hasChildren() {
        return BeanUtils.isNotEmpty(getChildren());
    }

    /**
     * @return
     */
    public List<NaryNode<E>> getChildren() {
        return children;
    }

    /**
     * Adds the <code>treeNode</code> as children of the tree.
     *
     * @param treeNode
     */
    public void addChild(final NaryNode<E> treeNode) {
        if (BeanUtils.isNull(children)) {
            children = new LinkedList<>();
        }

        // check the treeNode is not null
        if (BeanUtils.isNotNull(treeNode)) {
            if (!treeNode.hasParent()) {
                treeNode.setParent(this);
            }
            children.add(treeNode);
        }
    }

    /**
     * Adds the <code>child</code> as children of the <code>parent</code> tree.
     *
     * @param parent
     * @param child
     */
    public void addChild(NaryNode<E> parent, NaryNode<E> child) {
        if (BeanUtils.isNull(parent)) {
            addChild(child);
        } else {
            if (!child.hasParent()) {
                child.setParent(parent);
            }
            parent.addChild(child);
        }
    }

    /**
     * Adds the <code>data</code> as children of the <code>parent</code> tree.
     *
     * @param parent
     * @param data
     */
    public void addChild(NaryNode<E> parent, E data) {
        addChild(new NaryNode<>(parent, data));
    }

    /**
     * Adds the <code>data</code> as children of the tree.
     *
     * @param data
     */
    public void addChild(E data) {
        addChild(new NaryNode(this, data));
    }

    /**
     * Returns the string representation of this object. For Example:
     *
     * <pre>
     * CEO
     * |-- CTO
     * |   |-- Server
     * |   |-- iOS
     * |   |   |-- Objective-C
     * |   |   |-- Swift
     * |   |-- Android
     * |-- CFO
     * </pre>
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder nodeString = new StringBuilder();
        // if (hasParent()) {
        // nodeString.append("|\n");
        // }

        if (getData() != null) {
            nodeString.append(getData());
            if (SHOW_DEPTH) {
                nodeString.append(" [").append(maxHeight(this)).append("]");
            }
            nodeString.append("\n");
        }

        if (hasChildren()) {
            for (NaryNode child : getChildren()) {
                int maxDepth = maxDepth(child);
                for (int i = 1; i < maxDepth - 1; i++) {
                    nodeString.append("|   ");
                }
                nodeString.append("|-- ").append(child.toString());
            }
        }

        return nodeString.toString();
    }


    /**
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        NaryNode treeNode = (NaryNode) object;
        return (getData() == treeNode.getData() && Objects.equals(children, treeNode.getChildren()));
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getData(), children);
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // ROOT
        NaryNode root = new NaryNode(null, "CEO");
        System.out.println(root);
        System.out.println("Edges:" + NaryNode.maxEdges(root));
        System.out.println();

        // CTO
        NaryNode cto = new NaryNode(root, "CTO");
        root.addChild(cto);
        // Server
        cto.addChild("Server");
        // IOS
        NaryNode iOS = new NaryNode(cto, "iOS");
        cto.addChild(iOS);
        iOS.addChild("Objective-C");
        iOS.addChild("Swift");
        // Android
        cto.addChild("Android");

        // CFO
        NaryNode cfo = new NaryNode(root, "CFO");
        root.addChild(cfo);
        System.out.println(root);
        System.out.println("Edges:" + NaryNode.maxEdges(root));
    }
}
