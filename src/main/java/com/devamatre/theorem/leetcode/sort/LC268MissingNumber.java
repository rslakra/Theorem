package com.devamatre.theorem.leetcode.sort;

import com.devamatre.theorem.adts.search.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 1:24 PM
 */
public class LC268MissingNumber {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC268MissingNumber.class);

    /**
     * <url>https://leetcode.com/problems/missing-number</url>
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int pivot = Search.findPivotInRotatedArray(nums);
        LOGGER.debug("pivot:{}", pivot);
        // pivot value == target
        if (pivot == -1) {
            // regular binary search
            return Search.findIteratively(nums, target, 0, nums.length);
        }

        if (nums[pivot] == target) {
            return pivot;
        } else if (target >= nums[0]) {
            return Search.findIteratively(nums, target, 0, pivot);
        } else {
            return Search.findIteratively(nums, target, pivot + 1, nums.length);
        }
    }
}
