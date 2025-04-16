package com.rslakra.theorem.leetcode.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Rohtash Lakra
 * @created 1/26/24 10:42 AM
 */
public class LC680ValidPalindromeIITest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC680ValidPalindromeIITest.class);

    /**
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     *
     * <pre>
     * Example 1:
     *
     * Input: s = "aba"
     * Output: true
     * Example 2:
     *
     * Input: s = "abca"
     * Output: true
     * Explanation: You could delete the character 'c'.
     * Example 3:
     *
     * Input: s = "abc"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s consists of lowercase English letters.
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{"abba", true});
        input.add(new Object[]{"madam", true});
        input.add(new Object[]{"banana", true});
        input.add(new Object[]{"devamatre", false});
        input.add(new Object[]{"maadam", true});
        input.add(new Object[]{"maaedam", false});
        input.add(new Object[]{"abca", true});
        input.add(new Object[]{"sippi", true});

        return input.iterator();
    }

    /**
     * Tests the <code>validPalindrome()</code> method.
     *
     * @param input
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testValidPalindrome(String input, boolean expected) {
        LOGGER.debug("testValidPalindrome({}, {})", input, expected);
        LC680ValidPalindromeII instance = new LC680ValidPalindromeII();
        boolean result = instance.validPalindrome(input);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}
