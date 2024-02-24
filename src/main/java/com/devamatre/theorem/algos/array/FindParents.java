package com.devamatre.theorem.algos.array;

import com.devamatre.theorem.adts.array.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/12/24 11:52 AM
 */
public class FindParents {

    /**
     * Find parents of nodes.
     *
     * @param input
     * @return
     */
    public List<Integer> findParents(int[] input) {
        List<Integer> parentIndices = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            int parentIndex = ArrayUtils.findParent(input, i);
            if (!parentIndices.contains(parentIndex)) {
                parentIndices.add(parentIndex);
            }
        }

        return parentIndices;
    }
}
