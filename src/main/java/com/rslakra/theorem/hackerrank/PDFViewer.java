package com.rslakra.theorem.hackerrank;

import java.util.Scanner;

public class PDFViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] alphaHeights = new int[26];
        for (int i = 0; i < 26; i++) {
            alphaHeights[i] = in.nextInt();
        }

        String word = in.next();
        in.close();
        int totalArea = 0;
        int tallestLetter = 0;
        if (word != null && word.length() <= 10) {
            for (int i = 0; i < word.length(); i++) {
                int index = ((int) word.charAt(i) - 97);
                if (alphaHeights[index] > tallestLetter) {
                    tallestLetter = alphaHeights[index];
                }
            }

            totalArea = tallestLetter * word.length();
        }

        System.out.println(totalArea);
    }

}
