package com.devamatre.theorem.adts.tree.data.populate;

import com.devamatre.theorem.adts.tree.AbstractTree;

/**
 * An example of the biological classification of some animals.
 * <pre>
 * Kingdom
 * |-- Animalia
 * |   |-- Arthropod
 * |   |   |-- Insect
 * |   |   |   |-- Diptera
 * |   |   |   |   |-- Muscidae
 * |   |   |   |   |   |-- Musca
 * |   |   |   |   |   |   |-- Domestica
 * |   |   |   |   |   |   |   |-- Housefly
 * |   |-- Chordate
 * |   |   |-- Mammal
 * |   |   |   |-- Carnivora
 * |   |   |   |   |-- Falidae
 * |   |   |   |   |   |-- Felis
 * |   |   |   |   |   |   |-- Domestica
 * |   |   |   |   |   |   |   |-- House Cat
 * |   |   |   |   |   |   |-- Leo
 * |   |   |   |   |   |   |   |-- Lion
 * |   |   |   |-- Primate
 * |   |   |   |   |-- Hominidae
 * |   |   |   |   |   |-- Homo
 * |   |   |   |   |   |   |-- Sapiens
 * |   |   |   |   |   |   |   |-- Human
 * |   |   |   |   |-- Pongidae
 * |   |   |   |   |   |-- Pan
 * |   |   |   |   |   |   |-- Troglodytes
 * |   |   |   |   |   |   |   |-- Chimpanzee
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 12/21/23 8:45 AM
 */
public class AnimalBiologicalTreeHierarchicalDataPopulator implements TreeHierarchicalDataPopulator<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        tree.addNode("Kingdom");

        // add next level children
        tree.addNode(tree.findNode("Kingdom"), "Animalia");
        tree.addNode(tree.findNode("Animalia"), "Arthropod");
        tree.addNode(tree.findNode("Arthropod"), "Insect");
        tree.addNode(tree.findNode("Insect"), "Diptera");
        tree.addNode(tree.findNode("Diptera"), "Muscidae");
        tree.addNode(tree.findNode("Muscidae"), "Musca");
        tree.addNode(tree.findNode("Musca"), "Domestica");
        tree.addNode(tree.findNode("Domestica"), "Housefly");

        // add next level children
        tree.addNode(tree.findNode("Animalia"), "Chordate");
        tree.addNode(tree.findNode("Chordate"), "Mammal");

        // add next level children
        tree.addNode(tree.findNode("Mammal"), "Carnivora");
        tree.addNode(tree.findNode("Carnivora"), "Falidae");
        tree.addNode(tree.findNode("Falidae"), "Felis");

        // add next level children
        tree.addNode(tree.findNode("Felis"), "Domestica");
        tree.addNode(tree.findNode("Domestica"), "House Cat");
        tree.addNode(tree.findNode("Felis"), "Leo");
        tree.addNode(tree.findNode("Leo"), "Lion");

        // add next level children
        tree.addNode(tree.findNode("Mammal"), "Primate");
        // add next level children
        tree.addNode(tree.findNode("Primate"), "Hominidae");
        tree.addNode(tree.findNode("Hominidae"), "Homo");
        tree.addNode(tree.findNode("Homo"), "Sapiens");
        tree.addNode(tree.findNode("Sapiens"), "Human");
        // add next level children
        tree.addNode(tree.findNode("Primate"), "Pongidae");
        tree.addNode(tree.findNode("Pongidae"), "Pan");
        tree.addNode(tree.findNode("Pan"), "Troglodytes");
        tree.addNode(tree.findNode("Troglodytes"), "Chimpanzee");

        return tree;
    }
}
