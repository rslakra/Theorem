package com.devamatre.theorem.algos.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.devamatre.theorem.adts.list.ListUtils;
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
 * @created 12/2/23 11:12 AM
 */
public class SwapNodesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwapNodesTest.class);

    /**
     * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
     * modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     * <url>https://leetcode.com/problems/swap-nodes-in-pairs</url>
     *
     * <pre>
     *  Example 1:
     *      Input: head = [1,2,3,4]
     *      Output: [2,1,4,3]
     *
     *  Example 2:
     *      Input: head = []
     *      Output: []
     *
     *  Example 3:
     *      Input: head = [1]
     *      Output: [1]
     * </pre>
     */
    @DataProvider
    public Iterator<Object[]> swapPairsData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * <pre>
         *  Example 1:
         *      Input: head = [1,2,3,4]
         *      Output: [2,1,4,3]
         *
         *  Example 2:
         *      Input: head = []
         *      Output: []
         *
         *  Example 3:
         *      Input: head = [1]
         *      Output: [1]
         * </pre>
         */
        inputs.add(new Object[]{new Integer[]{1, 2, 3, 4}, new Integer[]{2, 1, 4, 3}});
        inputs.add(new Object[]{new Integer[]{3, 6, 9, 2, 9, 4}, new Integer[]{6, 3, 2, 9, 4, 9}});
        inputs.add(new Object[]{new Integer[]{2, 6, 8, 3, 0, 7, 1, 3}, new Integer[]{6, 2, 3, 8, 7, 0, 3, 1}});
        inputs.add(new Object[]{new Integer[]{}, new Integer[]{}});
        inputs.add(new Object[]{new Integer[]{1}, new Integer[]{1}});

        return inputs.iterator();
    }

    /**
     * Test <code>findUnion</code> method.
     */
    @Test(dataProvider = "swapPairsData")
    public void testSwapPairs(Integer[] inputData, Integer[] expected) {
        LOGGER.debug("testSwapPairs({}, {})", inputData, expected);
        SwapNodes instance = new SwapNodes();
        ListNode<Integer> headNode = ListUtils.buildListNodesRecursively(inputData);
        LOGGER.debug("headNode:{}", ListNode.toString(headNode));
        if (headNode == null) {
            assertNull(headNode);
        } else {
            assertNotNull(headNode);
        }
        assertEquals(Arrays.toString(inputData), ListNode.toString(headNode));

        ListNode<Integer> swapPairs = instance.swapPairs(headNode);
        LOGGER.debug("swapPairs:{}", ListNode.toString(swapPairs));
        if (swapPairs == null) {
            assertNull(swapPairs);
        } else {
            assertNotNull(swapPairs);
        }
        assertEquals(Arrays.toString(expected), ListNode.toString(swapPairs));
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
     * modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     * <url>https://leetcode.com/problems/swap-nodes-in-pairs</url>
     *
     * <pre>
     *  Example 1:
     *      Input: head = [1,2,3,4]
     *      Output: [2,1,4,3]
     *
     *  Example 2:
     *      Input: head = []
     *      Output: []
     *
     *  Example 3:
     *      Input: head = [1]
     *      Output: [1]
     * </pre>
     */
    @DataProvider
    public Iterator<Object[]> swapNodesData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * <pre>
         *  Example 1:
         *      Input: head = [1,2,3,4]
         *      Output: [2,1,4,3]
         *
         *  Example 2:
         *      Input: head = []
         *      Output: []
         *
         *  Example 3:
         *      Input: head = [1]
         *      Output: [1]
         * </pre>
         */
        inputs.add(new Object[]{new Integer[]{}, 0, new Integer[]{}});
        inputs.add(new Object[]{new Integer[]{1}, 1, new Integer[]{1}});
        inputs.add(new Object[]{new Integer[]{1, 2}, 1, new Integer[]{2, 1}});
        inputs.add(new Object[]{new Integer[]{1, 2, 3}, 1, new Integer[]{3, 2, 1}});
        inputs.add(new Object[]{new Integer[]{1, 2, 3}, 2, new Integer[]{1, 2, 3}});
        inputs.add(new Object[]{new Integer[]{1, 2, 3, 4, 5}, 1, new Integer[]{5, 2, 3, 4, 1}});
        inputs.add(new Object[]{new Integer[]{1, 2, 3, 4, 5}, 2, new Integer[]{1, 4, 3, 2, 5}});
        inputs.add(new Object[]{new Integer[]{1, 2, 3, 4, 5}, 3, new Integer[]{1, 2, 3, 4, 5}});
        inputs.add(new Object[]{new Integer[]{1, 2, 3, 4, 5}, 4, new Integer[]{1, 4, 3, 2, 5}});
        inputs.add(new Object[]{new Integer[]{1, 2, 3, 4, 5}, 5, new Integer[]{5, 2, 3, 4, 1}});

        return inputs.iterator();
    }

    /**
     * Test <code>findUnion</code> method.
     */
    @Test(dataProvider = "swapNodesData")
    public void testSwapNodes(Integer[] inputData, int k, Integer[] expected) {
        LOGGER.debug("testSwapNodes({}, {})", inputData, expected);
        SwapNodes instance = new SwapNodes();
        ListNode<Integer> headNode = ListUtils.buildListNodesRecursively(inputData);
        LOGGER.debug("headNode:{}", ListNode.toString(headNode));
        if (headNode == null) {
            assertNull(headNode);
        } else {
            assertNotNull(headNode);
        }
        assertEquals(Arrays.toString(inputData), ListNode.toString(headNode));

        ListNode<Integer> swapPairs = instance.swapNodes(headNode, k);
        LOGGER.debug("swapPairs:{}", ListNode.toString(swapPairs));
        if (swapPairs == null) {
            assertNull(swapPairs);
        } else {
            assertNotNull(swapPairs);
        }
        assertEquals(Arrays.toString(expected), ListNode.toString(swapPairs));
    }
}
