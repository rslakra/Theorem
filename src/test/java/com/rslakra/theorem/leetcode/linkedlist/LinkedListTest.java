package com.rslakra.theorem.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.leetcode.list.ListNode;
import com.rslakra.theorem.leetcode.list.ListUtils;
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
 * @created 1/24/24 2:35 PM
 */
public class LinkedListTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [2,7,11,15]
        input.add(new Object[]{new Integer[]{1, 2, 3, 4, 5}});

        return input.iterator();
    }

    /**
     * Tests the <code>LinkedList</code> object.
     *
     * @param inputData
     */
    @Test(dataProvider = "inputData")
    public void testIntLinkedList(Integer[] inputData) {
        LOGGER.debug("+testIntLinkedList({})", inputData);
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertNotNull(linkedList);
        // add nodes to the list
        linkedList.addNode(inputData);
        LOGGER.debug("linkedList:{}", linkedList);
        assertEquals(inputData.length, linkedList.getSize());
        List<Integer> expected = ListUtils.asIntList(linkedList.getHead());
        LOGGER.debug("expected:{}", expected);
        assertEquals(expected, Arrays.asList(inputData));
        assertEquals(expected.toString(), linkedList.toString());
        LOGGER.debug("-testIntLinkedList()", inputData);
    }

    @Test
    public void testLinkedList() {
        LOGGER.debug("+testLinkedList()");
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertNotNull(linkedList);
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertEquals(4, linkedList.getSize());

        // find node
        ListNode findNode = linkedList.findNode(3);
        LOGGER.debug("findNode:{}", findNode);
        assertEquals(3, findNode.data);

        // remove node
        ListNode removeNode = linkedList.removeNode(3);
        LOGGER.debug("removeNode:{}", removeNode);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertEquals(3, linkedList.getSize());

        //2nd linked list
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        assertNotNull(linkedList2);
        linkedList2.addNode(2);
        linkedList2.addNode(4);
        linkedList2.addNode(5);
        LOGGER.debug("Size:{}, linkedList2:{}", linkedList2.getSize(), linkedList2);
        assertEquals(3, linkedList.getSize());

        LOGGER.debug("+testLinkedList()");
    }
}
