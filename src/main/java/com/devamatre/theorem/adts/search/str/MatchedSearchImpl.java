package com.devamatre.theorem.adts.search.str;

import com.devamatre.appsuite.core.ToString;
import com.devamatre.theorem.adts.search.MatchedSearch;

/**
 * @author Rohtash Lakra
 * @created 5/11/22 1:07 PM
 */
public class MatchedSearchImpl implements MatchedSearch {

    private int start;
    private int length;

    /**
     * @param start
     * @param length
     */
    public MatchedSearchImpl(final int start, final int length) {
        this.start = start;
        this.length = length;
    }

    @Override
    public int start() {
        return start;
    }

    @Override
    public int length() {
        return length;
    }

    /**
     * ToString
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(MatchedSearchImpl.class)
            .add("start", start())
            .add("length", length())
            .toString();
    }
}
