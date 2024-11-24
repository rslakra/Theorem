package com.rslakra.theorem.adts.tree.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.appsuite.core.BeanUtils;
import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TraversalMode;
import com.rslakra.theorem.adts.tree.TreeParser;
import com.rslakra.theorem.adts.tree.TreeTest;
import com.rslakra.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 5:15 PM
 */
public class PreOrderTreeParserTest extends AbstractTreeParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreOrderTreeParserTest.class);

    /**
     * Tests the <code>getTraversalMode()</code> method.
     */
    @Test
    public void testGetTraversalMode() {
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.PRE_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);
        assertEquals(PreOrderTreeParser.class, treeParser.getClass());
    }

    /**
     * Tests the <code>buildTree()</code> method.
     */
    @Test
    public void testBuildTree() {
        LOGGER.debug("testBuildTree()");
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.PRE_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        Node<Integer>
            rootNode =
            buildBinaryTree(TraversalMode.PRE_ORDER_TRAVERSAL, Arrays.asList(TreeTest.PRE_ORDER_DATA_WITH_NEGATIVE));
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        assertEquals(TreeTest.PRE_ORDER_DATA.length, TreeUtils.countNodes(rootNode));
        TreeUtils.printBinaryTree(rootNode);
    }

    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafs() {
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.PRE_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        Node<Integer>
            rootNode =
            buildBinaryTree(TraversalMode.PRE_ORDER_TRAVERSAL, Arrays.asList(TreeTest.PRE_ORDER_DATA_WITH_NEGATIVE));
        assertEquals(TreeTest.PRE_ORDER_DATA.length, TreeUtils.countNodes(rootNode));

        Integer[] excludeNullLeafs = treeParser.parse(rootNode, false);
        assertNotNull(excludeNullLeafs);
        LOGGER.debug("excludeNullLeafs:{}", BeanUtils.toString(excludeNullLeafs));
        assertEquals(TreeTest.PRE_ORDER_DATA.length, excludeNullLeafs.length);

        Integer[] expected = new Integer[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 7, -1, -1, 8, -1, -1};
        Integer[] includeNullLeafs = treeParser.parse(rootNode, true);
        assertNotNull(includeNullLeafs);
        LOGGER.debug("includeNullLeafs:{}", Arrays.toString(includeNullLeafs));
        assertEquals(expected.length, includeNullLeafs.length);
    }

    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverter() {
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.PRE_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        Node<Integer>
            rootNode =
            buildBinaryTree(TraversalMode.PRE_ORDER_TRAVERSAL, Arrays.asList(TreeTest.PRE_ORDER_DATA_WITH_NEGATIVE));
        assertEquals(TreeTest.PRE_ORDER_DATA.length, TreeUtils.countNodes(rootNode));

        Integer[] excludeNullLeafs = treeParser.parse(rootNode, false);
        assertNotNull(excludeNullLeafs);
        LOGGER.debug("excludeNullLeafs:{}", BeanUtils.toString(excludeNullLeafs));
        assertEquals(TreeTest.PRE_ORDER_DATA.length, excludeNullLeafs.length);
    }

    /**
     * Tests <code>parse()</code>
     */
    @Test
    @Override
    public void testParseWithIncludeNullLeafs() {

    }

    /**
     * Tests <code>parse()</code>
     */
    @Test
    @Override
    public void testParse() {

    }
}
