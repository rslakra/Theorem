package com.devamatre.theorem.coderbyte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given a string consisting of a,b and c's, we can perform the following operation: Take any two adjacent distinct
 * characters and replace it with the third character.
 * <p>
 * For example, if 'a' and 'c' are adjacent, they can replaced with 'b'.
 * <p>
 * What is the smallest string which can result by applying this operation repeatedly?
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 03/11/2021 5:27 PM
 */
public class StringReduction {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringReduction.class);

    /**
     * Returns true if the <code>input</code> contains the same chars in it otherwise false.
     *
     * @param input
     * @return
     */
    private static boolean hasSameCharacters(String input) {
        if (Objects.nonNull(input) && input.length() > 1) {
            char cChar = input.charAt(0);
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) != cChar) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * <pre>
     *  Time Complexity: O(n * k) - k is the reduced string of x chars
     *  Space Complexity: O(n)
     * </pre>
     *
     * @param input
     * @return
     */
    public static int solve1(String input) {
        LOGGER.debug("+solve1({})", input);
        Map<String, String> replacements = new HashMap<>();
        // build replacement pairs
        replacements.put("ab", "c");
        replacements.put("ac", "b");
        replacements.put("bc", "a");
        // build reverse replacement pairs
        replacements.put("ba", "c");
        replacements.put("ca", "b");
        replacements.put("cb", "a");

        LOGGER.debug("replacements:{}", replacements);
        while (!hasSameCharacters(input) && input.length() > 1) {
            LOGGER.debug("reduced:{}", input);
            for (String key : replacements.keySet()) {
                LOGGER.debug("reduced:{}, key:{}, value:{}", input, key, replacements.get(key));
                input = input.replaceFirst(key, replacements.get(key));
            }
        }

        LOGGER.debug("-solve1(), reduced:{}, length:{}", input, input.length());
        return input.length();
    }

    /**
     * Reduces the <code>input</code>.
     *
     * @param input
     * @return
     */
    private static String reduce(String input) {
        if (input.equalsIgnoreCase("ab") || input.equalsIgnoreCase("ba")) {
            return "c";
        } else if (input.equalsIgnoreCase("bc") || input.equalsIgnoreCase("cb")) {
            return "a";
        } else if (input.equalsIgnoreCase("ac") || input.equalsIgnoreCase("ca")) {
            return "b";
        } else {
            return input;
        }
    }

    /**
     * <pre>
     *  Time Complexity: O(n * k) - k is the reduced string of x chars
     *  Space Complexity: O(n)
     * </pre>
     *
     * @param input
     * @return
     */
    public static int solve2(String input) {
        LOGGER.debug("+solve2({})", input);
        while (!hasSameCharacters(input) && input.length() > 1) {
            for (int i = 0; i < input.length() - 1; i++) {
                int nextIndex = i + 2;
                // reduce the string
                LOGGER.debug("i:{}, nextIndex:{}, input:{}", i, nextIndex, input);
                String prefix = "";
                if (i > 0) {
                    prefix = input.substring(0, i);
                }

                String reduced = reduce(input.substring(i, nextIndex));
                input = prefix + reduced + input.substring(nextIndex);
            }
        }

        LOGGER.debug("-solve2(), reduced:{}, length:{}", input, input.length());
        return input.length();
    }

    /**
     * Pseudo-code
     *
     * <pre>
     *  1. Count the number of occurrences of each letter in input.
     *  2. If 2 of (a,b or b,c or a,c) these counts are 0, then return string.length.
     *  3. else if (all counts are even) or (all counts are odd), return 2.
     *  4. else return 1
     * </pre>
     *
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param str
     * @return
     */
    public static int solve3(String str) {
        LOGGER.debug("+solve3({})", str);
        // code goes here
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < str.length(); i++) {
            // check which char is it and increase the count of that
            if (str.charAt(i) == 'a') {
                a++;
            } else if (str.charAt(i) == 'b') {
                b++;
            } else if (str.charAt(i) == 'c') {
                c++;
            }
        }

        int result = 1;
        // check if count of any one, equals to the length of the string (means same char string)
        if (a == str.length() || b == str.length() || c == str.length()) {
            result = str.length();
        } else if ((a % 2 == 0 && b % 2 == 0 && c % 2 == 0) || (a % 2 == 1 && b % 2 == 1 && c % 2 == 1)) {
            // check if (all counts are even) or (all counts are odd), return 2
            return 2;
        }

        LOGGER.debug("-solve3(), result:{}", result);
        return result;
    }

}
