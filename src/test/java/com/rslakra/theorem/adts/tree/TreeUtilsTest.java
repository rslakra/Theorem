package com.rslakra.theorem.adts.tree;

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
 * The <code>TreeUtils</code> tests.
 *
 * @author Rohtash Lakra
 * @created 9/28/23 5:56 PM
 */
public class TreeUtilsTest {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(TreeUtilsTest.class);

    /**
     * Tests the <code>printWhiteSpaces()</code> method.
     */
    @Test
    public void testPrintWhiteSpaces() {
        TreeUtils.printWhiteSpaces(16);
    }

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
     * Tests the <code>parentIndex()</code> method.
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
     * Tests the <code>leftNodeIndex()</code> method.
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
     * Tests the <code>rightNodeIndex()</code> method.
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
     * Tests the <code>leftSiblingIndex()</code> method.
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
     * Tests the <code>rightSiblingIndex()</code> method.
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
     * Tests the <code>getMidIndex()</code> method.
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
     * Tests the <code>getHeightByInputSize()</code> method.
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
     * Tests the <code>getMemoryAllotmentByTreeHeight()</code> method.
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
     * Tests the <code>getMemoryAllotmentByInputSize()</code> method.
     */
    @Test(dataProvider = "memoryAllotmentByInputSizeData")
    public void testGetMemoryAllotmentByInputSize(int index, int result) {
        int memoryAllotmentByInputSize = TreeUtils.getMemoryAllotmentByInputSize(index);
        LOGGER.debug("memoryAllotmentByInputSize:{}", memoryAllotmentByInputSize);
        assertEquals(result, memoryAllotmentByInputSize);
    }

    /**
     * In-Order input data and expected node counts results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> buildTreeData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2), 2});
        inputs.add(new Object[]{Arrays.asList(1, null, 3), 2});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 3});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 5});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, null, 6), 6});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, null, 6, null, null, 7, 8), 8});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 11});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 15});

        return inputs.iterator();
    }

    /**
     * Tests the <code>buildTree()</code> method.
     */
    @Test(dataProvider = "buildTreeData")
    public void testBuildTree(List<Integer> inputData, Integer expected) {
        Node<Integer> rootNode = TreeUtils.buildTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printBinaryTree(rootNode);

        int nodeCount = TreeUtils.countNodes(rootNode);
        LOGGER.debug("nodeCount:{}", nodeCount);
        assertEquals(expected, nodeCount);
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
     * Tests <code>buildBinaryTree()</code> method.
     */
    @Test(dataProvider = "buildBinaryTreeData")
    public void testBuildBinaryTreeWithList(List<Integer> inputData) {
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
    }

    /**
     * Tests <code>buildBinaryTree()</code> method.
     */
    @Test
    public void testBuildBinaryTreeWithString() {
        Node<Integer> treeNode = TreeUtils.buildBinaryTree("1, 2, 3, 4, 5, 6, 7");
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> buildNaryTreeData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1)});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3)});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1)});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)});

        return inputs.iterator();
    }

    /**
     * Tests <code>buildNaryTree()</code> method.
     */
    @Test(dataProvider = "buildNaryTreeData")
    public void testBuildNaryTree(List<Integer> inputData) {
        Node<Integer> rootNode = TreeUtils.buildNaryTree(inputData);
        LOGGER.debug("rootNode:{}, Children:{}", rootNode, rootNode.getChildren().size());
        assertNotNull(rootNode);
        TreeUtils.printPrettyTree(rootNode, true);
    }

    /**
     * Tests the <code>printBinaryTree()</code> method.
     */
    @Test
    public void testPrintBinaryTree() {
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        TreeUtils.printBinaryTree(treeNode);
    }

    /**
     * Tests the <code>printPrettyTreeVertically()</code> method.
     */
    @Test
    public void testPrintPrettyTreeVertically() {
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        TreeUtils.printPrettyTreeVertically(treeNode);
    }

    /**
     * Tests the <code>printPrettyTree()</code> method.
     */
    @Test
    public void testPrintPrettyTree() {
        final Node<Integer> root = new Node<Integer>(1);
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));
        int maxHeight = TreeUtils.getHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(2, maxHeight);

        StringBuilder printPrettyTree = TreeUtils.printPrettyTree(root, 0, maxHeight);
        LOGGER.debug("\n{}", printPrettyTree);

        // add new node
        root.getLeft().setLeft(new Node<>(4));
        maxHeight = TreeUtils.getHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        TreeUtils.printPrettyTree(root);
        TreeUtils.printPrettyTree(root);
