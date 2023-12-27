package com.devamatre.theorem.adts.tree.data.loader;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.Node;

/**
 * <pre>
 * Operator
 * |-- Arithmetic
 * |   |-- +
 * |   |-- -
 * |   |-- *
 * |   |-- /
 * |   |-- %
 * |   |-- ++
 * |   |-- --
 * |-- Comparison
 * |   |-- ==
 * |   |-- !=
 * |   |-- >
 * |   |-- >=
 * |   |-- <
 * |   |-- <=
 * |-- Logical
 * |   |-- &&
 * |   |-- ||
 * |   |-- !
 * |-- Bitwise
 * |   |-- &
 * |   |-- |
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/26/2023 4:45 PM
 */
public class OperatorTreeHierarchicalDataLoader implements TreeHierarchicalDataLoader<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        Node<String> rootNode = new Node<>("Operators");
        tree.addNode(null, rootNode);
        // add next level children
        Node<String> arithmetic = new Node<>("Arithmetic");
        Node<String> comparison = new Node<>("Comparison");
        Node<String> logical = new Node<>("Logical");
        Node<String> bitwise = new Node<>("Bitwise");
        tree.addNode(rootNode, arithmetic);
        tree.addNode(rootNode, comparison);
        tree.addNode(rootNode, logical);
        tree.addNode(rootNode, bitwise);
        // add next level children
        tree.addNode(arithmetic, "+");
        tree.addNode(arithmetic, "-");
        tree.addNode(arithmetic, "*");
        tree.addNode(arithmetic, "/");
        tree.addNode(arithmetic, "%");
        tree.addNode(arithmetic, "++");
        tree.addNode(arithmetic, "--");
        // add next level children
        tree.addNode(comparison, "==");
        tree.addNode(comparison, "!=");
        tree.addNode(comparison, ">");
        tree.addNode(comparison, ">=");
        tree.addNode(comparison, "<");
        tree.addNode(comparison, "<=");
        // add next level children
        tree.addNode(logical, "&&");
        tree.addNode(logical, "||");
        // add next level children
        tree.addNode(bitwise, "&");
        tree.addNode(bitwise, "|");

        return tree;
    }
}
