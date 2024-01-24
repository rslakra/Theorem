package com.devamatre.theorem.leetcode.palindrome;

import com.devamatre.theorem.leetcode.palindrome.LC9PalindromeNumber;
import org.junit.jupiter.api.Test;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 01/20/2024 4:45 PM
 */
public class LC9PalindromeNumberTest {

    @Test
    public void testPalindromeNumber() {
        final LC9PalindromeNumber instance = new LC9PalindromeNumber();
        Integer[] inputData = new Integer[]{121, 12321, -121};
        for (int i = 0; i < inputData.length; i++) {
            boolean result = instance.palindromeNumber(inputData[i]);
            System.out.println("inputData:" + inputData[i] + ", result:" + result);
        }
    }

}
