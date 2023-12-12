package com.devamatre.theorem.adts.tree;

import com.devamatre.appsuite.core.BeanUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 9/18/23 7:00 PM
 */
@Getter
@Setter
public class TreeNode<E extends Comparable<? super E>> extends Node<E> {

    private final static boolean SHOW_DEPTH = true;
    private List<TreeNode> children;

    /**
     * Creates the new node.
     *
     * @param value
     */
    public TreeNode(E value) {
        super(value);
        if (BeanUtils.isEmpty(value)) {
            throw new IllegalArgumentException("value is null!");
        }
        setParent(this);
    }

    /**
     * Returns the value of parent.
     *
     * @return the parent
     */
    @Override
    public TreeNode<E> getParent() {
        return (TreeNode) super.getParent();
    }

    /**
     * Returns the value of leftNode.
     *
     * @return the leftNode
     */
    @Override
    public TreeNode<E> getLeft() {
        return (TreeNode) super.getLeft();
    }

    /**
     * Returns the value of rightNode.
     *
     * @return the rightNode
     */
    @Override
    public TreeNode<E> getRight() {
        return (TreeNode) super.getRight();
    }

    /**
     * Returns the length of the path to its root.
     *
     * @param treeNode
     * @return
     */
    public static int maxDepth(final TreeNode treeNode) {
        return (BeanUtils.isNull(treeNode) ? 0 : (maxDepth(treeNode.getParent()) + 1));
    }

    /**
     * Returns the length of the <code>treeNode</code>.
     *
     * @param treeNode
     * @return
     */
    public static int maxHeight(final TreeNode treeNode) {
        int maxDepth = 1;
        if (BeanUtils.isNotNull(treeNode) && treeNode.hasChildren()) {
            for (int i = 0; i < treeNode.getChildren().size(); i++) {
                TreeNode childNode = (TreeNode) treeNode.getChildren().get(i);
                maxDepth = Math.max(maxHeight(childNode) + 1, maxDepth);
            }
        }

        return maxDepth;
    }

    /**
     * Returns the edge count of the <code>treeNode</code>.
     *
     * @param treeNode
     * @return
     */
    public static int maxEdges(final TreeNode treeNode) {
        int edgeCount = 0;
        if (BeanUtils.isNotNull(treeNode) && treeNode.hasChildren()) {
            for (int i = 0; i < treeNode.getChildren().size(); i++) {
                TreeNode childNode = (TreeNode) treeNode.getChildren().get(i);
                edgeCount += (maxEdges(childNode) + 1);
            }
        }

        return edgeCount;
    }

    /**
     * @return
     */
    public List<TreeNode> getChildren() {
        return children;
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
     * @param treeNode
     */
    public void addChild(final TreeNode treeNode) {
        if (BeanUtils.isNull(children)) {
            children = new LinkedList<>();
        }

        // check the treeNode is not null
        if (BeanUtils.isNotNull(treeNode)) {
            treeNode.setParent(this);
            children.add(treeNode);
        }
    }

    /**
     * Adds the new child for this node.
     *
     * @param data
     */
    public void addChild(final E data) {
        addChild(new TreeNode(data));
    }

    /**
     * Returns the string representation of this object.
     * <p>
     * For Example:
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

        if (BeanUtils.isNotNull(getData())) {
            nodeString.append(getData());
            if (SHOW_DEPTH) {
                nodeString.append(" [").append(maxHeight(this)).append("]");
            }
            nodeString.append("\n");
        }

        if (hasChildren()) {
            for (TreeNode child : getChildren()) {
                int nodeLevel = maxDepth(child);
                for (int i = 1; i < nodeLevel - 1; i++) {
                    nodeString.append("|   ");
                }
                nodeString.append("|-- ").append(child.toString());
            }
        }

        return nodeString.toString();
    }


}
