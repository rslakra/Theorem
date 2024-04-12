package com.devamatre.theorem.coderbyte;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 03/11/2021 5:27 PM
 * <p>
 * https://github.com/gutty333/Hard-Programming-Challenges/blob/master/27_WildcardCharacters.cpp
 */
public class Wildcards {

    /**
     * @param cChar
     * @return
     */
    private static boolean isNumber(char cChar) {
        return (cChar >= '1' && cChar <= '9');
    }

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
                int maxSize = 3;
                // check if it's default repetition of 3 or provided length

                // if (index + 1 < pattern.length() && pattern.charAt(index + 1) == '{') {
                //  int startCurly = pattern.indexOf('{', index + 1);
                //  int endCurly = pattern.indexOf('}', startCurly);
                //  maxSize = Integer.parseInt(pattern.substring(startCurly, endCurly));
                // }

                if (index + 1 < pattern.length()) {
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


    public static void main(String[] args) {
        String input = "$+ 1r"; // true
        boolean result = Wildcards.matchWildcards(input);
        System.out.println(input + ": " + result);
        assert result == true;

        input = "++*{5} gheeeee"; // true
        result = Wildcards.matchWildcards(input);
        System.out.println(input + ": " + result);
        assert result == true;

        input = "+++++* abcdemmmmmm"; // false
        result = Wildcards.matchWildcards(input);
        System.out.println(input + ": " + result);
        assert result == false;

        input = "**+*{2} mmmrrrkbb"; // true
        result = Wildcards.matchWildcards(input);
        System.out.println(input + ": " + result);
        assert result == true;

        input = "+++++* abcdehhhhhh"; // false
        result = Wildcards.matchWildcards(input);
        System.out.println(input + ": " + result);
        assert result == false;

        input = "$**+*{2} 9mmmrrrkbb"; // true
        result = Wildcards.matchWildcards(input);
        System.out.println(input + ": " + result);
        assert result == true;
    }
}
