package com.devamatre.theorem.leetcode.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.devamatre.theorem.leetcode.text.LC1930UniqueLength3PalindromicSubsequences;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 11/13/2023 7:14 PM
 */
public class LC1930UniqueLength3PalindromicSubsequencesTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> countPalindromicSubsequenceData() {
        List<Object[]> inputs = new ArrayList<>();

        // Example 1:
        // Input: s = "aabca"
        // Output: 3
        // Explanation: The 3 palindromic subsequences of length 3 are:
        // - "aba" (subsequence of "aabca")
        // - "aaa" (subsequence of "aabca")
        // - "aca" (subsequence of "aabca")
        inputs.add(new Object[]{"aabca", 3});

        // Example 2:
        // Input: s = "adc"
        // Output: 0
        // Explanation: There are no palindromic subsequences of length 3 in "adc".
        inputs.add(new Object[]{"adc", 0});

        // Example 3:
        // Input: s = "bbcbaba"
        // Output: 4
        // Explanation: The 4 palindromic subsequences of length 3 are:
        // - "bbb" (subsequence of "bbcbaba")
        // - "bcb" (subsequence of "bbcbaba")
        // - "bab" (subsequence of "bbcbaba")
        // - "aba" (subsequence of "bbcbaba")
        inputs.add(new Object[]{"bbcbaba", 4});

        return inputs.iterator();
    }

    /**
     * @param input
     * @param result
     */
    @Test(dataProvider = "countPalindromicSubsequenceData")
    public void testCountPalindromicSubsequence(String input, int result) {
        LC1930UniqueLength3PalindromicSubsequences instance = new LC1930UniqueLength3PalindromicSubsequences();
        assertEquals(result, instance.countPalindromicSubsequence(input));
    }
}
