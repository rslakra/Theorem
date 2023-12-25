package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/24/23 1:43 PM
 */
public abstract class AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTreeTest.class);

    /**
     * Builds the <code>BinarySearchTree</code>.
     *
     * @param inputData
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> void fillTree(final AbstractTree<E> tree, List<E> inputData) {
        LOGGER.debug("+fillTree({}, {})", tree, inputData);
        if (BeanUtils.isNotEmpty(inputData)) {
            inputData.forEach(data -> {
                LOGGER.debug("data:{}", data);
                tree.addNode(data);
            });
        }

        LOGGER.debug("-fillTree(), tree:{}", tree);
    }

    /**
     * Fills the tree with american the names of American presidents.
     *
     * @param tree
     */
    public static void fillTreeWithPresidents(AbstractTree<String> tree) {
        fillTree(tree, Arrays.asList("Lincoin", "Jefferson", "Jackson", "Adams", "Kennedy", "Washington", "Madison",
                                     "Roosevelt", "Buchanan"));
    }

    /**
     * Fills the tree with the animal species.
     *
     * @param tree
     */
    public static void fillTreeWithSpecies(AbstractTree<String> tree) {
        fillTree(tree, Arrays.asList("Anamilia", "Chordate", "Mammal", "Arthropoda", "Insect", "Primate", "Carnivora",
                                     "Diptera", "Hominidac", "Pongidae", "Felidae", "Muscidae", "Homo", "Pan", "Felis",
                                     "Musca", "Sapiens", "Troglodytes", "Domestica", "Leo", "Domestica", "Human",
                                     "Chimpanzee", "House Cat", "Lion", "Housefly"));

    }

    /**
     * Builds the tree with the provided <code>inputData</code>
     *
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> AbstractTree<E> buildTree(List<E> inputData) {
        LOGGER.debug("buildTree({})", inputData);
        return null;
    }

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     * @param <E>
     */
    public <E extends Comparable<? super E>> AbstractTree<E> fillHierarchicalTree(AbstractTree<E> tree) {
        LOGGER.debug("+fillHierarchicalTree({})", tree);

        LOGGER.debug("-fillHierarchicalTree({})", tree);
        return tree;
    }

    /**
     * @param tree
     * @return
     */
    public static Integer[] treeToPreOrderArray(AbstractTree<Integer> tree) {
        if (tree instanceof Tree) {
            return TreeUtils.preOrderChildren(tree.getRoot(), false).toArray(new Integer[0]);
        }

        return TreeUtils.preOrder(tree.getRoot()).toArray(new Integer[0]);
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
    public static void assertPreOrderTree(AbstractTree<Integer> tree, Integer[] expected) {
        assertEquals(tree.getSize(), expected.length, "Invalid tree size!");
        Integer[] actual = treeToPreOrderArray(tree);
        assertEquals(actual.length, expected.length, "Invalid tree size!");
        assertArraysEquals(actual, expected);
    }

    /**
     * Asserts the iterator node exists in <code>treeTraversal</code> list.
     *
     * @param itr
     * @param treeTraversal
     */
    public static void assertIteratorWithTraversal(Iterator<Integer> itr, List<Integer> treeTraversal) {
        while (itr.hasNext()) {
            Integer nextData = itr.next();
            LOGGER.debug("nextData:{}", nextData);
            assertTrue(treeTraversal.contains(nextData));
        }
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
