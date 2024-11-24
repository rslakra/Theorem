package com.rslakra.theorem.adts.tree.data.loader;

import com.rslakra.theorem.adts.tree.AbstractTree;
import com.rslakra.theorem.adts.tree.Node;

/**
 * An example of a cluster diagram
 * <pre>
 * Cluster
 * |-- Analytics
 * |   |-- Cluster
 * |   |    |-- Hierarchical
 * |   |-- Graph
 * |   |    |-- Tree
 * |   |-- Optimization
 * |   |    |-- Aspect Ratio
 * |-- Animate
 * |   |-- Pause
 * |   |-- Parallel
 * |   |-- Interpolate
 * |   |   |-- Array
 * |   |   |-- Matrix
 * |-- Data
 * |   |-- Schema
 * |   |   |-- Table
 * |   |   |   |-- Field
 * |-- Query
 * |   |-- Create
 * |   |-- Select
 * |   |   |-- Field
 * |   |-- Update
 * |   |-- Delete
 * |-- Operator
 * |   |   |-- Unary
 * |   |   |-- Binary
 * |   |   |   |-- Addition
 * |   |   |   |-- Division
 * |   |   |   |-- Multiply
 * |   |   |   |-- Subtract
 * |   |   |-- Logical
 * |   |   |   |-- And
 * |   |   |   |-- Or
 * |   |   |   |-- Not
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 12/21/23 8:47 AM
 */
public class ClusterTreeHierarchicalDataLoader implements TreeHierarchicalDataLoader<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        Node<String> rootNode = new Node<>("Cluster");
        tree.addNode(null, rootNode);
        // add next level children
        Node<String> analytics = new Node<>("Analytics");
        Node<String> animate = new Node<>("Animate");
        Node<String> data = new Node<>("Data");
        Node<String> query = new Node<>("Query");
        Node<String> operator = new Node<>("Operator");
        tree.addNode(rootNode, analytics);
        tree.addNode(rootNode, animate);
        tree.addNode(rootNode, data);
        tree.addNode(rootNode, query);
        tree.addNode(rootNode, operator);
        // add next level children
        Node<String> cluster = new Node<>("Cluster");
        tree.addNode(analytics, cluster);
        tree.addNode(cluster, "Hierarchical");
        // add next level children
        tree.addNode(analytics, "Graph");
        tree.addNode(tree.findNode("Graph"), "Tree");
        // add next level children
        tree.addNode(analytics, "Optimization");
        tree.addNode(tree.findNode("Optimization"), "Aspect Ratio");
        // add next level children
        tree.addNode(animate, "Pause");
        tree.addNode(animate, "Parallel");
        Node<String> interpolate = new Node<>("Interpolate");
        tree.addNode(animate, interpolate);
        // add next level children
        tree.addNode(interpolate, "Array");
        tree.addNode(interpolate, "Matrix");
        // add next level children
        tree.addNode(data, "Schema");
        tree.addNode(tree.findNode("Schema"), "Table");
        tree.addNode(tree.findNode("Table"), "Field");
        // add next level children
        tree.addNode(query, "Create");
        tree.addNode(query, "Select");
        tree.addNode(tree.findNode("Select"), "Field");
        tree.addNode(query, "Update");
        tree.addNode(query, "Delete");
        // add next level children
        tree.addNode(operator, "Unary");
        tree.addNode(operator, "Binary");
        tree.addNode(operator, "Logical");
        // add next level children
        Node<String> binary = tree.findNode("Binary");
        tree.addNode(binary, "Addition");
        tree.addNode(binary, "Division");
        tree.addNode(binary, "Multiply");
        tree.addNode(binary, "Subtract");
        // add next level children
        Node<String> logical = tree.findNode("Logical");
        tree.addNode(logical, "And");
        tree.addNode(logical, "Or");
        tree.addNode(logical, "Not");

        return tree;
    }
}
