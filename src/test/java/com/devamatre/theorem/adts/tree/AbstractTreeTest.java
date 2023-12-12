package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/24/23 1:43 PM
 */
public abstract class AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTreeTest.class);

    /**
     * Fills the tree with american the names of American presidents.
     *
     * @param binaryTree
     */
    public static void fillTreeWithPresidents(BinaryTree<String> binaryTree) {
        binaryTree.addNode("Lincoin");
        binaryTree.addNode("Jefferson");
        binaryTree.addNode("Jackson");
        binaryTree.addNode("Adams");
        binaryTree.addNode("Kennedy");
        binaryTree.addNode("Washington");
        binaryTree.addNode("Madison");
        binaryTree.addNode("Roosevelt");
        binaryTree.addNode("Buchanan");
    }

    /**
     * Fills the tree with the animal species.
     *
     * @param binaryTree
     */
    public static void fillTreeWithAnimalSpecies(BinaryTree<String> binaryTree) {
        binaryTree.addNode("Anamilia");
        binaryTree.addNode("Chordate");
        binaryTree.addNode("Mammal");
        binaryTree.addNode("Arthropoda");
        binaryTree.addNode("Insect");
        binaryTree.addNode("Primate");
        binaryTree.addNode("Carnivora");
        binaryTree.addNode("Diptera");
        binaryTree.addNode("Hominidac");
        binaryTree.addNode("Pongidae");
        binaryTree.addNode("Felidae");
        binaryTree.addNode("Muscidae");
        binaryTree.addNode("Homo");
        binaryTree.addNode("Pan");
        binaryTree.addNode("Felis");
        binaryTree.addNode("Musca");
        binaryTree.addNode("Sapiens");
        binaryTree.addNode("Troglodytes");
        binaryTree.addNode("Domestica");
        binaryTree.addNode("Leo");
        binaryTree.addNode("Domestica");
        binaryTree.addNode("Human");
        binaryTree.addNode("Chimpanzee");
        binaryTree.addNode("House Cat");
        binaryTree.addNode("Lion");
        binaryTree.addNode("Housefly");
    }


    /**
     * Builds the binary tree from the provided <code>inputData</code>.
     *
     * @param inputData
     * @return
     */
    public static <E extends Comparable<? super E>> Tree<E> buildTree(List<E> inputData, boolean isBinary) {
        LOGGER.debug("+buildTree({}, {})", inputData, isBinary);
        final Tree<E> tree = new Tree<>(isBinary);
        if (BeanUtils.isNotEmpty(inputData)) {
            inputData.forEach(data -> {
                LOGGER.debug("data:{}", data);
                tree.addNode(data);
            });
        }

        LOGGER.debug("-buildTree(), tree:{}", tree);
        return tree;
    }

    /**
     * Builds the binary tree from the provided <code>inputData</code>.
     *
     * @param inputData
     * @return
     */
    public static <E extends Comparable<? super E>> BinaryTree<E> buildBinaryTree(List<E> inputData) {
        LOGGER.debug("+buildBinaryTree({})", inputData);
        final BinaryTree<E> tree = new BinaryTree<>();
        if (BeanUtils.isNotEmpty(inputData)) {
            inputData.forEach(data -> {
                LOGGER.debug("data:{}", data);
                tree.addNode(data);
            });
        }

        LOGGER.debug("-buildBinaryTree(), tree:{}", tree);
        return tree;
    }

    /**
     * @param tree
     * @return
     */
    public static Integer[] treeToPreOrderArray(AbstractTree<Integer> tree) {
        return TreeUtils.preOrder(tree.root).toArray(new Integer[0]);
    }

    /**
     * Asserts the array is same.
     *
     * @param actual
     * @param expected
     */
    public static void assertArraysEquals(Integer[] actual, Integer[] expected) {
        assertNotNull(actual);
        assertNotNull(expected);
        assertEquals(expected.length, actual.length);
        for (Integer i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], String.format("Incorrect value at index {0}", i));
        }
    }

    /**
     * Asserts the tree is same
     *
     * @param actual
     * @param expected
     */
    public static void assertTreesEquals(BinaryTree<Integer> actual, BinaryTree<Integer> expected) {
        assertArraysEquals(treeToPreOrderArray(actual), treeToPreOrderArray(expected));
    }

    /**
     * Asserts the tree is pre-order.
     *
     * @param tree
     * @param expected
     */
    public static void assertTreePreOrder(AbstractTree<Integer> tree, Integer[] expected) {
        assertEquals(tree.getSize(), expected.length, "Tree count is incorrect");
        Integer[] actual = treeToPreOrderArray(tree);
        assertArraysEquals(actual, expected);
    }

    /**
     * Tests <code>buildTree()</code> method.
     */
    public void testBuildTree() {

    }

    /**
     * Tests <code>addNode()</code> method.
     */
    public void testAddNode() {

    }


}
