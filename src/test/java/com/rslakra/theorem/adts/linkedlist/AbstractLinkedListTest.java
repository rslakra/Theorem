package com.rslakra.theorem.adts.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rslakra.theorem.AbstractTest;
import com.rslakra.theorem.adts.AlgoUtils;
import com.rslakra.theorem.adts.list.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 12/1/23 11:11 AM
 */
public abstract class AbstractLinkedListTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLinkedListTest.class);
    public static final int SIZE = 5;
    public static final int UPPER_BOUND = 10;

    /**
     * Builds the linkedList of random integers.
     *
     * @param size
     * @param upperBound
     * @param linkedList
     */
    public static void buildIntRandomLinkedList(int size, int upperBound, LinkedList<Integer> linkedList) {
        LOGGER.debug("+buildIntRandomLinkedList({}, {})", size, linkedList);
        assertEquals(0, linkedList.getSize());
        AlgoUtils.randomIntListGenerator(size, upperBound).forEach(item -> linkedList.addNode(item));
        assertEquals(size, linkedList.getSize());
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        LOGGER.debug("-buildIntRandomLinkedList()");
    }

    /**
     * Builds the linkedList of random integers.
     */
    public static void buildIntRandomLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(SIZE, UPPER_BOUND, linkedList);
        assertEquals(SIZE, linkedList.getSize());
    }

    /**
     * Builds the random order linkedList with the same numbers.
     * <pre>
     *  [1, 0, 2, 4, 3]
     * </pre>
     *
     * @param linkedList
     */
    public static void buildIntRandomLinkedList(LinkedList<Integer> linkedList) {
        LOGGER.debug("+buildIntRandomLinkedList({})", linkedList);
        assertEquals(0, linkedList.getSize());

        // add 0
        linkedList.addHead(0);
        assertEquals(1, linkedList.getSize());

        // add 2
        Node<Integer> secondNode = new Node<Integer>(2);
        linkedList.addTail(secondNode);
        assertEquals(2, linkedList.getSize());
        // add 3
        linkedList.addTail(3);
        assertEquals(3, linkedList.getSize());

        // add 1 at the head of the linkedList
        linkedList.addHead(1);
        assertEquals(4, linkedList.getSize());

        // add 4 after the node 2
        linkedList.insertAfter(secondNode, new Node<Integer>(4));
        assertEquals(5, linkedList.getSize());
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        LOGGER.debug("-buildIntRandomLinkedList()");
    }

    /**
     * Builds the linkedList of integers.
     *
     * @return
     */
    public static void buildIntLinkedList(int size, LinkedList<Integer> linkedList) {
        LOGGER.debug("+buildIntLinkedList({}, {})", size, linkedList);
        assertEquals(0, linkedList.getSize());
        AlgoUtils.positiveIntListGenerator(size).forEach(item -> linkedList.addNode(item));
        assertEquals(size, linkedList.getSize());
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        LOGGER.debug("-buildIntLinkedList()");
    }

    /**
     * Builds the linkedList of random integers.
     */
    public static void buildIntLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntLinkedList(SIZE, linkedList);
        assertEquals(SIZE, linkedList.getSize());
    }

    /**
     * Builds the string linkedList.
     * <pre>
     *  [One, Zero, Two, Four, Three]
     * </pre>
     *
     * @param linkedList
     */
    public static void buildStringLinkedList(LinkedList<String> linkedList) {
        LOGGER.debug("+buildStringLinkedList({})", linkedList);
        assertEquals(0, linkedList.getSize());

        // Zero
        linkedList.addHead(new Node<String>("Zero"));
        // Two
        Node<String> secondNode = new Node<String>("Two");
        linkedList.addTail(secondNode);
        // One
        linkedList.addHead("One");
        // Three
        linkedList.addTail("Three");
        // Four
        linkedList.insertAfter(secondNode, new Node<String>("Four"));
        assertEquals(5, linkedList.getSize());
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        LOGGER.debug("-buildStringLinkedList()");
    }

    /**
     * Tests <code>new LinkedList()</code> method.
     *
     * @return
     */
    public abstract void testBuildLinkedList();

    /**
     * Tests <code>getSize()</code> method.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    public abstract void testGetSize();

    /**
     * Tests <code>isEmpty()</code> method.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    public abstract void testIsEmpty();

    /**
     * Tests <code>toString()</code> method.
     *
     * @return
     */
    public abstract void testToString();

    /**
     * Tests <code>addHead()</code> method.
     *
     * @return
     */
    public abstract void testAddHead();

    /**
     * Tests <code>addTail()</code> method.
     *
     * @return
     */
    public abstract void testAddTail();

    /**
     * Tests <code>addNode()</code> method.
     *
     * @return
     */
    public abstract void testAddNode();

    /**
     * Tests <code>findNode()</code> method.
     *
     * @return
     */
    public abstract void testFindNode();

    /**
     * Tests <code>removeHead()</code> method.
     *
     * @return
     */
    public abstract void testRemoveHead();

    /**
     * Tests <code>removeTail()</code> method.
     *
     * @return
     */
    public abstract void testRemoveTail();

    /**
     * Tests <code>removeNode()</code> method.
     *
     * @return
     */
    public abstract void testRemoveNode();

}
