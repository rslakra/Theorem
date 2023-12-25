package com.devamatre.theorem.adts.tree.data.populate;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.Node;

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
public class ClusterTreeHierarchicalDataPopulator implements TreeHierarchicalDataPopulator<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        tree.addNode("Cluster");

        // add next level children
        Node<String> cluster = tree.findNode("Cluster");
        tree.addNode(cluster, "Analytics");
        tree.addNode(cluster, "Animate");
        tree.addNode(cluster, "Data");
        tree.addNode(cluster, "Query");
        tree.addNode(cluster, "Operator");

        // add next level children
        Node<String> analytics = tree.findNode("Analytics");
        tree.addNode(analytics, "Cluster");
        tree.addNode(tree.findNode("Cluster"), "Hierarchical");
        // add next level children
        tree.addNode(analytics, "Graph");
        tree.addNode(tree.findNode("Graph"), "Tree");
        // add next level children
        tree.addNode(analytics, "Optimization");
        tree.addNode(tree.findNode("Optimization"), "Aspect Ratio");
        // add next level children
        Node<String> animate = tree.findNode("Animate");
        tree.addNode(animate, "Pause");
        tree.addNode(animate, "Parallel");
        tree.addNode(animate, "Interpolate");
        // add next level children
        Node<String> interpolate = tree.findNode("Interpolate");
        tree.addNode(interpolate, "Array");
        tree.addNode(interpolate, "Matrix");
        // add next level children
        Node<String> data = tree.findNode("Data");
        tree.addNode(data, "Schema");
        tree.addNode(tree.findNode("Schema"), "Table");
        tree.addNode(tree.findNode("Table"), "Field");
        // add next level children
        Node<String> query = tree.findNode("Query");
        tree.addNode(query, "Create");
        tree.addNode(query, "Select");
        tree.addNode(tree.findNode("Select"), "Field");
        tree.addNode(query, "Update");
        tree.addNode(query, "Delete");
        // add next level children
        Node<String> operator = tree.findNode("Operator");
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
