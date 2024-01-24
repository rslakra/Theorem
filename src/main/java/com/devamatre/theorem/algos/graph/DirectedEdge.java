package com.devamatre.theorem.algos.graph;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Dec 28, 2020 18:52:52
 */
public class DirectedEdge<T> extends Edge<T> {

    /**
     * @param source
     * @param target
     * @param weight
     */
    public DirectedEdge(Vertex<T> source, Vertex<T> target, int weight) {
        super(source, target, true, weight);
    }

    /**
     * @param source
     * @param target
     */
    public DirectedEdge(Vertex<T> source, Vertex<T> target) {
        super(source, target, true);
    }
}
