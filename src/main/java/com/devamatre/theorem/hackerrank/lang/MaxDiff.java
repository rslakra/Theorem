package com.devamatre.theorem.hackerrank.lang;

import java.util.Scanner;

public class MaxDiff {

    static int maxDiff(int[] arr) {
        int maxDiff = -1;
        // max element from right side
        int maxRight = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                maxRight = arr[i];
            } else {
                int diff = maxRight - arr[i];
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        System.out.println(maxDiff(arr));
    }

}
