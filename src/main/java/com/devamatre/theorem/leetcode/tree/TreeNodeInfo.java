package com.devamatre.theorem.leetcode.tree;

import lombok.Getter;

/**
 * The class that represents the node and other metaData  of the node. This helper class is used in many other algo.
 *
 * @author Rohtash Lakra
 * @created 11/28/23 8:44 AM
 */
@Getter
public class TreeNodeInfo {

    private TreeNode treeNode;
    private int level;
    private int height;
    private long diameter;

    /**
     * @param treeNode
     * @param level
     * @param height
     * @param diameter
     */
    public TreeNodeInfo(TreeNode treeNode, int level, int height, long diameter) {
        this.treeNode = treeNode;
        this.level = level;
        this.height = height;
        this.diameter = diameter;
    }

    /**
     * @param treeNode
     * @param height
     * @param diameter
     */
    public TreeNodeInfo(TreeNode treeNode, int height, long diameter) {
        this(treeNode, 0, height, diameter);
    }

    /**
     * @param level
     * @param height
     */
    public TreeNodeInfo(int level, int height) {
        this(null, level, height, 0);
    }

    /**
     * @param height
     * @param diameter
     */
    public TreeNodeInfo(int height, long diameter) {
        this(null, 0, height, diameter);
    }

    /**
     * @param treeNode
     * @param level
     */
    public TreeNodeInfo(TreeNode treeNode, int level) {
        this(treeNode, level, 0, 0);
    }

    /**
     * @param treeNodeInfo
     */
    public TreeNodeInfo(TreeNodeInfo treeNodeInfo) {
        this.treeNode = treeNodeInfo.getTreeNode();
        this.level = treeNodeInfo.getLevel();
        this.height = treeNodeInfo.getHeight();
        this.diameter = treeNodeInfo.getDiameter();
    }
}
