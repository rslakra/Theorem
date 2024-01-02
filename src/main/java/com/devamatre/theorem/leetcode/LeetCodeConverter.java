package com.devamatre.theorem.leetcode;

import com.devamatre.theorem.adts.lang.AbstractCodeConverter;
import com.devamatre.theorem.adts.lang.CodeConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 01/01/2024 4:58 PM
 */
public class LeetCodeConverter extends AbstractCodeConverter implements CodeConverter {

    /**
     * Converts the <code>input</code> string to <code>E</code> double dimension array.
     *
     * @param input
     * @return
     */
    @Override
    public <E extends Comparable<? super E>> E[][] toArray(String input) {
        return null;
    }

    /**
     * Converts the <code>input</code> string to Integer array.
     * <p>
     * LeetCode 2-d array input usually comes like this: it's a REGULAR rectangle like:
     * <code>[[448,931],[234,889],[214,962],[576,746]]</code>.
     * The expected input for this method is: "[448,931],[234,889],[214,962],[576,746]" i.e. strip off the
     * beginning and ending square brackets, that's it. The output of this method will be a standard Java 2-d array.
     *
     * @param input
     * @return
     */
    @Override
    public Integer[][] toIntArray(String input) {
        String[] arrays = input.split("],\\[");
        int cols = arrays[1].split(",").length;
        Integer[][] result = new Integer[arrays.length][cols];
        for (int i = 0; i < arrays.length; i++) {
            if (i == 0) {
                String str = arrays[i].substring(1);
                String[] parts = str.split(",");
                for (int j = 0; j < parts.length; j++) {
                    result[i][j] = Integer.parseInt(parts[j]);
                }
            } else if (i == arrays.length - 1) {
                String str = arrays[i].substring(0, arrays[i].length() - 1);
                String[] parts = str.split(",");
                for (int j = 0; j < parts.length; j++) {
                    result[i][j] = Integer.parseInt(parts[j]);
                }
            } else {
                String[] parts = arrays[i].split(",");
                for (int j = 0; j < parts.length; j++) {
                    result[i][j] = Integer.parseInt(parts[j]);
                }
            }
        }

        return result;
    }


    /**
     * @param input
     * @return
     */
    public static Integer[][] convertLeetCodeIrregularLengths2DArrayInputIntoJavaArray(String input) {
        /**
         * LeetCode 2-d array input usually comes like this: each row could have different length
         * [[448,931,123,345],[889],[214,962],[576,746,897]]
         * The expected input for this method is: "[448,931,123,345],[889],[214,962],[576,746,897]"
         * i.e. strip off the beginning and ending square brackets, that's it.
         * The output of this method will be a standard Java 2-d array.
         * */
        String[] arrays = input.split("],\\[");
        int maxLen = 0;
        int[] sizes = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            String[] parts = arrays[i].split(",");
            maxLen = Math.max(maxLen, parts.length);
            sizes[i] = parts.length;
        }

        Integer[][] output = new Integer[arrays.length][];
        if (arrays.length == 1) {
            String str = arrays[0].substring(1, arrays[0].length() - 1);
            String[] parts = str.split(",");
            output[0] = new Integer[sizes[0]];
            for (int j = 0; j < sizes[0]; j++) {
                output[0][j] = Integer.parseInt(parts[j]);
            }
        } else {
            for (int i = 0; i < arrays.length; i++) {
                if (i == 0) {
                    String str = arrays[i].substring(1);
                    String[] parts = str.split(",");
                    output[i] = new Integer[sizes[i]];
                    for (int j = 0; j < sizes[i]; j++) {
                        output[i][j] = Integer.parseInt(parts[j]);
                    }
                } else if (i == arrays.length - 1) {
                    String str = arrays[i].substring(0, arrays[i].length() - 1);
                    String[] parts = str.split(",");
                    output[i] = new Integer[sizes[i]];
                    for (int j = 0; j < sizes[i]; j++) {
                        output[i][j] = Integer.parseInt(parts[j]);
                    }
                } else {
                    String[] parts = arrays[i].split(",");
                    output[i] = new Integer[sizes[i]];
                    for (int j = 0; j < sizes[i]; j++) {
                        output[i][j] = Integer.parseInt(parts[j]);
                    }
                }
            }
        }

