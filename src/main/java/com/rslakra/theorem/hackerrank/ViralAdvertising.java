package com.rslakra.theorem.hackerrank;

import java.util.Scanner;

public class ViralAdvertising {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        int received = 5;
        int liked = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                received = (int) Math.floor(received / 2) * 3;
                liked += (int) Math.floor(received / 2);
            } else {
                liked = (int) Math.floor(received / 2);
            }
        }
        System.out.println(liked);
    }

}
