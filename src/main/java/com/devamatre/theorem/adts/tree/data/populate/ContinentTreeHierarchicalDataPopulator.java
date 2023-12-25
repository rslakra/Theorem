package com.devamatre.theorem.adts.tree.data.populate;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.Node;

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
public class ContinentTreeHierarchicalDataPopulator implements TreeHierarchicalDataPopulator<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        tree.addNode("Continent");

        // add next level children
        Node<String> continent = tree.findNode("Continent");
        tree.addNode(continent, "Asia");
        tree.addNode(continent, "North America");

        // add next level children
        Node<String> asia = tree.findNode("Asia");
        tree.addNode(asia, "India");
        tree.addNode(asia, "China");
        tree.addNode(asia, "Japan");
        tree.addNode(asia, "Indonesia");

        // add next level children
        Node<String> india = tree.findNode("India");
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
