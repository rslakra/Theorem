package com.rslakra.theorem.adts.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 1/20/21 4:07 PM
 */
public enum TextUtils {

    INSTANCE;

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(TextUtils.class);

    /**
     * Returns true if the <code>text</code> contains the <code>findWhat</code> string starting from the provided
     * <code>index</code> otherwise false.
     * <pre>
     *  Time Complexity: O(log N)
     *  N - the length of the text string.
     *
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param index
     * @param text
     * @param findWhat
     * @return
     */
    public static boolean findExists(int index, String text, String findWhat) {
        if (text == null && findWhat == null) {
            return true;
        } else if (text != null && findWhat != null && index >= 0 && index <= text.length() - findWhat.length()) {
            int size = findWhat.length();
            for (int i = 0, j = findWhat.length() - 1; i <= j; i++, j--) {
                // beginning index
                if (text.charAt(i + index) != findWhat.charAt(i)) {
                    return false;
                } else if (text.charAt(index + (size - i - 1)) != findWhat.charAt(
                    size - i - 1)) { // end of the string index
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    /**
     * @param text
     * @param findWhat
     * @return
     */
    public static int findIndexOfFirstOccurrence(String text, String findWhat) {
        if (text == null) {
            return -1;
        } else if (findWhat == null) {
            return 0;
        } else if (findWhat.length() > text.length()) {
            return -1;
        }

        int size = text.length() - findWhat.length();
        for (int i = 0; i <= size; i++) {
            if (findExists(i, text, findWhat)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns the index of the pattern that starts in the string at that index. If the patterns does not exist in the
     * string, return -1.
     *
     * @param pattern
     * @param text
     * @return
     */
    public static int search(String pattern, String text) {
        if (pattern != null && text != null) {
            int patternSize = pattern.length();
            int textSize = text.length();
            // if the pattern size > text size, not exist
            if (patternSize > textSize) {
                return -1;
            }

            //find pattern in text
            for (int i = 0; i < textSize - patternSize; i++) {
                int j;
                for (j = 0; j < patternSize; j++) {
                    // chars don't match, check next in text
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                if (j == patternSize) {
                    // index in text, where pattern starts
                    LOGGER.debug("i:{}", i);
                    return i;
                }
            }
        }

        // not found
        return -1;
    }

    /**
     * Returns the index of the pattern that starts in the string at that index. If the patterns does not exist in the
     * string, return -1.
     *
     * @param pattern
     * @param text
     * @return
     */
    public static int searchOptimized(String pattern, String text) {
        if (pattern != null && text != null) {
            int patternSize = pattern.length();
            int textSize = text.length();
            // if the pattern size > text size, not exist
            if (patternSize > textSize) {
                return -1;
            }

            int i, j;
            //find pattern in text
            for (i = 0, j = 0; i < textSize && j < patternSize; i++) {
                if (text.charAt(i) == pattern.charAt(j)) {
                    j++;
                } else {
                    // chars don't match, check next in text
                    i -= j;
                    j = 0;
                }
            }

            // LOGGER.debug(j);
            if (j == patternSize && patternSize > 0) {
                // index in text, where pattern starts
                return i - patternSize;
            }
        }

        // not found
        return -1;
    }


}
