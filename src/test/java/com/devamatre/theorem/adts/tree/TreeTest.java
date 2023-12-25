package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.theorem.adts.tree.data.populate.TreeHierarchicalDataPopulator;
import com.devamatre.theorem.adts.tree.data.populate.TreeHierarchicalType;
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
     * Builds the <code>Tree</code>.
     *
     * @param inputData
     * @param <E>
     * @return
     */
    @Override
    public <E extends Comparable<? super E>> Tree<E> buildTree(List<E> inputData) {
        LOGGER.debug("+buildTree({}, {})", inputData);
        final Tree<E> tree = new Tree<>();
        fillTree(tree, inputData);
        LOGGER.debug("-buildTree(), tree:{}", tree);
        return tree;
    }

    /**
     * Build Tree with strings.
     */
    @Test
    public void testBuildStringTree() {
        final Tree<String> tree = new Tree<>();
        fillTreeWithPresidents(tree);
        assertNotNull(tree);
        assertEquals(9, tree.getSize());
        LOGGER.debug("Size:{}, tree:{}", tree.getSize(), tree);
        assertTrue(tree.contains("Jackson"));
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
        assertPreOrderTree(tree, new Integer[]{1, 2, 3});
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
//        inputs.add(new Object[]{TreeHierarchicalType.NUMERIC});
        inputs.add(new Object[]{TreeHierarchicalType.POLYGON});
        inputs.add(new Object[]{TreeHierarchicalType.WEB_PAGE});

        return inputs.iterator();
    }

    /**
     * Tests the <code>fillHierarchicalData()</code> method.
     */
    @Test(dataProvider = "treeHierarchicalData")
    public void testTreeHierarchicalStringDataPopulator(TreeHierarchicalType hierarchicalType) {
        Tree<String> tree = new Tree<>();
        TreeHierarchicalDataPopulator
            dataPopulator =
            TreeHierarchicalDataPopulator.createHierarchicalDataPopulator(hierarchicalType);
        dataPopulator.fillHierarchicalData(tree);
        LOGGER.debug("tree:{}", tree);
    }

    /**
     * Tests the <code>fillHierarchicalData()</code> method.
     */
    @Test
    public void testTreeHierarchicalNumericDataPopulator() {
        Tree<Integer> tree = new Tree<>();
        TreeHierarchicalDataPopulator
            dataPopulator =
            TreeHierarchicalDataPopulator.createHierarchicalDataPopulator(TreeHierarchicalType.NUMERIC);
        dataPopulator.fillHierarchicalData(tree);
        LOGGER.debug("tree:{}", tree);
        tree.printPrettyTree();
        tree.preOrderTraversal();
    }

}
