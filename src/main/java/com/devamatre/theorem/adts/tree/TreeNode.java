package com.devamatre.theorem.adts.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rohtash Lakra
 * @created 9/18/23 7:00 PM
 */
@Getter
@Setter
public class TreeNode<T> extends Node<T> {

    /**
     * @param value
     */
    public TreeNode(T value) {
        super(value);
    }

    /**
     * Returns the value of parent.
     *
     * @return the parent
     */
    @Override
    public TreeNode<T> getParent() {
        return (TreeNode) super.getParent();
    }

    /**
     * Returns the value of leftNode.
     *
     * @return the leftNode
     */
    @Override
    public TreeNode<T> getLeft() {
        return (TreeNode) super.getLeft();
    }

    /**
     * Returns the value of rightNode.
     *
     * @return the rightNode
     */
    @Override
    public TreeNode<T> getRight() {
        return (TreeNode) super.getRight();
    }
}
