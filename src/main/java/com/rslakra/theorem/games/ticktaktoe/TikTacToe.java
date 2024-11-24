/**
 *
 */
package com.rslakra.theorem.games.ticktaktoe;

/**
 * @author Rohtash Lakra
 */
public class TikTacToe {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private int[][] board = new int[ROWS][COLS];

    enum State {
        EMPTY, NAUGHT, PLAYING;

        static State toState(int value) {
            State[] states = State.values();
            for (int i = 0; i < states.length; i++) {
                if (states[i].ordinal() == value) {
                    return states[i];
                }
            }

            return null;
        }
    }

    State currentState = State.EMPTY;

    public TikTacToe() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = State.EMPTY.ordinal();
            }
        }
    }


    void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                switch (State.toState(board[i][j])) {
                    case EMPTY:
                        System.out.print("-");
                        break;
                    case NAUGHT:
                        System.out.print("O");
                        break;
                    case PLAYING:
                        System.out.print("X");
                        break;
                    default:
                        break;
                }
                if (j < board[0].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    void updateBoard(State state) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = State.EMPTY.ordinal();
            }
        }
    }

    void addTokenToBoard(State state, int row, int col) {
        currentState = state;
        board[row][col] = state.ordinal();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TikTacToe game = new TikTacToe();
        game.addTokenToBoard(State.PLAYING, 0, 1);
        game.addTokenToBoard(State.NAUGHT, 2, 1);
        game.printBoard();
    }

}
