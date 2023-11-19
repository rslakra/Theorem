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
     * Left Node Index
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
     * Left Node Index
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
     * Left Node Index
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
     * Left Node Index
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
        TreeNode treeNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3));
        inputs.add(new Object[]{treeNode, false});
        inputs.add(new Object[]{treeNode.getLeft(), true});
        inputs.add(new Object[]{treeNode.getRight(), true});

        return inputs.iterator();
    }

    /**
     * Left Node Index
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
     * Left Node Index
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
     * Left Node Index
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
     * Left Node Index
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
     * Left Node Index
     */
    @Test(dataProvider = "memoryAllotmentByInputSizeData")
    public void testGetMemoryAllotmentByInputSize(int index, int result) {
        int memoryAllotmentByInputSize = TreeUtils.getMemoryAllotmentByInputSize(index);
        LOGGER.debug("memoryAllotmentByInputSize:{}", memoryAllotmentByInputSize);
        assertEquals(result, memoryAllotmentByInputSize);
    }

    /**
     * Print Binary Tree
     */
    @Test
    public void testBuildBinaryTreeWithList() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
    }

    /**
     * Print Binary Tree
     */
    @Test
    public void testBuildBinaryTreeWithString() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree("1, 2, 3, 4, 5, 6, 7");
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
    }

    /**
     * Print Binary Tree
     */
    @Test
    public void testPrintBinaryTree() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        TreeUtils.printBinaryTree(root);
    }

    /**
     * Print Pretty Tree
     */
    @Test
    public void testPrintPrettyTreeVertically() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        TreeUtils.printPrettyTreeVertically(root);
    }

    /**
     *
     */
    @Test
    public void testPrintPrettyTree() {
        final Node<Integer> root = new Node<Integer>(1);
        root.addLeftNode(2);
        root.addRightNode(3);
        int maxHeight = TreeUtils.maxHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(2, maxHeight);

        StringBuilder printPrettyTree = TreeUtils.printPrettyTree(root, 0, maxHeight);
        LOGGER.debug("\n{}", printPrettyTree);

        // add new node
        root.getLeft().addLeftNode(4);
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
        root.addLeftNode(2);
        root.addRightNode(3);

        int maxHeight = TreeUtils.maxHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(2, maxHeight);

//        LOGGER.debug("\n{}", TreeUtils.printPrettyTree(root));
        StringBuilder printPrettyTree = TreeUtils.printPrettyTreeHorizontally(root);
        LOGGER.debug("\n{}", printPrettyTree);

        // add new node
        root.getLeft().addLeftNode(4);
        maxHeight = TreeUtils.maxHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        printPrettyTree = TreeUtils.printPrettyTreeHorizontally(root);
        LOGGER.debug("\n{}", printPrettyTree);
    }

    @Test
    public void testCountSpaces() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        int maxHeight = TreeUtils.maxHeight(root);
        LOGGER.debug("maxHeight:{}", maxHeight);
        assertEquals(3, maxHeight);

        int maxLevel = TreeUtils.countSpaces(maxHeight);
        LOGGER.debug("maxLevel:{}", maxLevel);
        assertEquals(5, maxLevel);
    }

    /**
     *
     */
    @Test
    public void testGetMaxLevel() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        int maxLevel = TreeUtils.getHeight(root);
        assertEquals(3, maxLevel);
    }

    /**
     *
     */
    @Test
    public void testGetLevelOrders() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LOGGER.debug("root:{}", root);
        assertNotNull(root);
        List<List<Integer>> levelOrders = TreeUtils.getLevelOrders(root);
        LOGGER.debug("levelOrders:{}", levelOrders);
        assertNotNull(levelOrders);
        assertEquals(3, levelOrders.size());
        assertEquals(1, levelOrders.get(0).size());
        assertEquals(2, levelOrders.get(1).size());
        assertEquals(4, levelOrders.get(2).size());
    }

    /**
     *
     */
    @Test
    public void testInOrder() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        TreeUtils.printPrettyTreeVertically(root);
        List<Integer> inOrder = TreeUtils.inOrder(root);
        assertNotNull(inOrder);
        LOGGER.debug("inOrder:{}", inOrder);
        assertEquals("[4, 2, 5, 1, 6, 3, 7]", inOrder.toString());
    }

    /**
     *
     */
    @Test
    public void testPreOrder() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        TreeUtils.printPrettyTreeVertically(root);
        List<Integer> preOrder = TreeUtils.preOrder(root);
        assertNotNull(preOrder);
        LOGGER.debug("preOrder:{}", preOrder);
        assertEquals("[1, 2, 4, 5, 3, 6, 7]", preOrder.toString());
    }

    /**
     *
     */
    @Test
    public void testPostOrder() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        TreeUtils.printPrettyTreeVertically(root);
        List<Integer> postOrder = TreeUtils.postOrder(root);
        assertNotNull(postOrder);
        LOGGER.debug("postOrder:{}", postOrder);
        assertEquals("[4, 5, 2, 6, 7, 3, 1]", postOrder.toString());
    }

    /**
     *
     */
    @Test
    public void testInOrderTraversal() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        String inOrderTraversal = TreeUtils.inOrderTraversal(root);
        assertNotNull(inOrderTraversal);
        LOGGER.debug("inOrderTraversal:{}", inOrderTraversal);
        assertEquals("[4, 2, 5, 1, 6, 3, 7]", inOrderTraversal.toString());
    }

    @Test
    public void testPreOrderTraversal() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        String preOrderTraversal = TreeUtils.preOrderTraversal(root);
        assertNotNull(preOrderTraversal);
        LOGGER.debug("preOrderTraversal:{}", preOrderTraversal);
        assertEquals("[1, 2, 4, 5, 3, 6, 7]", preOrderTraversal.toString());
    }

    @Test
    public void testPostOrderTraversal() {
        TreeNode<Integer> root = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNotNull(root);
        LOGGER.debug("root:{}", root);
        String postOrderTraversal = TreeUtils.postOrderTraversal(root);
        assertNotNull(postOrderTraversal);
        LOGGER.debug("postOrderTraversal:{}", postOrderTraversal);
        assertEquals("[4, 5, 2, 6, 7, 3, 1]", postOrderTraversal.toString());
    }

}
