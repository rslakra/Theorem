package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 9/28/23 5:56 PM
 */
public class TreeUtilsTest {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(TreeUtilsTest.class);

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> parentIndexData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{1, 0});
        inputs.add(new Object[]{2, 0});
        inputs.add(new Object[]{3, 1});
        inputs.add(new Object[]{4, 1});
        inputs.add(new Object[]{5, 2});
        inputs.add(new Object[]{6, 2});
        inputs.add(new Object[]{7, 3});
        inputs.add(new Object[]{8, 3});
        inputs.add(new Object[]{9, 4});
        inputs.add(new Object[]{10, 4});

        return inputs.iterator();
    }

    /**
     * Parent Index
     */
    @Test(dataProvider = "parentIndexData")
    public void testParentIndex(int index, int result) {
        int parentIndex = TreeUtils.parentIndex(index);
        LOGGER.debug("parentIndex:{}", parentIndex);
        assertEquals(result, parentIndex);
    }

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> leftNodeIndexData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 1});
        inputs.add(new Object[]{1, 3});
        inputs.add(new Object[]{2, 5});
        inputs.add(new Object[]{3, 7});
        inputs.add(new Object[]{4, 9});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "leftNodeIndexData")
    public void testLeftNodeIndex(int index, int result) {
        int leftNodeIndex = TreeUtils.leftNodeIndex(index);
        LOGGER.debug("leftNodeIndex:{}", leftNodeIndex);
        assertEquals(result, leftNodeIndex);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> rightNodeIndexData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 2});
        inputs.add(new Object[]{1, 4});
        inputs.add(new Object[]{2, 6});
        inputs.add(new Object[]{3, 8});
        inputs.add(new Object[]{4, 10});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "rightNodeIndexData")
    public void testRightNodeIndex(int index, int result) {
        int rightNodeIndex = TreeUtils.rightNodeIndex(index);
        LOGGER.debug("rightNodeIndex:{}", rightNodeIndex);
        assertEquals(result, rightNodeIndex);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> leftSiblingIndexData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, -1});
        inputs.add(new Object[]{1, 0});
        inputs.add(new Object[]{2, 1});
        inputs.add(new Object[]{3, 2});
        inputs.add(new Object[]{4, 3});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "leftSiblingIndexData")
    public void testLeftSiblingIndex(int index, int result) {
        int leftSiblingIndex = TreeUtils.leftSiblingIndex(index);
        LOGGER.debug("leftSiblingIndex:{}", leftSiblingIndex);
        assertEquals(result, leftSiblingIndex);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> rightSiblingIndexData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, -1});
        inputs.add(new Object[]{1, 2});
        inputs.add(new Object[]{2, 3});
        inputs.add(new Object[]{3, 4});
        inputs.add(new Object[]{4, 5});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "rightSiblingIndexData")
    public void testRightSiblingIndex(int index, int result) {
        int rightSiblingIndex = TreeUtils.rightSiblingIndex(index);
        LOGGER.debug("rightSiblingIndex:{}", rightSiblingIndex);
        assertEquals(result, rightSiblingIndex);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> isLeafData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{null, false});
        inputs.add(new Object[]{new TreeNode<>(0), true});
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3));
        inputs.add(new Object[]{treeNode, false});
        inputs.add(new Object[]{treeNode.getLeft(), true});
        inputs.add(new Object[]{treeNode.getRight(), true});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "isLeafData")
    public void testIsLeaf(TreeNode index, boolean result) {
        boolean isLeaf = TreeUtils.isLeaf(index);
        LOGGER.debug("isLeaf:{}", isLeaf);
        assertEquals(result, isLeaf);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getMidIndexData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 10, 5});
        inputs.add(new Object[]{1, 9, 5});
        inputs.add(new Object[]{2, 8, 5});
        inputs.add(new Object[]{4, 7, 5});
        inputs.add(new Object[]{5, 6, 5});
        inputs.add(new Object[]{6, 6, 6});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "getMidIndexData")
    public void testGetMidIndex(int start, int end, int result) {
        int getMidIndex = TreeUtils.getMidIndex(start, end);
        LOGGER.debug("getMidIndex:{}", getMidIndex);
        assertEquals(result, getMidIndex);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> heightByInputSizeData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 0});
        inputs.add(new Object[]{1, 0});
        inputs.add(new Object[]{2, 1});
        inputs.add(new Object[]{3, 1});
        inputs.add(new Object[]{4, 2});
        inputs.add(new Object[]{7, 2});
        inputs.add(new Object[]{8, 3});
        inputs.add(new Object[]{10, 3});
        inputs.add(new Object[]{15, 3});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "heightByInputSizeData")
    public void testGetHeightByInputSize(int size, int result) {
        int heightByInputSize = TreeUtils.getHeightByInputSize(size);
        LOGGER.debug("heightByInputSize:{}", heightByInputSize);
        assertEquals(result, heightByInputSize);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> memoryAllotmentByTreeHeightData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 1});
        inputs.add(new Object[]{1, 3});
        inputs.add(new Object[]{2, 7});
        inputs.add(new Object[]{3, 15});
        inputs.add(new Object[]{4, 31});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "memoryAllotmentByTreeHeightData")
    public void testGetMemoryAllotmentByTreeHeight(int index, int result) {
        int memoryAllotmentByTreeHeight = TreeUtils.getMemoryAllotmentByTreeHeight(index);
        LOGGER.debug("memoryAllotmentByTreeHeight:{}", memoryAllotmentByTreeHeight);
        assertEquals(result, memoryAllotmentByTreeHeight);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> memoryAllotmentByInputSizeData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 1});
        inputs.add(new Object[]{1, 1});
        inputs.add(new Object[]{2, 3});
        inputs.add(new Object[]{3, 3});
        inputs.add(new Object[]{4, 7});

        return inputs.iterator();
    }

    /**
     * Left PairNode Index
     */
    @Test(dataProvider = "memoryAllotmentByInputSizeData")
    public void testGetMemoryAllotmentByInputSize(int index, int result) {
        int memoryAllotmentByInputSize = TreeUtils.getMemoryAllotmentByInputSize(index);
        LOGGER.debug("memoryAllotmentByInputSize:{}", memoryAllotmentByInputSize);
        assertEquals(result, memoryAllotmentByInputSize);
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> buildBinaryTreeData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1)});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3)});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1)});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7)});

        return inputs.iterator();
    }

    /**
     * Tests <code>buildBinaryTree</code> method.
     */
    @Test(dataProvider = "buildBinaryTreeData")
    public void testBuildBinaryTreeWithList(List<Integer> inputData) {
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
    }

    /**
     * Tests <code>buildBinaryTree</code> method.
     */
    @Test
    public void testBuildBinaryTreeWithString() {
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree("1, 2, 3, 4, 5, 6, 7");
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
    }

    /**
     * Print Binary Tree
     */
    @Test
    public void testPrintBinaryTree() {
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        TreeUtils.printBinaryTree(treeNode);
    }

    /**
     * Print Pretty Tree
     */
    @Test
    public void testPrintPrettyTreeVertically() {
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        TreeUtils.printPrettyTreeVertically(treeNode);
    }

    /**
     *
     */
    @Test
    public void testPrintPrettyTree() {
        final Node<Integer> root = new Node<Integer>(1);
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));
        int maxHeight = TreeUtils.maxHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(2, maxHeight);

        StringBuilder printPrettyTree = TreeUtils.printPrettyTree(root, 0, maxHeight);
        LOGGER.debug("\n{}", printPrettyTree);

        // add new node
        root.getLeft().setLeft(new Node<>(4));
        maxHeight = TreeUtils.maxHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        printPrettyTree = TreeUtils.printPrettyTree(root);
        LOGGER.debug("\n{}", printPrettyTree);
    }

    /**
     *
     */
    @Test
    public void testPrintPrettyTreeHorizontally() {
        final Node<Integer> root = new Node<Integer>(1);
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));

        int maxHeight = TreeUtils.maxHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(2, maxHeight);

