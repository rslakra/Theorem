package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.theorem.adts.tree.data.loader.TreeHierarchicalDataLoader;
import com.devamatre.theorem.adts.tree.data.loader.TreeHierarchicalType;
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
 * @created 11/24/23 1:43 PM
 */
public class TreeTest extends AbstractTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeTest.class);

    /**
     * Build Tree with strings.
     */
    @Test
    public void testBuildStringTree() {
        final Tree<String> tree = new Tree<>();
        fillContinents(tree);
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        assertNotNull(tree);
        assertEquals(15, tree.getSize());
        assertTrue(tree.contains("India"));
    }

    /**
     * Test build tree.
     */
    @Test
    @Override
    public void testBuildTree() {
        Tree<Integer> tree = new Tree<>();
        assertNotNull(tree);
        LOGGER.debug("tree:{}", tree);
        TreeUtils.printPrettyTree(tree.getRoot());
    }

    /**
     * Test build tree.
     */
    @Test
    public void testBuildPreOrderTree() {
        Tree<Integer> tree = new Tree<>();
        assertNotNull(tree);
        LOGGER.debug("tree:{}", tree);

//        Integer[] inputData = new Integer[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 7, -1, -1, 8};
//        // build preOrder tree
//        tree.buildPreOrderTree(inputData);
//        LOGGER.debug("tree:{}", tree);
//        TreeUtils.printBinaryTree(tree.getRoot());
//
//        Integer[] expected = BeanUtils.toType(TreeUtils.preOrder(tree.getRoot()), Integer[].class);
//        LOGGER.debug("expected:{}", Arrays.toString(expected));
//        assertPreOrderTree(tree, expected);
//        assertEquals(expected.length, tree.getSize());
    }

    /**
     * Test build tree.
     * <pre>
     *         3
     *     /     \
     *    1       4
     *     \
     *      2
     * </pre>
     */
    @Test
    @Override
    public void testAddNode() {
        Tree<Integer> tree = buildTree(Arrays.asList(1, 2, 3));
        assertNotNull(tree);
        LOGGER.debug("tree:{}", tree);
        assertEquals(3, tree.getSize());
        TreeUtils.printBinaryTree(tree.getRoot());
        assertTreesEqualsInPreOrder(tree, new Integer[]{1, 2, 3});
    }

    /**
     * Tests <code>findNode()</code>
     */
    @Test
    @Override
    public void testFindNode() {
        Tree<Integer> tree = buildTree(Arrays.asList(10, 7, 5, 9, 6, 8, 16));
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        assertNotNull(tree);
        assertEquals(7, tree.getSize());
        tree.printPrettyTree();

        // node exists
        Integer findWhat = 6;
        Node<Integer> found = tree.findNode(findWhat);
        LOGGER.debug("found:{}", found);
        assertNotNull(found);
        assertEquals(findWhat, found.getData());

        // node not exists
        findWhat = 15;
        Node<Integer> notFound = tree.findNode(findWhat);
        LOGGER.debug("notFound:{}", notFound);
        assertNull(notFound);
    }

    /**
     * Tests <code>removeNode()</code> method.
     */
    @Test
    @Override
    public void testRemoveNode() {
        Tree<Integer> tree = new Tree<>();
        TreeHierarchicalDataLoader dataLoader = TreeHierarchicalDataLoader.createDataLoader(TreeHierarchicalType.NUMERIC);
        dataLoader.fillHierarchicalData(tree);
        LOGGER.debug("tree:{}", tree);
        tree.printPrettyTree();
        assertNotNull(tree);
        assertEquals(34, tree.getSize());

        // remove node
        tree.removeNode(26);
        tree.printPrettyTree();
        assertEquals(33, tree.getSize());
    }

    /**
     * Tests <code>removeNode()</code> method.
     */
    @Test
    public void testRemoveNodeWithNoChildren() {
        Tree<Integer> tree = new Tree<>();
        TreeHierarchicalDataLoader dataLoader = TreeHierarchicalDataLoader.createDataLoader(TreeHierarchicalType.NUMERIC);
        dataLoader.fillHierarchicalData(tree);
        LOGGER.debug("tree:{}", tree);
        tree.printPrettyTree();
        assertNotNull(tree);
        assertEquals(34, tree.getSize());

        // remove node
        tree.removeNode(26);
        tree.printPrettyTree();
        assertEquals(33, tree.getSize());
    }

    /**
     * Tests <code>removeNode()</code> method.
     */
    @Test
    public void testRemoveNodeWithChildren() {
        Tree<Integer> tree = new Tree<>();
        TreeHierarchicalDataLoader dataLoader = TreeHierarchicalDataLoader.createDataLoader(TreeHierarchicalType.NUMERIC);
        dataLoader.fillHierarchicalData(tree);
        LOGGER.debug("tree:{}", tree);
        tree.printPrettyTree(true);
        assertNotNull(tree);
        assertEquals(34, tree.getSize());

        // remove node
        tree.removeNode(28);
        tree.printPrettyTree(true);
        assertEquals(33, tree.getSize());
    }

    /**
     * Tests <code>removeNode()</code> method.
     */
    @Test
    public void testRemoveNodeRootNode() {
        Tree<Integer> tree = new Tree<>();
        TreeHierarchicalDataLoader dataLoader = TreeHierarchicalDataLoader.createDataLoader(TreeHierarchicalType.NUMERIC);
        dataLoader.fillHierarchicalData(tree);
        LOGGER.debug("tree:{}", tree);
        tree.printPrettyTree();
        assertNotNull(tree);
        assertEquals(34, tree.getSize());

        // remove node
        tree.removeNode(50);
        tree.printPrettyTree();
        assertEquals(33, tree.getSize());
    }

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> treeHierarchicalData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{TreeHierarchicalType.ANIMAL_BIOLOGICAL});
        inputs.add(new Object[]{TreeHierarchicalType.ANIMAL_HYPOTHETICAL});
        inputs.add(new Object[]{TreeHierarchicalType.CLUSTER});
        inputs.add(new Object[]{TreeHierarchicalType.CONTINENT});
        inputs.add(new Object[]{TreeHierarchicalType.OPERATOR});
        inputs.add(new Object[]{TreeHierarchicalType.POLYGON});
        inputs.add(new Object[]{TreeHierarchicalType.WEB_PAGE});

        return inputs.iterator();
    }

    /**
     * Tests the <code>fillHierarchicalData()</code> method.
     */
    @Test(dataProvider = "treeHierarchicalData")
    public void testTreeHierarchicalStringDataLoader(TreeHierarchicalType hierarchicalType) {
        Tree<String> tree = new Tree<>();
        TreeHierarchicalDataLoader dataLoader = TreeHierarchicalDataLoader.createDataLoader(hierarchicalType);
        dataLoader.fillHierarchicalData(tree);
        tree.printPrettyTree();
        LOGGER.debug("tree:{}", tree);
    }

    /**
     * Tests the <code>fillHierarchicalData()</code> method.
     */
    @Test
    public void testTreeHierarchicalNumericDataLoader() {
        Tree<Integer> tree = new Tree<>();
        TreeHierarchicalDataLoader dataLoader = TreeHierarchicalDataLoader.createDataLoader(TreeHierarchicalType.NUMERIC);
        dataLoader.fillHierarchicalData(tree);
        LOGGER.debug("tree:{}", tree);
        tree.printPrettyTree();
        tree.preOrderTraversal();
    }

}
