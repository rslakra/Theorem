package com.devamatre.theorem.adts.tree;

import com.devamatre.appsuite.core.BeanUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 */
public class NaryTree<E extends Comparable<? super E>> {

    private NaryNode<E> root;
    private int size;

    public NaryTree() {
        root = null;
        size = 0;
    }

    /**
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds the <code>child</code> as children of the <code>parent</code> tree.
     *
     * @param parent
     * @param child
     */
    public void addChild(NaryNode<E> parent, NaryNode<E> child) {
        if (BeanUtils.isNull(parent)) {
            if (BeanUtils.isNull(root)) {
                this.root = child;
            } else {
                root.addChild(child);
            }
        } else {
            parent.addChild(child);
        }
        size += child.getChildren().size() + 1;
    }

    /**
     * Adds the <code>data</code> as children of the <code>parent</code> tree.
     *
     * @param parent
     * @param data
     */
    public void addChild(NaryNode<E> parent, E data) {
        this.addChild(parent, new NaryNode<E>(parent, data));
    }

    /**
     * Adds the <code>child</code> as children of the <code>parent</code> tree.
     *
     * @param child
     */
    public void addChild(NaryNode<E> child) {
        addChild(root, child);
    }

    /**
     * Adds the <code>data</code> as children of the tree.
     *
     * @param data
     */
    public void addChild(E data) {
        this.addChild(root, new NaryNode<E>(root, data));
    }

    /**
     * Adds the <code>data</code> as children of the tree.
     *
     * @param data
     */
    public void add(E data) {
        this.addChild(root, new NaryNode<E>(root, data));
    }

    /**
     * Returns true if the node contain otherwise false.
     *
     * @param data
     * @return
     */
    public boolean contain(E data) {
        return (findNode(data) != null);
    }

    /**
     * Finds the node with the provided <code>data</code>.
     *
     * @param parentNode
     * @param data
     * @return
     */
    private NaryNode<E> findNode(NaryNode<E> parentNode, E data) {
        // base case, if parentNode is null, return null.
        if (parentNode == null) {
            return null;
        }

        // check the data matches with the parentNode or not
        if (parentNode.getData().compareTo(data) == 0) {
            return parentNode;
        } else {
            // check children of the parentNode
            for (NaryNode treeNode : parentNode.getChildren()) {
                return findNode(treeNode, data);
            }

            return null;
        }
    }

    /**
     * Returns the node for the given data.
     *
     * @param data
     * @return
     */
    private NaryNode<E> findNode(E data) {
        return (data == null ? null : findNode(root, data));
    }

    /**
     * Returns true if the node is deleted otherwise false.
     *
     * @param data
     * @return
     */
    public boolean delete(E data) {
        boolean deleted = false;
        // if not empty, check which node to delete.
        if (root != null) {
            NaryNode<E> delNode = findNode(data);
            // if node exists, delete it.
            if (delNode != null) {
                NaryNode<E> parent = delNode.getParent();
                // update tree's size
                int childCount = delNode.getChildren().size() + 1;
                deleted = parent.getChildren().remove(delNode);
                if (deleted) {
                    size -= childCount;
                }
                delNode.setParent(null);
            }
        }

        return deleted;
    }

    /**
     * Returns the string representation of this object.
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        if (BeanUtils.isNotNull(root)) {
            Queue<NaryNode<E>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                NaryNode<E> pollNode = queue.poll();
                sBuilder.append(pollNode.getData().toString());
                if (pollNode.hasChildren()) {
                    for (NaryNode<E> treeNode : pollNode.getChildren()) {
                        queue.add(treeNode);
                    }
                }
                if (!queue.isEmpty()) {
                    sBuilder.append(", ");
                }
            }
        }

        return sBuilder.append("]").toString();
    }

}
