package com.devamatre.theorem.adts.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 5/13/22 6:47 PM
 */
public class BinaryTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryTreeTest.class);

    @Test
    public void testAddNode() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addNode(3);
        tree.addNode(1);
        tree.addNode(4);
        tree.addNode(2);
        LOGGER.debug("tree:{}", tree);

//        Integer[] expected = new Integer[]{3, 1, 2, 4};
//        assertTreePreOrder(tree, expected);
    }
//
//    @Test
//    public void testRemoveLeaf() {
//        /**
//         * <pre>
//         *         3
//         *     /     \
//         *    1       4
//         *     \
//         *      2
//         * </pre>
//         */
//        BinaryTree<Integer> tree = new BinaryTree<Integer>();
//        tree.addNode(3);
//        tree.addNode(1);
//        tree.addNode(4);
//        tree.addNode(2);
//
//        tree.remove(2);
//        assertTreePreOrder(tree, new Integer[]{3, 1, 4});
//
//        tree.remove(4);
//        assertTreePreOrder(tree, new Integer[]{3, 1});
//
//        tree.remove(1);
//        assertTreePreOrder(tree, new Integer[]{3});
//    }
//
//    @Test
//    public void testRemoveRightChild() {
//        /**
//         * <pre>
//         *         3
//         *     /     \
//         *    1       4
//         *     \
//         *      2
//         * </pre>
//         */
//        BinaryTree<Integer> tree = new BinaryTree<Integer>();
//        tree.addNode(3);
//        tree.addNode(1);
//        tree.addNode(4);
//        tree.addNode(2);
//
//        tree.remove(1);
//        assertTreePreOrder(tree, new Integer[]{3, 2, 4});
//    }
//
//    @Test
//    public void testRemoveLeftChild() {
//        /**
//         * <pre>
//         *         3
//         *     /     \
//         *    2       4
//         *   /
//         *  1
//         * </pre>
//         */
//        BinaryTree<Integer> tree = new BinaryTree<Integer>();
//        tree.addNode(3);
//        tree.addNode(2);
//        tree.addNode(4);
//        tree.addNode(1);
//
//        tree.remove(2);
//        assertTreePreOrder(tree, new Integer[]{3, 1, 4});
//    }
//
//    @Test
//    public void testRemoveTwoChild() {
//        /**
//         * <pre>
//         *            10
//         *          /   \
//         *        /      \
//         *       5        11
//         *     /  \
//         *    4    9
//         *   / \
//         *  3   7
//         *       \
//         *        8
//         * </pre>
//         */
//        BinaryTree<Integer> tree = new BinaryTree<Integer>();
//        tree.addNode(10);
//        tree.addNode(5);
//        tree.addNode(4);
//        tree.addNode(9);
//        tree.addNode(7);
//        tree.addNode(8);
//        tree.addNode(3);
//        tree.addNode(11);
//
//        /**
//         * <pre>
//         *            10
//         *          /   \
//         *        /      \
//         *       7        11
//         *     /  \
//         *    4    9
//         *   / \
//         *  3   8
//         * </pre>
//         */
//        tree.remove(5);
//        assertTreePreOrder(tree, new Integer[]{10, 7, 4, 3, 9, 8, 11});
//    }
//
//    @Test
//    public void testRemoveRootTwoChild() {
//        //          10
//        //      5        20
//        //    4   6    15
//        //           12
//        //             13
//        //               14
//        BinaryTree<Integer> tree = new BinaryTree<Integer>();
//        tree.addNode(10);
//        tree.addNode(5);
//        tree.addNode(4);
//        tree.addNode(6);
//
//        tree.addNode(20);
//        tree.addNode(15);
//        tree.addNode(12);
//        tree.addNode(13);
//        tree.addNode(14);
//
//        //          12
//        //      5        20
//        //    4   6    15
//        //           13
//        //             14
//        //
//        tree.remove(10);
//        assertTreePreOrder(tree, new Integer[]{12, 5, 4, 6, 20, 15, 13, 14});
//
//        //          13
//        //      5        20
//        //    4   6    15
//        //           14
//        //
//        tree.remove(12);
//        assertTreePreOrder(tree, new Integer[]{13, 5, 4, 6, 20, 15, 14});
//    }
//
//    @Test
//    public void testRemoveRootOneChildLeft() {
//        //          3
//        //      2
//        //     1
//        BinaryTree<Integer> tree = new BinaryTree<Integer>();
//        tree.addNode(3);
//        tree.addNode(2);
//        tree.addNode(1);
//
//        tree.remove(3);
//        assertTreePreOrder(tree, new Integer[]{2, 1});
//    }
//
//    @Test
//    public void testRemoveRootOneChildRight() {
//        //          3
//        //            4
//        //              5
//        BinaryTree<Integer> tree = new BinaryTree<Integer>();
//        tree.addNode(3);
//        tree.addNode(4);
//        tree.addNode(5);
//
//        tree.remove(3);
//        assertTreePreOrder(tree, new Integer[]{4, 5});
//    }
//
//    @Test
//    public void testRemoveRootOnly() {
//        BinaryTree<Integer> tree = new BinaryTree<Integer>();
//        tree.addNode(3);
//
//        tree.remove(3);
//        assertTreePreOrder(tree, new Integer[]{});
//    }
//
//    @Test
//    public void testPreOrderCopyTree() {
//        //          10
//        //      5        20
//        //    4   6    15
//        //           12
//        //             13
//        //               14
//        BinaryTree<Integer> expected = new BinaryTree<Integer>();
//        expected.addNode(10);
//        expected.addNode(5);
//        expected.addNode(4);
//        expected.addNode(6);
//
//        expected.addNode(20);
//        expected.addNode(15);
//        expected.addNode(12);
//        expected.addNode(13);
//        expected.addNode(14);
//
//        BinaryTree<Integer> actual = new BinaryTree<Integer>();
////        expected.preOrderTraversal((value) => actual.addNode(value));
//
//        assertTreesSame(actual, expected);
//    }
//
//    private Integer[] preOrderArray(BinaryTree<Integer> tree) {
////        DoublyLinkedList<Integer> actualList = new DoublyLinkedList<Integer>();
////        tree.preOrderTraversal((value) = > actualList.AddTail(value));
////        return actualList.to();
//        return null;
//    }
//
//    private void assertTreesSame(BinaryTree<Integer> actual, BinaryTree<Integer> expected) {
//        assertArraysSame(preOrderArray(actual), preOrderArray(expected));
//    }
//
//    private void assertArraysSame(Integer[] actual, Integer[] expected) {
//        Assert.assertNotNull(actual);
//        Assert.assertNotNull(expected);
//        Assert.assertEquals(expected.length, actual.length);
//        for (Integer i = 0; i < expected.length; i++) {
//            Assert.assertEquals(expected[i], actual[i], String.format("Incorrect value at index {0}", i));
//        }
//    }
//
//    private void assertTreePreOrder(BinaryTree<Integer> tree, Integer[] expected) {
//        Assert.assertEquals(tree.getSize(), expected.length, "Tree count was incorrect");
//        Integer[] actual = preOrderArray(tree);
//        assertArraysSame(actual, expected);
//    }

    /**
     * @param tree
     */
    public static void fillPresidentTree(BinaryTree<String> tree) {
        tree.addNode("Lincoin");
        tree.addNode("Jefferson");
        tree.addNode("Jackson");
        tree.addNode("Adams");
        tree.addNode("Kennedy");
        tree.addNode("Washington");
        tree.addNode("Madison");
        tree.addNode("Roosevelt");
        tree.addNode("Buchanan");
    }

    /**
     * @param bTree
     */
    public static void fillAnimalSpeciesTree(BinaryTree<String> bTree) {
        bTree.addNode("Anamilia");
        bTree.addNode("Chordate");
        bTree.addNode("Mammal");
        bTree.addNode("Arthropoda");
        bTree.addNode("Insect");
        bTree.addNode("Primate");
        bTree.addNode("Carnivora");
        bTree.addNode("Diptera");
        bTree.addNode("Hominidac");
        bTree.addNode("Pongidae");
        bTree.addNode("Felidae");
        bTree.addNode("Muscidae");
        bTree.addNode("Homo");
        bTree.addNode("Pan");
        bTree.addNode("Felis");
        bTree.addNode("Musca");
        bTree.addNode("Sapiens");
        bTree.addNode("Troglodytes");
        bTree.addNode("Domestica");
        bTree.addNode("Leo");
        bTree.addNode("Domestica");
        bTree.addNode("Human");
        bTree.addNode("Chimpanzee");
        bTree.addNode("House Cat");
        bTree.addNode("Lion");
        bTree.addNode("Housefly");
    }

    @Test
    public void testBinaryTree() {
        BinaryTree<String> bTree = new BinaryTree<String>();
        fillPresidentTree(bTree);
        System.out.println("Size:" + bTree.getSize());
        System.out.println(bTree.contain("Jackson"));
        System.out.println(bTree);

        bTree = new BinaryTree<>();
        bTree.addLeftChild("A");
        bTree.addLeftChild("B");
        bTree.addRightChild("C");

        bTree.getLeftNode().addRightNode("D");
        bTree.getRightNode().addLeftNode("E");
        bTree.getRightNode().addRightNode("F");

        System.out.println(bTree);
    }

}
