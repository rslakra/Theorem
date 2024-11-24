package com.rslakra.theorem.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
 * @created 1/24/24 4:48 PM
 */
public class LC21MergeTwoSortedListsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC21MergeTwoSortedListsTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new Integer[]{1, 2, 3}, new Integer[]{2, 3}, new Integer[]{1, 2, 2, 3, 3}});
        input.add(new Object[]{new Integer[]{2, 3}, new Integer[]{1, 2, 3}, new Integer[]{1, 2, 2, 3, 3}});
        input.add(new Object[]{new Integer[]{1, 2, 3, 4}, new Integer[]{1}, new Integer[]{1, 1, 2, 3, 4}});
        input.add(new Object[]{null, new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3}});

        return input.iterator();
    }

    /**
     * Tests the <code>mergeTwoListsIteratively()</code> method.
     *
     * @param leftInput
     * @param rightInput
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testMergeTwoListsIteratively(Integer[] leftInput, Integer[] rightInput, Integer[] expected) {
        LOGGER.debug("testMergeTwoListsIteratively({}, {}, {})", leftInput, rightInput, expected);
        LC21MergeTwoSortedLists instance = new LC21MergeTwoSortedLists();
        ListNode firstList = LinkedListUtils.buildLinkedList(leftInput);
        ListNode secondList = LinkedListUtils.buildLinkedList(rightInput);
        LOGGER.debug("firstList:{}", LinkedListUtils.toString(firstList));
        LOGGER.debug("secondList:{}", LinkedListUtils.toString(secondList));
        ListNode result = instance.mergeTwoListsIteratively(firstList, secondList);
        LOGGER.debug("result:{}", LinkedListUtils.toString(result));
        List<Integer> nodeList = LinkedListUtils.asIntList(result);
        LOGGER.debug("nodeList:{}", nodeList);
        assertEquals(Arrays.asList(expected), nodeList);
    }

    /**
     * Tests the <code>mergeTwoListsRecursively()</code> method.
     *
     * @param leftInput
     * @param rightInput
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testMergeTwoListsRecursively(Integer[] leftInput, Integer[] rightInput, Integer[] expected) {
        LOGGER.debug("testMergeTwoListsRecursively({}, {}, {})", leftInput, rightInput, expected);
        LC21MergeTwoSortedLists instance = new LC21MergeTwoSortedLists();
        ListNode firstList = LinkedListUtils.buildLinkedList(leftInput);
        ListNode secondList = LinkedListUtils.buildLinkedList(rightInput);
        LOGGER.debug("firstList:{}", LinkedListUtils.toString(firstList));
        LOGGER.debug("secondList:{}", LinkedListUtils.toString(secondList));
        ListNode result = instance.mergeTwoListsRecursively(firstList, secondList);
        LOGGER.debug("result:{}", LinkedListUtils.toString(result));
        List<Integer> nodeList = LinkedListUtils.asIntList(result);
        LOGGER.debug("nodeList:{}", nodeList);
        assertEquals(Arrays.asList(expected), nodeList);
    }

}
