package com.rslakra.theorem.coderbyte;

/**
 * Have the function WildcardCharacters(str) read str which will contain two strings separated by a space. The first
 * string will consist of the following sets of characters: +, $, *, and {N} which is optional.
 * <p>
 * The plus (+) character represents a single alphabet character.
 * <p>
 * The plus ($) character represents a single numeric [0-9] character.
 * <p>
 * The asterisk (*) represents a sequence of the same character of length 3 unless it is followed by {N} which
 * represents how many characters should appear in the sequence where N will be at least 1. Your goal is to determine if
 * the second string exactly matches the pattern of the first string in the input.
 * <p>
 * For example: if str is "++*{5} gheeeee" then the second string in this case does match the pattern, so your program
 * should return the string true. If the second string does not match the pattern your program should return the string
 * false.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 03/11/2021 5:27 PM
 * <url>https://github.com/gutty333/Hard-Programming-Challenges</url>
 */
public class Wildcards {

    private static final String SIZE_PATTERN = "^{(\\d+)}";

    /**
     * @param cChar
     * @return
     */
    private static boolean isNumber(char cChar) {
        return (cChar >= '1' && cChar <= '9');
    }

    /**
     * Returns the size extracted from the pattern.
     *
     * @param pattern
     * @param index
     * @return
     */
    private static int getPatternSize(String pattern, int index) {
        int maxSize = 3;
        if (pattern != null && index + 1 < pattern.length()) {
            // condition to get the assigned length if one is provided
            if (pattern.charAt(index + 1) == '{') {
                String sequence = "";
                while (pattern.charAt(index) != '}') {
                    if (isNumber(pattern.charAt(index))) {
                        sequence += pattern.charAt(index);
                    }
                    index++;
                }
                maxSize = Integer.parseInt(sequence);
            }
        }

        return maxSize;
    }

    /**
     * Returns the size, extracted from the patter.
     *
     * @param pattern
     * @param index
     * @return
     */
    private static int getPatternSize(String pattern, int index, int defaultSize) {
        int maxSize = defaultSize;
        if (pattern != null && index + 1 < pattern.length() && pattern.charAt(index + 1) == '{') {
            int startCurly = pattern.indexOf('{', index);
            int endCurly = pattern.indexOf('}', index);
            maxSize = Integer.parseInt(pattern.substring(startCurly + 1, endCurly));
        }

        return maxSize;
    }

    /**
     * @param str
     * @return
     */
    public static boolean matchWildcards(String str) {
        // split the input string into tokens
        String[] tokens = str.split(" ");
        // pattern, tokens
        String pattern = tokens[0];
        String second = tokens[1];

        // iterate each char of second wildcard to validate the rule
        int index = 0;
        int step = 0;
        while (index < pattern.length()) {
            // checking symbol
            if (pattern.charAt(index) == '+') {
                step++;
            } else if (pattern.charAt(index) == '$') {
                if (!isNumber(second.charAt(step))) {
                    System.out.println("index:" + index + ", char: " + pattern.charAt(index));
                    return false;
                }
                step++;
            } else if (pattern.charAt(index) == '*') {
                // check if it's default repetition of 3 or provided length
                int maxSize = getPatternSize(pattern, index, 3);
                // first checking for out of bounds
                if (step + maxSize - 1 > second.length()) {
                    return false;
                } else {
                    // loop to ensure the characters are the same in a sequence
                    char curChar = second.charAt(step);
                    while (maxSize > 0) {
                        if (second.charAt(step) != curChar) {
                            return false;
                        }

                        maxSize--;
                        step++;
                    }
                }
            }

            index++;
        }

        // check traversal is sequential
        if (step != second.length()) {
            return false;
        }

        return true;
    }

}
