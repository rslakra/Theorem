package com.rslakra.theorem.adts;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/14/24 1:54 PM
 */
public interface PrettyPrinter<E> {

    /**
     * Prints the pretty <code>elements</code> horizontally.
     *
     * @param elements
     */
    void prettyPrint(List<List<E>> elements);

    /**
     * Prints the pretty <code>elements</code>.
     *
     * @param elements
     */
    void prettyPrint(E[][] elements);

    /**
     * @param strBuilder
     * @param size
     * @param fillWith
     */
    default void fillBuilder(final StringBuilder strBuilder, int size, String fillWith) {
        for (int i = 0; i < size; i++) {
            strBuilder.append(fillWith);
        }
    }

}