        return output;
    }

    /**
     * Converts the <code>input</code> string to Integer array.
     * <p>
     * LeetCode 2-d char array usually comes in like <code>["#"," ","#"],[" "," ","#"],["#","c"," "]</code>, which is
     * wrapped in double quotes instead of single quotes which makes it not usable in Java code. This method helps with
     * the conversion.
     *
     * @param input
     * @return
     */
    @Override
    public Character[][] toCharArray(String input) {
        String[] arrays = input.split("],\\[");
        int rows = arrays.length;
        int cols = arrays[1].split(",").length;
        Character[][] result = new Character[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (i == 0) {
                String str = arrays[i].substring(1);
                String[] parts = str.split(",");
                for (int j = 0; j < parts.length; j++) {
                    result[i][j] = parts[j].charAt(1);
                }
            } else if (i == rows - 1) {
                String str = arrays[i].substring(0, arrays[i].length() - 1);
                String[] parts = str.split(",");
                for (int j = 0; j < parts.length; j++) {
                    result[i][j] = parts[j].charAt(1);
                }
            } else {
                String[] parts = arrays[i].split(",");
                for (int j = 0; j < parts.length; j++) {
                    result[i][j] = parts[j].charAt(1);
                }
            }
        }

        return result;
    }

    /**
     * Converts the <code>input</code> string to <code>E</code> list of list.
     *
     * @param input
     * @return
     */
    @Override
    public <E extends Comparable<? super E>> List<E> toList(String input) {
        /**
         * LeetCode 2-d array input usually comes like this: each row could have different length
         * ["A","B","C"]
         * The expected input for this method is: "[\"A\",\"B\",\"C\"]"
         * just copy the LeetCode input: ["A","B","C"] into double quotes in Java,
         * it'll auto escape the double quotes.
         * The output of this method will be a standard Java 1-d array.
         * */
        String[] arrays = input.split(",");
        List<E> result = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            String word;
            if (i == 0) {
                word = arrays[i].substring(1);
            } else if (i == arrays.length - 1) {
                word = arrays[i].substring(0, arrays[i].length() - 1);
            } else {
                word = arrays[i];
            }

            result.add((E) word);
        }

        return result;
    }

    /**
     * Converts the <code>input</code> string to <code>E</code> list of list.
     *
     * @param input
     * @return
     */
    @Override
    public <E extends Comparable<? super E>> List<List<E>> listOfList(String input) {
        /**
         * How to copy LeetCode 2-d String array into this method:
         * 1. remove the beginning and ending quotes;
         * 2. put double quotes into this method parameter;
         * 3. copy the input into the double quotes.
         *
         * LeetCode 2-d array input usually comes like this: each row could have different length
         * [["A","B"],["C"],["B","C"],["D"]]
         * The expected input for this method is: "[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\"]"
         * just copy the LeetCode input: ["A","B"],["C"],["B","C"],["D"] into double quotes in Java,
         * it'll auto escape the double quotes.
         * i.e. strip off the beginning and ending square brackets, that's it.
         * The output of this method will be a standard Java 2-d array.
         * */
        String[] arrays = input.split("],\\[");
        List<List<E>> result = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            List<E> level = new ArrayList<>();
            String[] strings;
            if (i == 0) {
                strings = arrays[i].substring(1).split(",");
            } else if (i == arrays.length - 1) {
                strings = arrays[i].substring(0, arrays[i].length() - 1).split(",");
            } else {
                strings = arrays[i].split(",");
            }
            for (int j = 0; j < strings.length; j++) {
                level.add((E) strings[j]);
            }
            result.add(level);
        }

        return result;
    }

}
