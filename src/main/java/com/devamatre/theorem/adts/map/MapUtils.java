package com.devamatre.theorem.adts.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 9/19/23 3:08 PM
 */
public enum MapUtils {
    INSTANCE;

    /**
     * @param <K>
     * @param <V>
     */
    private static class KeyComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
        implements Comparator<Map.Entry<K, V>> {

        /**
         * Sort by value.
         */
        @Override
        public int compare(Map.Entry<K, V> left, Map.Entry<K, V> right) {
            return left.getKey().compareTo(right.getKey());
        }
    }

    /**
     * @param <K>
     * @param <V>
     */
    private static class ValueComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
        implements Comparator<Map.Entry<K, V>> {

        /**
         * Compare by value.
         *
         * @param left  the first object to be compared.
         * @param right the second object to be compared.
         * @return
         */
        @Override
        public int compare(Map.Entry<K, V> left, Map.Entry<K, V> right) {
            int result = left.getValue().compareTo(right.getValue());
            // values might be same and can override the key
            if (result == 0) {
                result = left.getKey().compareTo(right.getKey());
            }

            return result;
        }
    }

    /**
     * Returns the <code>LinkedHashMap</code> of the <code>entries</code>.
     *
     * @param entries
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> asLinkedHashMap(
        List<Map.Entry<K, V>> entries) {
        Map<K, V> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entries) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        return linkedHashMap;
    }

    /**
     * Sorts the map by value.
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByKey(
        Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        entries.sort(new KeyComparator<>());
        return asLinkedHashMap(entries);
    }

    /**
     * Sorts the map by value.
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByValue(
        Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        // entries.sort(Map.Entry.comparingByValue());
        entries.sort(new ValueComparator<>());
        // Stream<Map.Entry<K,V>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        return asLinkedHashMap(entries);
    }

    /**
     * Returns the map of the <code>Map<Integer, Character></code> index and character.
     *
     * @return
     */
    public static Map<Integer, Character> getCharIndexes() {
        Map<Integer, Character> charIndexes = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            charIndexes.put(i, (char) i);
        }

        return charIndexes;
    }

}
