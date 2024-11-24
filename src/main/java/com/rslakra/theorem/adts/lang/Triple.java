package com.rslakra.theorem.adts.lang;

import com.rslakra.appsuite.core.ToString;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rohtash Lakra
 * @created 2/18/24 6:20 PM
 */
@Getter
@Setter
public class Triple<L, M, R> {

    private final L left;
    private final M middle;
    private final R right;

    /**
     * @param left
     * @param middle
     * @param right
     */
    public Triple(L left, M middle, R right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(Triple.class)
            .add("left", getLeft())
            .add("middle", getMiddle())
            .add("right", getRight())
            .toString();
    }
}
