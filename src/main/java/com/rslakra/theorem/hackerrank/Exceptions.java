package com.rslakra.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 01:35:02 PM
 */
public class Exceptions {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String numStr = in.next();
        in.close();

        try {
            System.out.println(Integer.parseInt(numStr));
        } catch (Exception ex) {
            System.out.println("Bad String");
        }
    }

}
