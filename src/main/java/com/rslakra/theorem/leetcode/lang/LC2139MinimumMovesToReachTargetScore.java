package com.rslakra.theorem.leetcode.lang;

/**
 * @author Rohtash Lakra
 * @created 1/11/24 3:21 PM
 */
public class LC2139MinimumMovesToReachTargetScore {

    /**
     * @param target
     * @param maxDoubles
     * @param count
     * @return
     */
    private int minMovesRecursively(int target, int maxDoubles, int count) {
        if (target == 1) {
            return count;
        }

        if (maxDoubles > 0 && target % 2 == 0) { // if even
            return minMovesRecursively(target / 2, maxDoubles - 1, count + 1);
        }

        return minMovesRecursively(target - 1, maxDoubles, count + 1);
    }

    /**
     * @param target
     * @param maxDoubles
     * @return
     */
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        if (maxDoubles > 0) {
            while (target > 0) {
                if (target == 1) {
                    break;
                }

                if (maxDoubles > 0 && target % 2 == 0) { // even number
                    target /= 2;
                    maxDoubles -= 1;
                    count++;
                } else {
                    target--;
                    count++;
                }
            }
        } else {
            count = target - 1;
        }

        return count;
    }
}
