package com.devamatre.theorem.adts.tree.parser;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeParser;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 5:15 PM
 */
public class PostOrderTreeParserTest extends AbstractTreeParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostOrderTreeParserTest.class);

    /**
     * Tests the <code>getTraversalMode()</code> method.
     */
    @Test
    public void testGetTraversalMode() {
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.POST_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);
        assertEquals(PostOrderTreeParser.class, treeParser.getClass());
    }

    /**
     * Tests the <code>buildTree()</code> method.
     */
    @Test
    public void testBuildTree() {
        LOGGER.debug("testBuildTree()");
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.POST_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        Integer[] inputData = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Node<Integer> rootNode = buildBinaryTree(TraversalMode.POST_ORDER_TRAVERSAL, Arrays.asList(inputData));
        assertNotNull(rootNode);
        LOGGER.debug("rootNode:{}", rootNode);
        Integer[] expected = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));
        TreeUtils.printBinaryTree(rootNode);
    }

    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafs() {
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.POST_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        Integer[] inputData = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Integer[] expected = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        Node<Integer> rootNode = buildBinaryTree(TraversalMode.POST_ORDER_TRAVERSAL, Arrays.asList(inputData));
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));

        Integer[] excludeNullLeafs = treeParser.parse(rootNode, false);
        assertNotNull(excludeNullLeafs);
        LOGGER.debug("excludeNullLeafs:{}", BeanUtils.toString(excludeNullLeafs));
        assertEquals(expected.length, excludeNullLeafs.length);

        expected = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
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
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.POST_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        Integer[] inputData = new Integer[]{-1, -1, 4, -1, -1, 5, 2, -1, -1, -1, 7, -1, -1, 8, 6, 3, 1};
        Integer[] expected = new Integer[]{4, 5, 2, 7, 8, 6, 3, 1};
        Node<Integer> rootNode = buildBinaryTree(TraversalMode.POST_ORDER_TRAVERSAL, Arrays.asList(inputData));
        assertEquals(expected.length, TreeUtils.countNodes(rootNode));

        Integer[] excludeNullLeafs = treeParser.parse(rootNode, false);
        assertNotNull(excludeNullLeafs);
        LOGGER.debug("excludeNullLeafs:{}", BeanUtils.toString(excludeNullLeafs));
        assertEquals(expected.length, excludeNullLeafs.length);
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
