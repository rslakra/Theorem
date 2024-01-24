package com.devamatre.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Feb 13, 2021 11:03:15
 */
public class LC1755ClosestSubsequenceSum {

    /**
     * O(2 ^ N)
     *
     * @param nums
     * @param goal
     * @return
     */
    int result = Integer.MAX_VALUE;

    public int minAbsDifferenceBruteForce(int[] nums, int goal) {
        minAbsSum(nums, goal, 0, 0);
        return result;
    }

    /**
     * @param nums
     * @param goal
     * @param sum
     * @param index
     * @return
     */
    public void minAbsSum(int[] nums, int goal, int sum, int index) {
        if (index >= nums.length) {
            result = (Math.min(result, Math.abs(sum - goal)));
            return;
        }
        minAbsSum(nums, goal, sum + nums[index], index + 1);
        minAbsSum(nums, goal, sum, index + 1);
    }


    public int minAbsDifference(int[] nums, int goal) {
        // Arrays.copyOfRange(0, N/2)
        // Arrays.copyOfRange(N/2, N)

        //minAbsSum(firstHalf)
        //minAbsSum(secondHalf)

        //iterate firstHalf
        // get delta = goal - fh[i];
        // equalOrSmaller = sg.floor(delta)
        // equalOrHigher = sg.ceiling(delta)

// result = Math.min(result, (delta - equalOrSmaller))
// result = Math.min(result, (equalOrHigher - delta))

        return -1;
    }

}
