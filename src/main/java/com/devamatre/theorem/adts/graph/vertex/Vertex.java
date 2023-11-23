package com.devamatre.theorem.adts.graph.vertex;

import com.devamatre.appsuite.core.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 4:59 PM
 */
public class Vertex<E extends Comparable> {

    private E data;
    private List<Edge> edges;

    /**
     * @param data
     */
    public Vertex(E data) {
        this.data = data;
        edges = new ArrayList<>();
    }

    /**
     * @return
     */
    public E getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * @return
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * @param edges
     */
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Adds the edge between this vertex and the provided <code>endVertex</code>.
     *
     * @param endVertex
     * @param weight
     */
    public void addEdge(Vertex endVertex, BigDecimal weight) {
        edges.add(new Edge(this, endVertex, weight));
    }

    /**
     * Adds the edge between this vertex and the provided <code>endVertex</code>.
     *
     * @param endVertex
     */
    public void addEdge(Vertex endVertex) {
        addEdge(endVertex, null);
    }

    /**
     * Removes the edge between this vertex and the provided <code>endVertex</code>.
     *
     * @param endVertex
     */
    public void removeEdge(Vertex endVertex) {
        edges.removeIf(edge -> edge.getTarget().equals(endVertex));
    }

    /**
     * @param showWeight
     * @return
     */
    public String toString(boolean showWeight) {
        final ToString toString = ToString.of();
        if (edges.isEmpty()) {
            toString.add(getData().toString());
        } else {
            AtomicInteger index = new AtomicInteger();
            edges.forEach(edge -> {
                index.incrementAndGet();
                if (index.get() == 1) {
                    toString.add(edge.getSource().toString()).add(" --> ");
                }

                toString.add(edge.getTarget().toString());

                if (showWeight) {
                    toString.add(" (").add(Objects.toString(edge.getWeight())).add(")");
                }

                if (index.get() < edges.size() - 1) {
                    toString.add(", ");
                }
            });
        }

        return toString.toString();
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(Vertex.class)
            .add("data", getData())
            .add("edges", getEdges())
            .toString();
    }
}
