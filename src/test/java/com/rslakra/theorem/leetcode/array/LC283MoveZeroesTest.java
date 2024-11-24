package com.rslakra.theorem.leetcode.array;

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
 * @created 1/23/24 3:44 PM
 */
public class LC283MoveZeroesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC283MoveZeroesTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}});
        input.add(new Object[]{new int[]{0, 1, 0, 3, 2, 4, 0, 0, 5}, new int[]{1, 3, 2, 4, 5, 0, 0, 0, 0}});

        return input.iterator();
    }

    /**
     * Tests the <code>moveZeroes()</code> method.
     *
     * @param input
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testMoveZeroes(int[] input, int[] expected) {
        LOGGER.debug("testMoveZeroes({}, {})", input, expected);
        LC283MoveZeroes instance = new LC283MoveZeroes();
        instance.moveZeroes(input);
        LOGGER.debug("input:{}", input);
        assertEquals(expected, input);
    }
}
