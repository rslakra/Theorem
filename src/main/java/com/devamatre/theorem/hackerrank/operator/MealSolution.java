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
package com.devamatre.theorem.hackerrank.operator;

import java.util.Scanner;

/**
 * ask Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip),
 * and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total
 * cost.
 * <p>
 * Note: Be sure to use precise values for your calculations, or you may end up with an incorrectly rounded result!
 * <p>
 * Input Format:
 * <p>
 * There are lines of numeric input: The first line has a double, (the cost of the meal before tax and tip). The second
 * line has an integer, (the percentage of being added as tip). The third line has an integer, (the percentage of being
 * added as tax).
 * <p>
 * Output Format:
 * <p>
 * Print The total meal cost is totalCost dollars., where is the rounded integer result of the entire bill ( with added
 * tax and tip).
 * <p>
 * Sample Input:</br> 12.00 </br> 20 </br> 8
 * <p>
 * Sample Output:</br> The total meal cost is 15 dollars.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-08-18 06:58:14 PM
 * @since 1.0.0
 */
public class MealSolution {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double mealCost = in.nextDouble();
        int tipPercent = in.nextInt();
        int taxPercent = in.nextInt();
        in.close();

        double totalCost = 0;
        double tip = mealCost * tipPercent / 100;
        double tax = mealCost * taxPercent / 100;
        totalCost = Math.round(mealCost + tax + tip);
        System.out.println("The total meal cost is " + totalCost + " dollars.");

    }

}
