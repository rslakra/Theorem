package com.devamatre.theorem.adts.graph.vertex;

import com.devamatre.appsuite.core.ToString;
import com.devamatre.theorem.adts.graph.Edge;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 4:59 PM
 */
@Getter
public class GraphEdge<E extends Comparable<? super E>> extends Edge<Vertex<E>> {

    private Vertex<E> source;
    private Vertex<E> target;

    /**
     * @param source
     * @param target
     * @param weight
     * @param directed
     */
    public GraphEdge(Vertex<E> source, Vertex<E> target, BigDecimal weight, boolean directed) {
        this.source = source;
        this.target = target;
        setWeight(weight);
        setDirected(directed);
    }

    /**
     * @param source
     * @param target
     * @param weight
     */
    public GraphEdge(Vertex source, Vertex target, BigDecimal weight) {
        this(source, target, weight, false);
    }

    /**
     * @param source
     * @param target
     * @param directed
     */
    public GraphEdge(Vertex source, Vertex target, boolean directed) {
        this(source, target, BigDecimal.ZERO, directed);
    }

    /**
     * @param source
     * @param target
     */
    public GraphEdge(Vertex source, Vertex target) {
        this(source, target, null);
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        ToString strBuilder = ToString.of(GraphEdge.class, true);
        // Note: - Don't add vertex, because it will create the recursion loop
        if (Objects.nonNull(getSource())) {
            strBuilder.add("source", getSource().getLabel());
        }
        if (Objects.nonNull(getTarget())) {
            strBuilder.add("target", getTarget().getLabel());
        }
        strBuilder.add("weight", getWeight());
        strBuilder.add("directed", isDirected());

        return strBuilder.toString();
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getTarget(), getWeight(), isDirected());
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final GraphEdge edge = (GraphEdge) object;
        return Objects.equals(getSource(), edge.getSource()) && Objects.equals(getTarget(), edge.getTarget())
               && Objects.equals(getWeight(), edge.getWeight()) && Objects.equals(isDirected(), edge.isDirected());
    }

    /**
     * Returns the new <code>GraphEdge<E></E></code> object by swapping the source and target values.
     *
     * @return
     */
    public GraphEdge reverseEdge() {
        return new GraphEdge(getTarget(), getSource(), getWeight(), isDirected());
    }

    /**
     * Returns the <code>Edge<E></code> object.
     *
     * @param source
     * @param target
     * @param weight
     * @param directed
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> GraphEdge<E> of(Vertex<E> source, Vertex<E> target,
                                                                    BigDecimal weight, boolean directed) {
        return new GraphEdge<>(source, target, weight, directed);
    }

    /**
     * Returns the <code>Edge<E></code> object.
     *
     * @param source
     * @param target
     * @param weight
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> GraphEdge<E> of(Vertex<E> source, Vertex<E> target,
                                                                    BigDecimal weight) {
        return new GraphEdge<>(source, target, weight);
    }

    /**
     * Returns the <code>Edge<E></code> object.
     *
     * @param source
     * @param target
     * @param directed
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> GraphEdge<E> of(Vertex<E> source, Vertex<E> target,
                                                                    boolean directed) {
        return new GraphEdge<>(source, target, directed);
    }

    /**
     * Returns the <code>Edge<E></code> object.
     *
     * @param source
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> GraphEdge<E> of(Vertex<E> source, Vertex<E> target) {
        return new GraphEdge<>(source, target);
    }
}
