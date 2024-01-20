package com.devamatre.theorem.leetcode.peak;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 11:15 AM
 */
public class LC2951FindPeaks {

    /**
     * <url>https://leetcode.com/problems/find-the-peaks</url>
     *
     * @param mountain
     * @return
     */
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        if (mountain != null) {
            int start = 0;
            int end = mountain.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (mountain[mid] > mountain[mid + 1]) { // means the large number should on left side of an array
                    end = mid;
                } else {
                    // the larger number should be on the right side of an array
                    start = mid + 1;
                }
            }

            // now the both start and end pointer should be on the same index
            result.add(start); // or end
        }

        return result;
    }
}
