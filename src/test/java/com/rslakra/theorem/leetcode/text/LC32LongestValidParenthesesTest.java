package com.rslakra.theorem.leetcode.text;

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
 * @created 1/25/24 5:13 PM
 */
public class LC32LongestValidParenthesesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC32LongestValidParenthesesTest.class);

    /**
     * <pre>
     * Example 1:
     *  Input: s = "(()"
     *  Output: 2
     *  Explanation: The longest valid parentheses substring is "()".
     *
     * Example 2:
     *  Input: s = ")()())"
     *  Output: 4
     *  Explanation: The longest valid parentheses substring is "()()".
     *
     * Example 3:
     *  Input: s = ""
     *  Output: 0
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{"", 0});
        input.add(new Object[]{"(()", 2});
        input.add(new Object[]{")()())", 4});
        input.add(new Object[]{"()(()", 4});
        input.add(new Object[]{"1$(34%$)@(63(5)8!", 4});

        return input.iterator();
    }

    /**
     * Tests the <code>longestValidParentheses()</code> method.
     *
     * @param inputData
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testLongestValidParentheses(String inputData, int expected) {
        LOGGER.debug("testLongestValidParentheses({}, {})", inputData, expected);
        LC32LongestValidParentheses instance = new LC32LongestValidParentheses();
        int result = instance.longestValidParentheses(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
        assertEquals(expected, instance.longestValidParentheses2(inputData));
        assertEquals(expected, instance.longestValidParentheses3(inputData));
    }
}
