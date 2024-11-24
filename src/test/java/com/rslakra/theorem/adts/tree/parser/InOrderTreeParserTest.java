package com.rslakra.theorem.adts.tree.parser;

import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TraversalMode;
import com.rslakra.theorem.adts.tree.TreeParser;
import com.rslakra.theorem.adts.tree.TreeTest;
import com.rslakra.theorem.adts.tree.builder.InOrderTreeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 5:15 PM
 */
public class InOrderTreeParserTest extends AbstractTreeParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InOrderTreeParserTest.class);

    /**
     * Tests the <code>getTraversalMode()</code> method.
     */
    @Test
    public void testGetTraversalMode() {
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);
        assertEquals(InOrderTreeParser.class, treeParser.getClass());
    }

    /**
     * Tests the <code>buildInOrderTreeWithPreOrder()</code> method.
     */
    @Test
    public void testBuildInOrderTreeWithPreOrder() {
        LOGGER.debug("testBuildInOrderTreeWithPreOrder()");
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        // build tree
        InOrderTreeBuilder<Integer> treeBuilder = new InOrderTreeBuilder<>();
        Node<Integer>
            rootNode =
            treeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA),
                                         Arrays.asList(TreeTest.PRE_ORDER_DATA), null);

        // validate treeParser
        Integer[] excludeNullLeafs = treeParser.parse(rootNode);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(TreeTest.IN_ORDER_DATA.length, excludeNullLeafs.length);
        assertArrayEquals(TreeTest.IN_ORDER_DATA, excludeNullLeafs);
    }

    /**
     * Tests the <code>buildInOrderTreeWithPreOrder()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafsInOrderTreeWithPreOrder() {
        LOGGER.debug("testTreeConverterIncludeNullLeafsInOrderTreeWithPreOrder()");
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        // build tree
        InOrderTreeBuilder<Integer> treeBuilder = new InOrderTreeBuilder<>();
        Node<Integer>
            rootNode =
            treeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA),
                                         Arrays.asList(TreeTest.PRE_ORDER_DATA), null);

        // treeConverter validation
        Integer[] excludeNullLeafs = treeParser.parse(rootNode);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(TreeTest.IN_ORDER_DATA.length, excludeNullLeafs.length);
        assertArrayEquals(TreeTest.IN_ORDER_DATA, excludeNullLeafs);

        Integer[] expected = new Integer[]{-1, 4, -1, 2, -1, 5, -1, 1, -1, 3, -1, 7, -1, 6, -1, 8, -1};
        Integer[] includeNullLeafs = treeParser.parse(rootNode, true);
        LOGGER.debug("includeNullLeafs:{}", Arrays.toString(includeNullLeafs));
        assertNotNull(includeNullLeafs);
        assertEquals(expected.length, includeNullLeafs.length);
        assertArrayEquals(expected, includeNullLeafs);
    }

    /**
     * Tests the <code>buildInOrderTreeWithPostOrder()</code> method.
     */
    @Test
    public void testBuildInOrderTreeWithPostOrder() {
        LOGGER.debug("testBuildInOrderTreeWithPostOrder()");
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        // build tree
        InOrderTreeBuilder<Integer> treeBuilder = new InOrderTreeBuilder<>();
        Node<Integer>
            rootNode =
            treeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA), null,
                                         Arrays.asList(TreeTest.POST_ORDER_DATA));

        // treeConverter validation
        Integer[] excludeNullLeafs = treeParser.parse(rootNode);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(TreeTest.IN_ORDER_DATA.length, excludeNullLeafs.length);
        assertArrayEquals(TreeTest.IN_ORDER_DATA, excludeNullLeafs);
    }

    /**
     * Tests the <code>buildInOrderTreeWithPreOrder()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafsInOrderTreeWithPostOrder() {
        LOGGER.debug("testTreeConverterIncludeNullLeafsInOrderTreeWithPostOrder()");
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        InOrderTreeBuilder treeBuilder = new InOrderTreeBuilder();
        Node<Integer>
            rootNode =
            treeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA), null,
                                         Arrays.asList(TreeTest.POST_ORDER_DATA));

        // treeConverter validation
        Integer[] excludeNullLeafs = treeParser.parse(rootNode, false);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(TreeTest.IN_ORDER_DATA.length, excludeNullLeafs.length);
        assertArrayEquals(TreeTest.IN_ORDER_DATA, excludeNullLeafs);

        Integer[] expected = new Integer[]{-1, 4, -1, 2, -1, 5, -1, 1, -1, 3, -1, 7, -1, 6, -1, 8, -1};
        Integer[] includeNullLeafs = treeParser.parse(rootNode, true);
        LOGGER.debug("includeNullLeafs:{}", Arrays.toString(includeNullLeafs));
        assertNotNull(includeNullLeafs);
        assertEquals(expected.length, includeNullLeafs.length);
        assertArrayEquals(expected, includeNullLeafs);
    }

    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverterIncludeNullLeafs() {
        LOGGER.debug("testTreeConverterIncludeNullLeafs()");
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        InOrderTreeBuilder treeBuilder = new InOrderTreeBuilder();
        Node<Integer>
            rootNode =
            treeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA),
                                         Arrays.asList(TreeTest.PRE_ORDER_DATA), null);

        // validate
        Integer[] expected = new Integer[]{-1, 4, -1, 2, -1, 5, -1, 1, -1, 3, -1, 7, -1, 6, -1, 8, -1};
        Integer[] includeNullLeafs = treeParser.parse(rootNode, true);
        LOGGER.debug("includeNullLeafs:{}", Arrays.toString(includeNullLeafs));
        assertNotNull(includeNullLeafs);
        assertEquals(expected.length, includeNullLeafs.length);
        assertArrayEquals(expected, includeNullLeafs);
    }

    /**
     * Tests the <code>treeConverter()</code> method.
     */
    @Test
    public void testTreeConverter() {
        LOGGER.debug("testTreeConverter()");
        TreeParser<Integer> treeParser = buildTreeParser(TraversalMode.IN_ORDER_TRAVERSAL);
        LOGGER.debug("treeParser:{}", treeParser);
        assertNotNull(treeParser);

        InOrderTreeBuilder treeBuilder = new InOrderTreeBuilder();
        Node<Integer>
            rootNode =
            treeBuilder.buildRecursively(true, Arrays.asList(TreeTest.IN_ORDER_DATA),
                                         Arrays.asList(TreeTest.PRE_ORDER_DATA), null);

        // treeConverter validation
        Integer[] excludeNullLeafs = treeParser.parse(rootNode);
        LOGGER.debug("excludeNullLeafs:{}", Arrays.toString(excludeNullLeafs));
        assertNotNull(excludeNullLeafs);
        assertEquals(TreeTest.IN_ORDER_DATA.length, excludeNullLeafs.length);
        assertArrayEquals(TreeTest.IN_ORDER_DATA, excludeNullLeafs);
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
