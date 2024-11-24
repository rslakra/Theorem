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
 * @created 1/24/24 3:11 PM
 */
public class LC2AddTwoNumbersTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC2AddTwoNumbersTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new Integer[]{3, 2, 1}, new Integer[]{3, 2}, new Integer[]{6, 4, 1}});
        input.add(new Object[]{new Integer[]{3, 2}, new Integer[]{3, 2, 1}, new Integer[]{6, 4, 1}});
        input.add(new Object[]{new Integer[]{9, 9}, new Integer[]{9, 9}, new Integer[]{8, 9, 1}});
        input.add(new Object[]{new Integer[]{9, 9, 9}, new Integer[]{9, 9}, new Integer[]{8, 9, 0, 1}});

        return input.iterator();
    }

    /**
     * Tests the <code>addTwoNumbers()</code> method.
     *
     * @param leftInput
     * @param rightInput
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testAddTwoNumbers(Integer[] leftInput, Integer[] rightInput, Integer[] expected) {
        LOGGER.debug("testAddTwoNumbers({}, {}, {})", leftInput, rightInput, expected);
        LC2AddTwoNumbers instance = new LC2AddTwoNumbers();
        ListNode leftOperand = LinkedListUtils.buildLinkedList(leftInput);
        ListNode rightOperand = LinkedListUtils.buildLinkedList(rightInput);
        LOGGER.debug("leftOperand:{}", LinkedListUtils.toString(leftOperand));
        LOGGER.debug("rightOperand:{}", LinkedListUtils.toString(rightOperand));
        ListNode result = instance.addTwoNumbers(leftOperand, rightOperand);
        LOGGER.debug("result:{}", LinkedListUtils.toString(result));
        List<Integer> sum = LinkedListUtils.asIntList(result);
        LOGGER.debug("sum:{}", sum);
        assertEquals(Arrays.asList(expected), sum);
        result = instance.addTwoNumbers2(leftOperand, rightOperand);
        sum = LinkedListUtils.asIntList(result);
        LOGGER.debug("sum:{}", sum);
        assertEquals(Arrays.asList(expected), sum);
    }
}
