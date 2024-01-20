package com.devamatre.theorem.algos.array;

/**
 * @author Rohtash Lakra
 * @created 12/14/23 3:58 PM
 */
public class GetWrongAnswers {

    /**
     * @param n
     * @param input
     * @return
     */
    public String getWrongAnswers(int n, String input) {
        StringBuilder sBuilder = new StringBuilder(input);
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) - 'A' == 0) {
                sBuilder.setCharAt(i, 'B');
            } else {
                sBuilder.setCharAt(i, 'A');
            }
        }

        return sBuilder.toString();
    }
}
