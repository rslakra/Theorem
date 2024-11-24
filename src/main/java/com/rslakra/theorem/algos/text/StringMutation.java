package com.rslakra.theorem.algos.text;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/5/24 5:57 PM
 */
public class StringMutation {

    /**
     * @param input
     * @param permutation
     * @return
     */
    public List<String> findMutations(String input, String permutation) {
        if (input.isEmpty()) {
            List<String> result = new ArrayList<>();
            result.add(permutation);
            return result;
        }

        char cChar = input.charAt(0);
        // include
        List<String> left = findMutations(input.substring(1), permutation + cChar);
        // exclude
        List<String> rightNode = findMutations(input.substring(1), permutation);
        left.addAll(rightNode);
        // return all
        return left;
    }

    /**
     * @param input
     * @return
     */
    public List<String> findMutations(String input) {
        return findMutations(input, "");
    }

}
