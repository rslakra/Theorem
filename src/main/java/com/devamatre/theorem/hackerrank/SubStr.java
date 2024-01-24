package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:07:37 AM
 */
public class SubStr {

    /**
     * @param str
     * @return
     */
    static String evenChars(String str) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i = i + 2) {
            sBuilder.append(str.charAt(i));
        }

        return sBuilder.toString();
    }

    /**
     * @param str
     * @return
     */
    static String oddChars(String str) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 1; i < str.length(); i = i + 2) {
            sBuilder.append(str.charAt(i));
        }

        return sBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] lines = new String[n];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = in.next();
        }
        in.close();

        for (int i = 0; i < lines.length; i++) {
            System.out.println(evenChars(lines[i]) + "  " + oddChars(lines[i]));
        }
    }

}
