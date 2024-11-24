package com.rslakra.theorem.adts.array;

import com.rslakra.theorem.adts.PrettyPrinter;
import com.rslakra.theorem.adts.lang.AbstractPrettyPrinter;

import java.io.Writer;

/**
 * @author Rohtash Lakra
 * @created 1/14/24 2:00 PM
 */
public class TablePrettyPrinter<E> extends AbstractPrettyPrinter<E> {

    /**
     * @param writer
     */
    public TablePrettyPrinter(Writer writer) {
        super(writer);
    }

    /**
     *
     */
    public TablePrettyPrinter() {
        super();
    }

    /**
     * Returns the <code>TablePrettyPrinter</code> instance.
     *
     * @param <E>
     * @return
     */
    public static <E> PrettyPrinter<E> buildPrettyPrinter() {
        return new TablePrettyPrinter<>();
    }

}
