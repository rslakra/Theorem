package com.rslakra.theorem.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 10/13/23 12:10 PM
 */
public class LC1003CheckIfWordIsValidAfterSubstitutionsTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> isValidData() {
        List<Object[]> inputs = new ArrayList<>();

// Example 1:
// Input: s = "aabcbc"
// Output: true
// Explanation:
// "" -> "abc" -> "aabcbc"
// Thus, "aabcbc" is valid.
        inputs.add(new Object[]{"aabcbc", true});

// Example 2:
// Input: s = "abcabcababcc"
// Output: true
// Explanation:
// "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
// Thus, "abcabcababcc" is valid.
        inputs.add(new Object[]{"abcabcababcc", true});

// Example 3:
// Input: s = "abccba"
// Output: false
// Explanation: It is impossible to get "abccba" using the operation.
        inputs.add(new Object[]{"abccba", false});

        return inputs.iterator();
    }

    /**
     * @param input
     * @param result
     */
    @Test(dataProvider = "isValidData")
    public void testIsValid(String input, List<String> result) {
        LC1003CheckIfWordIsValidAfterSubstitutions instance = new LC1003CheckIfWordIsValidAfterSubstitutions();
        assertEquals(result, instance.isValid(input));
    }

}
