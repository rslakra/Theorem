package com.devamatre.theorem.leetcode.array;

import java.util.Scanner;

/**
 * Author: Rohtash Singh Lakra Created: 7/25/20 11:18 AM Version: 1.0.0
 */
public class LC37SudokuSolver {

    private char[][] board;
    private int row;
    private int col;

    public LC37SudokuSolver() {
        board = new char[9][9];
    }

    public void readBoard() {
        Scanner input = new Scanner(System.in);
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[row].length; col++) {
                board[row][col] = (char) input.nextInt();
            }
        }
    }

    public void dummyFillBoard() {
        int index = 1;
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[row].length; col++) {
                board[row][col] = (char) (row + col + 1);
            }
        }
    }


    public void fillBoard() {
    }

    private void printLine() {
        System.out.print("|");
        for (row = 0; row < board.length; row++) {
            System.out.print("-");
        }
        System.out.print("|");
    }

    public void printBoard() {
        printLine();
        for (row = 0; row < board.length; row++) {
            System.out.print("|");
            for (col = 0; col < board[row].length; col++) {
                System.out.print("|" + board[row][col] + "_");
            }

            printLine();
        }
        printLine();
    }

    public static void main(String[] args) {
        LC37SudokuSolver sudokuSolver = new LC37SudokuSolver();
        sudokuSolver.dummyFillBoard();
        sudokuSolver.printBoard();
    }

}
