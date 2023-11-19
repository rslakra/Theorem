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
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-22 09:42:10 PM
 * @since 1.0.0
 */
public class NaryNode<T> {

    private final static boolean SHOW_DEPTH = true;
    private NaryNode parent;
    private final T value;
    private List<NaryNode<T>> children;

    /**
     * Creates the new node.
     *
     * @param parent
     * @param value
     */
    public NaryNode(NaryNode parent, T value) {
        this.parent = parent;
        if (BeanUtils.isEmpty(value)) {
            throw new IllegalArgumentException("The value is null!");
        }
        this.value = value;
    }

    /**
     * @param data
     */
    public NaryNode(T data) {
        this(null, data);
    }

    /**
     * return a N-ary tree based on the preorder values
     */
    public static <T> Node createNaryTree(List<T> nodeValues) {
        return null;
    }

    /**
     * Returns the length of the path to its root.
     *
     * @param naryNode
     * @return
     */
    public static int maxDepth(final NaryNode naryNode) {
        if (naryNode == null) {
            return 0;
        } else {
            return (maxDepth(naryNode.getParent()) + 1);
        }
    }

    /**
     * Returns the length of the path to a leaf.
     *
     * @param naryNode
     * @return
     */
    public static <T> int maxHeight(NaryNode<T> naryNode) {
        if (naryNode == null) {
            return 1;
        } else {
            int maxDepth = 1;
            if (naryNode.hasChildren()) {
                for (NaryNode<T> child : naryNode.getChildren()) {
                    maxDepth = Math.max(maxHeight(child) + 1, maxDepth);
                }
            }

            return maxDepth;
        }
    }

    /**
     * Returns the edge count of the node.
     *
     * @param naryNode
     * @return
     */
    public static <T> int maxEdges(NaryNode<T> naryNode) {
        if (naryNode == null) {
            return 0;
        } else {
            int edgeCount = 0;
            if (naryNode.hasChildren()) {
                for (NaryNode<T> child : naryNode.getChildren()) {
                    edgeCount += (maxEdges(child) + 1);
                }
            }

            return edgeCount;
        }
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
    public T getValue() {
        return value;
    }

    /**
     * Returns true if the node has children otherwise false.
     *
     * @return
     */
    public boolean hasChildren() {
        return (getChildren() != null && getChildren().size() > 0);
    }

    /**
     * @return
     */
    public List<NaryNode<T>> getChildren() {
        return children;
    }

    /**
     * @param naryNode
     */
    public void addChild(final NaryNode naryNode) {
        if (children == null) {
            children = new LinkedList<>();
        }

        if (naryNode != null) {
            children.add(naryNode);
        }
    }

    /**
     * Adds the new child for this node.
     *
     * @param data
     */
    public void addChild(final String data) {
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

        if (getValue() != null) {
            nodeString.append(getValue());
            if (SHOW_DEPTH) {
                nodeString.append(" [").append(maxHeight(this)).append("]");
            }
            nodeString.append("\n");
        }

        if (hasChildren()) {
            for (NaryNode child : getChildren()) {
                int nodeLevel = maxDepth(child);
                for (int i = 1; i < nodeLevel - 1; i++) {
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
        return (getValue() == treeNode.getValue() && Objects.equals(children, treeNode.getChildren()));
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getValue(), children);
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
