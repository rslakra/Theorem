package com.rslakra.theorem.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rslakra.theorem.leetcode.text.LC20ValidParentheses;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/13/23 11:48 AM
 */
public class LC20ValidParenthesesTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> isValidData() {
        List<Object[]> inputs = new ArrayList<>();

        // Example 1:
        // Input: s = "()"
        // Output: true
        inputs.add(new Object[]{"()", true});

        // Example 2:
        // Input: s = "()[]{}"
        // Output: true
        inputs.add(new Object[]{"()[]{}", true});

        // Example 3:
        // Input: s = "(]"
        // Output: false
        inputs.add(new Object[]{"(]", false});

        return inputs.iterator();
    }

    /**
     * @param input
     * @param result
     */
    @Test(dataProvider = "isValidData")
    public void testIsValid(String input, boolean result) {
        LC20ValidParentheses instance = new LC20ValidParentheses();
        assertEquals(result, instance.isValid(input));
        assertEquals(result, instance.validParentheses(input));
    }
}
