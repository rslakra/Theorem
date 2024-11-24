package com.rslakra.theorem.hackerrank;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LeaderBoard {

    /**
     * TODO: NEED OPTIMIZATION. DOES NOT PASS ALL TESTCASES.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        final Comparator<Integer> descSorter = new Comparator<Integer>() {

            @Override
            public int compare(Integer newValue, Integer oldValue) {
                return (oldValue - newValue);
            }
        };

        // your code goes here
        Set<Integer> ranks = new TreeSet<Integer>(descSorter);
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
            ranks.add(scores[i]);
        }

        int m = in.nextInt();
        int[] alice = new int[m];
        for (int i = 0; i < m; i++) {
            alice[i] = in.nextInt();
        }
        in.close();

        Integer[] uniqueScores = ranks.toArray(new Integer[0]);
        int rank = 0;
        int lastIndex = uniqueScores.length - 1;
        for (int j = 0; j < alice.length; j++) {
            for (int k = lastIndex; k >= 0; k--) {
                if (uniqueScores[k] > alice[j]) {
                    rank = (lastIndex == uniqueScores.length - 1 ? uniqueScores.length : lastIndex) + 1;
                    break;
                } else if (uniqueScores[k] == alice[j]) {
                    rank = k + 1;
                    break;
                }
                rank = k;
                lastIndex = k;
            }

            if (rank == 0) {
                rank++;
            }
            System.out.println(rank);
        }
    }
}
