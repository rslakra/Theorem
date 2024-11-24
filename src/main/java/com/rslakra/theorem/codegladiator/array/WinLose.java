package com.rslakra.theorem.codegladiator.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Prints the WIN or LOSE as result of the given input. There are 2 lines of inputs. If the all the 2nd line inputs are
 * less than equal to 1st line input, then print WIN otherwise LOSE. The input can be in any order.
 *
 * <pre>
 * The first line of input represents the number of test-cases.
 * The second line of input represents the number of villians and players.
 * The third line represents all the villians.
 * The fourth line represents all the players.
 * </pre>
 *
 * <pre>
 * Input:
 * 1
 * 4
 * 3 2 1 6
 * 2 7 8 4
 *
 * Output:
 * WIN
 *
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created May 17, 2019 5:19:15 PM
 */
public class WinLose {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            int[] villians = new int[n];
            for (int i = 0; i < n; i++) {
                villians[i] = in.nextInt();
            }

            int[] players = new int[n];
            for (int i = 0; i < n; i++) {
                players[i] = in.nextInt();
            }

            Arrays.sort(villians);
            Arrays.sort(players);
            System.out.println(Arrays.toString(players));
            System.out.println(Arrays.toString(villians));

            boolean result = true;
            for (int i = n - 1; i >= 0; i--) {
                result &= players[i] >= villians[i];
            }

            if (result) {
                System.out.println("WIN");
            } else {
                System.out.println("LOSE");
            }

        }
        in.close();
    }

}
