package com.devamatre.theorem.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 09/21/2017 04:06:05 PM
 */
public class RegExp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> emails = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String firstName = in.next();
            String email = in.next();
            if (firstName.length() <= 20 && email.length() <= 50) {
                if (email.endsWith("@gmail.com")) {
                    emails.add(firstName);
                }
            }
        }
        in.close();
        Collections.sort(emails);

        for (String firstName : emails) {
            System.out.println(firstName);
        }
    }

}
