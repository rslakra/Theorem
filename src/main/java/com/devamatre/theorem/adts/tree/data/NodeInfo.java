package com.devamatre.theorem.adts.tree.data;

import com.devamatre.theorem.adts.tree.Node;
import lombok.Getter;

/**
 * The class that represents the node and other metaData  of the node. This helper class is used in many other algo.
 *
 * @author Rohtash Lakra
 * @created 11/28/23 8:44 AM
 */
@Getter
public class NodeInfo<E extends Comparable<? super E>> {

    private Node<E> node;
    private int level;
    private int height;
    private long diameter;

    /**
     * @param node
     * @param level
     * @param height
     * @param diameter
     */
    public NodeInfo(Node<E> node, int level, int height, long diameter) {
        this.node = node;
        this.level = level;
        this.height = height;
        this.diameter = diameter;
    }

    /**
     * @param node
     * @param height
     * @param diameter
     */
    public NodeInfo(Node<E> node, int height, long diameter) {
        this(node, 0, height, diameter);
    }

    /**
     * @param level
     * @param height
     */
    public NodeInfo(int level, int height) {
        this(null, level, height, 0);
    }

    /**
     * @param height
     * @param diameter
     */
    public NodeInfo(int height, long diameter) {
        this(null, 0, height, diameter);
    }

    /**
     * @param node
     * @param level
     */
    public NodeInfo(Node<E> node, int level) {
        this(node, level, 0, 0);
    }

    /**
     * @param nodeInfo
     */
    public NodeInfo(NodeInfo nodeInfo) {
        this.node = nodeInfo.getNode();
        this.level = nodeInfo.getLevel();
        this.height = nodeInfo.getHeight();
        this.diameter = nodeInfo.getDiameter();
    }
}
