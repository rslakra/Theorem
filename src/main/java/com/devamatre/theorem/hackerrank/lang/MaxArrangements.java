package com.devamatre.theorem.hackerrank.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxArrangements {

    public static void main(String[] args) {
        System.out.println("Enter number (1-20) ");
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        System.out.println(arrangements(n));
        sc.close();
    }

    static int arrangements(int n) {
        int count = 0;
        if (n > 1) {
            final List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }
            count = findArrangement(1, numbers, n, count);
        }
        return count;
    }

    public static int findArrangement(final int index, final List<Integer> numbers, final int number, int count) {
        for (int i = 0; i < numbers.size(); i++) {
            int value = numbers.get(i);
            if (value % index == 0 || index % value == 0) {
                final List<Integer> remains = new ArrayList<>(numbers);
                remains.remove(numbers.get(i));
                if (index < number) {
                    count = findArrangement(index + 1, remains, number, count);
                } else {
                    count++;
                }
            }
        }

        return count;
    }

}
