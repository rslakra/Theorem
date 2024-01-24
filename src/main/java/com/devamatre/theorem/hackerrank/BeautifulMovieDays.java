package com.devamatre.theorem.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BeautifulMovieDays {

    static boolean isBeautiful(int x, int reversed, int k) {
        return (Math.abs(x - reversed) % k == 0);
    }

    static int reverse(int x) {
        Queue<Integer> digits = new LinkedList<Integer>();
        while (x != 0) {
            int rem = x % 10;
            digits.add(rem);
            x = x / 10;
        }

        StringBuilder sBuilder = new StringBuilder();
        while (!digits.isEmpty()) {
            sBuilder.append(digits.remove());
        }
        return Integer.parseInt(sBuilder.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        in.close();

        int days = 0;
        for (int index = i; index <= j; index++) {
            if (isBeautiful(index, reverse(index), k)) {
                days++;
            }
        }
        System.out.println(days);

    }

}
