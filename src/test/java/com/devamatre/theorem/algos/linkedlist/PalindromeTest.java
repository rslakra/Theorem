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
public class PalindromeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeTest.class);

    /**
     * <pre>
     * <pre>
     *  Example 1:
     *      Input: head = [1,2,3,2,1]
     *      Output: true
     *
     *  Example 2:
     *      Input: head = [1,2,2,1]
     *      Output: true
     *
     *  Example 3:
     *      Input: head = [1,2]
     *      Output: false
     *
     *  Example 4:
     *      Input: head = [1]
     *      Output: true
     * </pre>
     * </pre>
     */
    @DataProvider
    public Iterator<Object[]> isPalindromeData() {
        List<Object[]> inputs = new ArrayList<>();
        /**
         * <pre>
         *  Example 1:
         *      Input: head = [1,2,3,2,1]
         *      Output: true
         *
         *  Example 2:
         *      Input: head = [1,2,2,1]
         *      Output: true
         *
         *  Example 3:
         *      Input: head = [1,2]
         *      Output: false
         *
         *  Example 4:
         *      Input: head = [1]
         *      Output: true
         * </pre>
         */
        inputs.add(new Object[]{new Integer[]{}, true});
        inputs.add(new Object[]{new Integer[]{1}, true});
        inputs.add(new Object[]{new Integer[]{1, 2, 1}, true});
        inputs.add(new Object[]{new Integer[]{1, 2, 2, 1}, true});
        inputs.add(new Object[]{new Integer[]{1, 2, 3, 2, 1}, true});

        // false cases
        inputs.add(new Object[]{new Integer[]{1, 2}, false});
        inputs.add(new Object[]{new Integer[]{1, 2, 3}, false});
        inputs.add(new Object[]{new Integer[]{1, 2, 3, 4}, false});

        return inputs.iterator();
    }

    /**
     * Test <code>findUnion</code> method.
     */
    @Test(dataProvider = "isPalindromeData")
    public void testIsPalindrome(Integer[] inputData, boolean expected) {
        LOGGER.debug("testIsPalindrome({}, {})", inputData, expected);
        Palindrome instance = new Palindrome();
        ListNode<Integer> headNode = ListUtils.buildListNodesRecursively(inputData);
        LOGGER.debug("headNode:{}", ListNode.toString(headNode));
        if (headNode == null) {
            assertNull(headNode);
        } else {
            assertNotNull(headNode);
        }
        assertEquals(Arrays.toString(inputData), ListNode.toString(headNode));

        boolean result = instance.isPalindrome(headNode);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
