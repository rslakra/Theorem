package com.devamatre.theorem.algos.array.matrix;

import com.devamatre.theorem.adts.array.TablePrettyPrinter;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 7/25/20 2:57 PM
 * @since 1.0.0
 */
public class Sudoku<E> {

    private Object[][] board;

    public Sudoku() {
        board = new Object[9][9];
    }

    /**
     * Reads the sudoku board from input device.
     */
    public void readBoard() {
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = input.nextInt();
            }
        }
    }

    /**
     * Fills the board with default values.
     */
    public void fillBoardDynamically() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = (row * 10 + col + 1);
            }
        }
    }

    /**
     * Fills the board with the provided <code>inputData</code>.
     *
     * @param inputData
     */
    public void fillBoard(E[][] inputData) {
        if (board.length != inputData.length || board[0].length != inputData[0].length) {
            throw new IllegalArgumentException("input data is not valid!");
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = inputData[row][col];
            }
        }
    }

    /**
     * Prints the sudoku board.
     */
    public void printBoard() {
        TablePrettyPrinter.buildPrettyPrinter().prettyPrint(board);
    }

    /**
     * Returns true if the board contains unique [0-9] in the provided <code>row</code>.
     *
     * @param board
     * @param row
     * @param rowMap
     * @return
     */
    public static <T> boolean isValidRow(T[][] board, int row, Map<T, Set<T>> rowMap) {
        if (row < 0 || row >= board.length) {
            return false;
        }

        // valid the row must contain the digits 1-9 without repetition.
        for (int i = 0; i < board.length; i++) {
            if (rowMap.get(row).contains(board[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns true if the board contains unique [0-9] in the provided <code>column</code>.
     *
     * @param board
     * @param col
     * @param colMap
     * @param <T>
     * @return
     */
    public static <T> boolean isValidColumn(T[][] board, int col, Map<T, Set<T>> colMap) {
        if (col < 0 || col >= board[0].length) {
            return false;
        }

        // valid the row must contain the digits 1-9 without repetition.
        for (int i = 0; i < board[0].length; i++) {
            if (colMap.get(col).contains(board[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns true if each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * <p>
     * col/row->{index, set of #} {row/3 + col/3, set of numbers}
     *
     * @param board
     * @param row
     * @param col
     * @param sqrMap
     * @param <T>
     * @return
     */
    public static <T> boolean isValidSquare(T[][] board, int row, int col, Map<T, Set<T>> sqrMap) {
        // row and col are valid indices
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        // valid the row must contain the digits 1-9 without repetition.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // check first box of row/column contains only [1-9] digits
                if (sqrMap.get(i / 3 * 3 + j / 3).contains(board[row][col])) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardDynamically();
        sudoku.printBoard();
        System.out.println();
        sudoku.fillBoard(new Integer[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9}
        });
        sudoku.printBoard();
        System.out.println();
        sudoku.fillBoard(new String[][]{
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
            });
        sudoku.printBoard();
    }

}
