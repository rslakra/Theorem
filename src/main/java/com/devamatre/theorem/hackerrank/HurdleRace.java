package com.devamatre.theorem.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class HurdleRace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        in.close();
        // your code goes here

        Arrays.sort(height);
        int magicBeverages = (height[height.length - 1] - k);
        System.out.println((magicBeverages > 0 ? magicBeverages : 0));
    }
}
