package com.rslakra.theorem.adts.tree.data.loader;

import com.rslakra.theorem.adts.tree.AbstractTree;
import com.rslakra.theorem.adts.tree.Node;

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
public class AnimalHypotheticalTreeHierarchicalDataLoader implements TreeHierarchicalDataLoader<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        Node<String> rootNode = new Node<>(false, "Tree of Life");
        tree.addNode(null, rootNode);

        // add next level children
        tree.addNode(rootNode, "Vertebrates");
        tree.addNode(rootNode, "Seaweed");

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
