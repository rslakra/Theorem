package com.rslakra.theorem.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/13/23 12:01 PM
 */
public class LC301RemoveInvalidParenthesesTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> removeInvalidParenthesesData() {
        List<Object[]> inputs = new ArrayList<>();

        // Example 1:
        // Input: s = "()())()"
        // Output: ["(())()","()()()"]
        inputs.add(new Object[]{"()())()", Arrays.asList("(())()", "()()()")});

        // Example 2:
        // Input: s = "(a)())()"
        // Output: ["(a())()","(a)()()"]
        inputs.add(new Object[]{"(a)())()", Arrays.asList("(a())()", "(a)()()")});

        // Example 3:
        // Input: s = ")("
        // Output: [""]
        inputs.add(new Object[]{")(", Arrays.asList("")});

        return inputs.iterator();
    }

    /**
     * Tests the <code>removeInvalidParentheses()</code> method.
     *
     * @param input
     * @param result
     */
    @Test(dataProvider = "removeInvalidParenthesesData")
    public void testRemoveInvalidParentheses(String input, List<String> result) {
        LC301RemoveInvalidParentheses instance = new LC301RemoveInvalidParentheses();
        assertEquals(result, instance.removeInvalidParentheses(input));
    }
}
