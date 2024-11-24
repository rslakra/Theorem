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
 * @created 1/26/24 10:42 AM
 */
public class LC28FindIndexOfFirstOccurrenceInStringTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC28FindIndexOfFirstOccurrenceInStringTest.class);

    /**
     * <pre>
     * Example 1:
     *  Input: haystack = "sadbutsad", needle = "sad"
     *  Output: 0
     *  Explanation: "sad" occurs at index 0 and 6.
     *  The first occurrence is at index 0, so we return 0.
     *
     * Example 2:
     *  Input: haystack = "leetcode", needle = "leeto"
     *  Output: -1
     *  Explanation: "leeto" did not occur in "leetcode", so we return -1.
     *
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{"", "lakra", -1});
        input.add(new Object[]{"leetcode", "leeto", -1});
        input.add(new Object[]{"sadbutsad", "sad", 0});
        input.add(new Object[]{"butsad", "sad", 3});
        input.add(new Object[]{"leetcode", "code", 4});
        input.add(new Object[]{"aaa", "aaaa", -1});
        input.add(new Object[]{"mississippi", "issip", 4});
        input.add(new Object[]{"mississippi", "issipi", -1});

        return input.iterator();
    }

    /**
     * Tests the <code>longestValidParentheses()</code> method.
     *
     * @param haystack
     * @param needle
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testLongestValidParentheses(String haystack, String needle, int expected) {
        LOGGER.debug("testLongestValidParentheses({}, {}, {})", haystack, needle, expected);
        LC28FindIndexOfFirstOccurrenceInString instance = new LC28FindIndexOfFirstOccurrenceInString();
        int result = instance.strStr(haystack, needle);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
        assertEquals(expected, instance.strStr1(haystack, needle));
        assertEquals(expected, instance.strStr2(haystack, needle));
        assertEquals(expected, instance.strStr3(haystack, needle));
        assertEquals(expected, instance.strStr4(haystack, needle));
    }
}
