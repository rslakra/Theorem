/**
 *
 */
package com.rslakra.theorem.algos.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Rohtash Lakra
 */
public class FindElement {

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }

        int[] temp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int index = A[i] - 1;
            if (index >= 0 && index < A.length) {
                temp[index] = A[i];
            }
        }

        int digit = 1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == digit) {
                digit++;
            }
        }

        return digit;
    }

    /**
     * @param n
     * @return
     */
    public static int func(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + func(n / 2);
    }

    /**
     * @param arr
     * @param k
     * @return
     */
    public static int findKthLargestElement(int[] arr, int k) {
        SortedSet<Integer> sSet = Collections.synchronizedSortedSet(new TreeSet<>());
        for (int i = 0; i < arr.length; i++) {
            sSet.add(arr[i]);
            if (sSet.size() > k) {
                sSet.remove(sSet.first());
            }
        }

        System.out.println(sSet);
        return sSet.first();
    }

    /**
     * @param arr
     * @param k
     * @return
     */
    public static int findKthSmallestElement(int[] arr, int k) {
        SortedSet<Integer> sSet = Collections.synchronizedSortedSet(new TreeSet<>());
        for (int i = 0; i < arr.length; i++) {
            sSet.add(arr[i]);
            if (sSet.size() > k) {
                sSet.remove(sSet.last());
            }
        }

        System.out.println(sSet);
        return sSet.last();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] temp = new int[]{1, 3, 6, 4, 1, 2};
        temp = new int[]{-1, -3};
        System.out.println(solution(temp));
        // System.out.println(func(4));

        Collection<Integer> list = new ArrayList<>();
        Optional<Integer> optional = Optional.empty();
        // optional.get();
        list.forEach(a -> System.out.println(a));

        temp = new int[]{1, 3, 4, 2, 2};
        int k = 3;
        System.out.println("Kth largest element:" + findKthLargestElement(temp, k));
        System.out.println("Kth smallest element:" + findKthSmallestElement(temp, k));

        int low = 0;
        int high = 10;
        while (low < high) {
            int mid = (low + high) >>> 1;
            System.out.println("low:" + low + ", high:" + high + ", mid:" + mid);
            high = mid;
        }

    }

}
