package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

public class UtopianTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cycles = new int[n];
        for (int i = 0; i < cycles.length; i++) {
            cycles[i] = in.nextInt();
        }
        in.close();

        for (int i = 0; i < cycles.length; i++) {
            int treeHeight = 1;
            for (int j = 0; j < cycles[i]; j++) {
                if (j == 0 || j % 2 == 0) {
                    treeHeight *= 2;
                } else {
                    treeHeight += 1;
                }
            }
            System.out.println(treeHeight);
        }
    }

}
