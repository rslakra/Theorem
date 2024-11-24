package com.rslakra.theorem.hackerrank.text;

import java.util.Scanner;

public class FindAnagrams {

    public static int numberNeeded(String first, String second) {
        int numbers = 0;
        if (first != null && second != null) {
            int[] counts = new int[26];
            int ctr = 0;
            int cChar = 'a';
            for (int i = 0; i < first.length(); i++) {
                ctr = ((int) first.charAt(i) - cChar);
                counts[ctr]++;
            }

            for (int i = 0; i < second.length(); i++) {
                ctr = ((int) second.charAt(i) - cChar);
                counts[ctr]--;

            }

            for (int i = 0; i < counts.length; i++) {
                numbers += Math.abs(counts[i]);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        System.out.println(numberNeeded(a, b));
    }

}
