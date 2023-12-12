package com.devamatre.theorem.algos.pattern;

/**
 * @author Rohtash Lakra
 * @created 12/8/23 10:56 AM
 */
public class Pattern {

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
     * Prints the following solid rhombus pattern of the provided <code>rows</code> and <code>character</code>.
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
    public void printNumberPyramid(int rows, char cChar) {
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

}
