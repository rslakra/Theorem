/**
 *
 */
package com.rslakra.theorem.algos.lang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 22, 2019 10:14:14 AM
 */
public class Fibonacci {

    /**
     * Time Complexity: O(N)
     * <p>
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    public int getNFib(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int next = 0;
        for (int i = 2; i < n; i++) {
            next = first + second;
            first = second;
            second = next;
        }

        return next;
    }

    /**
     * @param arr
     * @param n
     * @return
     */
    private int getNFibMemoized(int[] arr, int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        if (arr[n] > 1) {
            return arr[n];
        } else {
            arr[n] = getNFibMemoized(arr, n - 1) + getNFibMemoized(arr, n - 2);
            return arr[n];
        }
    }

    /**
     * Time Complexity: O(N)
     * <p>
     * Space Complexity: O(N)
     *
     * @param n
     * @return
     */
    public int getNFibMemoized(int n) {
        return getNFibMemoized(new int[n + 1], n);
    }

    /**
     * Time Complexity: O(2 ^ N)
     * <p>
     * Space Complexity: O(N)
     *
     * @param n
     * @return
     */
    public int getNFibRecursion(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        return getNFibRecursion(n - 1) + getNFibRecursion(n - 2);
    }

    /**
     * @param n
     */
    public void printNFib(int n) {
        if (n <= 1) {
            System.out.println("0");
        }

        int first = 0;
        int second = 1;
        System.out.println("1");
        int next = 0;
        for (int i = 1; i < n; i++) {
            next = first + second;
            System.out.println(next);
            first = second;
            second = next;
        }
    }

    /**
     * @param n
     */
    public void printNFibSeries(int n) {
        int prev = 0;
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                System.out.println(i);
            } else {
                result += prev;
                System.out.println(result);
                prev = result - prev;
            }
        }
    }


    private final Map<Integer, Integer> cache = new HashMap<>();

    /**
     * Time Complexity: O(N) Space Complexity: O(N)
     *
     * @param n
     * @return
     */
    public int getNthFibonacciNumberTopDown(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        cache.put(n, getNthFibonacciNumberTopDown(n - 1) + getNthFibonacciNumberTopDown(n - 2));

        return cache.get(n);
    }


    /**
     * Time Complexity: O(N) Space Complexity: O(N)
     *
     * @param n
     * @return
     */
    public int getNthFibonacciNumberBottomUp(int n) {
        int[] mem = new int[n];
        mem[0] = mem[1] = 1;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        System.out.println(Arrays.toString(mem));
        return mem[n - 1];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.getNFib(i) + " " + obj.getNFibRecursion(i) + " " + obj.getNFibMemoized(i));
        }

        System.out.println();
        obj.printNFib(5);
        obj.printNFibSeries(10);
        int n = 6;
        System.out.println("n:" + obj.getNthFibonacciNumberTopDown(n));
        System.out.println(obj.cache);
        System.out.println("n:" + obj.getNthFibonacciNumberBottomUp(n));
    }

}
