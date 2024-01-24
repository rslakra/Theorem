/**
 *
 */
package com.devamatre.theorem.algos.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 22, 2019 11:20:37 AM
 */
public class Graph<T> {

    private boolean directed;
    private Map<T, Vertex<T>> vertices;
    private List<Edge<T>> edges;

    /**
     * @param directed
     */
    public Graph(final boolean directed) {
        edges = new ArrayList<>();
        vertices = new HashMap<T, Vertex<T>>();
        this.directed = directed;
    }

    /**
     *
     */
    public Graph() {
        this(false);
    }

    public boolean isDirected() {
        return directed;
    }

    public Map<T, Vertex<T>> getVertices() {
        return vertices;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }
}
