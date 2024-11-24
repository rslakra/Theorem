package com.rslakra.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 11:34 AM
 */
public class LC2210CountHillsAndValleysInArray {

    /**
     * <url>https://leetcode.com/problems/count-hills-and-valleys-in-an-array</url>
     *
     * <pre>
     *  Input: nums = [2,4,1,1,6,5]
     *  Output: 3
     *  Explanation:
     *  At index 0: There is no non-equal neighbor of 2 on the left, so index 0 is neither a hill nor a valley.
     *  At index 1: The closest non-equal neighbors of 4 are 2 and 1. Since 4 > 2 and 4 > 1, index 1 is a hill.
     *  At index 2: The closest non-equal neighbors of 1 are 4 and 6. Since 1 < 4 and 1 < 6, index 2 is a valley.
     *  At index 3: The closest non-equal neighbors of 1 are 4 and 6. Since 1 < 4 and 1 < 6, index 3 is a valley, but
     *  note that it is part of the same valley as index 2.
     *  At index 4: The closest non-equal neighbors of 6 are 1 and 5. Since 6 > 1 and 6 > 5, index 4 is a hill.
     *  At index 5: There is no non-equal neighbor of 5 on the right, so index 5 is neither a hill nor a valley.
     *  There are 3 hills and valleys so we return 3.
     * </pre>
     *
     * @param nums
     * @return
     */
    public int countHillValley(int[] nums) {
        return -1;
    }

}
