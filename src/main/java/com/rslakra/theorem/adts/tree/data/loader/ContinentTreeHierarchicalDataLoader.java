package com.rslakra.theorem.adts.tree.data.loader;

import com.rslakra.theorem.adts.tree.AbstractTree;
import com.rslakra.theorem.adts.tree.Node;

/**
 * Continents Hierarchy
 *
 * <pre>
 * Continent
 * |-- Asia
 * |   |-- India
 * |   |   |-- Delhi
 * |   |   |-- Kolkata
 * |   |   |-- Mumbai
 * |   |   |-- Rohtak
 * |   |-- China
 * |   |   |-- Bejing
 * |   |   |-- Guangzhou
 * |   |   |-- Shanghai
 * |   |-- Japan
 * |   |-- Indonesia
 * |-- North America
 * |   |-- United States
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 12/21/23 8:50 AM
 */
public class ContinentTreeHierarchicalDataLoader implements TreeHierarchicalDataLoader<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        Node<String> rootNode = new Node<>("Continent");
        tree.addNode(null, rootNode);

        // add next level children
        tree.addNode(rootNode, "Asia");
        tree.addNode(rootNode, "North America");

        // add next level children
        Node<String> asia = tree.findNode("Asia");
        tree.addNode(asia, "India");
        tree.addNode(asia, "China");
        tree.addNode(asia, "Japan");
        tree.addNode(asia, "Indonesia");

        // add next level children
        Node<String> india = tree.findNode("India");
        assert india != null;
        tree.addNode(india, "Delhi");
        tree.addNode(india, "Kolkata");
        tree.addNode(india, "Mumbai");
        tree.addNode(india, "Rohtak");

        // add next level children
        Node<String> china = tree.findNode("China");
        tree.addNode(china, "Bejing");
        tree.addNode(china, "Guangzhou");
        tree.addNode(china, "Shanghai");

        // add next level children
        tree.addNode(tree.findNode("North America"), "United States");

        return tree;
    }
}
