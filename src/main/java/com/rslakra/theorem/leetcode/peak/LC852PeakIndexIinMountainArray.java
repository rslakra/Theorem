package com.rslakra.theorem.leetcode.peak;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 11:11 AM
 */
public class LC852PeakIndexIinMountainArray {

    /**
     * <url>https://leetcode.com/problems/peak-index-in-a-mountain-array</url>
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) { // mean the large number should on the left side of an array
                end = mid;
            } else {
                // the larger number should be on the right side of an array
                start = mid + 1;
            }
        }

        // now the both start and end pointer should be on the same index
        return start; // or end
    }
}
