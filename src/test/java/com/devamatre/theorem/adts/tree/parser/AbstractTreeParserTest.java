package com.devamatre.theorem.adts.tree.parser;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeBuilder;
import com.devamatre.theorem.adts.tree.TreeFactory;
import com.devamatre.theorem.adts.tree.TreeParser;
import com.devamatre.theorem.adts.tree.TreeTest;
import com.devamatre.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rohtash Lakra
 * @created 11/27/23 12:39 PM
 */
public abstract class AbstractTreeParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTreeParserTest.class);

    /**
     * Returns the <code>TreeParser</code> object.
     *
     * @param traversalMode
     * @return
     */
    public TreeParser buildTreeParser(TraversalMode traversalMode) {
        LOGGER.debug("+buildTreeParser()");
        TreeParser<Integer> treeParser = TreeFactory.treeParser(traversalMode);
        assertNotNull(treeParser);
        LOGGER.debug("treeParser:{}", treeParser);
        assertEquals(traversalMode, treeParser.getTraversalMode());
        LOGGER.debug("-buildTreeParser(), treeParser:{}", treeParser);
        return treeParser;
    }

    /**
     * Builds the binary tree of the
     *
     * @param traversalMode
     * @param inputData
     * @return
     */
    public Node<Integer> buildBinaryTree(TraversalMode traversalMode, List<Integer> inputData) {
        TreeBuilder<Integer> treeBuilder = TreeFactory.treeBuilder(traversalMode);
        assertNotNull(treeBuilder);
        Node<Integer> rootNode = treeBuilder.buildBinaryTree(inputData);
        assertNotNull(rootNode);
//        assertEquals(inputData.size(), rootNode.getSize());
        TreeUtils.printPrettyTree(rootNode);
        return rootNode;
    }

    /**
     * Tests the <code>getTraversalMode()</code> method.
     */
    public abstract void testGetTraversalMode();

    /**
     * Tests <code>parse()</code>
     */
    public abstract void testParseWithIncludeNullLeafs();

    /**
     * Tests <code>parse()</code>
     */
    public abstract void testParse();

}
