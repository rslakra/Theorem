package com.devamatre.theorem.adts;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/14/24 1:54 PM
 */
public interface PrettyPrinter<E extends Comparable<? super E>> {

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
     * Prints the pretty <code>elements</code>.
     *
     * @param elements
     */
    void prettyPrint(Object[][] elements);

    /**
     * @param stringBuilder
     * @param size
     * @param fillWith
     */
    default void fillBuilder(final StringBuilder stringBuilder, int size, String fillWith) {
        for (int i = 0; i < size; i++) {
            stringBuilder.append(fillWith);
        }
    }

}
