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

import com.rslakra.theorem.hackerrank.Utils;

import java.util.Scanner;

/**
 * All of the posted solutions require pre-computing all eight magic squares. I wanted to offer a few suggestions on how
 * to generate them -- or at least show what I did.
 * <p>
 * We can start with two observations: a) the "middle" of any 3x3 magic square must be 5, and b) the "magic sum" must be
 * 15.
 * <p>
 * Here's a way to think about the "magic sum". The sum of numbers 1-9 is 45. The three horizontal rows will include all
 * 9 numbers (and thus sum to 45). And since there are three rows, each row will sum to 45/3 = 15.
 * <p>
 * It takes a bit of pen and paper to see that the middle must be 5 (or at least, it took me some trial and error). But
 * once we know these two things, we can think in terms of the 4 "pairs" that can go on opposite sides of the 5:
 *
 * <code>
 * 1 and 9 2 and 8 3 and 7 4 and 6
 * </code>
 * <p>
 * So for example, if 4 goes Top/Left, we know that 6 must go Bottom/Right (since the "magic sum" must be 15, and 5 is
 * in the middle)
 * <p>
 * A bit more on pen/paper will show that only two of these pairs fit in the "corners":
 *
 * <code>
 * 2 and 8 4 and 6
 * </code>
 * <p>
 * The other two pairs must be "wedged" inside the corner paris (e.g., top middle, bottom middle). And once we set our
 * four corners, there is only 1 way to place the rest of the numbers.
 * <p>
 * This is enough to show that there are 8 magic matrices. There are 4 possible ways to place the 4 and 6 pair (the 4
 * could go in Top/Left, Top/Right, Bottom/Right, Bottom/Left). Then once we place the 4 and 6, there are two different
 * ways we could place the 2 and 8.
 * <p>
 * To acutally generate these matrices, I started with one "seed" (which happend to be the first magic matrix I found):
 *
 * <code>
 * [4 3 8] [9 5 1] [2 7 6]
 * </code>
 * <p>
 * From ths seed, we can rotate it clockwise 4 times (so the 4 appears in each corner). And then from each rotation, we
 * can place the remaining digits either clockwise, or counterclockwise around the 5 (going counterclockwise is
 * equivalent to getting the "mirror" of the matrix along a diagonal).
 * <p>
 * These two matrix manipulations are also great helper functions to have handy on other problems.
 * <p>
 * <p>
 * ============================================================================
 * <p>
 * The 8 valid combinations of 3 numbers that add to 15 are:
 *
 * <code>
 * 9 5 1 7 5 3 2 5 8 4 5 6 2 9 4 6 1 8 6 7 2 8 3 4
 * </code>
 * <p>
 * All 8 of those combinations need to appear in the square as a row, column or diagonal. The centre cell must appear in
 * the middle row, middle column and both diagonals. So it must be a number that appears four times, and the only digit
 * that does is 5. So 5 must be the centre.
 * <p>
 * Similarly, each of the corner pieces must form part of a row, a column and a diagonal. So each corner cell must be a
 * number that appears 3 times. Those are the even numbers 2, 4, 6 and 8. That means the diagonals must be "2 5 8" and
 * "4 5 6" <code> 2 _ 4 _ 5 _ 6 _ 8
 * </code>
 * <p>
 * That leaves the middle edge cells, each of which needs to appear in a row and a column. These are the odd numbers 1,
 * 3, 7 and 9. So the middle row and column must be "9 5 1" and "7 5 3". Just insert these into the above such that the
 * rows and columns add up correctly, leaving you with: <code> 2 9 4 7 5 3 6 1 8
 * </code>
 * <p>
 * From that you can take the mirror images (horizontally and vertically) and the rotation of each.
 * <p>
 * Mirror images:
 *
 * <code>
 * 4 9 2 | 2 9 4 3 5 7 | 7 5 3 8 1 6 | 6 1 8 ------------- 8 1 6 | 6 1 8 3 5 7 | 7 5 3 4 9 2 | 2 9 4
 * </code>
 * <p>
 * Rotations:
 *
 * <code>
 * 8 3 4 | 4 3 8 1 5 9 | 9 5 1 6 7 2 | 2 7 6 ------------- 6 7 2 | 2 7 6 1 5 9 | 9 5 1 8 3 4 | 4 3 8
 * </code>
 * <p>
 * <p>
 * ============================================================================ I approached this problem by first
 * identifying all the different 3x3 magic squares.
 * <p>
 * Demonstrate that all 3x3 magic squares have a 5 in the center
 * <p>
 * Let's call the center value 'C'. Let's call the sum of all other values 'Others'.
 * <p>
 * A 3x3 magic square contains all numbers from 1 to 9. So the sum of the values of a 3x3 magic square is 45 (= 1 + 2 +
 * ... + 8 + 9).
 * <p>
 * Therefore,
 * <p>
 * C + Others = 45 (eq. 1)
 * <p>
 * In addition, the sum of the numbers on each row, column, and diagonal has to be 15 (the magical number). Now,
 * consider the sum of the middle row, the middle column, and the two diagonals. They add to 60 (= 4 * 15). And this sum
 * is equivalent to adding all the numbers in the square once and four times the central number.
 * <p>
 * Therefore,
 * <p>
 * 4 * C + Others = 60 (eq. 2)
 * <p>
 * From equations 1 and 2, we infer C = 5. Hence, all 3x3 magic squares have a 5 in the center.
 * <p>
 * Desmonstrate that corner values are always even numbers
 * <p>
 * Since we necessarily have a 5 in the center, it follows that each row, column, and diagonal that comprises this five
 * will have two other numbers that add to 10. Hence we can establish candidate pairs:
 * <p>
 * (1, 9) (2, 8) (3, 7) (4, 6)
 * <p>
 * Notice that two of these pairs have odd numbers and two have even numbers.
 * <p>
 * Imagine we place one of the odd pairs on a diagonal. We would then have an odd number in one of the top corners.
 * Consider the first row (starting from the top). Since it alreay has an odd number in a corner, and the row has to sum
 * to 15, the two other numbers both need to be odd, or both even. But we don't have enough odd pairs (we only have one
 * left). And neither do we have enough even pairs, because if we place two of these vertically, then we have none left
 * for the column containing the odd corner number. Hence, we reach a contradiction. This implies that our original
 * hypothesis was incorrect. Namely, the corner numbers can't be odd, and therefore, should be even.
 * <p>
 * Since we have two even pairs, there are 4 ways to place the first pair in the corners (for example, the (2, 8) pair
 * can be placed with the 2 in the top-left, top-right, bottom-left, bottom-right). And for each of those 4 positions,
 * there are two ways to place the second pair. Hence, 8 in total.
 * <p>
 * Once the corner pairs have been placed, there is only one way to place the remaining numbers.
 * <p>
 * Therefore, we have demonstrated that there are 8 different 3x3 magic squares. And we know how to generate them.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-03 06:30:52 PM
 * @since 1.0.0
 */
