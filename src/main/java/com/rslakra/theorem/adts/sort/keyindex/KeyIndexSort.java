package com.rslakra.theorem.adts.sort.keyindex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 1/6/21 1:02 PM
 */
public class KeyIndexSort {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyIndexSort.class);

    private final StringKeyIndex keyIndex;

    /**
     * @param keyIndexType
     */
    public KeyIndexSort(KeyIndexType keyIndexType) {
        switch (keyIndexType) {
            case BINARY:
                keyIndex = new BinaryStringKeyIndex();
                break;

//            case VOWELS:
//                keyIndex = new VowelStringKeyIndex();
//                break;

//            case ALPHABETS:
//                keyIndex = new AlphabetsStringKeyIndex();
//                break;
//
//            case ALPHANUMERIC:
//                keyIndex = new AlphaNumericStringKeyIndex();
//                break;

            default:
                keyIndex = new AsciiStringKeyIndex();
                break;
        }
    }

    /**
     * Sorts the characters array based on the key-index.
     *
     * @param chars
     */
    public void sort(char[] chars) {
        char[] sortedChars = new char[chars.length];
        int[] count = new int[keyIndex.size() + 1];
        // count each vowel
        for (int i = 0; i < chars.length; i++) {
            LOGGER.trace("i:{}, char:", i, chars[i]);
            int index = keyIndex.get(chars[i]) + 1;
            count[index] = count[index] + 1;
        }
        LOGGER.trace("after vowel's count:{}", Arrays.toString(count));

        // find the next position index
        for (int i = 1; i < count.length - 1; i++) {
            count[i + 1] += count[i];
        }
        LOGGER.trace("after next position index:{}", Arrays.toString(count));

        // sort characters
        for (int i = 0; i < chars.length; i++) {
            sortedChars[count[keyIndex.get(chars[i])]++] = chars[i];
        }
        LOGGER.trace("after sorting, count:{}, sortedChars:{}", Arrays.toString(count), Arrays.toString(sortedChars));

        // copy the sorted array to original array
        System.arraycopy(sortedChars, 0, chars, 0, chars.length);
    }

    /**
     * Sorts the string.
     *
     * @param input
     * @return
     */
    public String sort(String input) {
        char[] chars = input.toCharArray();
        sort(chars);
        return new String(chars);
    }

}
