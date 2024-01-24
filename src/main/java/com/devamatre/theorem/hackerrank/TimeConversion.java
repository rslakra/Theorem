package com.devamatre.theorem.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:08:25 AM
 */
public class TimeConversion {

    /**
     * 19:05:45
     *
     * @param timeString
     * @return
     */
    public static String timeConversion(String timeString) {
        // Complete this function
        if (timeString != null && timeString.trim().length() > 0) {
            Date date = null;
            try {
                date = new SimpleDateFormat("hh:mm:ssa").parse(timeString);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            if (date != null) {
                timeString = new SimpleDateFormat("HH:mm:ss").format(date);
            }
        }

        return timeString;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        // 07:05:45PM
        String timeString = scanner.next();
        scanner.close();
        String result = timeConversion(timeString);
        System.out.println(result);

    }

}
