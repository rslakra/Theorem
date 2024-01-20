package com.devamatre.theorem.adts.graph;

import com.devamatre.theorem.adts.Pair;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 4:59 PM
 */
public class GraphPair<T extends Comparable<? super T>> extends Pair<T, BigDecimal> {

    /**
     * @param source
     * @param weight
     */
    public GraphPair(T source, BigDecimal weight) {
        super(source, weight);
    }

    /**
     * @param pair the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Pair<T, BigDecimal> pair) {
        return (Objects.nonNull(getValue()) ? getValue().subtract(pair.getValue()).intValue() : 0);
    }
}
