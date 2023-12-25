package com.devamatre.theorem.adts.tree.data.populate;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.Node;

/**
 * Hypothetical animal labelled tree
 *
 * <pre>
 * Tree of Life
 * |-- Vertebrates
 * |   |-- Amphibian
 * |   |   |-- Frog
 * |   |-- Birds
 * |   |   |-- Peacock
 * |   |-- Mammals
 * |   |   |-- Cow
 * |   |   |-- Human
 * |   |   |-- Zebra
 * |   |-- Fishes
 * |   |-- Reptiles
 * |   |    |-- Lizard
 * |   |    |-- Snake
 * |-- Seaweed
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 12/21/23 8:43 AM
 */
public class AnimalHypotheticalTreeHierarchicalDataPopulator implements TreeHierarchicalDataPopulator<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        tree.addNode("Tree of Life");

        // add next level children
        Node<String> treeOfLife = tree.findNode("Tree of Life");
        tree.addNode(treeOfLife, "Vertebrates");
        tree.addNode(treeOfLife, "Seaweed");

        // add next level children
        Node<String> vertebrates = tree.findNode("Vertebrates");
        tree.addNode(vertebrates, "Amphibian");
        tree.addNode(tree.findNode("Amphibian"), "Frog");
        // add next level children
        tree.addNode(vertebrates, "Birds");
        tree.addNode(tree.findNode("Birds"), "Peacock");
        // add next level children
        tree.addNode(vertebrates, "Mammals");
        Node<String> mammals = tree.findNode("Mammals");
        tree.addNode(mammals, "Cow");
        tree.addNode(mammals, "Human");
        tree.addNode(mammals, "Zebra");

        // add next level children
        tree.addNode(vertebrates, "Fishes");

        // add next level children
        tree.addNode(vertebrates, "Reptiles");
        Node<String> reptiles = tree.findNode("Reptiles");
        tree.addNode(reptiles, "Lizard");
        tree.addNode(reptiles, "Snake");

        return tree;
    }
}
