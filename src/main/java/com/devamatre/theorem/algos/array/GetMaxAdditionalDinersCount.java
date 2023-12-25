package com.devamatre.theorem.algos.array;

import java.util.HashSet;

/**
 * @author Rohtash Lakra
 * @created 12/14/23 4:39 PM
 */
public class GetMaxAdditionalDinersCount {

    private boolean isValid(HashSet<Integer> set, int index, int k, long N) {
        // base case
        if ((index - k) < 0 || index >= N) {
            return false;
        }
        for (int i = index - k; i <= index + k && i >= 0 && i < N; i++) {
            if (set.contains(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right. Social distancing
     * guidelines require that every diner be seated such that K seats to their left and K seats to their right (or all
     * the remaining seats to that side if there are fewer than K) remain empty. There are currently M diners seated at
     * the table, the ith of whom is in seat Si. No two diners are sitting in the same seat, and the social distancing
     * guidelines are satisfied. Determine the maximum number of additional diners who can potentially sit at the table
     * without social distancing guidelines being violated for any new or existing diners, assuming that the existing
     * diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
     * Please take care to write a solution which runs within the time limit.
     *
     * <url>https://www.metacareers.com/profile/coding_puzzles/?puzzle=203188678289677</url>
     *
     * @param N
     * @param K
     * @param M
     * @param S
     * @return
     */
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        long count = 0L;
        int k = Long.valueOf(K).intValue();
        long[] num = new long[Long.valueOf(N).intValue()];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < S.length; i++) {
            int index = Long.valueOf(S[i]).intValue() - 1;
            set.add(index);
            num[index] = S[i];
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0 && isValid(set, i, k, N)) {
                count++;
                num[i] = i + 1;
                set.add(i);
            }
        }

        return count;
    }
}
