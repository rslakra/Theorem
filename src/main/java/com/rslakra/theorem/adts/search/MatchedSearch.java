package com.rslakra.theorem.adts.search;

/**
 * @author Rohtash Lakra
 * @created 5/11/22 12:59 PM
 */
public interface MatchedSearch {

    /**
     * Returns the start index.
     *
     * @return
     */
    int start();

    /**
     * Returns the length of the matched text.
     *
     * @return
     */
    int length();
}
