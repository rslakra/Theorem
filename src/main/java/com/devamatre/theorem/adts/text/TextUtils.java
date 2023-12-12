package com.devamatre.theorem.adts.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 1/20/21 4:07 PM
 */
public class TextUtils {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(TextUtils.class);

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

//            LOGGER.debug(j);
            if (j == patternSize && patternSize > 0) {
                // index in text, where pattern starts
                return i - patternSize;
            }
        }

        // not found
        return -1;
    }


}