//        LOGGER.debug("\n{}", printPrettyTree);
    }

    /**
     * Tests the <code>printPrettyTree()</code> method.
     */
    @Test
    public void testPrettyTreeHorizontally() {
        final Node<Integer> root = new Node<Integer>(1);
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));
        int maxHeight = TreeUtils.getHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(2, maxHeight);

        StringBuilder printPrettyTree = TreeUtils.printPrettyTree(root, 0, maxHeight);
        LOGGER.debug("\n{}", printPrettyTree);

        // add new node
        root.getLeft().setLeft(new Node<>(4));
        maxHeight = TreeUtils.getHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        TreeUtils.printPrettyTree(root);
        TreeUtils.printPrettyTree(root);
//        LOGGER.debug("\n{}", printPrettyTree);
    }

    /**
     * Tests the <code>printPrettyTreeHorizontally()</code> method.
     */
    @Test
    public void testPrintPrettyTreeHorizontally() {
        final Node<Integer> root = new Node<Integer>(1);
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));

        int maxHeight = TreeUtils.getHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(2, maxHeight);

//        LOGGER.debug("\n{}", TreeUtils.printPrettyTree(root));
        StringBuilder printPrettyTree = TreeUtils.printPrettyTreeHorizontally(root);
        LOGGER.debug("\n{}", printPrettyTree);

        // add new node
        root.getLeft().setLeft(new Node<>(4));
        maxHeight = TreeUtils.getHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        printPrettyTree = TreeUtils.printPrettyTreeHorizontally(root);
        LOGGER.debug("\n{}", printPrettyTree);
    }

    /**
     * Test <code>countSpaces()</code> method.
     */
    @Test
    public void testCountSpaces() {
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        int maxHeight = TreeUtils.getHeight(treeNode);
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
    public Iterator<Object[]> countSlashesData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 0});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 1});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 2});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 2});

        return inputs.iterator();
    }

    /**
     * Test <code>countSlashes()</code> method.
     */
    @Test(dataProvider = "countSlashesData")
    public void testCountSlashes(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testCountSlashes({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        int countSlashes = TreeUtils.countSlashes(TreeUtils.getHeight(treeNode));
        LOGGER.debug("countSlashes:{}", countSlashes);
        assertEquals(expected, countSlashes);
    }

    /**
     * Data to test the max depth of the tree.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> maxDepthData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 2});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 3});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3});

        return inputs.iterator();
    }

    /**
     * Test <code>maxDepth()</code> method.
     */
    @Test(dataProvider = "maxDepthData")
    public void testMaxDepth(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testMaxDepth({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        int maxLevel = TreeUtils.maxDepth(treeNode);
        assertEquals(expected, maxLevel);
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getHeightData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 2});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 3});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3});

        return inputs.iterator();
    }

    /**
     * Test <code>getHeight()</code> method.
     */
    @Test(dataProvider = "getHeightData")
    public void testGetHeight(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testGetHeight({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        int maxHeight = TreeUtils.getHeight(treeNode);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(expected, maxHeight);
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> countNodesData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 3});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 5});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 7});

        return inputs.iterator();
    }

    /**
     * Test <code>countNodes()</code> method.
     */
    @Test(dataProvider = "countNodesData")
    public void testCountNodes(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testCountNodes({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        int nodeCount = TreeUtils.countNodes(treeNode);
        LOGGER.debug("nodeCount:{}", nodeCount);
        assertEquals(expected, nodeCount);
    }

    /**
     * Nary-Tree input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> maxAncestorDepthData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 1, 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 2, 2});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 3, 2});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6), 5, 3});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 9, 4});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), 11, 5});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 14, 6});
        return inputs.iterator();
    }

    /**
     * Test <code>maxAncestorDepth()</code> method.
     */
    @Test(dataProvider = "maxAncestorDepthData")
    public void testMaxAncestorDepth(List<Integer> inputData, Integer findWhat, int expected) {
        LOGGER.debug("testMaxAncestorDepth({}, {})", inputData);
        Node<Integer> rootNode = TreeUtils.buildNaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printPrettyTree(rootNode);
        Node<Integer> findNode = rootNode.findNode(findWhat);
        LOGGER.debug("findNode:{}", findNode);
        int maxAncestorDepth = TreeUtils.maxAncestorDepth(findNode);
        LOGGER.debug("maxAncestorDepth:{}", maxAncestorDepth);
        assertEquals(expected, maxAncestorDepth);
    }

    /**
     * Nary-Tree input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> maxEdgesData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 0});
        inputs.add(new Object[]{Arrays.asList(1, 2), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 2});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4), 3});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5), 4});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6), 5});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 6});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 7});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 8});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 9});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13), 12});
        return inputs.iterator();
    }

    /**
     * Test <code>maxEdges()</code> method.
     */
    @Test(dataProvider = "maxEdgesData")
    public void testMaxEdges(List<Integer> inputData, int expected) {
        LOGGER.debug("testMaxEdges({}, {})", inputData);
        Node<Integer> rootNode = TreeUtils.buildNaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printPrettyTree(rootNode);
        int maxEdges = TreeUtils.maxEdges(rootNode);
        LOGGER.debug("maxEdges:{}", maxEdges);
        assertEquals(expected, maxEdges);
    }

    /**
     * Nary-Tree input data and expected results.
     *
     * <pre>
     *  1
     *  |-- 2
     *  |   |-- 4
     *  |   |   |-- 7
     *  |   |   |   |-- 10
     *  |   |   |   |   |-- 13
     *  |   |   |   |   |-- 14
     *  |   |   |   |   |-- 15
     *  |   |   |   |-- 11
     *  |   |   |   |-- 12
     *  |   |   |-- 8
     *  |   |   |-- 9
     *  |   |-- 5
     *  |   |-- 6
     *  |-- 3
     * </pre>
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getHeightOfNaryTreeData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 6});
        return inputs.iterator();
    }

    /**
     * Test <code>getHeight()</code> method.
     * <pre>
     *  1
     *  |-- 2
     *  |   |-- 4
     *  |   |   |-- 7
     *  |   |   |   |-- 10
     *  |   |   |   |   |-- 13
     *  |   |   |   |   |-- 14
     *  |   |   |   |   |-- 15
     *  |   |   |   |-- 11
     *  |   |   |   |-- 12
     *  |   |   |-- 8
     *  |   |   |-- 9
     *  |   |-- 5
     *  |   |-- 6
     *  |-- 3
     * </pre>
     */
    @Test(dataProvider = "getHeightOfNaryTreeData")
    public void testGetHeightOfNaryTree(List<Integer> inputData, int expected) {
        LOGGER.debug("testNaryTreeMaxHeight({}, {})", inputData);
        Node<Integer> rootNode = TreeUtils.buildNaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printPrettyTree(rootNode);
        int maxHeight = TreeUtils.getHeight(rootNode);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(expected, maxHeight);
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> addSeparatorData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{1, TreeUtils.BACK_SLASH, 1});
        inputs.add(new Object[]{2, TreeUtils.COMMA, 2});
        inputs.add(new Object[]{3, TreeUtils.COMMA_SPACE, 6});
        inputs.add(new Object[]{4, TreeUtils.DASH, 4});
        inputs.add(new Object[]{5, TreeUtils.LEFT, 10});
        inputs.add(new Object[]{6, TreeUtils.NULL, 24});
        inputs.add(new Object[]{7, TreeUtils.RIGHT, 14});
        inputs.add(new Object[]{8, TreeUtils.SLASH, 8});
        inputs.add(new Object[]{9, TreeUtils.SPACE, 9});

        return inputs.iterator();
    }

    /**
     * Test <code>addSeparator()</code> method.
     */
    @Test(dataProvider = "addSeparatorData")
    public void testAddSeparator(Integer totalSpaces, String separator, Integer expected) {
        LOGGER.debug("testAddSeparator({}, {})", totalSpaces, separator);
        StringBuilder strBuilder = new StringBuilder();
        TreeUtils.addSeparator(totalSpaces, strBuilder, separator);
        LOGGER.debug("strBuilder:{}", strBuilder.length());
        assertEquals(expected, strBuilder.length());
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
     * Test <code>getLevelOrders()</code> method.
     */
    @Test(dataProvider = "levelOrdersData")
    public void testGetLevelOrders(List<Integer> inputData, List<List<Integer>> expected) {
        LOGGER.debug("testGetLevelOrders({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
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
     * Test <code>inOrder()</code> method.
     */
    @Test(dataProvider = "inOrderData")
    public void testInOrder(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testInOrder({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
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
     * Test <code>preOrder()</code> method.
     */
    @Test(dataProvider = "preOrderData")
    public void testPreOrder(List<Integer> inputData, List<Integer> expected) {
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
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
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        TreeUtils.printPrettyTreeVertically(treeNode);
        List<Integer> postOrder = TreeUtils.postOrder(treeNode);
        assertNotNull(postOrder);
        LOGGER.debug("postOrder:{}", postOrder);
        assertEquals(expected, postOrder);
    }

    /**
     * Test <code>inOrderTraversal()</code> method.
     */
    @Test(dataProvider = "inOrderData")
    public void testInOrderTraversal(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testInOrderTraversal({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        String inOrderTraversal = TreeUtils.inOrderTraversal(treeNode);
        assertNotNull(inOrderTraversal);
        LOGGER.debug("inOrderTraversal:{}", inOrderTraversal);
        assertEquals(expected.toString(), inOrderTraversal);
    }

    /**
     * Test <code>preOrderTraversal()</code> method.
     */
    @Test(dataProvider = "preOrderData")
    public void testPreOrderTraversal(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testPreOrderTraversal({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        String preOrderTraversal = TreeUtils.preOrderTraversal(treeNode);
        assertNotNull(preOrderTraversal);
        LOGGER.debug("preOrderTraversal:{}", preOrderTraversal);
        assertEquals(expected.toString(), preOrderTraversal);
    }

    /**
     * Test <code>postOrderTraversal()</code> method.
     */
    @Test(dataProvider = "postOrderData")
    public void testPostOrderTraversal(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testPostOrderTraversal({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        assertNotNull(treeNode);
        LOGGER.debug("treeNode:{}", treeNode);
        String postOrderTraversal = TreeUtils.postOrderTraversal(treeNode);
        assertNotNull(postOrderTraversal);
        LOGGER.debug("postOrderTraversal:{}", postOrderTraversal);
        assertEquals(expected.toString(), postOrderTraversal);
    }

    /**
     * Pre-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> treeViewTraversalData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(1, 2, 3, 4, 7)});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), Arrays.asList(5, 4, 3, 2)});

        return inputs.iterator();
    }

    /**
     * Test <code>treeViewTraversal()</code> method.
     */
    @Test(dataProvider = "treeViewTraversalData")
    public void testTreeViewTraversal(List<Integer> inputData, List<Integer> expected) {
        LOGGER.debug("testTreeViewTraversal({}, {})", inputData, expected);
        Node<Integer> rootNode = TreeUtils.buildBinaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printBinaryTree(rootNode);

        String treeViewTraversal = TreeUtils.treeViewTraversal(rootNode);
        LOGGER.debug("treeViewTraversal:{}", treeViewTraversal);
        assertNotNull(treeViewTraversal);
        assertEquals(expected.toString(), treeViewTraversal);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findLeftMostChildData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{Arrays.asList(1), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 2});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 2});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 4});
        inputs.add(new Object[]{Arrays.asList(6, 2, 3, 4, 5, 7), 4});

        return inputs.iterator();
    }

    /**
     * Test <code>findLeftMostChild()</code> method.
     */
    @Test(dataProvider = "findLeftMostChildData")
    public void testFindLeftMostChild(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testFindLeftMostChild({}, {})", inputData, expected);
        Node<Integer> rootNode = TreeUtils.buildBinaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printBinaryTree(rootNode);

        Node<Integer> leftMostChild = TreeUtils.findLeftMostChild(rootNode);
        LOGGER.debug("leftMostChild:{}", leftMostChild);
        assertEquals(expected, leftMostChild.getData());
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findRightMostChildData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{Arrays.asList(1), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 3});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 3});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 7});
        inputs.add(new Object[]{Arrays.asList(6, 2, 3, 4, 5, 7), 3});

        return inputs.iterator();
    }

    /**
     * Test <code>findRightMostChild()</code> method.
     */
    @Test(dataProvider = "findRightMostChildData")
    public void testFindRightMostChild(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testFindRightMostChild({}, {})", inputData, expected);
        Node<Integer> rootNode = TreeUtils.buildBinaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printBinaryTree(rootNode);

        Node<Integer> leftMostChild = TreeUtils.findRightMostChild(rootNode);
        LOGGER.debug("leftMostChild:{}", leftMostChild);
        assertEquals(expected, leftMostChild.getData());
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findInOrderSuccessorData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{Arrays.asList(1), null});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 3});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 3});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 6});
        inputs.add(new Object[]{Arrays.asList(6, 2, 3, 4, 5, 7), 7});

        return inputs.iterator();
    }

    /**
     * Test <code>findInOrderSuccessor()</code> method.
     */
    @Test(dataProvider = "findInOrderSuccessorData")
    public void testFindInOrderSuccessor(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testFindInOrderSuccessor({}, {})", inputData, expected);
        Node<Integer> rootNode = TreeUtils.buildBinaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printBinaryTree(rootNode);

        Node<Integer> leftMostChild = TreeUtils.findInOrderSuccessor(rootNode);
        LOGGER.debug("leftMostChild:{}", leftMostChild);
        if (expected == null) {
            assertEquals(expected, leftMostChild);
        } else {
            assertEquals(expected, leftMostChild.getData());
        }
    }

    /**
     * In-Order input data and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getSumData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{Arrays.asList(1), 1});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), 6});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), 15});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), 28});

        return inputs.iterator();
    }

    /**
     * Test <code>getSum()</code> method.
     */
    @Test(dataProvider = "getSumData")
    public void testGetSum(List<Integer> inputData, Integer expected) {
        LOGGER.debug("testGetSum({}, {})", inputData, expected);
        Node<Integer> treeNode = TreeUtils.buildBinaryTree(inputData);
        LOGGER.debug("treeNode:{}", treeNode);
        assertNotNull(treeNode);
        int nodeSum = TreeUtils.getSum(treeNode).intValue();
        LOGGER.debug("nodeSum:{}", nodeSum);
        assertEquals(expected, nodeSum);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> getDiameterData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{Arrays.asList(1), Long.valueOf(1)});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), Long.valueOf(3)});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), Long.valueOf(4)});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Long.valueOf(5)});

        return inputs.iterator();
    }

    /**
     * Test <code>getDiameter()</code> method.
     */
    @Test(dataProvider = "getDiameterData")
    public void testGetDiameter(List<Integer> inputData, Long expected) {
        LOGGER.debug("testGetDiameter({}, {})", inputData, expected);
        Node<Integer> rootNode = TreeUtils.buildBinaryTree(inputData);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        TreeUtils.printBinaryTree(rootNode);

        long nodeDiameter = TreeUtils.getDiameter(rootNode).getDiameter();
        LOGGER.debug("nodeDiameter:{}", nodeDiameter);
        assertEquals(expected, nodeDiameter);
    }

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> isSubtreeData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{Arrays.asList(1), Arrays.asList(1), true});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), Arrays.asList(1, 3), false});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), Arrays.asList(1, 2), false});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), true});
        inputs.add(new Object[]{Arrays.asList(5, 4, 2, 1), Arrays.asList(5, 4, 3, 1), false});
        inputs.add(new Object[]{Arrays.asList(5, 4, 3, 2, 1), Arrays.asList(5, 4, 3, 2, 1), true});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(1, 2, 3, 4, 5, 6, 7), true});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(1, 2, 3), false});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(3, 4, 5), false});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(2, 4, 5), true});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(5, 6, 7), false});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(1, 2, 6, 7), false});
        inputs.add(new Object[]{Arrays.asList(1, 2, 3, 4, 5, 6, 7), Arrays.asList(3, 6, 7), true});

        return inputs.iterator();
    }

    /**
     * Test <code>isSubtree()</code> method.
     */
    @Test(dataProvider = "isSubtreeData")
    public void testIsSubtree(List<Integer> bigTreeInputData, List<Integer> smallTreeInputData, boolean expected) {
        LOGGER.debug("testIsSubtree({}, {})", bigTreeInputData, smallTreeInputData, expected);
        Node<Integer> bigTree = TreeUtils.buildBinaryTree(bigTreeInputData);
        LOGGER.debug("bigTree:{}", bigTree);
        assertNotNull(bigTree);
        TreeUtils.printBinaryTree(bigTree);

        Node<Integer> smallTree = TreeUtils.buildBinaryTree(smallTreeInputData);
        LOGGER.debug("smallTree:{}", smallTree);
        assertNotNull(smallTree);
        TreeUtils.printBinaryTree(smallTree);

        boolean treeContains = TreeUtils.isSubtree(bigTree, smallTree);
        LOGGER.debug("expected:{}, treeContains:{}", expected, treeContains);
        assertEquals(expected, treeContains);
    }

}
