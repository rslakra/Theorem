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

import java.util.Scanner;

/**
 * Sam's house has an apple tree and an orange tree that yield an abundance of fruit. In the diagram below, the red
 * region denotes his house, where is the start point and is the end point. The apple tree is to the left of his house,
 * and the orange tree is to its right. You can assume the trees are located on a single point, where the apple tree is
 * at point and the orange tree is at point .
 * <p>
 * Apple and orange(2).png
 * <p>
 * When a fruit falls from its tree, it lands units of distance from its tree of origin along the -axis. A negative
 * value of means the fruit fell units to the tree's left, and a positive value of means it falls units to the tree's
 * right.
 * <p>
 * Given the value of for apples and oranges, can you determine how many apples and oranges will fall on Sam's house
 * (i.e., in the inclusive range )? Print the number of apples that fall on Sam's house as your first line of output,
 * then print the number of oranges that fall on Sam's house as your second line of output.
 * <p>
 * Input Format
 * <p>
 * The first line contains two space-separated integers denoting the respective values of and . The second line contains
 * two space-separated integers denoting the respective values of and . The third line contains two space-separated
 * integers denoting the respective values of and . The fourth line contains space-separated integers denoting the
 * respective distances that each apple falls from point . The fifth line contains space-separated integers denoting the
 * respective distances that each orange falls from point .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print two lines of output:
 * <p>
 * On the first line, print the number of apples that fall on Sam's house. On the second line, print the number of
 * oranges that fall on Sam's house.
 * <p>
 * Sample Input 0
 * <p>
 * 7 11 5 15 3 2 -2 2 1 5 -6
 * <p>
 * Sample Output 0
 * <p>
 * 1 1
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-08-18 07:24:44 PM
 * @since 1.0.0
 */
public class AppleAndOrange {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // s
        int houseStartPoint = in.nextInt();
        // t
        int houseEndPoint = in.nextInt();

        // a
        int appleTreePoint = in.nextInt();
        // b
        int orangeTreePoint = in.nextInt();

        // fruit distance from tree where negative represents left side and
        // positive represents right side.
        // m
        int noOfApples = in.nextInt();
        // n
        int noOfOranges = in.nextInt();

        // apples
        int[] appleCount = new int[noOfApples];
        for (int i = 0; i < appleCount.length; i++) {
            appleCount[i] = in.nextInt();
        }

        // oranges
        int[] orangeCount = new int[noOfOranges];
        for (int i = 0; i < orangeCount.length; i++) {
            orangeCount[i] = in.nextInt();
        }
        in.close();

        int totalApplesFall = 0;
        for (int i = 0; i < appleCount.length; i++) {
            int result = appleTreePoint + appleCount[i];
            if (result >= houseStartPoint && result <= houseEndPoint) {
                totalApplesFall++;
            }
        }

        int totalOrangesFall = 0;
        for (int i = 0; i < orangeCount.length; i++) {
            int result = orangeTreePoint + orangeCount[i];
            if (result >= houseStartPoint && result <= houseEndPoint) {
                totalOrangesFall++;
            }
        }

        // output
        System.out.println(totalApplesFall);
        System.out.println(totalOrangesFall);
    }

}
