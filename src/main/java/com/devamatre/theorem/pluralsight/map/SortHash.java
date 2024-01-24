/**
 *
 */
package com.devamatre.theorem.pluralsight.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Rohtash Lakra
 */
public class SortHash {

    private Map<String, Integer> map;

    public SortHash() {
        map = new HashMap<>();
    }

    /**
     * Fills the map with default values.
     */
    public void fillMap() {
        // enter data into hashmap
        map.put("Math", 98);
        map.put("Data Structure", 85);
        map.put("Database", 91);
        map.put("Java", 95);
        map.put("Operating System", 79);
        map.put("Networking", 80);
    }

    /**
     * Returns the cloned map.
     *
     * @return
     */
    public Map<String, Integer> getClonedMap() {
        return new HashMap<>(map);
    }

    /**
     * @author Rohtash Lakra
     */
    static class SortByKeyComparator implements Comparator<Map.Entry<String, Integer>> {

        /**
         *
         */
        @Override
        public int compare(Entry<String, Integer> left, Entry<String, Integer> right) {
            return left.getKey().compareTo(right.getKey());
        }

    }

    /**
     * @author Rohtash Lakra
     */
    static class SortByValueComparator implements Comparator<Map.Entry<String, Integer>> {

        /**
         *
         */
        @Override
        public int compare(Entry<String, Integer> left, Entry<String, Integer> right) {
            return left.getValue().compareTo(right.getValue());
        }
    }

    /**
     * Converts the list into map.
     *
     * @param list
     * @return
     */
    public Map<String, Integer> toMap(List<Map.Entry<String, Integer>> list) {
        Map<String, Integer> sortedMap = null;

        if (list != null) {
            sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : list) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        return sortedMap;
    }

    /**
     * Sorts the map by keys.
     *
     * @param map
     * @return
     */
    public Map<String, Integer> sortByKey(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new SortByKeyComparator());
        return toMap(list);
    }

    /**
     * Sorts the map by values.
     *
     * @param map
     * @return
     */
    public Map<String, Integer> sortByValues(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new SortByValueComparator());
        return toMap(list);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SortHash sortHash = new SortHash();
        sortHash.fillMap();
        System.out.println("Map:");
        System.out.println(sortHash.getClonedMap());
        System.out.println("Sorted By Key:");
        System.out.println(sortHash.sortByKey(sortHash.getClonedMap()));
        System.out.println("Sorted By Value:");
        System.out.println(sortHash.sortByValues(sortHash.getClonedMap()));
    }

}
