package com.devamatre.theorem.leetcode.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.text.LC1657DetermineTwoStringsAreClose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/13/24 4:43 PM
 */
public class LC1657DetermineTwoStringsAreCloseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC1657DetermineTwoStringsAreCloseTest.class);

    /**
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // test 1
        input.add(new Object[]{1});

        return input.iterator();
    }

    /**
     * Tests the <code>closeStrings()</code> method.
     *
     * @param word1
     * @param word2
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testCloseStrings(String word1, String word2, boolean expected) {
        LOGGER.debug("testCloseStrings({}, {}, {})", word1, word2, expected);
        LC1657DetermineTwoStringsAreClose instance = new LC1657DetermineTwoStringsAreClose();
        boolean result = instance.closeStrings(word1, word2);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
