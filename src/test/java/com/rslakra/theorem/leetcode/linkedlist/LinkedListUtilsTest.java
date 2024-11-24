package com.rslakra.theorem.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
 * @created 1/24/24 2:27 PM
 */
public class LinkedListUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListUtilsTest.class);

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
     * Tests the <code>buildLinkedList()</code> method.
     *
     * @param inputData
     */
    @Test(dataProvider = "inputData")
    public void testLinkedListUtils(Integer[] inputData) {
        LOGGER.debug("+testLinkedListUtils({})", inputData);
        ListNode headNode = LinkedListUtils.buildLinkedList(inputData);
        assertNotNull(headNode);
        String linkedList = LinkedListUtils.toString(headNode);
        LOGGER.debug("headNode:{}", linkedList);
        List<Integer> expected = LinkedListUtils.asIntList(headNode);
        LOGGER.debug("expected:{}", expected);
        assertEquals(expected, Arrays.asList(inputData));
        assertEquals(expected.toString(), linkedList);
        LOGGER.debug("-testLinkedListUtils()", inputData);
    }
}
