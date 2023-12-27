package com.devamatre.theorem.adts.tree;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.data.loader.TreeHierarchicalDataLoader;
import com.devamatre.theorem.adts.tree.data.loader.TreeHierarchicalType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> AbstractTree<E> fillHierarchicalTree(AbstractTree<E> tree) {
        LOGGER.debug("fillHierarchicalTree({})", tree);
        return tree;
    }

    /**
     * @param tree
     * @return
     */
    public AbstractTree<String> fillContinents(AbstractTree<String> tree) {
        LOGGER.debug("+fillContinents({})", tree);
        TreeHierarchicalDataLoader dataLoader = TreeHierarchicalDataLoader.createDataLoader(TreeHierarchicalType.CONTINENT);
        dataLoader.fillHierarchicalData(tree);
        tree.printPrettyTree(false);
        LOGGER.debug("-fillContinents(), tree:{}", tree);
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

    /**
     * Tests <code>addNode()</code> method.
     */
    public void testRemoveNode() {

    }


}
