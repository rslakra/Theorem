package com.devamatre.theorem.adts.tree.data.loader;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.Node;

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
public class AnimalBiologicalTreeHierarchicalDataLoader implements TreeHierarchicalDataLoader<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        Node<String> rootNode = new Node<>("Kingdom");
        tree.addNode(null, rootNode);
        // add next level children
        Node<String> animalia = new Node<>("Animalia");
        tree.addNode(rootNode, animalia);
        // add next level children
        Node<String> arthropod = new Node<>("Arthropod");
        Node<String> chordate = new Node<>("Chordate");
        tree.addNode(animalia, arthropod);
        tree.addNode(animalia, chordate);
        // add next level children
        tree.addNode(arthropod, "Insect");
        tree.addNode(tree.findNode("Insect"), "Diptera");
        tree.addNode(tree.findNode("Diptera"), "Muscidae");
        tree.addNode(tree.findNode("Muscidae"), "Musca");
        tree.addNode(tree.findNode("Musca"), "Domestica");
        tree.addNode(tree.findNode("Domestica"), "Housefly");
        // add next level children
        Node<String> mammal = new Node<>("Mammal");
        tree.addNode(chordate, mammal);
        // add next level children
        Node<String> carnivora = new Node<>("Carnivora");
        Node<String> primate = new Node<>("Primate");
        tree.addNode(mammal, carnivora);
        tree.addNode(mammal, primate);
        // add next level children
        tree.addNode(carnivora, "Falidae");
        Node<String> felis = new Node<>("Felis");
        tree.addNode(tree.findNode("Falidae"), felis);
        Node<String> domestica = new Node<>("Domestica");
        tree.addNode(felis, domestica);
        tree.addNode(felis, "Leo");
        tree.addNode(domestica, "House Cat");
        tree.addNode(tree.findNode("Leo"), "Lion");

        // add next level children
        Node<String> hominidae = new Node<>("Hominidae");
        Node<String> pongidae = new Node<>("Pongidae");
        tree.addNode(primate, hominidae);
        tree.addNode(primate, pongidae);
        // add next level children
        tree.addNode(hominidae, "Homo");
        tree.addNode(tree.findNode("Homo"), "Sapiens");
        tree.addNode(tree.findNode("Sapiens"), "Human");
        // add next level children
        tree.addNode(pongidae, "Pan");
        tree.addNode(tree.findNode("Pan"), "Troglodytes");
        tree.addNode(tree.findNode("Troglodytes"), "Chimpanzee");

        return tree;
    }
}
