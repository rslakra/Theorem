package com.devamatre.theorem.adts.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.linkedlist.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 12/2/23 11:44 AM
 */
public class ListUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListUtilsTest.class);

    /**
     * Tests the <code>buildLinkedList</code> method.
     */
    @Test
    public void testBuildLinkedListRecursively() {
        Node<Integer> headNode = ListUtils.buildNodesRecursively(new Integer[]{1, 0, 2, 4, 3});
        LOGGER.debug("headNode:{}", headNode);
        assertNotNull(headNode);
        assertEquals(1, headNode.getData());
    }

    /**
     * Tests the <code>buildLinkedList</code> method.
     */
    @Test
    public void testBuildLinkedListWithInput() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListUtils.buildLinkedList(linkedList, new Integer[]{1, 0, 2, 4, 3});
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertNotNull(linkedList);
        assertEquals("[1, 0, 2, 4, 3]", linkedList.toString());
    }

    /**
     * Tests the <code>buildLinkedList</code> method.
     */
    @Test
    public void testBuildLinkedList() {
        LinkedList<Integer> linkedList = ListUtils.buildLinkedList(new Integer[]{1, 0, 2, 4, 3});
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertNotNull(linkedList);
        assertEquals("[1, 0, 2, 4, 3]", linkedList.toString());
    }
}
