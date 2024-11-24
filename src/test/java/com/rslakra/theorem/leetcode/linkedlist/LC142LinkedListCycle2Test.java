package com.rslakra.theorem.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:46 PM
 */
public class LC142LinkedListCycle2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC142LinkedListCycle2Test.class);

    /**
     * <url>https://leetcode.com/problems/longest-consecutive-sequence</url>
     * <pre>
     * Example 1:
     *  Input: head = [3,2,0,-4], pos = 1
     *  Output: tail connects to node index 1
     *  Explanation: There is a cycle in the linked list, where tail connects to the second node.
     *
     * Example 2:
     *  Input: head = [1,2], pos = 0
     *  Output: tail connects to node index 0
     *  Explanation: There is a cycle in the linked list, where tail connects to the first node.
     *
     * Example 3:
     *  Input: head = [1], pos = -1
     *  Output: no cycle
     *  Explanation: There is no cycle in the linked list.
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // [2,7,11,15], k = 9
        input.add(new Object[]{new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}});
        input.add(new Object[]{new int[]{3, 2, 4}, 6, new int[]{1, 2}});
        input.add(new Object[]{new int[]{-1, 0}, -1, new int[]{0, 1}});

        return input.iterator();
    }

    /**
     * Tests the <code>detectCycle()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testDetectCycle(ListNode headNode, ListNode expected) {
        LOGGER.debug("testDetectCycle({}, {})", headNode, expected);
        LC142LinkedListCycle2 instance = new LC142LinkedListCycle2();
        ListNode result = instance.detectCycle(headNode);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
