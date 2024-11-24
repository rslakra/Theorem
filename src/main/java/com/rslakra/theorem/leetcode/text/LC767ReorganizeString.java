package com.rslakra.theorem.leetcode.text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Rohtash Lakra
 * @created 11/1/23 5:01 PM
 */
public class LC767ReorganizeString {

    // # 1. Approach Brute Force Approach (Works but get TLE (Time Limit Exceeded)
    private static class ValueComparator implements Comparator<Map.Entry<Character, Integer>> {

        /**
         * Time Complexity: O(N Log N)
         * <p>
         * Space Complexity: O(N)
         *
         * @param left  the first object to be compared.
         * @param right the second object to be compared.
         * @return
         */
        public int compare(Map.Entry<Character, Integer> left, Map.Entry<Character, Integer> right) {
            int result = right.getValue() - left.getValue();
            // make sure the same value doesn't override the key/value pair.
            if (result == 0) {
                // keep same values in natural order of input keys
                result = left.getKey() - right.getKey();
            }

            return result;
        }
    }

    /**
     * Time Complexity: O(K Log K) - K unique entry of characters
     * <p>
     * Space Complexity: O(K) - K unique characters
     *
     * @param input
     * @return
     */
    private Map<Character, Integer> sortByValue(Map<Character, Integer> input) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(input.entrySet());
        // sort map by value count
        list.sort(new ValueComparator());
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    /**
     * Time Complexity: O(K Log K) - K unique entry of characters
     * <p>
     * Space Complexity: O(K) - K unique characters
     *
     * @param input
     * @return
     */
    private LinkedList<Map.Entry<Character, Integer>> sortByValueBuildLinkedList(Map<Character, Integer> input) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(input.entrySet());
        // sort map by value count
        list.sort(new ValueComparator());
        final LinkedList<Map.Entry<Character, Integer>> result = new LinkedList<>();
        list.forEach(entry -> result.add(entry));
        return result;
    }

    /**
     * Time Complexity: O(1) *
     *
     * @param cChars
     * @param index
     * @param entry
     * @return
     */
    boolean isSameChar(char[] cChars, int index, Map.Entry<Character, Integer> entry) {
        if (index == cChars.length - 1 && cChars[index - 1] == entry.getKey()) {
            return true;
        } else {
            return ((index > 0 && index < cChars.length - 1) && (cChars[index - 1] == entry.getKey()
                                                                 || cChars[index + 1] == entry.getKey()));
        }
    }

    /**
     * Time Complexity: O(K Log K) - K unique entry of characters
     * <p>
     * Space Complexity: O(K) - K unique characters
     *
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        if (s == null || s.isEmpty() || (s.length() == 2 && s.charAt(0) == s.charAt(1))) {
            return "";
        }

        // O(N)
        char[] cChars = new char[s.length()];
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        // O(N log N)
        boolean nextEntry = false;
        LinkedList<Map.Entry<Character, Integer>> list = sortByValueBuildLinkedList(counts);

        // O(K) * O(N)
        while (!list.isEmpty()) {
            nextEntry = false;
            Map.Entry<Character, Integer> entry = list.removeFirst();
            int index = 0;
            while (index < cChars.length && entry != null) {
                // remove if frequency is zero
                if (entry.getValue() == 0) {
                    if (index < cChars.length && !list.isEmpty()) {
                        //get next entry to fill the remaining holes
                        entry = list.getFirst();
                        nextEntry = true;
                        continue;
                    }
                    break;
                }

                if (cChars[index] == '\u0000' && !isSameChar(cChars, index, entry)) {
                    cChars[index++] = entry.getKey();
                    entry.setValue(entry.getValue() - 1);
                }

                index++;
            }

            // if still have remaining entries, it's a recursion so break it here
            if (!nextEntry && entry.getValue() > 0) {
                return "";
            }
        }

        if (list.size() > 0) {
            return "";
        }

        return new String(cChars);
    }

    //  2. Approach - Heap

    /**
     * Time Complexity: O(K Log K) - K unique entry of characters
     * <p>
     * Space Complexity: O(K) - K unique characters
     *
     * @param input
     * @return
     */
    public String reorganizeStringWithHeap(String input) {
        // O(N)
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // build maxHeap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((left, right) -> freqMap.get(right) - freqMap.get(left));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder res = new StringBuilder();
        while (maxHeap.size() >= 2) {
            char char1 = maxHeap.poll();
            char char2 = maxHeap.poll();

            res.append(char1);
            res.append(char2);

            freqMap.put(char1, freqMap.get(char1) - 1);
            freqMap.put(char2, freqMap.get(char2) - 1);

            if (freqMap.get(char1) > 0) {
                maxHeap.add(char1);
            }

            if (freqMap.get(char2) > 0) {
                maxHeap.add(char2);
            }
        }

        // handle single character
        if (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            if (freqMap.get(ch) > 1) {
                return "";
            }
            res.append(ch);
        }

        System.out.println(res.toString());
        return res.toString();
    }
}
