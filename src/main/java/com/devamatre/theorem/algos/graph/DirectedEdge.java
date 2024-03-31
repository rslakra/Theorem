package com.devamatre.theorem.algos.graph;

import com.devamatre.theorem.adts.graph.Edge;
import com.devamatre.theorem.adts.graph.vertex.Vertex;

import java.math.BigDecimal;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Dec 28, 2020 18:52:52
 */
public class DirectedEdge extends Edge {

    /**
     * @param source
     * @param target
     * @param weight
     * @param directed
     */
    public DirectedEdge(Vertex source, Vertex target, BigDecimal weight, boolean directed) {
        super(source, target, weight, directed);
    }

    /**
     * @param source
     * @param target
     * @param weight
     */
    public DirectedEdge(Vertex source, Vertex target, BigDecimal weight) {
        super(source, target, weight);
    }

    /**
     * @param source
     * @param target
     * @param directed
     */
    public DirectedEdge(Vertex source, Vertex target, boolean directed) {
        super(source, target, directed);
    }

    /**
     * @param source
     * @param target
     */
    public DirectedEdge(Vertex source, Vertex target) {
        super(source, target);
    }
}
