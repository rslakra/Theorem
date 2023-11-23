package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 5/13/22 6:47 PM
 */
public class BinaryTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryTreeTest.class);

    /**
     * Builds the binary tree from the provided <code>inputData</code>.
     *
     * @param inputData
     * @return
     */
    public static <E extends Comparable<E>> BinaryTree<E> buildBinaryTree(List<E> inputData) {
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
    private Integer[] treeToPreOrderArray(BinaryTree<Integer> tree) {
        return TreeUtils.preOrder(tree.getRoot()).toArray(new Integer[0]);
    }

    /**
     * Asserts the tree is same
     *
     * @param actual
     * @param expected
     */
    private void assertTreesEquals(BinaryTree<Integer> actual, BinaryTree<Integer> expected) {
        assertArraysEquals(treeToPreOrderArray(actual), treeToPreOrderArray(expected));
    }

    /**
     * Asserts the array is same.
     *
     * @param actual
     * @param expected
     */
    private void assertArraysEquals(Integer[] actual, Integer[] expected) {
        assertNotNull(actual);
        assertNotNull(expected);
        assertEquals(expected.length, actual.length);
        for (Integer i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], String.format("Incorrect value at index {0}", i));
        }
    }

    /**
     * Asserts the tree is pre-order.
     *
     * @param tree
     * @param expected
     */
    private void assertTreePreOrder(BinaryTree<Integer> tree, Integer[] expected) {
        assertEquals(tree.getSize(), expected.length, "Tree count is incorrect");
        Integer[] actual = treeToPreOrderArray(tree);
        assertArraysEquals(actual, expected);
    }

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
     * Build binary tree with strings.
     */
    @Test
    public void testBinaryTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        fillTreeWithPresidents(tree);
        assertNotNull(tree);
        assertEquals(9, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        assertTrue(tree.contain("Jackson"));
    }

    /**
     * Tests the addLeftChild method.
     */
    @Test
    public void testAddLeftChild() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.addLeftNode("A");
        tree.addLeftNode("B");
        assertNotNull(tree);
        assertEquals(2, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
    }

    /**
     * Tests the addRightChild method.
     */
    @Test
    public void testAddRightChild() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.addRightNode("C");
        assertNotNull(tree);
        assertEquals(1, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
    }


    /**
     * Tests the addLeftChild and addRightChild methods.
     */
    @Test
    public void testAddChildren() {
        BinaryTree<String> tree = new BinaryTree<>();
        assertNotNull(tree);
        tree.addLeftNode("A");
        tree.addLeftNode("B");
        tree.addRightNode("C");
        assertEquals(3, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);

        tree.addLeftNode("D");
        tree.addLeftNode("E");
        tree.addRightNode("F");

        assertEquals(6, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
    }

    /**
     * Test add node.
     * <pre>
     *         3
     *     /     \
     *    1       4
     *     \
     *      2
     * </pre>
     */
    @Test
    public void testAddNode() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertNotNull(tree);
        LOGGER.debug("tree:{}", tree);

        tree.addNode(1);
        assertEquals(1, tree.getSize());

        assertTreePreOrder(tree, new Integer[]{1});
    }

    /**
     * Test add node.
     * <pre>
     *         3
     *     /     \
     *    1       4
     *     \
     *      2
     * </pre>
     */
    @Test
    public void testBuildBinaryTree() {
        Integer[] inputData = new Integer[]{3, 1, 2, 4};
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(inputData));
        assertNotNull(tree);
        assertEquals(inputData.length, tree.getSize());
        LOGGER.debug("tree:{}", tree);

        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
    }

    /**
     * Remove leaf node.
     * <pre>
     *         3
     *     /     \
     *    1       4
     *     \
     *      2
     * </pre>
     */
    @Test
    public void testRemoveLeaf() {
        Integer[] inputData = new Integer[]{3, 1, 2, 4};
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(inputData));
        assertNotNull(tree);
        assertEquals(inputData.length, tree.getSize());
        LOGGER.debug("tree:{}", tree);

        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());

        // remove node
        tree.removeNodeWithoutParentHandling(2);
        expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());

        tree.removeNodeWithoutParentHandling(4);
        expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());

        tree.removeNodeWithoutParentHandling(1);
        expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
    }

    /**
     * Tests to remove the right child.
     * <pre>
     *         3
     *     /     \
     *    1       4
     *     \
     *      2
     * </pre>
     */
    @Test
    public void testRemoveRightChild() {
        Integer[] inputData = new Integer[]{3, 1, 2, 4};
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(inputData));
        assertNotNull(tree);
        assertEquals(inputData.length, tree.getSize());
        LOGGER.debug("tree:{}", tree);

        tree.removeNodeWithoutParentHandling(1);
        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
    }

    /**
     * Tests to remove left child.
     * <pre>
     *         3
     *     /     \
     *    1       4
     *     \
     *      2
     * </pre>
     */
    @Test
    public void testRemoveLeftChild() {
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(3, 1, 2, 4));
        assertNotNull(tree);
        assertEquals(4, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        TreeUtils.printBinaryTree(tree.getRoot());

        tree.removeNodeWithoutParentHandling(2);
        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
    }

    /**
     * Tests to remove node with 2 children.
     */
    @Test
    public void testRemoveNodeWithTwoChildren() {
        /**
         * <pre>
         *            10
         *          /   \
         *        /      \
         *       7        16
         *     /  \
         *    5    9
         *   / \
         *  3   6
         * </pre>
         */
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(10, 7, 5, 9, 6, 3, 16));
        assertNotNull(tree);
        assertEquals(7, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        TreeUtils.printBinaryTree(tree.getRoot());

//        tree.remove(5);
        tree.removeNodeWithParentHandling(5);
        /**
         * After removing 5, the tree should be:
         * <pre>
         *            10
         *          /   \
         *        /      \
         *       7        16
         *     /  \
         *    6    9
         *   /
         *  3
         * </pre>
         */
        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
    }

    /**
     * Tests 2 remove 2 children of the root.
     */
    @Test
    public void testRemoveTwoChildrenOfRoot() {
        /**
         * <pre>
         *              10
         *            /   \
         *          /      \
         *        /         \
         *       5          20
         *     /  \         /
         *    4    6      15
         *   / \         /
         *  3   8      12
         *               \
         *                13
         *                  \
         *                  14
         * </pre>
         */
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(10, 5, 4, 6, 20, 15, 12, 13, 14));
        assertNotNull(tree);
        assertEquals(9, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        TreeUtils.printBinaryTree(tree.getRoot());

        tree.removeNodeWithoutParentHandling(10);
        /**
         * After removing 10, the tree should be:
         * <pre>
         *              12
         *            /   \
         *          /      \
         *        /         \
         *       5          20
         *     /  \         /
         *    4    6      15
         *   / \         /
         *  3   8      13
         *               \
         *                14
         * </pre>
         */
        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());

        tree.removeNodeWithoutParentHandling(12);
        /**
         * After removing 12, the tree should be:
         * <pre>
         *              13
         *            /   \
         *          /      \
         *        /         \
         *       5          20
         *     /  \         /
         *    4    6      15
         *   / \         /
         *  3   8      14
         * </pre>
         */
        expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
    }

    /**
     * Remove left child of the root of the tree.
     */
    @Test
    public void testRemoveOnlyLeftChildOfRootNode() {
        /**
         * <pre>
         *          3
         *        /
         *       2
         *     /
         *   1
         * </pre>
         */
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(3, 2, 1));
        assertNotNull(tree);
        assertEquals(3, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        TreeUtils.printBinaryTree(tree.getRoot());

//        tree.remove(3);
        tree.removeNodeWithParentHandling(3);
        /**
         * After removing node 3, the tree should look like:
         * <pre>
         *       2
         *     /
         *   1
         * </pre>
         */
        List<Integer> preOrder = TreeUtils.preOrder(tree.getRoot());
        LOGGER.debug("preOrder:{}", preOrder);
        Integer[] expected = BeanUtils.toType(preOrder, Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
    }

    /**
     * Remove the right child of the root of the tree.
     */
    @Test
    public void testRemoveOnlyRightChildOfRootNode() {
        /**
         * <pre>
         *    3
         *     \
         *      4
         *       \
         *        5
         * </pre>
         */
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(3, 4, 5));
        assertNotNull(tree);
        assertEquals(3, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        TreeUtils.printBinaryTree(tree.getRoot());

//        tree.remove(3);
        tree.removeNodeWithParentHandling(3);
        /**
         * After removing node 3, the tree should look like:
         * <pre>
         *    4
         *     \
         *      5
         * </pre>
         */
        List<Integer> preOrder = TreeUtils.preOrder(tree.getRoot());
        LOGGER.debug("preOrder:{}", preOrder);
        Integer[] expected = BeanUtils.toType(preOrder, Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
    }

    /**
     * Remove only the root node.
     */
    @Test
    public void testRemoveRootOnly() {
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(3));
        assertNotNull(tree);
        assertEquals(1, tree.getSize());

        tree.removeNodeWithoutParentHandling(3);
        assertTreePreOrder(tree, new Integer[]{});
        assertEquals(0, tree.getSize());
    }

    /**
     * Tests the preOrderTree copy.
     */
    @Test
    public void testPreOrderCopyTree() {
        /**
         * <pre>
         *              10
         *            /   \
         *          /      \
         *        /         \
         *       5          20
         *     /  \         /
         *    4    6      15
         *   / \         /
         *  3   8      12
         *               \
         *                13
         *                  \
         *                   14
         * </pre>
         */
        BinaryTree<Integer> tree = buildBinaryTree(Arrays.asList(10, 5, 4, 6, 20, 15, 12, 13, 14));
        assertNotNull(tree);
        assertEquals(9, tree.getSize());

        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
        LOGGER.debug("expected:{}", Arrays.toString(expected));
        assertTreePreOrder(tree, expected);
        assertEquals(expected.length, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
    }

}
