package com.devamatre.theorem.algos.array;

/**
 * @author Rohtash Lakra
 * @created 12/14/23 3:58 PM
 */
public class GetWrongAnswers {

    /**
     *
     * @param N
     * @param C
     * @return
     */
    public String getWrongAnswers(int N, String C) {
        StringBuilder sBuilder = new StringBuilder(C);
        for(int i = 0; i < N; i++) {
            if(C.charAt(i) - 'A' == 0) {
                sBuilder.setCharAt(i, 'B');
            } else {
                sBuilder.setCharAt(i, 'A');
            }
        }

        return sBuilder.toString();
    }
}
