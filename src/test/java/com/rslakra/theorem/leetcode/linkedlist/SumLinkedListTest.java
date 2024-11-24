package com.rslakra.theorem.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.leetcode.list.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/24/24 2:46 PM
 */
public class SumLinkedListTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SumLinkedListTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new Integer[]{1, 2, 3, 4}});

        return input.iterator();
    }

    /**
     * Tests the <code>testSumLinkedList</code> object.
     */
    @Test(dataProvider = "inputData")
    public void testSumLinkedList(Integer[] inputData) {
        LOGGER.debug("+testSumLinkedList()");
        SumLinkedList linkedList = new SumLinkedList();
        assertNotNull(linkedList);
        linkedList.addNode(inputData);
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

        // 2nd linked list
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        assertNotNull(linkedList2);
        linkedList2.addNode(new Integer[]{2, 4, 5});
        LOGGER.debug("Size:{}, linkedList2:{}", linkedList2.getSize(), linkedList2);
        assertEquals(3, linkedList.getSize());

        // sum 2 linked lists
        LinkedList<Integer> resultLinkedList = linkedList.sum(linkedList2);
        LOGGER.debug("Size:{}, resultLinkedList:{}", resultLinkedList.getSize(), resultLinkedList);
        LOGGER.debug("-testSumLinkedList()");

    }
}
