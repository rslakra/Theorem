package com.devamatre.theorem.adts.graph.vertex;

import com.devamatre.appsuite.core.ToString;
import com.devamatre.theorem.adts.graph.Edge;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 4:59 PM
 */
@Getter
@Setter
public class Vertex<E extends Comparable<? super E>> implements Comparable<Vertex<E>> {

    private final E label;
    private final Set<GraphEdge<E>> edges = new HashSet<>();

    /**
     * @param label
     */
    public Vertex(E label) {
        this.label = label;
    }

    /**
     * Adds the edge between this vertex and the provided <code>endVertex</code>.
     *
     * @param endVertex
     * @param weight
     */
    public void addEdge(Vertex endVertex, BigDecimal weight) {
        edges.add(GraphEdge.of(this, endVertex, weight));
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
     * Returns the <code>neighbors</code> value;
     *
     * @return neighbors
     */
    public Set<Vertex> getNeighbors() {
        return edges.stream()
            .map(edge -> edge.getTarget())
            .collect(Collectors.toSet());
    }

    /**
     * @return
     */
    public int getDegree() {
        return this.edges.size();
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    public static String toString(Vertex vertex) {
        final ToString strBuilder = ToString.of(Vertex.class, true);
        if (Objects.nonNull(vertex)) {
            Set<Edge> edges = vertex.getEdges();
            if (edges.isEmpty()) {
                strBuilder.add("data", vertex.getLabel());
            } else {
                Iterator<Edge> itr = edges.iterator();
                while (itr.hasNext()) {
                    Edge edge = itr.next();
                    if (strBuilder.length() > 0) {
                        strBuilder.add(", ");
                    }
                    strBuilder.add(edge.toString());
                }
            }
        }

        return strBuilder.toString();
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(Vertex.class, true)
            .add("label", getLabel())
            .add("edges", getEdges())
            .toString();
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that
     * {@code x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
     * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Vertex<E> other) {
        return getLabel().compareTo(other.getLabel());
    }

}
