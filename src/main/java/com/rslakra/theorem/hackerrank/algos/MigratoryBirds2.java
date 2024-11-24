package com.rslakra.theorem.hackerrank.algos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 02:59:38 PM
 */
public class MigratoryBirds2 {

    static class ArrayComparator implements Comparator<int[]> {

        /**
         * @param o1
         * @param o2
         * @return
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o2[1] == o1[1] ? 0 : o2[1] > o1[1] ? 1 : -1);
        }
    }

    static int migratoryBirds(int n, int[] ar) {
        int mostCommonBirds = 0;
        int[][] birdTypes = new int[5][2];
        for (int i = 0; i < ar.length; i++) {
            birdTypes[ar[i] - 1][0] = ar[i];
            birdTypes[ar[i] - 1][1] = ++birdTypes[ar[i] - 1][1];
        }

        Arrays.sort(birdTypes, new ArrayComparator());
        mostCommonBirds = birdTypes[0][0];

        return mostCommonBirds;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }

}
