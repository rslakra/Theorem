package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.data.loader.TreeHierarchicalDataLoader;
import com.devamatre.theorem.adts.tree.data.loader.TreeHierarchicalType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 11/24/23 1:43 PM
 */
public abstract class AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTreeTest.class);

    public static final Integer[] IN_ORDER_DATA = new Integer[]{4, 2, 5, 1, 3, 7, 6, 8};
    public static final Integer[] LEVEL_ORDER_DATA = new Integer[]{4, 2, 5, 1, 3, 7, 6, 8};
    public static final Integer[]
        LEVEL_ORDER_DATA_WITH_NEGATIVE =
        new Integer[]{4, 2, 5, 1, 3, -1, 7, -1, -1, -1, -1, 6, 8};
    public static final Integer[] PRE_ORDER_DATA = new Integer[]{1, 2, 4, 5, 3, 6, 7, 8};
    public static final Integer[]
        PRE_ORDER_DATA_WITH_NEGATIVE =
        new Integer[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 7, -1, -1, 8};
    public static final Integer[] POST_ORDER_DATA = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};

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
     * Builds the binary tree of the
     *
     * @param traversalMode
     * @param inputData
     * @return
     */
    public <E extends Comparable<? super E>> Node<E> buildBinaryTree(TraversalMode traversalMode, List<E> inputData) {
        TreeBuilder<E> treeBuilder = TreeFactory.treeBuilder(traversalMode);
        assertNotNull(treeBuilder);
        Node<E> rootNode = treeBuilder.buildBinaryTree(inputData);
        assertNotNull(rootNode);
//        assertEquals(inputData.size(), rootNode.getSize());
        TreeUtils.printBinaryTree(rootNode);
        return rootNode;
    }

    /**
     * Builds the tree with the provided <code>inputData</code>
     *
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> AbstractTree<E> buildTree(AbstractTree<E> tree, List<E> inputData) {
        LOGGER.debug("+buildTree({}, {})", tree, inputData);
        if (Objects.nonNull(tree)) {
            fillTree(tree, inputData);
            tree.printPrettyTree();
        }

        LOGGER.debug("-buildTree(), tree:{}", tree);
        return tree;
    }

    /**
     * Builds the tree with the provided <code>inputData</code>
     *
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> Tree<E> buildTree(List<E> inputData) {
        return (Tree) buildTree(new Tree<>(), inputData);
    }

    /**
     * Builds the tree with the provided <code>inputData</code>
     *
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> Tree<E> buildTree(E[] inputData) {
        return buildTree(Arrays.asList(inputData));
    }

    /**
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> BinaryTree<E> buildBinaryTree(List<E> inputData) {
        return (BinaryTree) buildTree(new BinaryTree<>(), inputData);
    }

    /**
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> BinaryTree<E> buildBinaryTree(E[] inputData) {
        return buildBinaryTree(Arrays.asList(inputData));
    }

    /**
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> BinarySearchTree<E> buildBinarySearchTree(List<E> inputData) {
        return (BinarySearchTree) buildTree(new BinarySearchTree<>(), inputData);
    }

    /**
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> BinarySearchTree<E> buildBinarySearchTree(E[] inputData) {
        return buildBinarySearchTree(Arrays.asList(inputData));
    }

    /**
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> Tree<E> buildHierarchicalTree(List<E> inputData) {
        return (Tree) buildTree(new Tree<>(), inputData);
    }

    /**
     * @param inputData
     * @param <E>
     * @return
     */
    public <E extends Comparable<? super E>> Tree<E> buildHierarchicalTree(E[] inputData) {
        return (Tree) buildTree(new Tree<>(), Arrays.asList(inputData));
    }

    /**
     * @param tree
     * @return
     */
    public AbstractTree<String> fillContinents(AbstractTree<String> tree) {
        LOGGER.debug("+fillContinents({})", tree);
        TreeHierarchicalDataLoader
            dataLoader =
            TreeHierarchicalDataLoader.createDataLoader(TreeHierarchicalType.CONTINENT);
        dataLoader.fillHierarchicalData(tree);
        tree.printPrettyTree();
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
    public static void assertTreesEqualsInPreOrder(AbstractTree<Integer> tree, Integer[] expected) {
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
     * Tests <code>findNode()</code> method.
     */
    public void testFindNode() {

    }

    /**
     * Tests <code>addNode()</code> method.
     */
    public void testRemoveNode() {

    }


}
