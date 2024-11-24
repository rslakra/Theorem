package com.rslakra.theorem.adts.lang;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 01/01/2024 4:41 PM
 */
public interface CodeConverter {

    /**
     * Converts the <code>input</code> string to <code>E</code> double dimension array.
     *
     * @param input
     * @param <E>
     * @return
     */
    <E extends Comparable<? super E>> E[][] toArray(String input);

    /**
     * Converts the <code>input</code> string to Integer array.
     *
     * @param input
     * @return
     */
    Integer[][] toIntArray(String input);

    /**
     * Converts the <code>input</code> string to Integer array.
     *
     * @param input
     * @return
     */
    Character[][] toCharArray(String input);

    /**
     * Converts the <code>input</code> string to <code>E</code> list of list.
     *
     * @param input
     * @param <E>
     * @return
     */
    <E extends Comparable<? super E>> List<E> toList(String input);

    /**
     * Converts the <code>input</code> string to <code>E</code> list of list.
     *
     * @param input
     * @param <E>
     * @return
     */
    <E extends Comparable<? super E>> List<List<E>> listOfList(String input);

}
