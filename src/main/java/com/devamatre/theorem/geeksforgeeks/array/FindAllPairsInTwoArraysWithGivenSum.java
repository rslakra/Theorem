package com.devamatre.theorem.geeksforgeeks.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Rohtash Lakra
 */
public class FindAllPairsInTwoArraysWithGivenSum {

    public class Pair<K, V> implements Comparable<Pair<K, V>> {

        private final K key;
        private final V value;

        /**
         * @param key
         * @param value
         */
        public Pair(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * @return the key
         */
        public K getKey() {
            return key;
        }

        /**
         * @return the value
         */
        public V getValue() {
            return value;
        }

        /**
         * Returns the hash code of this object.
         *
         * @return
         */
        @Override
        public int hashCode() {
            return (Objects.hash(getKey()) ^ Objects.hash(getValue()));
        }

        /**
         * Returns true if the object is same otherwise false.
         *
         * @param other
         * @return
         */
        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            if (other instanceof Pair) {
                Pair<?, ?> otherPair = (Pair<?, ?>) other;
                return (Objects.equals(getKey(), otherPair.getKey())
                        && Objects.equals(getValue(), otherPair.getValue()));
            }

            return false;
        }

        /**
         * @param other
         */
        @SuppressWarnings("unchecked")
        @Override
        public int compareTo(Pair<K, V> other) {
            int result = ((Comparable<K>) getKey()).compareTo(other.getKey());
            if (result == 0) {
                result = ((Comparable<V>) getValue()).compareTo(other.getValue());
            }

            return result;
        }

        /**
         * Returns the string representation of this object.
         */
        @Override
        public String toString() {
            return (getKey() + " = " + getValue());
        }

    }

    /**
     * @param first
     * @param second
     * @param sum
     * @return
     */
    public TreeSet<Pair<Integer, Integer>> findAllPairsWithGivenSum(int[] first, int[] second, int sum) {
        TreeSet<Pair<Integer, Integer>> allPairs = new TreeSet<>();
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] + second[j] == sum) {
                    allPairs.add(new Pair<Integer, Integer>(first[i], second[j]));
                }
            }
        }

        return allPairs;
    }

    /**
     * @param first
     * @param second
     * @param sum
     * @return
     */
    public TreeSet<Pair<Integer, Integer>> findAllPairsWithSum(int[] first, int[] second, int sum) {
        TreeSet<Pair<Integer, Integer>> allPairs = new TreeSet<>();
        Arrays.sort(second);
        for (int i = 0; i < first.length; i++) {
            int value = sum - first[i];
            if (Arrays.binarySearch(second, value) >= 0) {
                allPairs.add(new Pair<Integer, Integer>(first[i], value));
            }
        }

        return allPairs;
    }

    public static void main(String[] args) {
        FindAllPairsInTwoArraysWithGivenSum findPairs = new FindAllPairsInTwoArraysWithGivenSum();
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        HashMap<Integer, TreeSet<Pair<Integer, Integer>>> results = new HashMap<>();
        for (int index = 0; index < testCases; index++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int sum = input.nextInt();

            // first array
            int[] first = new int[n];
            for (int i = 0; i < n; i++) {
                first[i] = input.nextInt();
            }

            // 2nd array
            int[] second = new int[m];
            for (int i = 0; i < m; i++) {
                second[i] = input.nextInt();
            }

// TreeSet<Pair<Integer, Integer>> allPairs = findPairs.findAllPairsWithGivenSum(first, second, sum);
            TreeSet<Pair<Integer, Integer>> allPairs = findPairs.findAllPairsWithSum(first, second, sum);
            if (allPairs.size() > 0) {
                results.put(index, allPairs);
            }
        }

        for (int index = 0; index < testCases; index++) {
            if (results.containsKey(index)) {
                System.out.println(results.get(index).toString().replace(" = ", " ").replace("[", "").replace("]", ""));
            } else {
                System.out.println(-1);
            }
        }

        input.close();
    }

}
