package com.devamatre.theorem.adts.tree.data.populate;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.Node;

/**
 * The numeric tree
 * <pre>
 * 50
 * |-- 30
 * |   |-- 28
 * |   |   |-- 29
 * |   |   |   |-- 24
 * |-- 10
 * |   |-- 16
 * |   |   |-- 13
 * |   |   |   |-- 19
 * |   |-- 18
 * |   |   |-- 11
 * |   |   |-- 17
 * |   |   |   |-- 15
 * |   |-- 12
 * |-- 20
 * |   |-- 25
 * |   |   |-- 22
 * |   |   |   |-- 28
 * |   |   |   |-- 28
 * |   |-- 29
 * |   |   |-- 24
 * |   |   |   |-- 21
 * |   |   |-- 22
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
public class NumericTreeHierarchicalDataPopulator implements TreeHierarchicalDataPopulator<Integer> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<Integer> fillHierarchicalData(AbstractTree<Integer> tree) {
        // add rootNode
        tree.addNode(50);

        // add next level children
        Node<Integer> fifty = tree.findNode(50);
        tree.addNode(fifty, 30);
        tree.addNode(fifty, 10);
        tree.addNode(fifty, 20);
        tree.addNode(fifty, 40);

        // add next level children
        tree.addNode(tree.findNode(30), 28);
        tree.addNode(tree.findNode(28), 29);
        tree.addNode(tree.findNode(29), 24);

        // add next level children
        Node<Integer> ten = tree.findNode(10);
        tree.addNode(ten, 16);
        tree.addNode(ten, 18);
        tree.addNode(ten, 12);
        // add next level children
        tree.addNode(tree.findNode(16), 13);
        tree.addNode(tree.findNode(13), 19);
        // add next level children
        tree.addNode(tree.findNode(18), 11);
        tree.addNode(tree.findNode(18), 17);
        tree.addNode(tree.findNode(17), 15);

        // add next level children
        Node<Integer> twenty = tree.findNode(20);
        tree.addNode(twenty, 25);
        tree.addNode(twenty, 29);
        tree.addNode(tree.findNode(25), 22);
        tree.addNode(tree.findNode(22), 28);
        tree.addNode(tree.findNode(22), 24);
        tree.addNode(tree.findNode(24), 21);
        tree.addNode(tree.findNode(29), 22);

        // add next level children
        Node<Integer> fourty = tree.findNode(40);
        tree.addNode(fourty, 44);
        tree.addNode(fourty, 45);
        tree.addNode(tree.findNode(44), 42);
        tree.addNode(tree.findNode(42), 43);
        tree.addNode(tree.findNode(42), 44);
        tree.addNode(tree.findNode(45), 46);

        /**
         50 [10]
         |-- 30 [6]
         |   |-- 28 [5]
         |   |   |-- 29 [4]
         |   |   |   |-- 24 [2]
         |   |   |   |   |-- 21 [1]
         |   |   |   |-- 22 [1]
         |-- 10 [6]
         |   |-- 16 [3]
         |   |   |-- 13 [2]
         |   |   |   |-- 19 [1]
         |   |-- 18 [3]
         |   |   |-- 11 [1]
         |   |   |-- 17 [2]
         |   |   |   |-- 15 [1]
         |   |-- 12 [1]
         |-- 20 [6]
         |   |-- 25 [4]
         |   |   |-- 22 [3]
         |   |   |   |-- 28 [1]
         |   |   |   |-- 24 [1]
         |   |-- 29 [1]
         |-- 40 [6]
         |   |-- 44 [4]
         |   |   |-- 42 [3]
         |   |   |   |-- 43 [1]
         |   |   |   |-- 44 [1]
         |   |-- 45 [2]
         |   |   |-- 46 [1]
         *
         */

        return tree;
    }
}
