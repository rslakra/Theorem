package com.devamatre.theorem.adts.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertNull;

/**
 * @author Rohtash Lakra
 * @created 12/13/23 8:09 PM
 */
public class NodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeTest.class);

    /**
     * Tests the <code>increaseCount()</code> method.
     */
    @Test
    public void testIncreaseCount() {
        Node<Integer> rootNode = new Node(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());
    }

    /**
     * Tests the <code>decreaseCount()</code> method.
     */
    @Test
    public void testDecreaseCount() {
        Node<Integer> rootNode = new Node(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());

        // TODO - REMOVE NODE
    }


    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> isLeafData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new Node<>(0), true});
        Node<Integer> rootNode = TreeUtils.buildBinaryTree(Arrays.asList(1, 2, 3));
        inputs.add(new Object[]{rootNode, false});
        inputs.add(new Object[]{rootNode.getLeft(), true});
        inputs.add(new Object[]{rootNode.getRight(), true});

        return inputs.iterator();
    }

    /**
     * Tests the <code>isLeaf()</code> method.
     */
    @Test(dataProvider = "isLeafData")
    public void testIsLeaf(Node<Integer> rootNode, boolean expected) {
        LOGGER.debug("testIsLeaf({}, {})", rootNode, expected);
        assertEquals(expected, rootNode.isLeaf());
    }

    /**
     * Tests the <code>addChildRecursively()</code> method.
     */
    @Test
    public void testAddChildRecursively() {
        Node<Integer> rootNode = new Node(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());
        assertEquals(1, rootNode.getSize());

        // add child
        Node<Integer> childNode = new Node(2);
        LOGGER.debug("childNode:{}", childNode);
        assertNotNull(childNode);
        assertEquals(1, childNode.getCount());
        assertEquals(1, childNode.getSize());
        rootNode.addNode(childNode);
        LOGGER.debug("rootNode:{}", rootNode);
        assertEquals(1, rootNode.getCount());
        assertEquals(2, rootNode.getSize());
    }

    /**
     * Tests the <code>addChild()</code> method.
     */
    @Test
    public void testAddChild() {
        Node<Integer> rootNode = new Node(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());
        assertEquals(1, rootNode.getSize());

        // add child
        rootNode.addNode(2);
        LOGGER.debug("rootNode:{}", rootNode);
        assertEquals(1, rootNode.getCount());
        assertEquals(2, rootNode.getSize());

        // add child
        rootNode.addNode(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertEquals(2, rootNode.getCount());
        assertEquals(3, rootNode.getSize());
    }

    /**
     * Tests the <code>toString()</code> method.
     */
    @Test
    public void testToString() {
        Node<Integer> rootNode = new Node(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());
        assertEquals(1, rootNode.getSize());
        TreeUtils.printPrettyTree(rootNode);

        // add child
        rootNode.addNode(2);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(2, rootNode.getSize());
        TreeUtils.printPrettyTree(rootNode);
    }

    /**
     * Tests the <code>isLeftOf()</code> method.
     */
    @Test
    public void testIsLeftOf() {
        Node<Integer> rootNode = new Node(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());

        // left child
        Node<Integer> leftNode = new Node(2);
        rootNode.setLeft(leftNode);
        LOGGER.debug("leftNode:{}", leftNode);
        assertNotNull(leftNode);
        assertTrue(leftNode.isLeftOf(rootNode));

        // right child
        Node<Integer> rightNode = new Node(3);
        rootNode.setRight(rightNode);
        LOGGER.debug("rightNode:{}", rightNode);
        assertNotNull(rightNode);
        assertFalse(rightNode.isLeftOf(rootNode));
    }

    /**
     * Tests the <code>isRightOf()</code> method.
     */
    @Test
    public void testIsRightOf() {
        Node<Integer> rootNode = new Node(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());

        // left child
        Node<Integer> leftNode = new Node(2);
        rootNode.setLeft(leftNode);
        LOGGER.debug("leftNode:{}", leftNode);
        assertNotNull(leftNode);
        assertFalse(leftNode.isRightOf(rootNode));

        // right child
        Node<Integer> rightNode = new Node(3);
        rootNode.setRight(rightNode);
        LOGGER.debug("rightNode:{}", rightNode);
        assertNotNull(rightNode);
        assertTrue(rightNode.isRightOf(rootNode));
    }

    /**
     * Tests the <code>findNode()</code> method.
     */
    @Test
    public void testFindNaryTreeNode() {
        Node<Integer> rootNode = TreeUtils.buildNaryTree(Arrays.asList(4, 1, 3, 7, 4, 5, 8));
        LOGGER.debug("rootNode:{}, children:{}", rootNode, rootNode.getChildren().size());
        assertNotNull(rootNode);

        // find node
        Node<Integer> findChild = rootNode.findNode(rootNode, 4);
        LOGGER.debug("findChild:{}", findChild);
        assertNotNull(findChild);
        assertEquals(4, findChild.getData());

        // find node
        Node<Integer> notFound = rootNode.findNode(rootNode, 16);
        LOGGER.debug("notFound:{}", notFound);
        assertNull(notFound);
    }

    /**
     * Tests the <code>findNodeIteratively()</code> method.
     */
    @Test
    public void testFindNodeIteratively() {
        Node<Integer> rootNode = TreeUtils.buildNaryTree(Arrays.asList(4, 1, 3, 7, 4, 5, 8));
        LOGGER.debug("rootNode:{}, children:{}", rootNode, rootNode.getChildren().size());
        assertNotNull(rootNode);

        // find node
        Node<Integer> findNode = rootNode.findNode(4);
        LOGGER.debug("findNode:{}", findNode);
        assertNotNull(findNode);
        assertEquals(4, findNode.getData());

        // find node
        Node<Integer> notFound = rootNode.findNode(16);
        LOGGER.debug("notFound:{}", notFound);
        assertNull(notFound);
    }

    /**
     * Tests the <code>findNodeRecursively()</code> method.
     */
    @Test
    public void testFindNodeRecursively() {
        Node<Integer> rootNode = TreeUtils.buildNaryTree(Arrays.asList(4, 1, 3, 7, 4, 5, 8));
        LOGGER.debug("rootNode:{}, children:{}", rootNode, rootNode.getChildren().size());
        assertNotNull(rootNode);

        // find node
        Node<Integer> findNode = rootNode.findNode(4);
        LOGGER.debug("findNode:{}", findNode);
        assertNotNull(findNode);
        assertEquals(4, findNode.getData());

        // find node
        Node<Integer> notFound = rootNode.findNode(16);
        LOGGER.debug("notFound:{}", notFound);
        assertNull(notFound);
    }

    /**
     * Tests the <code>findNode()</code> method.
     */
    @Test
    public void testFindNode() {
        Node<Integer> rootNode = TreeUtils.buildNaryTree(Arrays.asList(4, 1, 3, 7, 4, 5, 8));
        LOGGER.debug("rootNode:{}, children:{}", rootNode, rootNode.getChildren().size());
        assertNotNull(rootNode);

        // find node
        Node<Integer> findNode = rootNode.findNode(4);
        LOGGER.debug("findNode:{}", findNode);
        assertNotNull(findNode);
        assertEquals(4, findNode.getData());

        // find node
        Node<Integer> notFound = rootNode.findNode(16);
        LOGGER.debug("notFound:{}", notFound);
        assertNull(notFound);
    }

    /**
     * Tests the <code>compareTo()</code> method.
     */
    @Test
    public void testCompareTo() {
        Node<Integer> rootNode = new Node<>(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());

        // equal node
        Node<Integer> equalNode = new Node<>(1);
        LOGGER.debug("equalNode:{}", equalNode);
        assertNotNull(equalNode);
        assertEquals(1, equalNode.getCount());
        assertEquals(0, rootNode.compareTo(equalNode));

        // less than node
        Node<Integer> lessThanNode = new Node<>(0);
        LOGGER.debug("lessThanNode:{}", lessThanNode);
        assertNotNull(lessThanNode);
        assertEquals(1, lessThanNode.getCount());
        assertEquals(1, rootNode.compareTo(lessThanNode));

        // greater than node
        Node<Integer> greaterThanNode = new Node<>(16);
        LOGGER.debug("greaterThanNode:{}", greaterThanNode);
        assertNotNull(greaterThanNode);
        assertEquals(1, greaterThanNode.getCount());
        assertEquals(-1, rootNode.compareTo(greaterThanNode));
    }

    /**
     * Tests the <code>isGreaterThanEqualTo()</code> method.
     */
    @Test
    public void testIsGreaterThanEqualTo() {
        Node<Integer> rootNode = new Node<>(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());

        // greater than node
        Node<Integer> equalToNode = new Node<>(1);
        LOGGER.debug("equalToNode:{}", equalToNode);
        assertNotNull(equalToNode);
        assertEquals(1, equalToNode.getCount());
        assertEquals(0, rootNode.compareTo(equalToNode));

        // greater than node
        Node<Integer> greaterThanEqualToNode = new Node<>(16);
        LOGGER.debug("greaterThanEqualToNode:{}", greaterThanEqualToNode);
        assertNotNull(greaterThanEqualToNode);
        assertEquals(1, greaterThanEqualToNode.getCount());
        assertEquals(-1, rootNode.compareTo(greaterThanEqualToNode));
    }

    /**
     * Tests the <code>isGreaterThan()</code> method.
     */
    @Test
    public void testIsGreaterThan() {
        Node<Integer> rootNode = new Node<>(1);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());

        // greater than node
        Node<Integer> greaterThanNode = new Node<>(16);
        LOGGER.debug("greaterThanNode:{}", greaterThanNode);
        assertNotNull(greaterThanNode);
        assertEquals(1, greaterThanNode.getCount());
        assertEquals(-1, rootNode.compareTo(greaterThanNode));
    }

    /**
     * Tests the <code>isLessThan()</code> method.
     */
    @Test
    public void testIsLessThan() {
        Node<Integer> rootNode = new Node<>(16);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());

        // greater than node
        Node<Integer> lessThanNode = new Node<>(1);
        LOGGER.debug("lessThanNode:{}", lessThanNode);
        assertNotNull(lessThanNode);
        assertEquals(1, lessThanNode.getCount());
        assertEquals(1, rootNode.compareTo(lessThanNode));
    }

    /**
     * Tests the <code>isEquals()</code> method.
     */
    @Test
    public void testIsEquals() {
        Node<Integer> rootNode = new Node<>(16);
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals(1, rootNode.getCount());

        // greater than node
        Node<Integer> equalToNode = new Node<>(16);
        LOGGER.debug("equalToNode:{}", equalToNode);
        assertNotNull(equalToNode);
        assertEquals(1, equalToNode.getCount());
        assertEquals(0, rootNode.compareTo(equalToNode));
    }

    /**
     * Tests the <code>NaryTree</code>.
     * <pre>
     * CEO
     * |-- CTO
     * |   |-- Server
     * |   |-- iOS
     * |   |   |-- Objective-C
     * |   |   |-- Swift
     * |   |-- Android
     * |-- CFO
     * </pre>
     */
    @Test
    public void testNaryNode() {
        // ROOT
        Node<String> rootNode = new Node(false, "CEO");
        LOGGER.debug("rootNode:{}", rootNode);
        assertNotNull(rootNode);
        assertEquals("CEO", rootNode.getData());
        int maxEdges = TreeUtils.maxEdges(rootNode);
        LOGGER.debug("Edges:{}", maxEdges);
        assertEquals(0, maxEdges);
        System.out.println();

        // CTO
        Node cto = new Node("CTO");
        assertNotNull(cto);
        rootNode.addNode(cto);
        // Server
        cto.addNode("Server");
        // IOS
        Node iOS = new Node("iOS");
        assertNotNull(iOS);
        cto.addNode(iOS);
        iOS.addNode("Objective-C");
        iOS.addNode("Swift");
        // Android
        cto.addNode("Android");

        // CFO
        Node cfo = new Node("CFO");
        assertNotNull(cfo);
        assertEquals("CFO", cfo.getData());
        rootNode.addNode(cfo);
        maxEdges = TreeUtils.maxEdges(rootNode);
        LOGGER.debug("Edges:{}", maxEdges);
        assertEquals(7, maxEdges);
        System.out.println();
        TreeUtils.printPrettyTree(rootNode, true);
    }

    /**
     * Node
     * <pre>
     * Lakra
     * |-- Rohtash
     * |   |-- R Singh
     * |   |-- RS Lakra
     * |-- Singh
     * |   |-- RS
     * </pre>
     */
    @Test
    public void testNaryTree() {
        Tree<String> tree = new Tree<>();
        assertNotNull(tree);
        assertEquals(0, tree.getSize());
        Node<String> lakraNode = new Node<>(false, "Lakra");
        tree.addNode(null, lakraNode);
        assertEquals(1, tree.getSize());
        LOGGER.debug("tree:{}", tree);

        // rohtash tree
        Node<String> rohtashTree = new Node<>("Rohtash");
        assertNotNull(rohtashTree);
        assertEquals(0, rohtashTree.getChildren().size());
        rohtashTree.addNode("R Singh");
        rohtashTree.addNode("RS Lakra");
        LOGGER.debug("rohtashTree:{}", rohtashTree);
        tree.addNode(lakraNode, rohtashTree);
        assertEquals(4, tree.getSize());
        LOGGER.debug("tree:{}", tree);

        // singh tree
        Node<String> singhTree = new Node<>("Singh");
        assertNotNull(singhTree);
        assertEquals(0, singhTree.getChildren().size());
        singhTree.addNode("RS");
        LOGGER.debug("singhTree:{}", singhTree);
        tree.addNode(lakraNode, singhTree);
        assertEquals(6, tree.getSize());
        LOGGER.debug("tree:{}", tree);
        tree.printPrettyTree();
    }
}
