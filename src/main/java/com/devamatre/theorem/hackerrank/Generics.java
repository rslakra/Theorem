package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

class Printer<T> {

    /**
     * Method Name: printArray Print each element of the generic array on a new line. Do not return anything.
     *
     * @param A generic array
     **/

    // Write your code here
    public void printArray(T[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

}

public class Generics {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = in.nextInt();
        }

        n = in.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = in.next();
        }
        in.close();

        Printer<Integer> intPrinter = new Printer<Integer>();
        Printer<String> stringPrinter = new Printer<String>();
        intPrinter.printArray(intArray);
        stringPrinter.printArray(stringArray);
        if (Printer.class.getDeclaredMethods().length > 1) {
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
    }
}
