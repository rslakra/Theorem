package com.devamatre.theorem.algos.lang;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Design a system to return the number with the max occurrences
 * <p>
 * PUSH POP
 * <p>
 * Example : PUSH(1) PUSH(2) PUSH(1)
 * <p>
 * POP() - should return 1 POP() - 1/2 POP() -
 *
 * @author Rohtash Lakra
 */
public class MaxOccurances {

    static class Node {

        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    /**
     * @author Rohtash Lakra
     */
    static class SortByValueComparator implements Comparator<Map.Entry<Integer, Node>> {

        /**
         *
         */
        @Override
        public int compare(Entry<Integer, Node> left, Entry<Integer, Node> right) {
            return right.getValue().value - left.getValue().value;
        }
    }

    /**
     * Sorts the map by values.
     *
     * @param map
     * @return
     */
    private void sortByValues() {
        List<Map.Entry<Integer, Node>> list = new LinkedList<>(heap.entrySet());
        Collections.sort(list, new SortByValueComparator());

        if (list != null) {
            heap = new LinkedHashMap<>();
            for (Map.Entry<Integer, Node> entry : list) {
                heap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private Map<Integer, Node> heap = new TreeMap<Integer, Node>();

    public void push(int key) {
        Node node = new Node(key, 1);
        if (heap.containsKey(key)) {
            node = heap.get(key);
            node.value++;
        }

        heap.put(key, node);
        sortByValues();
    }

    public int pop() {
        Node node = heap.values().iterator().next();
        if (node.value > 1) {
            node.value--;
            heap.put(node.key, node);
        } else {
            heap.remove(node);
        }
        sortByValues();

        return node.key;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // After Push
        MaxOccurances maxOccurances = new MaxOccurances();
        maxOccurances.push(1);
        maxOccurances.push(2);
        maxOccurances.push(1);
        maxOccurances.push(3);
        maxOccurances.push(1);
        maxOccurances.push(5);
        maxOccurances.push(5);
        maxOccurances.push(5);
        maxOccurances.push(5);
        maxOccurances.push(5);
        maxOccurances.push(5);
        System.out.println(maxOccurances);

        // After Pop
        System.out.println(maxOccurances.pop());
        System.out.println(maxOccurances);
    }

}