//        LOGGER.debug("\n{}", TreeUtils.printPrettyTree(root));
        StringBuilder printPrettyTree = TreeUtils.printPrettyTreeHorizontally(root);
        LOGGER.debug("\n{}", printPrettyTree);

        // add new node
        root.getLeft().setLeft(new Node<>(4));
        maxHeight = TreeUtils.maxHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        printPrettyTree = TreeUtils.printPrettyTreeHorizontally(root);
        LOGGER.debug("\n{}", printPrettyTree);
    }

    @Test
    public void testCountSpaces() {
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        int maxHeight = TreeUtils.maxHeight(treeNode);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        int maxLevel = TreeUtils.countSpaces(maxHeight);
        LOGGER.debug("maxLevel:{}", maxLevel);
        assertEquals(5, maxLevel);
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getMaxLevelData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 2});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 3});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3});

        return inputs.iterator();
    }

    /**
     * Test <code>inOrder</code> method.
     */
    @Test(dataProvider = "getMaxLevelData")
    public void testGetMaxLevel(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testGetMaxLevel({}, {})", inputData, expected);
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        int maxLevel = TreeUtils.getHeight(treeNode);
        assertEquals(expected, maxLevel);
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> levelOrdersData() {
        List<Object[]> inputs = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        // [[1], [2, 3], [4, 5, 6, 7]]
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(4, 5, 6, 7));
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), expected});

        // [[5], [4, 3], [2, 1]]
        expected = new ArrayList<>();
        expected.add(Arrays.asList(5));
        expected.add(Arrays.asList(4, 3));
        expected.add(Arrays.asList(2, 1));
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), expected});

        return inputs.iterator();
    }

    /**
     * Test <code>inOrder</code> method.
     */
    @Test(dataProvider = "levelOrdersData")
    public void testGetLevelOrders(List<Integer> inputData, List<List<Integer>> expected) {
        LOGGER.debug("testGetLevelOrders({}, {})", inputData, expected);
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        List<List<Integer>> levelOrders = TreeUtils.getLevelOrders(treeNode);
        LOGGER.debug("levelOrders:{}", levelOrders);
        assertNotNull(levelOrders);
        assertEquals(expected.size(), levelOrders.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).size(), levelOrders.get(i).size());
            assertEquals(expected.get(i), levelOrders.get(i));
        }
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inOrderData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(4, 2, 5, 1, 6, 3, 7)});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), Arrays.asList(2, 4, 1, 5, 3)});

        return inputs.iterator();
    }

    /**
     * Test <code>inOrder</code> method.
     */
    @Test(dataProvider = "inOrderData")
    public void testInOrder(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testInOrder({}, {})", inputData, expected);
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        TreeUtils.printPrettyTreeVertically(treeNode);
        List<Integer> inOrder = TreeUtils.inOrder(treeNode);
        assertNotNull(inOrder);
        LOGGER.debug("inOrder:{}", inOrder);
        assertEquals(expected, inOrder);
    }

    /**
     * Pre-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> preOrderData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(1, 2, 4, 5, 3, 6, 7)});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), Arrays.asList(5, 4, 2, 1, 3)});

        return inputs.iterator();
    }

    /**
     * Test <code>preOrder</code> method.
     */
    @Test(dataProvider = "preOrderData")
    public void testPreOrder(List<Integer> inputData, List<Integer> expected) {
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        TreeUtils.printPrettyTreeVertically(treeNode);
        List<Integer> preOrder = TreeUtils.preOrder(treeNode);
        assertNotNull(preOrder);
        LOGGER.debug("preOrder:{}", preOrder);
        assertEquals(expected, preOrder);
    }

    /**
     * Post-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> postOrderData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(4, 5, 2, 6, 7, 3, 1)});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), Arrays.asList(2, 1, 4, 3, 5)});

        return inputs.iterator();
    }

    /**
     * Test <code>postOrder</code> method.
     */
    @Test(dataProvider = "postOrderData")
    public void testPostOrder(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testPostOrder({}, {})", inputData, expected);
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        TreeUtils.printPrettyTreeVertically(treeNode);
        List<Integer> postOrder = TreeUtils.postOrder(treeNode);
        assertNotNull(postOrder);
        LOGGER.debug("postOrder:{}", postOrder);
        assertEquals(expected, postOrder);
    }

    /**
     * Test <code>inOrderTraversal</code> method.
     */
    @Test(dataProvider = "inOrderData")
    public void testInOrderTraversal(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testInOrderTraversal({}, {})", inputData, expected);
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        String inOrderTraversal = TreeUtils.inOrderTraversal(treeNode);
        assertNotNull(inOrderTraversal);
        LOGGER.debug("inOrderTraversal:{}", inOrderTraversal);
        assertEquals(expected.toString(), inOrderTraversal);
    }

    /**
     * Test <code>preOrderTraversal</code> method.
     */
    @Test(dataProvider = "preOrderData")
    public void testPreOrderTraversal(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testPreOrderTraversal({}, {})", inputData, expected);
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        String preOrderTraversal = TreeUtils.preOrderTraversal(treeNode);
        assertNotNull(preOrderTraversal);
        LOGGER.debug("preOrderTraversal:{}", preOrderTraversal);
        assertEquals(expected.toString(), preOrderTraversal);
    }

    /**
     * Test <code>preOrderTraversal</code> method.
     */
    @Test(dataProvider = "postOrderData")
    public void testPostOrderTraversal(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testPostOrderTraversal({}, {})", inputData, expected);
        TreeNode<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        String postOrderTraversal = TreeUtils.postOrderTraversal(treeNode);
        assertNotNull(postOrderTraversal);
        LOGGER.debug("postOrderTraversal:{}", postOrderTraversal);
        assertEquals(expected.toString(), postOrderTraversal);
    }

}