public class MagicSquare {

    /**
     * magic constant m = n(n^2 + 1)/2 so for a 3X3 magic square m = 3(3^2 + 1)/2 = 15
     *
     * @param n
     * @return
     */
    static int magixConstant(int n) {
        return (n * ((int) Math.pow(n, 2) + 1) / 2);
    }

    static int sumRow(int[][] matrix, int row) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[row][i];
        }
        return sum;
    }

    static int sumColumn(int[][] matrix, int column) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][column];
        }
        return sum;
    }

    static int sumDiagonal(int[][] matrix, boolean isTopDown) {
        int sum = 0;
        if (isTopDown) {
            for (int i = 0, j = 0; i < matrix.length; i++, j++) {
                sum += matrix[i][j];
            }
        } else {
            for (int i = 0, j = matrix.length - 1; i != j; i++, j--) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        in.close();
        // Print the minimum cost of converting 's' into a magic square

        for (int i = 0; i < matrix.length; i++) {
            int rowSum = sumRow(matrix, i);
            int colSum = sumColumn(matrix, i);
            int digSum = sumDiagonal(matrix, true);
            int sumDig = sumDiagonal(matrix, false);
            if ((rowSum == colSum) != (digSum == sumDig)) {

            }
        }

        Utils.println(matrix);
    }

}
