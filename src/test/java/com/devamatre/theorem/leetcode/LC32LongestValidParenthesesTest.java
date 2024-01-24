package com.devamatre.theorem.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.LC32LongestValidParentheses;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/13/23 11:53 AM
 */
public class LC32LongestValidParenthesesTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> longestValidParenthesesData() {
        List<Object[]> inputs = new ArrayList<>();

// Example 1:
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
        inputs.add(new Object[]{"(()", 2});

// Example 2:
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
        inputs.add(new Object[]{")()())", 4});

// Example 3:
// Input: s = ""
// Output: 0
        inputs.add(new Object[]{"", 0});

        return inputs.iterator();
    }

    /**
     * @param input
     * @param result
     */
    @Test(dataProvider = "longestValidParenthesesData")
    public void testLongestValidParentheses(String input, int result) {
        LC32LongestValidParentheses instance = new LC32LongestValidParentheses();
        assertEquals(result, instance.longestValidParentheses(input));
    }
}
