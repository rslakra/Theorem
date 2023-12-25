package com.devamatre.theorem.algos.array;

/**
 * @author Rohtash Lakra
 * @created 12/14/23 4:08 PM
 */
public class GetHitProbability {

    /**
     * @param R
     * @param C
     * @param G
     * @return
     */
    public double getHitProbability(int R, int C, int[][] G) {
        Double div = new Double(R) * new Double(C);
        Double count = 0.0;
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[0].length; j++) {
                if (G[i][j] == 1) {
                    count++;
                }
            }
        }

        return count / div;
    }

}
