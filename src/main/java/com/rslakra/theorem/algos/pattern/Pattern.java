package com.rslakra.theorem.algos.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 12/08/2023 10:36 PM
 * @since 1.0.0
 */
public class Pattern {

    private static final Logger LOGGER = LoggerFactory.getLogger(Pattern.class);

    private static final String SPACE = " ";
    private static final String STAR = "*";

    /**
     * Prints the following rectangle of the provided <code>rows</code>, <code>cols</code> and <code>character</code>.
     * <pre>
     *  *****
     *  *****
     *  *****
     *  *****
     * </pre>
     *
     * @param rows
     * @param cols
     * @param cChar
     */
    public void printRectangle(int rows, int cols, char cChar) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following hollow rectangle of the provided <code>rows</code>, <code>cols</code> and
     * <code>character</code>.
     *
     * <pre>
     *  *****
     *  *   *
     *  *   *
     *  *****
     * </pre>
     *
     * @param rows
     * @param cols
     * @param cChar
     */
    public void printHollowRectangle(int rows, int cols, char cChar) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // only print the char at the outer boundary
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    System.out.print(cChar);
                } else {
                    System.out.print(SPACE);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the following half pyramid of the provided <code>rows</code>, and <code>character</code>.
     * <pre>
     *  *
     *  **
     *  ***
     *  ****
     *  *****
     * </pre>
     *
     * @param rows
     * @param cChar
     */
    public void printHalfPyramid(int rows, char cChar) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following inverted half pyramid of the provided <code>rows</code>, and <code>character</code>.
     *
     * <pre>
     *  *****
     *  ****
     *  ***
     *  **
     *  *
     * </pre>
     *
     * @param rows
     * @param cChar
     */
    public void printInvertedHalfPyramid(int rows, char cChar) {
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following inverted half pyramid of the provided <code>rows</code>, and <code>character</code>.
     *
     * <pre>
     *      1
     *     11
     *    111
     *   1111
     *  11111
     * </pre>
     *
     * @param rows
     * @param cChar
     */
    public void printInvertedAndRotatedHalfPyramid(int rows, char cChar) {
        for (int i = 1; i <= rows; i++) {
            // print spaces
            for (int j = 0; j < rows - i; j++) {
                System.out.print(SPACE);
            }

            // print star
            for (int j = 0; j < i; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following half pyramid of the provided <code>rows</code> with numbers.
     * <pre>
     *  1
     *  12
     *  123
     *  1234
     *  1234
     * </pre>
     *
     * @param rows
     */
    public void printHalfPyramidWithNumbers(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following inverted half pyramid of the provided <code>rows</code> with numbers.
     * <pre>
     *  12345
     *  1234
     *  123
     *  12
     *  1
     * </pre>
     *
     * @param rows
     */
    public void printInvertedHalfPyramidWithNumbers(int rows) {
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following half pyramid of the provided <code>rows</code> with numbers.
     * <pre>
     *      1
     *     12
     *    123
     *   1234
     *  12345
     * </pre>
     *
     * @param rows
     */
    public void printInvertedAndRotatedHalfPyramidWithNumbers(int rows) {
        for (int i = 1; i <= rows; i++) {
            // print spaces
            for (int j = 0; j < rows - i; j++) {
                System.out.print(SPACE);
            }

            // print number
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following floyd's triangle of the provided <code>rows</code> with numbers.
     * <pre>
     *  1
     *  2 3
     *  4 5 6
     *  7 8 9 10
     *  11 12 13 14 15
     * </pre>
     *
     * @param rows
     */
    public void printFloydsTriangle(int rows) {
        int ctr = 1;
        for (int i = 1; i <= rows; i++) {
            // print spaces
            for (int j = i; j >= 1; j--) {
                System.out.print(ctr + SPACE);
                ctr++;
            }
            System.out.println();
        }
    }

    /**
     * Prints the following 0-1 triangle of the provided <code>rows</code> with numbers.
     * <pre>
     *  1
     *  01
     *  101
     *  0101
     *  10101
     * </pre>
     *
     * @param rows
     */
    public void printZeroOneTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            // print spaces
            for (int j = 1; j <= i; j++) {
                // sum i +j and check even and odd
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }

                // add space after digit
//                if (j < i) {
//                    System.out.print(SPACE);
//                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the following butterfly pattern of the provided <code>rows</code> and <code>character</code>.
     * <pre>
     *  *        *
     *  **      **
     *  ***    ***
     *  ****  ****
     *  **********
     *  **********
     *  ****  ****
     *  ***    ***
     *  **      **
     *  *        *
     * </pre>
     *
     * @param rows
     */
    public void printButterflyPattern(int rows, char cChar) {
        int cols = rows * 2;
        // print butterfly top part
        for (int i = 1; i <= rows; i++) {
            // print left-side star
            for (int j = 1; j <= i; j++) {
                System.out.print(cChar);
            }

            // print spaces
            for (int j = 1; j <= cols - (i * 2); j++) {
                System.out.print(SPACE);
            }

            // print right-side star
            for (int j = 1; j <= i; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }

        //now reverse the above patterns
        // print butterfly top part
        for (int i = rows; i >= 1; i--) {
            // print left-side star
            for (int j = 1; j <= i; j++) {
                System.out.print(cChar);
            }

            // print spaces
            for (int j = 1; j <= cols - (i * 2); j++) {
                System.out.print(SPACE);
            }

            // print right-side star
            for (int j = 1; j <= i; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following solid rhombus pattern of the provided <code>rows</code> and <code>character</code>.
     * <pre>
     *     *****
     *    *****
     *   *****
     *  *****
     * *****
     * </pre>
     *
     * @param rows
     */
    public void printSolidRhombusPattern(int rows, char cChar) {
        int cols = rows * 2;
        // print butterfly top part
        for (int i = 1; i <= rows; i++) {
            // print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(SPACE);
            }

            // print stars
            for (int j = 1; j <= 5; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following solid rhombus pattern of the provided <code>rows</code>.
     * <pre>
     *     1
     *    2 2
     *   3 3 3
     *  4 4 4 4
     * 5 5 5 5 5
     * </pre>
     *
     * @param rows
     */
    public void printNumberPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            // print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(SPACE);
            }

            // print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
                if (j <= i - 1) {
                    System.out.print(SPACE);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the following palindromic pyramid of the provided <code>rows</code>.
     * <pre>
     *         1
     *       2 1 2
     *     3 2 1 2 3
     *   4 3 2 1 2 3 4
     * 5 4 3 2 1 2 3 4 5
     * </pre>
     *
     * @param rows
     */
    public void printPalindromicPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            // print spaces
            for (int j = 1; j <= (rows - i) * 2; j++) {
                System.out.print(SPACE);
            }

            // print left palindromic pyramid
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
                if (j >= 1) {
                    System.out.print(SPACE);
                }
            }

            // print right palindromic pyramid
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
                if (j <= i - 1) {
                    System.out.print(SPACE);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the following diamond pyramid of the provided <code>rows</code> and <code>cChar</code>.
     * <pre>
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     * *********
     *  *******
     *   *****
     *    ***
     *     *
     * </pre>
     *
     * @param rows
     */
    public void printDiamondPyramid(int rows, char cChar) {
        // print top part of the diamond
        for (int i = 1; i <= rows; i++) {
            // print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(SPACE);
            }

            // print left palindromic pyramid
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }

        // print bottom part of the diamond
        for (int i = rows; i >= 1; i--) {
            // print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(SPACE);
            }

            // print left palindromic pyramid
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print(cChar);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following hollow butterfly of the provided <code>rows</code> and <code>cChar</code>.
     * <pre>
     *  *        *
     *  **      **
     *  * *    * *
     *  *  *  *  *
     *  *   **   *
     *  *   **   *
     *  *  *  *  *
     *  * *    * *
     *  **      **
     *  *        *
     * </pre>
     *
     * @param rows
     */
    public void printHollowButterfly(int rows, char cChar) {
        // print top part of the hollow butterfly
        for (int i = 1; i <= rows; i++) {
            // print left star
            System.out.print(cChar);
            // print left side spaces
            for (int j = 1; j <= i - 2; j++) {
                System.out.print(SPACE);
            }

            // print left side inner star
            if (i > 1) {
                System.out.print(cChar);
            }

            // print center spaces
            for (int j = 1; j <= (rows - i) * 2; j++) {
                System.out.print(SPACE);
            }

            // print right inner star
            if (i > 1) {
                System.out.print(cChar);
            }

            // print right side spaces
            for (int j = 1; j <= i - 2; j++) {
                System.out.print(SPACE);
            }
            // print last star
            System.out.print(cChar);
            System.out.println();
        }

        // print bottom part of the hollow butterfly
        for (int i = rows; i >= 1; i--) {
            // print left star
            System.out.print(cChar);
            // print left side spaces
            for (int j = 1; j <= i - 2; j++) {
                System.out.print(SPACE);
            }

            // print left side inner star
            if (i > 1) {
                System.out.print(cChar);
            }

            // print center spaces
            for (int j = 1; j <= (rows - i) * 2; j++) {
                System.out.print(SPACE);
            }

            // print right inner star
            if (i > 1) {
                System.out.print(cChar);
            }

            // print right side spaces
            for (int j = 1; j <= i - 2; j++) {
                System.out.print(SPACE);
            }
            // print last star
            System.out.print(cChar);
            System.out.println();
        }
    }

    /**
     * Prints the following hollow rhombus of the provided <code>rows</code> and <code>cChar</code>.
     * <pre>
     *     *****
     *    *   *
     *   *   *
     *  *   *
     * *****
     * </pre>
     *
     * @param rows
     */
    public void printHollowRhombus(int rows, char cChar) {
        // print hollow rhombus
        for (int i = 1; i <= rows; i++) {
            // print left side spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(SPACE);
            }

            System.out.print(cChar);
            // print center spaces or star
            for (int j = 1; j <= 3; j++) {
                if (i > 1 && i < 5) {
                    System.out.print(SPACE);
                } else {
                    System.out.print(cChar);
                }
            }
            System.out.print(cChar);

            // move to next line
            System.out.println();
        }
    }

    /**
     * Prints the following number's half pyramid of the provided <code>rows</code>.
     * <pre>
     * 5
     * 44
     * 333
     * 2222
     * 11111
     * </pre>
     *
     * @param rows
     */
    public void printNumberHalfPyramid(int rows) {
        // print number's half pyramid
        for (int i = rows; i >= 1; i--) {
            for (int j = i; j <= rows; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following inverted number's half pyramid of the provided <code>rows</code>.
     * <pre>
     * 1
     * 22
     * 333
     * 4444
     * 55555
     * </pre>
     *
     * @param rows
     */
    public void printInvertedNumberHalfPyramid(int rows) {
        // print inverted number half pyramid
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    /**
     * Prints the following pascal's triangle of the provided <code>rows</code>.
     * <url>https://www.mathsisfun.com/pascals-triangle.html</url>
     * <pre>
     *     1
     *    1 1
     *   1 2 1
     *  1 3 3 1
     * 1 4 6 4 1
     * </pre>
     *
     * @param rows
     */
    public void printPascalsTriangle(int rows) {
        int lastDigit = 1;
        // print pascal's triangle
        for (int i = 0; i < rows; i++) {
            // print spaces
            for (int j = 0; j < (rows - i); j++) {
                System.out.print(SPACE);
            }

            // print digit
            for (int j = 0; j <= i; j++) {
                // for the left side first digit
                if (i == 0 || j == 0) {
                    lastDigit = 1;
                } else {
                    // for the rest of the digits
                    lastDigit = lastDigit * (i - j + 1) / j;
                }
                System.out.print(SPACE + lastDigit);
            }
            System.out.println();
        }
    }

}
