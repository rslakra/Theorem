package com.devamatre.theorem.adts.array;

import com.devamatre.theorem.adts.PrettyPrinter;
import com.devamatre.theorem.adts.lang.AbstractPrettyPrinter;

import java.io.Writer;

/**
 * @author Rohtash Lakra
 * @created 1/14/24 2:00 PM
 */
public class TablePrettyPrinter<E extends Comparable<? super E>> extends AbstractPrettyPrinter<E> {

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
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> PrettyPrinter<E> buildPrettyPrinter() {
        return new TablePrettyPrinter<>();
    }

}
