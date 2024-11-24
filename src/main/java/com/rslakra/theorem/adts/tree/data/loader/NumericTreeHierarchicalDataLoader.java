package com.rslakra.theorem.adts.tree.data.loader;

import com.rslakra.theorem.adts.tree.AbstractTree;
import com.rslakra.theorem.adts.tree.Node;

/**
 * The numeric tree
 * <pre>
 * 50
 * |-- 30
 * |   |-- 28
 * |   |   |-- 22
 * |   |   |-- 24
 * |   |   |   |-- 23
 * |   |   |-- 29
 * |   |   |   |-- 26
 * |   |-- 25
 * |-- 10
 * |   |-- 6
 * |   |   |-- 3
 * |   |   |   |-- 9
 * |   |-- 8
 * |   |   |-- 1
 * |   |   |-- 7
 * |   |   |   |-- 5
 * |   |-- 2
 * |-- 20
 * |   |-- 12
 * |   |-- 15
 * |   |   |-- 12
 * |   |-- 19
 * |   |   |-- 14
 * |   |   |   |-- 11
 * |   |   |   |-- 18
 * |   |   |-- 17
 * |-- 40
 * |   |-- 44
 * |   |   |-- 42
 * |   |   |   |-- 43
 * |   |   |   |-- 44
 * |   |-- 45
 * |   |   |-- 46
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 12/21/23 8:53 AM
 */
public class NumericTreeHierarchicalDataLoader implements TreeHierarchicalDataLoader<Integer> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<Integer> fillHierarchicalData(AbstractTree<Integer> tree) {
        // add rootNode
        Node<Integer> rootNode = new Node<>(50);
        tree.addNode(null, rootNode);

        // add next level children
        Node<Integer> ten = new Node<>(10);
        Node<Integer> twenty = new Node<>(20);
        Node<Integer> thirty = new Node<>(30);
        Node<Integer> forty = new Node<>(40);
        tree.addNode(rootNode, thirty);
        tree.addNode(rootNode, ten);
        tree.addNode(rootNode, twenty);
        tree.addNode(rootNode, forty);

        // add next level children
        Node<Integer> twentyEight = new Node<>(28);
        tree.addNode(thirty, twentyEight);
        tree.addNode(thirty, 25);
        tree.addNode(twentyEight, 22);
        Node<Integer> twentyFour = new Node<>(24);
        tree.addNode(twentyEight, twentyFour);
        tree.addNode(twentyFour, 23);
        Node<Integer> twentyNine = new Node<>(29);
        tree.addNode(twentyEight, twentyNine);
        tree.addNode(twentyNine, 26);

        // add next level children
        Node<Integer> six = new Node<>(6);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> two = new Node<>(2);
        tree.addNode(ten, six);
        tree.addNode(ten, eight);
        tree.addNode(ten, two);
        Node<Integer> three = new Node<>(3);
        tree.addNode(six, three);
        tree.addNode(three, 9);
        Node<Integer> seven = new Node<>(7);
        tree.addNode(eight, 1);
        tree.addNode(eight, seven);
        tree.addNode(seven, 5);

        // add next level children
        Node<Integer> twelve = new Node<>(12);
        Node<Integer> fifteen = new Node<>(15);
        Node<Integer> nineteen = new Node<>(19);
        tree.addNode(twenty, twelve);
        tree.addNode(twenty, fifteen);
        tree.addNode(twenty, nineteen);
        tree.addNode(fifteen, 12);
        Node<Integer> fourteen = new Node<>(14);
        tree.addNode(nineteen, fourteen);
        tree.addNode(nineteen, 17);
        tree.addNode(fourteen, 11);
        tree.addNode(fourteen, 18);

        // add next level children
        Node<Integer> fortyFour = new Node<>(44);
        Node<Integer> fortyFive = new Node<>(45);
        tree.addNode(forty, fortyFour);
        tree.addNode(forty, fortyFive);
        Node<Integer> fortyTwo = new Node<>(42);
        tree.addNode(fortyFour, fortyTwo);
        tree.addNode(fortyTwo, 43);
        tree.addNode(fortyTwo, 44);
        tree.addNode(fortyFive, 46);

        return tree;
    }
}
