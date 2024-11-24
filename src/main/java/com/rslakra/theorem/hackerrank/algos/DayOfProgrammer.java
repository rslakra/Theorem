/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.theorem.hackerrank.algos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-01 05:30:54 PM
 * @since 1.0.0
 */
public class DayOfProgrammer {

    /**
     * @param year
     * @param useJulianCalendar
     * @return
     */
    static boolean isLeapYear(int year, boolean useJulianCalendar) {
        return (useJulianCalendar ? (year % 4 == 0) : ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0));
    }

    static String solve(int year) {
        // Complete this function
        if (year > 1700 || year < 2700) {
            // Complete this function
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
            int dayFebruary = 28;
            if (year < 1918 && isLeapYear(year, true)) {
                dayFebruary = 29;
            } else if (year > 1918 && isLeapYear(year, false)) {
                dayFebruary = 29;
            } else if (year == 1918) {
                dayFebruary = 15;
            }
            int days = 256 - (215 + dayFebruary);
            cal.set(Calendar.DAY_OF_MONTH, days);
            return new SimpleDateFormat("dd.MM.yyyy").format(cal.getTime());
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        in.close();
        String result = solve(year);
        System.out.println(result);
    }

}
